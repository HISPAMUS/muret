import {
  Component,
  ComponentFactoryResolver,
  ElementRef,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output, QueryList,
  SimpleChanges,
  Type,
  ViewChild, ViewChildren
} from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';
import {Rectangle} from '../../model/rectangle';
import {Shape} from '../../model/shape';
import {Coordinate} from '../../model/coordinate';
import {MousePositionEvent} from './mouse-position-event';
import {SVGCanvasState, SvgCanvasStateService} from '../../services/svg-canvas-state.service';
import {Path} from '../../model/path';
import {Line} from '../../model/line';
import {Text} from '../../model/text';
import {DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';
import {BoundingBox} from '../../../core/model/entities/bounding-box';

@Component({
  selector: 'app-svg-canvas',
  templateUrl: './svg-canvas.component.html',
  styleUrls: ['./svg-canvas.component.css'],
  providers: [SvgCanvasStateService] // create service instance for SvgCanvasComponent -
  // (sandboxing) - see https://angular.io/guide/dependency-injection-in-action
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
  @Input() initialState: string;

  @Input() crop: BoundingBox;

  @ViewChild('canvas') canvas: ElementRef;
  @ViewChild('backgroundHiddenImageElement ') backgroundHiddenImageElement: ElementRef;
  @ViewChildren(ShapeComponent) shapeComponents: QueryList<ShapeComponent>;

  // interaction
  private svgMouseEventContent: MousePositionEvent = {}; // avoid creating too many objects
  @Output() svgMouseEvent = new EventEmitter<Coordinate>(); // only emitted on eIdle state

  @Output() svgShapeCreated = new EventEmitter<Shape>();
  @Output() svgShapeChanged = new EventEmitter<Shape>();
  @Output() svgShapeSelected = new EventEmitter<Shape>();
  @Output() svgShapeDeselected = new EventEmitter<Shape>();

  cursorClass = 'cursorDefault';
  // end of interaction

  viewBox: string;
  viewPortHeight = 0;
  viewPortWidth = 0;

  heightPercentString: string;
  widthPercentString: string;
  private nextShapeToDraw: string;
  private selectedComponent: ShapeComponent;
  private unsafeBackgroundImage: SafeResourceUrl;
  private shapeWithoutComponent: Rectangle | Line | Text | Path;

  constructor(private componentFactoryResolver: ComponentFactoryResolver,
              private stateService: SvgCanvasStateService,
              private sanitizer: DomSanitizer) {

  }

  ngOnInit() {
    this.requestStateChange(SVGCanvasState.eIdle);
    this.unsafeBackgroundImage = this.sanitizer.bypassSecurityTrustResourceUrl(this.backgroundImage);

    if (this.initialState) {
      const state = SVGCanvasState[this.initialState];
      this.requestStateChange(state);
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.computeViewBox(); // it costs less to compute the change than checking if it has changed
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

  private createShapeFromTypeName(nextShapeToDraw: string) {
    // wish - without switch
    switch (nextShapeToDraw) {
      case 'Rectangle': return new Rectangle();
      case 'Line': return new Line();
      case 'Text': return new Text();
      case 'Path': return new Path();
      default: throw new Error('Cannot find a shape for shape type ' + nextShapeToDraw);
    }
  }

  trackByShapeFn(index, item: Shape) {
    return item.id;
  }

  requestStateChange(state: SVGCanvasState, drawingShape?: string) {
    this.deselect();

    if (drawingShape) {
      this.nextShapeToDraw = drawingShape;
    }
    if (state === SVGCanvasState.eDrawing && !this.nextShapeToDraw) {
      throw new Error('Must specify a new shape when drawing');
    }

    const newState = this.stateService.requestStateChange(state);
    switch (newState) {
      case SVGCanvasState.eDrawing:
        this.changeCursor('cursorCrosshair');
        break;
      case SVGCanvasState.eIdle:
        this.changeCursor('cursorNotAllowed');
        break;
      case SVGCanvasState.eSelecting:
        this.changeCursor('cursorCell');
        break;
      case SVGCanvasState.eEditing:
        this.changeCursor('cursorDefault');
        break;
    }
    return newState;
  }

  private changeCursor(cursor: string) {
    this.cursorClass = cursor;
  }

  // ----------- Interaction ---------
  onMouseDown($event) {
    const svgCoordinate = this.screenCoordinateToSVGCoordinate($event.offsetX, $event.offsetY);

    switch (this.stateService.getState()) {
      case SVGCanvasState.eDrawing:
        this.deselect();
        this.createShape(svgCoordinate);
        break;
      case SVGCanvasState.eSelecting:
        this.deselect();
        // when auth clicks over a svg shape, it is sent to this method as event
        this.selectedComponent = this.findEventTargetComponent($event.target);
        if (this.selectedComponent) {
          this.selectedComponent.select(true);
          this.svgShapeSelected.emit(this.selectedComponent.shape);
        } else {
          this.svgShapeSelected.emit(null); // unselect
          // TODO - create selection rectangle
        }
        break;
      case SVGCanvasState.eEditing:
        this.deselect();
        // when auth clicks over a svg shape, it is sent to this method as event
        this.selectedComponent = this.findEventTargetComponent($event.target);
        if (this.selectedComponent) {
          this.selectedComponent.select(true);
          this.selectedComponent.setEditingMode(true);
          this.svgShapeSelected.emit(this.selectedComponent.shape);
        } else {
          this.svgShapeSelected.emit(null); // unselect
          // TODO - create selection rectangle
        }
        break;
    }
  }

  screenCoordinateToSVGCoordinate(screenX: number, screenY: number): Coordinate {
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
      x: screenX * xScale + xOffset,
      y: screenY * yScale + yOffset
    };
  }

  onMouseMove($event) {
    switch (this.stateService.getState()) {
      case SVGCanvasState.eDrawing:
        if (!this.selectedComponent && this.shapeWithoutComponent) {
          this.selectedComponent = this.shapeWithoutComponent.shapeComponent;
          this.shapeWithoutComponent = null;
        }

        if (this.selectedComponent) {
          const svgCoordinate = this.screenCoordinateToSVGCoordinate($event.offsetX, $event.offsetY);
          this.selectedComponent.draw(svgCoordinate);
        }
        break;
      case SVGCanvasState.eEditing:
        if (this.selectedComponent && this.selectedComponent.isHandleSelected()) {
          const svgCoordinate = this.screenCoordinateToSVGCoordinate($event.offsetX, $event.offsetY);
          this.selectedComponent.onHandleMouseMove(svgCoordinate.x, svgCoordinate.y);
        }
        break;
    }
  }

  onMouseUp($event): void {
    switch (this.stateService.getState()) {
      case SVGCanvasState.eDrawing:
        this.endShapeDraw();
        $event.stopPropagation();
        break;
      case SVGCanvasState.eEditing:
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
      this.svgShapeDeselected.emit(this.selectedComponent.shape);
      this.selectedComponent = null;
    }
  }

  private createShape(coordinate: Coordinate) {
    const shape = this.createShapeFromTypeName(this.nextShapeToDraw);
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
        this.svgShapeCreated.emit(this.selectedComponent.shape);
      }
      this.selectedComponent = null;
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
    const shape = this.shapes.find(s => s.id === target.id);
    if (shape) {
      return shape.shapeComponent;
    } else {
      return null;
    }
  }
}
