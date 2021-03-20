import {Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {ClassifierModel} from "../../../../../../core/model/entities/classifier-model";
import {Shape} from "../../../../../../svg/model/shape";
import {Region} from "../../../../../../core/model/entities/region";
import {ZoomManager} from "../../../../../../shared/model/zoom-manager";
import {SafeResourceUrl} from "@angular/platform-browser";
import {AgnosticSymbol} from "../../../../../../core/model/entities/agnostic-symbol";
import {Strokes} from "../../../../../../core/model/entities/strokes";
import {Polylines} from "../../../../../../svg/model/polylines";
import {Polyline} from "../../../../../../svg/model/polyline";
import {BoundingBox} from "../../../../../../core/model/entities/bounding-box";
import {Rectangle} from "../../../../../../svg/model/rectangle";
import {Line} from "../../../../../../svg/model/line";
import {Point} from "../../../../../../core/model/entities/point";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";
import {Store} from "@ngrx/store";
import {
  ImageRecognitionChangeSymbolBoundingBox,
  ImageRecognitionClearRegionSymbols,
  ImageRecognitionCreateSymbolFromBoundingBox,
  ImageRecognitionCreateSymbolFromStrokes, ImageRecognitionDeleteSymbols, ImageRecognitionSelectAgnosticSymbols
} from "../../../../store/actions/image-recognition.actions";
import {DialogsService} from "../../../../../../shared/services/dialogs.service";
import {selectImageRecognitionSelectedAgnosticSymbol} from "../../../../store/selectors/image-recognition.selector";

@Component({
  selector: 'app-region-preview',
  templateUrl: './region-preview.component.html',
  styleUrls: ['./region-preview.component.css']
})
export class RegionPreviewComponent implements OnInit, OnChanges, OnDestroy {
  @Input() agnosticSymbolClassifiers: Observable<ClassifierModel[]>;
  @Input() loadedImage: SafeResourceUrl;
  @Input() selectedRegion: Region;
  @Output() modeChange = new EventEmitter(); // must have this name in order to be input / output
  @Output() selectedShapesChange = new EventEmitter();

  modeValue: 'eAdding' | 'eEditing' | 'eSelecting';
  selectedShapesValue: Shape[];

  shapesOfSelectedRegion: Shape[];
  zoomManager: ZoomManager;
  nextShapeToDraw: 'Rectangle' | 'Polylines';
  addMethodTypeValue: 'boundingbox' | 'strokes' ;
  symbolsClassifierModelID: string;
  selectedSymbols: AgnosticSymbol[];
  private selectedSymbolSubscription: Subscription;


  constructor(private store: Store<ImageRecognitionState>, protected dialogsService: DialogsService) {
    this.zoomManager = new ZoomManager();
    this.modeValue = 'eSelecting';
    this.nextShapeToDraw = 'Rectangle';
    this.addMethodType = 'boundingbox';
    this.selectedShapesValue = [];
  }

  ngOnInit(): void {
    this.selectedSymbolSubscription = this.store.select(selectImageRecognitionSelectedAgnosticSymbol).subscribe(next => {
      if (next) {
        // this selection comes from outside (e.g. from agnostic-staff.ts) or from here (selectedShapesChange) -
        // we don't change it directly for having all changes just here
        this.selectedSymbols = next;
        const selectedShapes: Shape[] = [];
        this.selectedSymbols.forEach(symbol => {
          this.shapesOfSelectedRegion.forEach(shape => {
            if (shape.data == symbol) {
              selectedShapes.push(shape);
            }
          });
        });
        this.selectedShapes = selectedShapes;
      }
    });

  }

  ngOnDestroy(): void {
    this.selectedSymbolSubscription.unsubscribe();
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes.selectedRegion && this.selectedRegion) {
      this.drawSelectedRegionSymbols(this.selectedRegion.symbols);
    }
  }

  @Input()
  get mode() {
    return this.modeValue;
  }

  set mode(val) {
    if (this.modeValue != val) {
      this.modeValue = val;
      this.modeChange.emit(this.modeValue);
    }
  }


  @Input()
  get selectedShapes() {
    return this.selectedShapesValue;
  }

  set selectedShapes(val) {
    if (this.selectedShapesValue != val) {
      this.selectedShapesValue = val;
      this.selectedShapesChange.emit(this.selectedShapesValue);
    }
  }

  private drawSelectedRegionSymbols(agnosticSymbols: AgnosticSymbol[]) {
    this.shapesOfSelectedRegion = new Array();
    if (agnosticSymbols) {
      // first sort symbols in reverse order
      const sortedSymbols: AgnosticSymbol[] = agnosticSymbols.slice().sort((a,b) => {
        const ax = a.boundingBox ? a.boundingBox.fromX : a.approximateX;
        const bx = b.boundingBox ? b.boundingBox.fromX : b.approximateX;
        if (ax < bx) {
          return 1;
        } else if (ax > bx) {
          return -1;
        } else {
          return a.id - b.id;
        }
      });

      let lastX = this.selectedRegion.boundingBox.toX;
      /*console.log('SORTED:');
      sortedSymbols.forEach(symbol => {
        console.log('id=' + symbol.id);
        console.log('type=' + symbol.agnosticSymbolType);
        console.log('appx=' + symbol.approximateX);
        if (symbol.boundingBox) {
          console.log('bbox=' + symbol.boundingBox.fromX);
        }
        console.log('----')
      });*/
      sortedSymbols.forEach(symbol => {
        const color = 'red';
        if (symbol.strokes) {
          this.drawStrokes(this.shapesOfSelectedRegion, symbol,
            symbol.agnosticSymbolType, symbol.id, symbol.strokes, 'yellow');
        }

        if (symbol.boundingBox) {
          this.drawBox(this.shapesOfSelectedRegion, symbol,
            symbol.agnosticSymbolType, symbol.id, symbol.boundingBox, color, 1);

          lastX = symbol.boundingBox.fromX;
        } else if (symbol.approximateX) {
          this.drawLine(this.shapesOfSelectedRegion, symbol,
            symbol.agnosticSymbolType, symbol.id, symbol.approximateX, color);

          const bbox: BoundingBox = {
            fromX: symbol.approximateX,
            fromY: this.selectedRegion.boundingBox.fromY + 2,
            toX: lastX - 2,
            toY: this.selectedRegion.boundingBox.toY - 2
          };

          this.drawBox(this.shapesOfSelectedRegion, symbol,
            symbol.agnosticSymbolType, symbol.id, bbox, color, 1);

          lastX = symbol.approximateX;
        }
      });
    }
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

  onSymbolCreated(shape: Shape) {
    if (shape instanceof Rectangle) {
      const rect = shape;
      const bbox: BoundingBox = {
        fromX: rect.fromX,
        fromY: rect.fromY,
        toX: rect.fromX + rect.width,
        toY: rect.fromY + rect.height
      };

      this.store.dispatch(new ImageRecognitionCreateSymbolFromBoundingBox(this.symbolsClassifierModelID,
        this.selectedRegion.id, bbox, null, null));
      //TODO 2021 this.endToEndButtonLabel = 'Classifying...';
      //TODO 2021 this.processing = true;
    } else if (shape instanceof Polylines) {
      // console.log('shape: ' + shape.polylines.length);
      const creatingStrokes: Point[][] = shape.polylines.map(polyline => polyline.pointsValue);
      this.store.dispatch(new ImageRecognitionCreateSymbolFromStrokes( this.symbolsClassifierModelID,
        this.selectedRegion.id, creatingStrokes, null, null
      ));
    } else {
      throw new Error('Unsupported shape type: ' + shape.constructor.name);
    }
  }

  //TODO Comments
  onSymbolShapeChanged(shape: Shape) {
    // currently we only support bounding box change
    if (shape instanceof Rectangle) {
      this.store.dispatch(new ImageRecognitionChangeSymbolBoundingBox(shape.data, {
        fromX: shape.fromX,
        fromY: shape.fromY,
        id: shape.data.id,
        toX: shape.fromX + shape.width,
        toY: shape.fromY + shape.height
      }));
    }
  }

  isAddingMode() {
    return this.mode == 'eAdding';
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

  onSymbolsClassifierModelID(modelID: string) {
    this.symbolsClassifierModelID = modelID;

  }


  onShapesSelected(shapes: Shape[]) {
    this.selectedShapes = shapes;
    if (shapes) {
      const selectedSymbols: AgnosticSymbol[] = [];
      shapes.forEach(shape => {
        if (shape.data.agnosticSymbolType) {
          selectedSymbols.push(shape.data);
        }
      });
      if (selectedSymbols.length > 0) {
        // besides selecting them, we publish for other components which symbols are selected
        this.store.dispatch(new ImageRecognitionSelectAgnosticSymbols(selectedSymbols));
      }
    }
  }

  onDelete() {
    if (this.selectedSymbols && this.selectedSymbols.length > 0) {
        if (this.selectedSymbols.length > 1) {
          this.dialogsService.showConfirmation('There are ' + this.selectedSymbols.length
            + ' selected symbols', 'Do you want the delete them?')
            .subscribe((isConfirmed) => {
                if (isConfirmed) {
                  this.store.dispatch(new ImageRecognitionDeleteSymbols(this.selectedSymbols));
                }
              }
            );
        } else {
          this.store.dispatch(new ImageRecognitionDeleteSymbols(this.selectedSymbols));
        }
    }
  }

  onClear() {
    this.dialogsService.showConfirmation('Clear agnostic representation' , 'Do you want to delete all symbols?')
      .subscribe((isConfirmed) => {
          if (isConfirmed) {
            this.store.dispatch(new ImageRecognitionClearRegionSymbols(this.selectedRegion.id));
          }
        }
      );
  }

  isSelectionDone() {
    return this.selectedSymbols && this.selectedSymbols.length > 0;
  }

}
