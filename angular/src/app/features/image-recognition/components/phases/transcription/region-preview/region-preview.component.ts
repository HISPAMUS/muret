import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Observable} from "rxjs";
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

@Component({
  selector: 'app-region-preview',
  templateUrl: './region-preview.component.html',
  styleUrls: ['./region-preview.component.css']
})
export class RegionPreviewComponent implements OnInit, OnChanges {
  @Input() agnosticSymbolClassifiers: Observable<ClassifierModel[]>;
  @Input() loadedImage: SafeResourceUrl;
  @Input() selectedRegion: Region;

  selectedRegionShapes: Shape[];
  zoomManager: ZoomManager;
  mode: 'eAdding' | 'eEditing' | 'eSelecting';
  nextShapeToDraw: 'Rectangle' | 'Polylines';
  addMethodTypeValue: 'boundingbox' | 'strokes' ;

  constructor() {
    this.zoomManager = new ZoomManager();
    this.mode = 'eSelecting';
    this.nextShapeToDraw = 'Rectangle';
  }

  ngOnInit(): void {
  }


  ngOnChanges(changes: SimpleChanges): void {
    if (changes.selectedRegion && this.selectedRegion) {
      this.drawSelectedRegionSymbols(this.selectedRegion.symbols);
    }
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



  onExecuteClassifier(classifierModel: ClassifierModel) {

  }

  onSymbolCreated(shape: Shape) {
    /*    if (shape instanceof Rectangle) {
      const rect = shape;
      this.creatingBoundingBox = {
        fromX: rect.fromX,
        fromY: rect.fromY,
        toX: rect.fromX + rect.width,
        toY: rect.fromY + rect.height
      };

      this.store.dispatch(new CreateSymbolFromBoundingBox(this.symbolsClassifierModelID,
        this.selectedRegion.id, this.creatingBoundingBox, null, null));
      this.endToEndButtonLabel = 'Classifying...';
      this.processing = true;
    } else if (shape instanceof Polylines) {
      // console.log('shape: ' + shape.polylines.length);
      this.creatingStrokes = shape.polylines.map(polyline => polyline.pointsValue);
      this.store.dispatch(new CreateSymbolFromStrokes( this.symbolsClassifierModelID,
        this.selectedRegion.id, this.creatingStrokes, null, null
      ));
    } else {
      throw new Error('Unsupported shape type: ' + shape.constructor.name);
    }*/
  }

  onSymbolShapeChanged(shape: Shape) {
    /*
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
     */
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
}
