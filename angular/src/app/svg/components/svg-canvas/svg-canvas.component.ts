import {
  AfterContentChecked, AfterViewChecked,
  Component,
  ComponentFactoryResolver,
  ElementRef,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
  ViewChild
} from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';
import {Rectangle} from '../../model/rectangle';
import {Shape} from '../../model/shape';
import {Coordinate} from '../../model/coordinate';
import {Line} from '../../model/line';
import {Text} from '../../model/text';
import {DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';
import {BoundingBox} from '../../../core/model/entities/bounding-box';
import {Polylines} from '../../model/polylines';

@Component({
  selector: 'app-svg-canvas',
  templateUrl: './svg-canvas.component.html',
  styleUrls: ['./svg-canvas.component.css'],
  providers: []
})

/**
 * This canvas is only in charge of displaying svg shapes, possibly with a background image. It can create or setEditingMode shapes,
 * but the mode change must be driven from another client component.
 *
 * It also implements the resizing of elements without CDK drag&drop
 */
export class SvgCanvasComponent implements OnInit, OnChanges {
  @Input() backgroundImage: string;
  @Input() shapes: Shape[];
  @Input() widthPercentage: number;
  @Input() heightPercentage: number;

  @Input() crop: BoundingBox;
  @Input() nextShapeToAdd: 'Rectangle' | 'Line' | 'Text' | 'Polylines';

  selectedShapeValue: Shape;

  private modeValue: 'eIdle' | 'eAdding' | 'eEditing' | 'eSelecting';
  @Output() modeChange = new EventEmitter();

  @ViewChild('canvas') canvas: ElementRef;
  @ViewChild('backgroundHiddenImageElement ') backgroundHiddenImageElement: ElementRef;
  /// @ViewChildren(ShapeComponent) shapeComponents: QueryList<ShapeComponent>;

  // interaction
  @Output() svgMouseEvent = new EventEmitter<Coordinate>(); // only emitted on eIdle state

  @Output() svgShapeCreated = new EventEmitter<Shape>();
  @Output() svgShapeChanged = new EventEmitter<Shape>();
  @Output() selectedShapeChange = new EventEmitter<Shape>();

  cursorClass = 'cursorDefault';
  // end of interaction

  viewBox: string;
  viewPortHeight = 0;
  viewPortWidth = 0;

  heightPercentString: string;
  widthPercentString: string;
  private selectedComponent: ShapeComponent;
  private unsafeBackgroundImage: SafeResourceUrl;
  private shapeWithoutComponent: Rectangle | Line | Text | Polylines;
  private polylinesCreationTimeout: number;
  private emitShapeSelected: boolean;

  constructor(private componentFactoryResolver: ComponentFactoryResolver,
              private sanitizer: DomSanitizer) {

    this.modeValue = 'eIdle';
    this.updateCursor();
  }

  ngOnInit() {
    this.unsafeBackgroundImage = this.sanitizer.bypassSecurityTrustResourceUrl(this.backgroundImage);
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.computeViewBox(); // it costs less to compute the change than checking if it has changed
  }

  @Input()
  get mode() {
    return this.modeValue;
  }

  set mode(val) {
    this.modeValue = val;
    this.modeChange.emit(this.modeValue);
    this.updateCursor();
  }

  @Input()
  get selectedShape() {
    return this.selectedShapeValue;
  }

  set selectedShape(shape: Shape) {
    if (this.selectedShapeValue !== shape) {
      this.deselect();
      this.selectedComponent = this.findEventTargetComponent(shape);
      if (this.selectedComponent) {
        this.selectedShapeValue = shape;
        this.selectedComponent.select(true);
        this.selectedComponent.setEditingMode(this.mode === 'eEditing');
        if (this.emitShapeSelected) { // avoid circular
          this.selectedShapeChange.emit(shape);
        }
      } else {
        if (this.emitShapeSelected) {
          this.selectedShapeChange.emit(null); // unselect
        }
        // TODO - create selection rectangle
      }
    }
  }

  private computeViewBox() {
    if (this.crop) {
      this.viewBox = `${this.crop.fromX} ${this.crop.fromY} ${this.crop.toX - this.crop.fromX} ${this.crop.toY - this.crop.fromY}`;
    } else {
      this.viewBox = `0 0 ${this.viewPortWidth} ${this.viewPortHeight}`;
    }
    this.heightPercentString = this.heightPercentage + '%';
    this.widthPercentString = this.widthPercentage + '%';
  }

  private createShapeFromTypeName(nextShapeToDraw: 'Rectangle' | 'Line' | 'Text' | 'Polylines') {
    // wish - without switch
    switch (nextShapeToDraw) {
      case 'Rectangle': return new Rectangle();
      case 'Line': return new Line();
      case 'Text': return new Text();
      case 'Polylines': return new Polylines();
      default: throw new Error('Cannot find a shape for shape type ' + nextShapeToDraw);
    }
  }

  // TODO - see html
  /*trackByShapeFn(index, item: Shape) {
    return item.id;
  }*/

  updateCursor() {
    switch (this.mode) {
      case 'eAdding':
        this.changeCursor('cursorCrosshair');
        break;
      case 'eIdle':
        this.changeCursor('cursorNotAllowed');
        break;
      case 'eSelecting':
        this.changeCursor('cursorCell');
        break;
      case 'eEditing':
        this.changeCursor('cursorDefault');
        break;
    }
  }

  private changeCursor(cursor: string) {
    this.cursorClass = cursor;
  }

  private findShape(id: string): Shape {
    return this.shapes.find(s => s.id === id);
  }

  // ----------- Interaction ---------
  onMouseDown($event) {
    const svgCoordinate = this.screenCoordinateToSVGCoordinate($event.timeStamp, $event.offsetX, $event.offsetY);

    switch (this.mode) {
      case 'eAdding':
        if (this.polylinesCreationTimeout) {
          clearTimeout(this.polylinesCreationTimeout);
          this.polylinesCreationTimeout = null;
        } else {
          this.deselect();
          this.createShape(svgCoordinate);
        }
        break;
      case 'eSelecting':
        this.deselect();
        this.emitShapeSelected = true;
        this.selectedShape = this.findShape($event.target.id);
        this.emitShapeSelected = false;
        break;
      case 'eEditing':
        this.deselect();
        this.emitShapeSelected = true;
        // when auth clicks over a svg shape, it is sent to this method as event
        this.selectedShape = this.findShape($event.target.id);
        this.emitShapeSelected = false;
        break;
    }
  }

  screenCoordinateToSVGCoordinate(timestamp: number, screenX: number, screenY: number): Coordinate {
    let xScale: number;
    let yScale: number;

    let xOffset: number;
    let yOffset: number;

    if (this.crop) {
      xScale = (this.crop.toX - this.crop.fromX) / this.canvas.nativeElement.clientWidth;
      yScale = (this.crop.toY - this.crop.fromY)  / this.canvas.nativeElement.clientHeight;
      xOffset = this.crop.fromX;
      yOffset = this.crop.fromY;
    } else {
      xScale = this.viewPortWidth / this.canvas.nativeElement.clientWidth;
      yScale = this.viewPortHeight / this.canvas.nativeElement.clientHeight;
      xOffset = 0;
      yOffset = 0;
    }

    return {
      timestamp,
      x: screenX * xScale + xOffset,
      y: screenY * yScale + yOffset
    };
  }

  onMouseMove($event) {
    switch (this.mode) {
      case 'eAdding':
        if (!this.selectedComponent && this.shapeWithoutComponent) {
          this.selectedComponent = this.shapeWithoutComponent.shapeComponent;
          this.shapeWithoutComponent = null;
        }

        if (this.selectedComponent && !this.polylinesCreationTimeout) {
          const svgCoordinate = this.screenCoordinateToSVGCoordinate($event.timeStamp, $event.offsetX, $event.offsetY);
          this.selectedComponent.draw(svgCoordinate);
        }
        break;
      case 'eEditing':
        if (this.selectedComponent && this.selectedComponent.isHandleSelected()) {
          const svgCoordinate = this.screenCoordinateToSVGCoordinate($event.timeStamp, $event.offsetX, $event.offsetY);
          this.selectedComponent.onHandleMouseMove(svgCoordinate.x, svgCoordinate.y);
        }
        break;
    }
  }

  onMouseUp($event): void {
    switch (this.mode) {
      case 'eAdding':
        $event.stopPropagation();
        this.endShapeDraw();
        break;
      case 'eEditing':
        if (this.selectedComponent && this.selectedComponent.isHandleSelected()) {
          this.selectedComponent.deselectHandle();
          this.svgShapeChanged.emit(this.selectedComponent.shape);
          $event.stopPropagation();
        }
        break;
    }
  }

  private deselect() {
    if (this.selectedComponent) {
      this.selectedComponent.select(false);
      this.selectedComponent.setEditingMode(false);
      this.selectedComponent = null;
    }
  }

  private createShape(coordinate: Coordinate) {
    const shape = this.createShapeFromTypeName(this.nextShapeToAdd);
    shape.fillColor = 'transparent';
    shape.strokeColor = 'black';
    shape.strokeWidth = 3;
    shape.fromX = coordinate.x;
    shape.fromY = coordinate.y;
    this.shapes.push(shape);

    this.shapeWithoutComponent = shape;
  }

  private endShapeDraw() {
    if (this.selectedComponent) {
      if (this.selectedComponent.isDrawStarted()) { // if no drag has been done no shape is inserted
        const shape = this.selectedComponent.shape;

        if (shape instanceof Polylines) {
          shape.startNewPolyline = true;
          this.polylinesCreationTimeout = setTimeout(() => {
            this.selectedShape = null;
            this.svgShapeCreated.emit(shape);
            this.polylinesCreationTimeout = null;
          }, 1000); // TODO parametrizar timeout
        } else {
          this.selectedShape = null;
          this.svgShapeCreated.emit(shape);
        }
      }
    }
  }

  onBackgroundHiddenImageElementLoaded($event: Event) {
    // @ts-ignore
    this.viewPortHeight = $event.target.naturalHeight;
    // @ts-ignore
    this.viewPortWidth = $event.target.naturalWidth;

    this.computeViewBox();
  }

  private findEventTargetComponent(target: any): ShapeComponent {
    if (!this.shapes || !target) {
      return null;
    } else {
      const shape = this.shapes.find(s => s.id === target.id);
      if (shape) {
        return shape.shapeComponent;
      } else {
        return null;
      }
    }
  }
}
