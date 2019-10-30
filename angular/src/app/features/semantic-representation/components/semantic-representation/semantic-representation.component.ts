  import {Component, HostListener, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {GetImageProjection} from '../../../document-analysis/store/actions/document-analysis.actions';
import {ActivateLink} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';
import {Store} from '@ngrx/store';
import {Observable, Subscription} from 'rxjs';
import {Region} from '../../../../core/model/entities/region';
import {
  ClearNotation,
  ConvertAgnostic2Semantic,
  GetNotation,
  SendSemanticEncoding
} from '../../store/actions/semantic-representation.actions';
  import {selectNotation} from '../../store/selectors/semantic-representation.selector';
  import {Notation} from '../../services/notation';
  import {Shape} from '../../../../svg/model/shape';
  import {selectAgnosticSymbols} from '../../../agnostic-representation/store/selectors/agnostic-representation.selector';
  import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
  import {Rectangle} from '../../../../svg/model/rectangle';
  import {Part} from '../../../../core/model/entities/part';
  import {selectProjectParts, selectRegionPart} from '../../../parts/store/selectors/parts.selector';
  import {CreateRegionPart, GetImageProjectParts, GetRegionPart, UpdateRegionPart} from '../../../parts/store/actions/parts.actions';
  import {GetRegion} from '../../../agnostic-representation/store/actions/agnostic-representation.actions';

  @Component({
  selector: 'app-semantic-representation',
  templateUrl: './semantic-representation.component.html',
  styleUrls: ['./semantic-representation.component.css']
})
export class SemanticRepresentationComponent implements OnInit, OnDestroy {

  imageID: number;
  notationSubscription: Subscription;
  selectedRegionZoomFactor = 1;
  selectedRegion: Region;
  encodingPaneType: 'none' | 'manual' | 'mei';
  errorMessage: string = null;
  // semanticEncoding = '';
  // private semanticEncodingTextAreaContent: string;
  notation: Notation;

  selectedRegionAgnosticShapes: Shape[];
  agnosticSymbolsSubscription: Subscription;

  agnosticIDs: number[];
  agnosticIDMap: Map<number, number>;
  columnDefs = [
    {headerName: '**smens', field: 'smens' },
    {headerName: 'Agnostic symbols', field: 'agnosticSymbols' }
  ];
  rowData = [
  ];
  private gridApi;
  private gridColumnApi;

  defaultColDef: { resizable: boolean; editable: boolean };
  private string: string;

  projectParts$: Observable<Part[]>;
  // imagePart$: Observable<Part>;
  // pagePart$: Observable<Part>;
  regionPart$: Observable<Part>;
    private drawSymbolsPending = true;

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<any>) {
    this.defaultColDef = {
      editable: true,
      resizable: true
    };
  }

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.imageID = +params.get('id'); // + converts the string to number
      this.store.dispatch(new GetImageProjection(+this.imageID));
      this.store.dispatch(new GetImageProjectParts(+this.imageID));

      setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
        this.store.dispatch(new ActivateLink({title: 'Semantic', routerLink: 'semanticrepresentation/' + this.imageID}));
      });

    });

    this.notationSubscription = this.store.select(selectNotation).subscribe(next => {
      if (next) {
        if (next.errorMessage != null) {
          this.errorMessage = next.errorMessage;
        } else {
          this.errorMessage = null;
          // this.semanticEncoding = next.semanticEncoding;
          this.drawSemanticEncoding(next.semanticEncoding);
          this.notation = next;
        }
      }
    });

    this.agnosticSymbolsSubscription = this.store.select(selectAgnosticSymbols).subscribe(next => {
        setTimeout( () => { // avoid desync (first region, then symbols)
          this.drawSelectedRegionSymbols(next);
        });
    });

    this.projectParts$ = this.store.select(selectProjectParts);
    // this.imagePart$ = this.store.select(selectImagePart);
    // this.pagePart$ = this.store.select(selectPagePart);
    this.regionPart$ = this.store.select(selectRegionPart);
  }

  ngOnDestroy(): void {
    this.notationSubscription.unsubscribe();
    this.agnosticSymbolsSubscription.unsubscribe();
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.imageID]);
  }

  openAgnosticRepresentation() {
    this.router.navigate(['agnosticrepresentation', this.imageID]);
  }

  convertAgnosticSemantic() {
    this.store.dispatch(new ConvertAgnostic2Semantic(this.selectedRegion, false, 'verovio'));
  }

  setSelectedRegion($event: Region) {
    this.selectedRegion = $event;
    setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
      this.errorMessage = null;
      this.notation = null;
      // this.semanticEncoding = '';
      if (this.gridApi) {
        this.gridApi.setRowData([]);
      }

      if (this.selectedRegion) {
        this.store.dispatch(new GetNotation(this.selectedRegion, false, 'verovio')); // TODO
        this.store.dispatch(new GetRegionPart(this.selectedRegion));
      } else {
        this.store.dispatch(new ClearNotation());
      }
    });
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

  isManualEntrySelected() {
    return this.encodingPaneType === 'manual';
  }

  isMEISelected() {
    return this.encodingPaneType === 'mei';
  }

  showManualEntry() {
    this.encodingPaneType = 'manual';
  }


  showMEI() {
    this.encodingPaneType = 'mei';
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
    const newItems = [];
    const lines = semanticEncoding.split('\n');
    lines.forEach(line => {
      if (line.length > 0) {
        const columns = line.split('@');
        newItems.push({
          smens: columns[0],
          agnosticSymbols: this.findAgnosticID(columns[1]) // replaces the actual symbol ID for a more usable one
        });
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
    console.log(result);
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


    clearRegionPart() {
      this.store.dispatch(new UpdateRegionPart(this.selectedRegion, null));
    }

    updateRegionPart($event: Part) {
      this.store.dispatch(new UpdateRegionPart(this.selectedRegion, $event));
    }

    createRegionPart($event: string) {
      this.store.dispatch(new CreateRegionPart(this.selectedRegion, $event));
      this.store.dispatch(new GetImageProjectParts(+this.imageID)); // to update the drop down
    }

    noErrorMessage() {
      return this.errorMessage == null || !this.errorMessage;
    }

    hasErrorMessage() {
      return this.errorMessage != null && this.errorMessage;
    }


    hasNotation() {
      return this.notation != null;
    }

  }
