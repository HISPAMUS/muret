import {Component, HostListener, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Observable, Subscription} from 'rxjs';
import {Shape} from '../../../../svg/model/shape';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {Rectangle} from '../../../../svg/model/rectangle';
import {Region} from '../../../../core/model/entities/region';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {
  selectFileName,
  selectDocumentType,
} from '../../../document-analysis/store/selectors/document-analysis.selector';
import {Store} from '@ngrx/store';
import {
  GetImageProjection
} from '../../../document-analysis/store/actions/document-analysis.actions';
import {
  ChangeSymbol,
  ChangeSymbolBoundingBox, ChangeSymbolComments, ClassifyRegionEndToEnd, ClearRegionSymbols,
  CreateSymbolFromBoundingBox, CreateSymbolFromStrokes,
  DeleteSymbol, DeselectSymbol, GetAgnosticEnd2EndClassifierModels,
  GetSVGSet, GetSymbolClassifierModels, InitRegion,
  SelectSymbol
} from '../../store/actions/agnostic-representation.actions';
import {
  selectAgnosticEnd2EndClassifierModels,
  selectAgnosticSymbolClassifierModels,
  selectAgnosticSymbols, selectClassifiedSymbols,
  selectSelectedSymbol, selectSVGAgnosticSymbolSet
} from '../../store/selectors/agnostic-representation.selector';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {Polylines} from '../../../../svg/model/polylines';
import {Strokes} from '../../../../core/model/entities/strokes';
import {Polyline} from '../../../../svg/model/polyline';
import {ActivateLink} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';
import {SVGSet} from '../../model/svgset';
import {AgnosticSymbolAndPosition} from '../../model/agnostic-symbol-and-position';
import {Point} from '../../../../core/model/entities/point';
import {AgnosticTypeSVGPath} from '../../model/agnostic-type-svgpath';
import {PositionInStaffService} from '../../services/position-in-staff.service';
import {Line} from '../../../../svg/model/line';
import {ClassifierModel} from '../../../../core/model/entities/classifier-model';
import { debuglog } from 'util';

@Component({
  selector: 'app-agnostic-representation',
  templateUrl: './agnostic-representation.component.html',
  styleUrls: ['./agnostic-representation.component.css']
})
export class AgnosticRepresentationComponent implements OnInit, OnDestroy {
  imageID: number;
  agnosticSymbolsSubscription: Subscription;
  selectedSymbol: AgnosticSymbol;
  selectedRegion: Region;
  selectedSymbolSubscription: Subscription;
  selectedRegionShapes: Shape[];
  selectedRegionZoomFactor = 1;

  mode: 'eIdle' | 'eAdding' | 'eEditing' | 'eSelecting';
  private selectedShapeIDValue: string;
  nextShapeToDraw: 'Rectangle' | 'Polylines';
  selectedAgnosticSymbolTypeValue: string;
  addMethodTypeValue: 'boundingbox' | 'strokes' ;
  classifier = true;
  svgSet$: Observable<SVGSet>;
  filename$: Observable<string>;
  private documentTypeSubscription: Subscription;
  classifiedSymbols: AgnosticSymbolAndPosition[];
  classifiedSymbolsSubscription: Subscription;
  private creatingBoundingBox: BoundingBox;
  private creatingStrokes: Point[][];
  frequentSymbols: Map<string, number> = new Map<string, number>(); // key = agnostic type, value = frequency
  lines = ['L5', 'L4', 'L3', 'L2', 'L1'];
  spaces = ['S4', 'S3', 'S2', 'S1'];
  // enlargedCommentsBox = false;

