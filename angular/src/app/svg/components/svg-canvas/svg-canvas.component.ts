import {
  Component,
  ComponentFactoryResolver,
  ElementRef,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
  Type,
  ViewChild
} from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';
import {ShapeDirective} from '../../directives/shape.directive';
import {Rectangle} from '../../model/rectangle';
import {Shape} from '../../model/shape';
import {TextComponent} from '../text/text.component';
import {PathComponent} from '../path/path.component';
import {LineComponent} from '../line/line.component';
import {RectangleComponent} from '../rectangle/rectangle.component';
import {Coordinate} from '../../model/coordinate';
import {MousePositionEvent} from './mouse-position-event';
import {SVGCanvasState, SvgCanvasStateService} from '../../services/svg-canvas-state.service';
import {Path} from '../../model/path';
import {Line} from '../../model/line';
import {Text} from '../../model/text';

@Component({
  selector: 'app-svg-canvas',
  templateUrl: './svg-canvas.component.html',
  styleUrls: ['./svg-canvas.component.css'],
  providers: [SvgCanvasStateService] // create service instance for SvgCanvasComponent -
  // (sandboxing) - see https://angular.io/guide/dependency-injection-in-action
})

/**
 * This canvas is only in charge of displaying svg shapes, possibly with a background image. It can create or edit shapes,
 * but the mode change must be driven from another client component.
 *
 * It also implements the resizing of elements without CDK drag&drop
 */
export class SvgCanvasComponent implements OnInit, OnChanges {
  @Input() backgroundImage: string;
  @Input() viewPortWidth: number;
  @Input() shapes: Shape[];
  @Input() viewPortHeight: number;
  @Input() widthPercentage: number;
  @Input() heightPercentage: number;

  @ViewChild('canvas') canvas: ElementRef;

  // interaction
  @Output() svgMouseEvent = new EventEmitter<Coordinate>(); // only emitted on eIdle state
  private svgMouseEventContent: MousePositionEvent = {}; // avoid creating too many objects

  @Output() svgShapeCreated = new EventEmitter<Shape>();
  @Output() svgShapeChanged = new EventEmitter<Shape>();
  @Output() svgShapeSelected = new EventEmitter<Shape>();

  @Output() svgShapeDeselected = new EventEmitter<Shape>();

  cursorClass = 'cursorDefault';
  // end of interaction

  @ViewChild(ShapeDirective) injectComp: ShapeDirective;
  viewBox: string;
  heightPercentString: string;
  widthPercentString: string;
  private nextShapeToDraw: Type<Shape>;
  private selectedComponent: ShapeComponent;
  private shapeComponents = new Array<ShapeComponent>();

  constructor(private componentFactoryResolver: ComponentFactoryResolver,
              private stateService: SvgCanvasStateService) {

  }

  ngOnInit() {
    this.requestStateChange(SVGCanvasState.eIdle);
  }



  private removeShapeComponent(shapeComponent: ShapeComponent) {
    const i = this.shapeComponents.indexOf(shapeComponent, 0);
    if (i >= 0) {
      this.shapeComponents.splice(i, 1); // remove
      const viewContainerRef = this.injectComp.viewContainerRef;
      const index = viewContainerRef.remove(i);
    } else {
      // TODO error en consola
      console.warn('Shape component not found');
    }
  }

  private addShapeComponent(shape: Shape): ShapeComponent {
    /*const shapeClassName = shape.constructor.name;
    const type = window[shapeClassName + 'Component'].prototype;*/
    const componentType = this.shapeToComponent(shape);
    const componentCreated = this.addShape(componentType);
    componentCreated.shape = shape;
    this.shapeComponents.push(componentCreated);
    return componentCreated;
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.shapes) {
        const newShapes = changes.shapes.currentValue as unknown as Shape[];
        // check for changes

        const componentsToRemove: ShapeComponent[]
          = this.shapeComponents.filter(shapeComponent => newShapes.indexOf(shapeComponent.shape) < 0);
        console.log('Removed ' + componentsToRemove.length);
        // Note that if a new added shape was not added to the client due to an error,
        // it will be in components but not in the new shape array
        // and it will be deleted
        const shapesToAdd =
          newShapes.filter(shape => !this.shapeComponents.some(shapeComponent => shapeComponent.shape === shape));
        console.log('Added ' + shapesToAdd.length);

        componentsToRemove.forEach(shapeComponent => {
          this.removeShapeComponent(shapeComponent);
        });

        shapesToAdd.forEach(shape => {
          this.addShapeComponent(shape);
        });
    }

