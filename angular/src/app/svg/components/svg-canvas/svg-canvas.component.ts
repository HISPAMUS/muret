import {
  Component,
  ComponentFactory,
  ComponentFactoryResolver,
  ComponentRef,
  ElementRef, EventEmitter,
  Input, OnChanges,
  OnInit, Output, SimpleChanges,
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

export enum SVGCanvasState {
  eIdle,  eSelecting, eDrawing, eEditing, eMoving
}

@Component({
  selector: 'app-svg-canvas',
  templateUrl: './svg-canvas.component.html',
  styleUrls: ['./svg-canvas.component.css']
})

export class SvgCanvasComponent implements OnInit, OnChanges {
  @Input() shapes: Shape[];
  @Input() backgroundImage: string;
  @Input() viewPortWidth: number;
  @Input() viewPortHeight: number;
  @Input() widthPercentage: number;
  @Input() heightPercentage: number;

  @ViewChild('canvas') canvas: ElementRef;

  // interaction
  @Output() svgMouseEvent = new EventEmitter<Coordinate>(); // only emitted on eIdle state
  private svgMouseEventContent: MousePositionEvent = {}; // avoid creating too many objects

  @Output() svgShapeChanged = new EventEmitter<ShapeComponent>();

  @Output() svgShapeSelected = new EventEmitter<ShapeComponent>();

  @Output() svgShapeDeselected = new EventEmitter<ShapeComponent>();

  @Output() svgShapeCreated = new EventEmitter<ShapeComponent>();
  // end of interaction

  @ViewChild(ShapeDirective) injectComp: ShapeDirective;
  viewBox: string;
  heightPercentString: string;
  widthPercentString: string;

  constructor(private componentFactoryResolver: ComponentFactoryResolver) { }

  ngOnInit() {
    if (this.shapes) {
      this.shapes.forEach(shape => {
        /*const shapeClassName = shape.constructor.name;
        const type = window[shapeClassName + 'Component'].prototype;*/
        const componentType = this.shapeToComponent(shape);
        const componentCreated = this.addShape(componentType);
        componentCreated.shape = shape;
      });
    }
    this.computeViewBox();
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.computeViewBox();
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

  trackByShapeFn(index, item: ShapeComponent) {
    return item.shape.id;
  }

  private addShape<T>(componentType: Type<T>): T {
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(componentType);
    const viewContainerRef = this.injectComp.viewContainerRef;
    const componentRef = viewContainerRef.createComponent(componentFactory);
    return componentRef.instance;
  }

  onMouseDown($event) {
    const svgCoordinate = this.screenCoordinateToSVGCoordinate($event.offsetX, $event.offsetY);
    console.log(svgCoordinate.x + ', ' + svgCoordinate.y);
  }

  screenCoordinateToSVGCoordinate(screenX: number, screenY: number): Coordinate {
    const xScale = this.viewPortWidth / this.canvas.nativeElement.clientWidth;
    const yScale = this.viewPortHeight / this.canvas.nativeElement.clientHeight;

    return {
      x: screenX * xScale,
      y: screenY * yScale
    };
  }

  onMouseUp($event) {

  }

  onMouseMove($event) {

  }

  private changeMousePosition(event: MouseEvent) {
  }


}
