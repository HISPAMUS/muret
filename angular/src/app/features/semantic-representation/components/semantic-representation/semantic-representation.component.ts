import {Component, HostListener, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {GetImageProjection} from '../../../document-analysis/store/actions/document-analysis.actions';
import {Store} from '@ngrx/store';
import {Subscription, Observable} from 'rxjs';
import {Region} from '../../../../core/model/entities/region';
import {
  ClearNotation,
  ConvertAgnostic2Semantic,
  GetNotation,
  SendSemanticEncoding,
  GetTranslationModels, ResetSemanticRepresentationServerError, ChangeNotationType
} from '../../store/actions/semantic-representation.actions';
import {
  selectNotation,
  selectSemanticRepresentationServerError,
  selectTranslationModels
} from '../../store/selectors/semantic-representation.selector';
import {Notation} from '../../services/notation';
import {Shape} from '../../../../svg/model/shape';
import {selectAgnosticSymbols} from '../../../agnostic-representation/store/selectors/agnostic-representation.selector';
import {AgnosticSymbol} from '../../../../core/model/entities/agnostic-symbol';
import {Rectangle} from '../../../../svg/model/rectangle';
import {Part} from '../../../../core/model/entities/part';
import {
  GetRegion
} from '../../../agnostic-representation/store/actions/agnostic-representation.actions';
import {selectUsesOfParts} from '../../../parts/store/selectors/parts.selector';
import {PartUse, PartUsedIn, UsesOfAllParts} from '../../../../core/model/restapi/uses-of-all-parts';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {
  CreateImagePart, CreateRegionPart,
  GetUsesOfParts,
  PartsLinkPartToImage,
  LinkPartToRegion,
  UnlinkPartToImage, UnlinkPartToRegion
} from '../../../parts/store/actions/parts.actions';
import {
  selectImageDocumentID,
  selectFileName,
  selectDocumentType
} from '../../../document-analysis/store/selectors/document-analysis.selector';
import {ModalOptions} from '../../../../dialogs/options-dialog/options-dialog.component';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';
import {ShowErrorService} from '../../../../core/services/show-error.service';
import { LinkType } from 'src/app/layout/components/breadcrumbs/breadcrumbType';
import {SVGSet} from "../../../agnostic-representation/model/svgset";
import {selectCoreSVGAgnosticOrSemanticSymbolSet} from "../../../../core/store/selectors/core.selector";
import {CoreGetSVGSet} from "../../../../core/store/actions/fonts.actions";
import {KeyValue} from "@angular/common";

@Component({
  selector: 'app-semantic-representation',
  templateUrl: './semantic-representation.component.html',
  styleUrls: ['./semantic-representation.component.css']
})
export class SemanticRepresentationComponent implements OnInit, OnDestroy {

  translationModels$: Observable<ClassifierModel[]>;
  imageID: number;
  documentID: number;
  // mynumber: number;
  notationSubscription: Subscription;
  selectedRegionZoomFactor = 1;
  selectedRegion: Region;
  encodingPaneType: 'none' | 'manual' | 'mei' | 'toolbar';
  // semanticEncoding = '';
  // private semanticEncodingTextAreaContent: string;
  notation: Notation;
  waitingForSemantic: boolean;

  semanticLabel: string;

  selectedRegionAgnosticShapes: Shape[];
  agnosticSymbolsSubscription: Subscription;
  documentIDSubscription: Subscription;

  agnosticIDs: number[];
  //fileNameSubscription : Subscription;
  agnosticIDMap: Map<number, number>; // key = agnostic ID, value = usable ID (the one drawn in the agnostic view to identify the object visually)
  agnosticGridRow: Map<string, number>; // key = agnostic ID, value = row in the grid
  columnDefs = [
    {headerName: '**smens/**skern', field: 'smens' },
    {headerName: 'Agnostic symbols', field: 'agnosticSymbols' }
  ];
  rowData = [
  ];
  private gridApi;
  private gridColumnApi;

  defaultColDef: { resizable: boolean; editable: boolean };
  selectedSemanticSymbolID: string;
  selectedAgnosticSymbolID: string;

  // usesOfPartsSubscription: Subscription;
  private useOfPartsSubscription: Subscription;
  private usesOfParts: UsesOfAllParts;
  private serverErrorSubscription: Subscription;
  private selectedRegionSymbols: AgnosticSymbol[];

  svgSet$: Observable<SVGSet>;
  semanticToolbarFilters: Array<KeyValue<string, string>> = // map<values, titles> - initialized in constructor
    [
      {key: "clefsmeters", value: "Clefs Meters"},
      {key: "note.", value: "Notes"},
      {key: "note.beam", value: "Beamed notes"},
      {key: "rest", value: "Rests"},
      {key: "accidental.", value: "Accidentals"},
      {key: "other", value: "Other"}
    ];
  private documentTypeSubscription: Subscription;

  notationTypes: string[] = ['Same as whole document', 'ePlainChant', 'eMensural', 'eModern']; //TODO Get from server;
  specialNotationType: any;

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<any>,
              private dialogsService: DialogsService, private showErrorService: ShowErrorService
  ) {
    this.defaultColDef = {
      editable: true,
      resizable: true
    };

    // -- TODO -- From here it is repeated in Semantic
    this.documentTypeSubscription  = store.select(selectDocumentType).subscribe(next => {
      if (next) {
        this.store.dispatch(new CoreGetSVGSet(next.notationType, next.manuscriptType));
        // this.store.dispatch(new GetAgnosticEnd2EndClassifierModels(0, 0, next.notationType, next.manuscriptType));
        // moved to ngOnInit with region ID rather than these values
        // this.store.dispatch(new GetSymbolClassifierModels(0, 0, next.notationType, next.manuscriptType));
      }
    });
    this.svgSet$ = this.store.select(selectCoreSVGAgnosticOrSemanticSymbolSet);
    // -- TODO -- To here it is repeated in Semantic
  }

  ngOnInit() {

    this.semanticLabel = "Convert from agnostic";
    this.waitingForSemantic = false;

    /*this.fileNameSubscription = this.store.select(selectFileName).subscribe(name => {
      if(name!=null)
        setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
          this.store.dispatch(new ActivateLink(LinkType.File ,{title: name + ' /Semantic', routerLink: 'semanticrepresentation/' + this.imageID}));
        });
    })*/

    // this.mynumber = 189;
    this.route.paramMap.subscribe((params: ParamMap) => {
      if (params.get('id')) {
        this.imageID = +params.get('id'); // + converts the string to number
        this.store.dispatch(new GetImageProjection(+this.imageID));
        /// this.store.dispatch(new GetImageDocumentParts(+this.imageID));
      }

      if (params.get('region_id')) {
        this.store.dispatch(new GetRegion(+params.get('region_id')));
      }

      this.translationModels$ = this.store.select(selectTranslationModels);

      this.translationModels$.subscribe((value) => {
        console.log(value); // TODO Add translations
      });

      setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
        this.store.dispatch(new GetTranslationModels(this.imageID));
      });


    });

    this.notationSubscription = this.store.select(selectNotation).subscribe(next => {
      if (next) {
        // this.semanticEncoding = next.semanticEncoding;
        if (next.semanticEncoding) {
          this.drawSemanticEncoding(next.semanticEncoding);
          this.waitingForSemantic = false;
          this.semanticLabel = "Convert from agnostic";
        }
        this.notation = next;
      }
    });

    this.agnosticSymbolsSubscription = this.store.select(selectAgnosticSymbols).subscribe(next => {
      // required to draw the required symbols when the region is available
      this.selectedRegionSymbols = next;
    });

    this.useOfPartsSubscription = this.store.select(selectUsesOfParts).subscribe(uop => {
      this.usesOfParts = uop;

      // chained to reload uses of parts if necessary
      if (this.documentID == null)  {
        this.documentIDSubscription = this.store.select(selectImageDocumentID).subscribe(next => {
            if (next != null) {
              this.documentID = next;
              if (this.usesOfParts == null) { // we have not passed through the document screen - we load here the
                this.store.dispatch(new GetUsesOfParts(next));
              }
            }
          }
        );
      }
    });

    this.serverErrorSubscription = this.store.select(selectSemanticRepresentationServerError).subscribe(next => {
      if (next) {
        this.showErrorService.showServerError(next);
        this.store.dispatch(new ResetSemanticRepresentationServerError());
      }
    });
  }

  ngOnDestroy(): void {
    this.notationSubscription.unsubscribe();
    this.agnosticSymbolsSubscription.unsubscribe();
    this.documentIDSubscription.unsubscribe();
    this.useOfPartsSubscription.unsubscribe();
    this.serverErrorSubscription.unsubscribe();
    //this.fileNameSubscription.unsubscribe();
    // this.usesOfPartsSubscription.unsubscribe();
    this.documentTypeSubscription.unsubscribe();
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.imageID]);
  }

  openAgnosticRepresentation() {
    this.router.navigate(['agnosticrepresentation', this.imageID]);
  }

  convertAgnosticSemantic() {
    this.store.dispatch(new ConvertAgnostic2Semantic(this.selectedRegion, false, 'verovio'));
    this.waitingForSemantic = true;
    this.semanticLabel = "Translating...";
  }

  setSelectedRegion($event: Region) {
    setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
      this.selectedRegion = $event;
      this.notation = null;
      // this.semanticEncoding = '';
      if (this.gridApi) {
        this.gridApi.setRowData([]);
      }

      if (this.selectedRegion && this.hasPartAssigned()) {
        this.drawSelectedRegionSymbols(this.selectedRegionSymbols);

        this.store.dispatch(new GetNotation(this.selectedRegion, false, 'verovio')); // TODO
        // this.store.dispatch(new GetRegionPart(this.region));
      } else {
        this.store.dispatch(new ClearNotation());
      }

      if (this.selectedRegion && this.selectedRegion.notationType) {
        this.specialNotationType = this.selectedRegion.notationType;
      } else {
        this.specialNotationType = this.notationTypes[0]; // same as document
      }
    });
  }

  changeSpecialNotationType($event: any) {
    let notationType: string;
    if ($event === this.notationTypes[0]) {
      notationType = null;
    } else {
      notationType = $event;
    }

    this.store.dispatch(new ChangeNotationType(this.selectedRegion, notationType));
  }

  /*manualInputChanged($event: any) {
    this.semanticEncodingTextAreaContent = $event;
    // TODO ¿lo enviamos con intro, en cada tecleo? - combinación de teclas? console.log($event);
  }*/

  sendSemanticEncoding() {
    this.store.dispatch(new SendSemanticEncoding(this.selectedRegion, this.getSemanticEncoding(), false, 'verovio')); // TODO
  }

  isManualEntryCollapsed() {
    return this.encodingPaneType !== 'manual';
  }

  isMEICollapsed() {
    return this.encodingPaneType !== 'mei';
  }

  isToolbarCollapsed() {
    return this.encodingPaneType !== 'toolbar';
  }

  isManualEntrySelected() {
    return this.encodingPaneType === 'manual';
  }

  isMEISelected() {
    return this.encodingPaneType === 'mei';
  }

  isToolbarSelected() {
    return this.encodingPaneType === 'toolbar';
  }

  showManualEntry() {
    this.encodingPaneType = 'manual';
  }


  showMEI() {
    this.encodingPaneType = 'mei';
  }

  showToolbar() {
    this.encodingPaneType = 'toolbar';
  }

  private drawSelectedRegionSymbols(next: AgnosticSymbol[]) {
    this.selectedRegionAgnosticShapes = new Array();
    this.agnosticIDs = new Array();
    this.agnosticIDMap = new Map<number, number>();
    let cont = 0;
    if (next) {
      next.forEach(value => {
        this.drawAgnosticSymbol(value, cont);
        this.agnosticIDs.push(value.id);
        this.agnosticIDMap.set(value.id, cont);
        cont++;
      });
    }
  }

  private drawAgnosticSymbol(symbol: AgnosticSymbol, cont: number): Rectangle {
    const rect = new Rectangle();
    rect.id = '' + symbol.id;
    // TODO fusionar con Agnóstico
    if (symbol.approximateX && this.selectedRegion  && this.selectedRegion.boundingBox) {
      rect.fromX = symbol.approximateX;
      rect.fromY = this.selectedRegion.boundingBox.fromY;
      rect.width = 1;
      rect.height  = this.selectedRegion.boundingBox.toY - this.selectedRegion.boundingBox.fromY;
    } else if (symbol.boundingBox) {
      rect.fromX = symbol.boundingBox.fromX;
      rect.fromY = symbol.boundingBox.fromY;
      rect.width = symbol.boundingBox.toX - symbol.boundingBox.fromX;
      rect.height  = symbol.boundingBox.toY - symbol.boundingBox.fromY;
    } else {
      return;
    }

    rect.fillColor = 'transparent';
    rect.strokeColor = 'red';
    rect.strokeWidth = 1;
    rect.data = symbol;
    rect.label = ' ' + cont;
    rect.labelColor = 'brown';
    this.selectedRegionAgnosticShapes.push(rect);
    return rect;
  }

  /*private drawText(value: AgnosticSymbol, cont: number) {
    const text = new Text();
    text.id = 'agnostic_' + value.id;
    text.fromX = value.boundingBox.fromX;
    text.fromY = value.boundingBox.fromY;
    text.strokeColor = 'red';
    text.strokeWidth = 1;
    text.fillColor = 'red';
    text.label = ''+cont;
    text.data = value;
    this.selectedRegionAgnosticShapes.push(text);
    return text;
  }*/
  @HostListener('document:keydown.tab', ['$event'])
  keyEvent(event: KeyboardEvent) {
    // TODO Lo dejamos?
    event.preventDefault(); // avoid change control default behaviour
  }

  private drawSemanticEncoding(semanticEncoding: string) {
    this.agnosticGridRow = new Map<string, number>();
    const newItems = [];
    const lines = semanticEncoding.split('\n');
    let rowNumber = 0;
    lines.forEach(line => {
      if (line.length > 0) {
        const columns = line.split('@');
        const agnosticIDS = columns[1];
        newItems.push({
          smens: columns[0],
          agnosticSymbols: this.findAgnosticID(agnosticIDS) // replaces the actual symbol ID for a more usable one
        });

        if (agnosticIDS) {
          const IDS: string[] = agnosticIDS.split(',');
          IDS.forEach(id => {
            this.agnosticGridRow.set(id, rowNumber);
          });
        }
        rowNumber++;
      }
    });
    if (this.gridApi) {
      this.gridApi.setRowData(newItems);
    }
    // this.gridApi.updateRowData({ add: newItems });
  }

  private findAgnosticID(agnosticSymbolIDs: string) {
    let result: string;
    if (agnosticSymbolIDs && this.agnosticIDMap) {
      const IDS: string[] = agnosticSymbolIDs.split(',');
      IDS.forEach(id => {
        const simpleID = this.agnosticIDMap.get(Number(id));
        if (result) {
          result = result + ',' + simpleID;
        } else {
          result = '' + simpleID;
        }
      });
    }

    return result;

  }

  onGridReady(params) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
  }

  /**
   * It builds the semantic encoding from the grid. It replaces the 'usable' id for the actual one
   */
  private getSemanticEncoding() {
    let result = '';
    this.gridApi.forEachNode(node => {
      if (node.data.agnosticSymbols) {
        result += (node.data.smens + '@' + this.convertToSymbolIDS(node.data.agnosticSymbols) + '\n');
      } else {
        result += (node.data.smens + '\n');
      }
    });
    // console.log(result);
    return result;
  }

  /**
   * Converts 2,3 to 30404,304123
   * (i.e. the 'usable' ids to the actual ones
   */
  private convertToSymbolIDS(agnosticSymbols: string) {
    if (agnosticSymbols) {
      let result: string = null;
      const usableIDS: string [] = agnosticSymbols.split(',');
      usableIDS.forEach(id => {
        if (result) {
          result = result + ',' + this.agnosticIDs[id];
        } else {
          result = this.agnosticIDs[id];
        }
      });
      return result;
    } else {
      return null;
    }
  }

    addRow() {
      const newItem = {
        smens: '!Insert here'
      };

      const selectedNode = this.gridApi.getSelectedNodes();

      const index = selectedNode[0].childIndex;
      const res = this.gridApi.updateRowData({
        add: [newItem],
        addIndex: index + 1 // selectedNode.childIndex
      });

    }

    insertFirstRow() {
      const newItem = {
        smens: '!Insert here'
      };

      const res = this.gridApi.updateRowData({
        add: [newItem],
        addIndex: 0
      });

    }

    removeSelectedRow() {
      const selectedData = this.gridApi.getSelectedRows();
      const res = this.gridApi.updateRowData({ remove: selectedData });
    }


    /*clearRegionPart() {
      this.store.dispatch(new UpdateRegionPart(this.region, null));
    }

    updateRegionPart($event: Part) {
      this.store.dispatch(new UpdateRegionPart(this.region, $event));
    }

    createRegionPart($event: string) {
      this.store.dispatch(new PartsCreateRegionPart(this.region, $event));
      /// this.store.dispatch(new GetImageDocumentParts(+this.imageID)); // to update the drop down
    }*/

    hasNotation() {
      return this.notation != null && this.notation.notationResponseType != null;
    }

  hasPartAssignedToImage() {
      const partUses = this.getUseOfPartsAssignedToImage();
      return partUses && partUses != null;
  }

  hasPartAssignedToRegion() {
    const partUses = this.getUseOfPartsAssignedToRegion();
    return partUses && partUses != null;
  }

  getPartAssignedToImage(): Part {
    const partUses = this.getUseOfPartsAssignedToImage();
    return partUses.part;
  }

  getPartAssignedToRegion(): Part {
    const partUses = this.getUseOfPartsAssignedToRegion();
    return partUses.part;
  }

  getUseOfPartsAssignedToImage(): PartUsedIn {
    if (this.usesOfParts != null && this.imageID != null) {
      return this.usesOfParts.uses.find(partUses => partUses.images.indexOf(this.imageID) >= 0);
    } else {
      return null;
    }
  }

  getUseOfPartsAssignedToRegion(): PartUsedIn {
    // console.log('Looking for region ' + this.region.id + ' in UOP ' + this.usesOfParts);
    if (this.usesOfParts != null && this.selectedRegion != null) {
      return this.usesOfParts.uses.find(
        partUses => partUses.regions.filter(partUseRegion => partUseRegion.id === this.selectedRegion.id).length > 0);
    } else {
      return null;
    }
  }


  /*changePart() {
  }*/

  unlinkPartToImage() {
    this.dialogsService.showConfirmation('Part assigned to image', 'Do you want to unlink the part?')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          const partUse: PartUse = {
            id: null,
            partId: null,
            imageId: this.imageID
          };

          this.store.dispatch(new UnlinkPartToImage(partUse));
        }
      });
  }

  createPartOptions(): ModalOptions[] {
    const modalOptions: ModalOptions[] = [];
    this.usesOfParts.uses.forEach(partUses => {
      modalOptions.push({
        id: '' + partUses.part.id,
        name: partUses.part.name
      });
    });

    return modalOptions;
  }
  linkPartToImage() {
    const modalOptions = this.createPartOptions();

    this.dialogsService.showOptions('Link part to the whole image', modalOptions, 'New part/instrument name').
    subscribe(next => {
      if (next) {
        if (next.id) {
          const partUse: PartUse = {
            id: null,
            partId: +next.id,
            imageId: this.imageID
          };
          this.store.dispatch(new PartsLinkPartToImage(partUse));
        } else {
          // create a new part and assign to the image
          this.store.dispatch(new CreateImagePart(this.imageID, next.name));
        }
      }
    });

  }

  editInstruments() {
    this.router.navigate(['/document/instruments', this.documentID]);
  }

  linkPartToRegion() {
    const modalOptions = this.createPartOptions();

    this.dialogsService.showOptions('Link part to the selected region', modalOptions, 'New part/instrument name').
    subscribe(next => {
      if (next) {
        if (next.id) {
          const partUse: PartUse = {
            id: this.selectedRegion.id,
            partId: +next.id,
            imageId: this.imageID
          };
          this.store.dispatch(new LinkPartToRegion(partUse));
        } else {
          // create a new part and assign to the image
          this.store.dispatch(new CreateRegionPart(this.selectedRegion.id, next.name));
        }
      }
    });
  }

  unlinkPartToRegion() {
    this.dialogsService.showConfirmation('Part assigned to region', 'Do you want to unlink the part?')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          const partUse: PartUse = {
            id: this.selectedRegion.id,
            partId: null,
            imageId: this.imageID
          };

          this.store.dispatch(new UnlinkPartToRegion(partUse));
        }
      });
  }

  clearSemanticEncoding() {
    this.dialogsService.showConfirmation('Clear semantic encoding?', 'This action cannot be undone')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          this.store.dispatch(new SendSemanticEncoding(this.selectedRegion, '', false, 'verovio'));
          this.notation = null;
        }
      });
  }

  isProcessing() {
    return this.waitingForSemantic;
  }

  hasPartAssigned() {
    return this.hasPartAssignedToRegion() || this.hasPartAssignedToImage();
  }

  //TODO The selectionManager behaviour should be refactored to another object
  // The notation component takes the selected element from the binded this.selectedSemanticSymbolID
  // The **skern / **smens grid / matrix is selected using the selectGridRow method
  // In orderEntities to select the agnostic element, the this.selectedAgnosticSymbolID field is used, but the

  onGridRowSelected($event: any) {
    if ($event && $event.node.selected) {
      this.selectedSemanticSymbolID = 'L' + $event.rowIndex;
      this.selectAgnosticSymbolRelatedToLine($event.rowIndex);
    }
  }

  onNotationSymbolSelected($event: string) {
    if (this.gridApi) {
      const selectedLine = $event.substr(1);
      this.selectGridRow(+selectedLine);
      this.selectAgnosticSymbolRelatedToLine(+selectedLine);
    }
  }

  onAgnosticSymbolSelected($event: string) {
    if ($event) {
      const line = this.agnosticGridRow.get($event);
      if (line) {
        this.selectGridRow(line);
      }
    }
  }

  private selectGridRow(selectedLine: number) {
    this.gridApi.getRowNode(selectedLine).setSelected(true);
  }

  private selectAgnosticSymbolRelatedToLine(rowIndex: number) {
    this.agnosticGridRow.forEach((rowNumber, agnosticID) => {
      if (rowIndex === rowNumber) {
        this.selectedAgnosticSymbolID = agnosticID + '';
        return;
      }
    });
  }

}