  endToEndButtonLabel = 'End-to-end';
  end2endClassifierModels$: Observable<ClassifierModel[]>;
  symbolsClassifierModels$: Observable<ClassifierModel[]>;
  end2EndModelID: string;
  symbolsClassifierModelID: string;
  myNumber: number

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<any>,
              private dialogsService: DialogsService, private positionInStaffService: PositionInStaffService) {

    this.mode = 'eIdle';
    this.filename$ = store.select(selectFileName);

    this.documentTypeSubscription  = store.select(selectDocumentType).subscribe(next => {
      if (next) {
        this.store.dispatch(new GetSVGSet(next.notationType, next.manuscriptType));
        // this.store.dispatch(new GetAgnosticEnd2EndClassifierModels(0, 0, next.notationType, next.manuscriptType));
        // moved to ngOnInit with region ID rather than these values
        // this.store.dispatch(new GetSymbolClassifierModels(0, 0, next.notationType, next.manuscriptType));
      }
    });
    this.svgSet$ = store.select(selectSVGAgnosticSymbolSet);
    this.symbolsClassifierModels$ = store.select(selectAgnosticSymbolClassifierModels);
    this.end2endClassifierModels$ = store.select(selectAgnosticEnd2EndClassifierModels);

    this.end2endClassifierModels$.subscribe((result: ClassifierModel[]) => {

        if (result != null) {
          this.end2EndModelID = result[result.length - 1].id;
        }
    });

    this.symbolsClassifierModels$.subscribe((result: ClassifierModel[]) => {
      if (result != null) {
        this.symbolsClassifierModelID = result[result.length - 1].id;
      }
    });

    this.addMethodType = 'boundingbox';
  }

  ngOnInit() {
    // this.store.dispatch(new InitRegion()); -- commented to reseting region when changing from semantic to agnostic
    // request store data
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.imageID = +params.get('id'); // + converts the string to number
      this.store.dispatch(new GetImageProjection(+this.imageID));

      setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
        this.store.dispatch(new ActivateLink({title: 'Agnostic', routerLink: 'agnosticrepresentation/' + this.imageID}));
        this.store.dispatch(new GetAgnosticEnd2EndClassifierModels(this.imageID));
        this.store.dispatch(new GetSymbolClassifierModels(this.imageID));
      });

    });

    this.agnosticSymbolsSubscription = this.store.select(selectAgnosticSymbols).subscribe(next => {
      this.endToEndButtonLabel = 'End-to-end'; // we may come here after classifying
      this.drawSelectedRegionSymbols(next);
    });
    this.selectedSymbolSubscription = this.store.select(selectSelectedSymbol).subscribe(next => {
      this.setSelectedSymbol(next);
    });
    this.classifiedSymbolsSubscription = this.store.select(selectClassifiedSymbols).subscribe(next => {
      this.classifiedSymbols = next;
    });

    this.mode = 'eIdle';
  }

  ngOnDestroy() {
    this.agnosticSymbolsSubscription.unsubscribe();
    this.selectedSymbolSubscription.unsubscribe();
    this.documentTypeSubscription.unsubscribe();
    this.classifiedSymbolsSubscription.unsubscribe();
  }

  private findSelectedShape(): Shape {
    if (this.selectedShapeID) {
      return this.selectedRegionShapes.find(s => s.id === this.selectedShapeID);
    } else {
      return null;
    }
  }

  get selectedShapeID() {
    return this.selectedShapeIDValue;
  }

  /**
   * It comes from the svg canvas through image component
   */
  set selectedShapeID(id: string) {
    if (this.selectedShapeIDValue !== id) {
      this.selectedShapeIDValue = id;
      const shape = this.findSelectedShape();
      if (shape && shape.data !== this.selectedSymbol) {
        this.store.dispatch(new SelectSymbol(shape.data.id));
      } else if (!shape) {
        this.store.dispatch(new DeselectSymbol());
      }
    }
  }

  get selectedAgnosticSymbolType() {
    return this.selectedAgnosticSymbolTypeValue;
  }

  set selectedAgnosticSymbolType(val) {
    if (val !== this.selectedAgnosticSymbolTypeValue) {
      this.selectedAgnosticSymbolTypeValue = val;
    }
  }

  private setSelectedSymbol(symbol: AgnosticSymbol) {
    this.selectedSymbol = symbol;
    if (symbol) {
      this.selectedAgnosticSymbolType = symbol.agnosticSymbolType;
      const srs = this.selectedRegionShapes.find(s => s.data === symbol);
      this.selectedShapeID = srs.id;
    } else {
        this.selectedShapeID = null;
    }
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.imageID]);
  }

  openSemanticRepresentation() {
    this.router.navigate(['semanticrepresentation', this.imageID]);
  }


  private drawStrokes(shapes: Shape[], modelObject: AgnosticSymbol, layer: string, id: number, strokes: Strokes, color: string) {
    const polylines = new Polylines();
    polylines.id = layer + 'strokes' + id;
    polylines.polylines = strokes.strokeList.map(
      stroke => {
        return new Polyline(stroke.points);
      }
    );
    polylines.fillColor = 'transparent';
    polylines.strokeColor = color;
    polylines.strokeWidth = 2;
    polylines.layer = layer;
    polylines.data = modelObject;
    shapes.push(polylines);
    return polylines;
  }


  private drawBox(shapes: Shape[], modelObject: AgnosticSymbol,
                  layer: string, id: number, boundingBox: BoundingBox, color: string, strokeWidth: number): Rectangle {
    const rect = new Rectangle();
    rect.id = layer + id;
    rect.fromX = boundingBox.fromX;
    rect.fromY = boundingBox.fromY;
    rect.width = boundingBox.toX - boundingBox.fromX;
    rect.height  = boundingBox.toY - boundingBox.fromY;
    rect.fillColor = 'transparent';
    rect.strokeColor = color;
    rect.strokeWidth = strokeWidth;
    rect.layer = layer;
    rect.data = modelObject;
    shapes.push(rect);
    return rect;
  }

  private drawLine(shapes: Shape[], modelObject: AgnosticSymbol, layer: string, id: number, approxX: number, color: string) {
    const line = new Line();
    line.id = layer + 'approxLines' + id;
    line.fromX = approxX;
    line.toX = approxX;
    line.fromY = 0;
    line.toY = 10000; // TODO
    line.strokeColor = color;
    line.strokeWidth = 2;
    line.strokeDashArray = '10';
    line.layer = layer;
    line.data = modelObject;
    shapes.push(line);
    return line;
  }


  private drawSelectedRegionSymbols(agnosticSymbols: AgnosticSymbol[]) {
    this.selectedRegionShapes = new Array();
    if (agnosticSymbols) {
      agnosticSymbols.forEach(symbol => {
        const color = 'red';
        if (symbol.boundingBox) {
          this.drawBox(this.selectedRegionShapes, symbol,
            symbol.agnosticSymbolType, symbol.id, symbol.boundingBox, color, 1);
        }

        if (symbol.strokes) {
          this.drawStrokes(this.selectedRegionShapes, symbol,
            symbol.agnosticSymbolType, symbol.id, symbol.strokes, 'yellow');
        }

        if (symbol.approximateX) {
          this.drawLine(this.selectedRegionShapes, symbol,
            symbol.agnosticSymbolType, symbol.id, symbol.approximateX, color);
        }

      });
    }
  }


  onSymbolCreated(shape: Shape) {
    if (shape instanceof Rectangle) {
      const rect = shape;
      this.creatingBoundingBox = {
        fromX: rect.fromX,
        fromY: rect.fromY,
        toX: rect.fromX + rect.width,
        toY: rect.fromY + rect.height
      };

      this.store.dispatch(new CreateSymbolFromBoundingBox(this.symbolsClassifierModelID,
        this.selectedRegion.id, this.creatingBoundingBox, null, null));
    } else if (shape instanceof Polylines) {
      // console.log('shape: ' + shape.polylines.length);
      this.creatingStrokes = shape.polylines.map(polyline => polyline.pointsValue);
      this.store.dispatch(new CreateSymbolFromStrokes( this.symbolsClassifierModelID,
        this.selectedRegion.id, this.creatingStrokes, null, null
      ));
    } else {
      throw new Error('Unsupported shape type: ' + shape.constructor.name);
    }
  }

  private movePitch(displacement: number) {
    if (this.selectedSymbol) {
      const positionInStaff = this.selectedSymbol.positionInStaff;
      const newPositionInStaff = this.positionInStaffService.movePitch(positionInStaff, displacement);

      this.store.dispatch(new ChangeSymbol(this.selectedSymbol, this.selectedSymbol.agnosticSymbolType, newPositionInStaff));
    }

  }

  movePitchDownSelectedSymbol() {
    this.movePitch(-1);
  }

  movePitchUpSelectedSymbol() {
    this.movePitch(+1);
  }

  changeLineSpace(linespace: string) {
    if (this.selectedSymbol) {
      const newPositionInStaff = linespace;
      this.store.dispatch(new ChangeSymbol(this.selectedSymbol, this.selectedSymbol.agnosticSymbolType, newPositionInStaff));
    }
  }

  deleteSelectedSymbol() {
    if (this.selectedSymbol) {
      this.store.dispatch(new DeleteSymbol(this.selectedSymbol.id));
    }
  }

  onModeChange($event: any) {
    if ($event !== 'eEditing') {
      if (this.selectedSymbol) {
        this.store.dispatch(new DeselectSymbol());
      }
    }
    if ($event === 'eAdding' && !this.selectedAgnosticSymbolType) {
      this.selectedAgnosticSymbolType = 'clef.G';
    }
  }

  isAddingMode() {
    return this.mode === 'eAdding';
  }

  isEditingMode() {
    return this.mode === 'eEditing';
  }

  get addMethodType() {
    return this.addMethodTypeValue;
  }

  set addMethodType(val) {
    this.addMethodTypeValue = val;
    if (this.addMethodTypeValue === 'boundingbox') {
      this.nextShapeToDraw = 'Rectangle';
    } else if (this.addMethodType === 'strokes') {
      this.nextShapeToDraw = 'Polylines';
    } else {
      throw Error('Invalid add method type: ' + this.addMethodType);
    }
  }

  onSymbolShapeChanged(shape: Shape) {
    // currently we only support bounding box change
    if (shape instanceof Rectangle) {
      this.store.dispatch(new ChangeSymbolBoundingBox(shape.data, {
        fromX: shape.fromX,
        fromY: shape.fromY,
        id: shape.data.id,
        toX: shape.fromX + shape.width,
        toY: shape.fromY + shape.height
      }));
    }
  }

  zoomIn() {
    this.selectedRegionZoomFactor += 0.15;
  }

  zoomOut() {
    this.selectedRegionZoomFactor = Math.max(0.5, this.selectedRegionZoomFactor - 0.15);
  }

  zoomFit() {
    this.selectedRegionZoomFactor = 1;
  }

  onClassifierChanged($event: boolean) {
    this.classifier = $event;
  }

  @HostListener('window:keydown', ['$event']) // keydown to prevent scroll
  keyEvent(event: KeyboardEvent) {
    if (this.mode === 'eEditing' || this.mode === 'eAdding') {
      switch (event.code) {
        case 'Delete':
          setTimeout( () => {
            this.deleteSelectedSymbol();
          }, 1000 ); // patch to avoid calling twice the delete symbol method
          // TODO why?
          break;
        case 'ArrowDown':
          event.stopImmediatePropagation();
          event.preventDefault(); // prevent scroll
          this.movePitchDownSelectedSymbol();
          break;
        case 'ArrowUp':
          event.stopImmediatePropagation();
          event.preventDefault(); // prevent scroll
          this.movePitchUpSelectedSymbol();
          break;
        case 'Escape':
          this.store.dispatch(new DeselectSymbol());
          this.mode = 'eIdle';
          break;
      }
    }
  }


  trackClassifiedSymbol(index, item: AgnosticSymbolAndPosition) {
    return index;
  }


  onAgnosticSymbolTypeSelected(agnosticTypeSVGPath: AgnosticTypeSVGPath) {
    this.incrementFrequency(agnosticTypeSVGPath.agnosticTypeString);

    let agnosticSymbolTypeAndPosition = null;
    if (this.classifiedSymbols) {
      agnosticSymbolTypeAndPosition = this.classifiedSymbols.find(cs => cs.agnosticSymbolType === agnosticTypeSVGPath.agnosticTypeString);
    }

    const agnosticType = agnosticTypeSVGPath.agnosticTypeString;
    let positionInStaff: string;
    /* this resets the position to the default symbol one if (agnosticSymbolTypeAndPosition) {
      positionInStaff = agnosticSymbolTypeAndPosition.positionInStaff;
    } else {
      positionInStaff = agnosticTypeSVGPath.defaultPositionInStaff;
    } */
    positionInStaff = this.selectedSymbol.positionInStaff;

    if (this.selectedSymbol &&
      (this.selectedSymbol.agnosticSymbolType !== agnosticType || this.selectedSymbol.positionInStaff !== positionInStaff)) {
      this.store.dispatch(new ChangeSymbol(this.selectedSymbol, agnosticType, positionInStaff));
    }
  }


  classifyEnd2End() {
    this.dialogsService.showConfirmation('Classify end to end?', 'This action will delete previous symbols and cannot be undone')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          this.endToEndButtonLabel = 'Classifying...';
          this.store.dispatch(new ClassifyRegionEndToEnd(this.end2EndModelID, this.selectedRegion.id));
          this.mode = 'eEditing';
        }
      });

  }


  clear() {
    this.dialogsService.showWarningConfirmation('Clear region symbols?', 'You are about to erase all region symbols, this will leave nothing behind')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          this.dialogsService.showWarningConfirmation('WARNING',
            'Are you sure? This change cannot be undone and all progress will be lost').subscribe((isConfirmed) => {
              if (isConfirmed) {
                this.store.dispatch(new ClearRegionSymbols(this.selectedRegion.id));
              }
          });
        }
      });
  }


  private incrementFrequency(agnosticTypeString: string) {
    const val = this.frequentSymbols.get(agnosticTypeString);
    if (!val) {
      this.frequentSymbols.set(agnosticTypeString, 1);
    } else {
      this.frequentSymbols.set(agnosticTypeString, val + 1);
    }
  }

  /*toggleComments() {
    this.enlargedCommentsBox = !this.enlargedCommentsBox;
  }*/
  addComment() {
    if (this.selectedSymbol != null && this.selectedSymbol !== undefined) {
      this.editAddComment(this.selectedSymbol);
    }
  }

  onCommentClicked(agnosticSymbol: AgnosticSymbol) {
    this.editAddComment(agnosticSymbol);
  }

  private editAddComment(agnosticSymbol: AgnosticSymbol) {
    this.dialogsService.showInput('Comments', 'Set agnostic symbol comments', agnosticSymbol.comments)
      .subscribe((text) => {
        if (text) {
          this.store.dispatch(new ChangeSymbolComments(agnosticSymbol, text));
        } else if (agnosticSymbol.comments) {
          this.store.dispatch(new ChangeSymbolComments(agnosticSymbol, null));
        }
      });

  }

  setSelectedRegion($event: Region) {
    setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
      this.selectedRegion = $event;
      console.log($event)
      console.log(this.selectedRegion)
    });
  }

  setMyNumber($event: number)
  {
    console.log($event)
  }
}