    this.computeViewBox(); // it costs less to compute the change than checking if it has changed
  }

  private computeViewBox() {
    this.viewBox = `0 0 ${this.viewPortWidth} ${this.viewPortHeight}`;
    this.heightPercentString = this.heightPercentage + '%';
    this.widthPercentString = this.widthPercentage + '%';
  }

  // this could be done with reflection
  shapeToComponent(shape: Shape): Type<any> {
    switch (shape.constructor.name) {
      case 'Rectangle': return RectangleComponent;
      case 'Line': return LineComponent;
      case 'Text': return TextComponent;
      case 'Path': return PathComponent;
      default: throw new Error('Cannot find a component for shape type ' + shape.constructor.name);
    }
  }

  private createShapeFromType(nextShapeToDraw: Type<Shape>) {
    // wish - without switch
    switch (nextShapeToDraw.name) {
      case 'Rectangle': return new Rectangle();
      case 'Line': return new Line();
      case 'Text': return new Text();
      case 'Path': return new Path();
      default: throw new Error('Cannot find a shape for shape type ' + nextShapeToDraw.name);
    }
  }


  /*trackByShapeFn(index, item: ShapeComponent) {
    return item.shape.id;
  }*/

  private addShape<T>(componentType: Type<T>): T {
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(componentType);
    const viewContainerRef = this.injectComp.viewContainerRef;
    const componentRef = viewContainerRef.createComponent(componentFactory);
    return componentRef.instance;
  }

  requestStateChange(state: SVGCanvasState, drawingShape?: Type<Shape>) {
    this.deselect();

    if (state === SVGCanvasState.eDrawing && !drawingShape) {
      throw new Error('Must specify a new shape when drawing');
    }
    this.nextShapeToDraw = drawingShape;

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
      case SVGCanvasState.eEditing:
        this.deselect();
        // when user clicks over a svg shape, it is sent to this method as event
        this.selectedComponent = this.findEventTargetComponent($event.target);
        if (this.selectedComponent) {
          this.selectedComponent.select(true);
          this.selectedComponent.edit(true);
          this.svgShapeSelected.emit(this.selectedComponent.shape);
        } else {
          this.svgShapeSelected.emit(null); // unselect
          // TODO - create selection rectangle
        }
        break;
    }
  }

  screenCoordinateToSVGCoordinate(screenX: number, screenY: number): Coordinate {
    const xScale = this.viewPortWidth / this.canvas.nativeElement.clientWidth;
    const yScale = this.viewPortHeight / this.canvas.nativeElement.clientHeight;

    return {
      x: screenX * xScale,
      y: screenY * yScale
    };
  }

  onMouseMove($event) {
    switch (this.stateService.getState()) {
      case SVGCanvasState.eDrawing:
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

  private changeMousePosition(event: MouseEvent) {
  }


  private deselect() {
    if (this.selectedComponent) {
      this.selectedComponent.select(false);
      this.selectedComponent.edit(false);
      this.svgShapeDeselected.emit(this.selectedComponent.shape);
      this.selectedComponent = null;
    }
  }

  private findEventTargetComponent(target: EventTarget): ShapeComponent {
    if (target instanceof SVGGraphicsElement) {
      const result = this.shapeComponents.find(sc => sc.shape.id === target.id);
      return result;
    } else {
      return null;
    }
  }

  private createShape(coordinate: Coordinate) {
    const shape = this.createShapeFromType(this.nextShapeToDraw);
    shape.fillColor = 'transparent';
    shape.strokeColor = 'black';
    shape.strokeWidth = 3;


    // shape.id = '1000'; // TODO
    this.selectedComponent = this.addShapeComponent(shape);
    this.selectedComponent.startDrawing(coordinate);
  }

  private endShapeDraw() {
    if (this.selectedComponent) {

      if (this.selectedComponent.isDrawStarted()) { // if no drag has been done no shape is inserted
        this.svgShapeCreated.emit(this.selectedComponent.shape);
      }
      this.selectedComponent = null;
    }
  }

}
