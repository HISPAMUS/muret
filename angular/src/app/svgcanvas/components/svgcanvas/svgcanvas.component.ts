import {
  Component, ComponentFactoryResolver, ComponentRef,
  ContentChild,
  EventEmitter, Injector, Input,
  OnInit,
  Output,
  TemplateRef,
  ViewContainerRef
} from '@angular/core';
import {MousePosition, ShapeProperties} from '../../model/shape';
import {ShapeComponent} from '../shape/shape.component';
import {LineComponent} from '../line/line.component';
import {CircleComponent} from '../circle/circle.component';
import {RectangleComponent} from '../rectangle/rectangle.component';
import {SquareComponent} from '../square/square.component';
import {EllipseComponent} from '../ellipse/ellipse.component';
import {TextComponent} from '../text/text.component';
import {ImageComponent} from '../image/image.component';
import {PolyLineComponent} from '../polyline/polyline.component';
import {PathComponent} from '../path/path.component';
import {NGXLogger} from 'ngx-logger';
import {FreehandComponent} from '../freehand/freehand.component';

export enum SVGCanvasState {
  eIdle,   eSelecting, eDrawing, eEditing, eMoving
}

export class SVGMousePositionEvent {
  private _svgPosition: any;
  private _mouseEvent: MouseEvent;
  get svgPosition(): any {
    return this._svgPosition;
  }

  get mouseEvent(): MouseEvent {
    return this._mouseEvent;
  }


  set svgPosition(value: any) {
    this._svgPosition = value;
  }

  set mouseEvent(value: MouseEvent) {
    this._mouseEvent = value;
  }
}

@Component({
  selector: 'app-svgcanvas',
  templateUrl: './svgcanvas.component.html',
  styleUrls: ['./svgcanvas.component.css']
})

export class SVGCanvasComponent implements OnInit {
  svg: any;
  @Input() height: number;
  @Input() width: number;

  @ContentChild(TemplateRef) shapeTemplate: TemplateRef<any>;

  currentPosition: MousePosition = new MousePosition();
  state: SVGCanvasState = SVGCanvasState.eIdle;
  selectedComponent: ShapeComponent;

  @Output() svgMouseEvent = new EventEmitter<SVGMousePositionEvent>(); // only emitted on eIdle state
  private svgMouseEventContent = new SVGMousePositionEvent(); // avoid creating too many objects

  @Output() svgShapeChanged = new EventEmitter<ShapeComponent>();

  @Output() svgShapeSelected = new EventEmitter<ShapeComponent>();

  @Output() svgShapeDeselected = new EventEmitter<ShapeComponent>();

  @Output() svgShapeCreated = new EventEmitter<ShapeComponent>();

  private shapeTypeToCreate: string;

  private shapesComponents: Array<ShapeComponent>;
  private defaultFillColor = 'gray';
  private defaultStrokeWidth = 1;
  private defaultStrokeColor = 'black';

  constructor(private viewContainerRef: ViewContainerRef,
                private componentFactoryResolver: ComponentFactoryResolver,
                private logger: NGXLogger) {
    this.shapesComponents = new Array<ShapeComponent>();
  }

  ngOnInit(): void {
    this.svg = document.querySelector('svg');
  }

  getShapes(): ShapeComponent[] {
    return this.shapesComponents;
  }

  public changeState(state: SVGCanvasState) {
    this.state = state;
  }

  private changeMousePosition(event: MouseEvent) {
    const CTM = this.svg.getScreenCTM();
    this.currentPosition.x = (event.clientX - CTM.e) / CTM.a;
    this.currentPosition.y = (event.clientY - CTM.f) / CTM.d;
    this.currentPosition.timestamp = event.timeStamp;
  }


  private buildComponent(shapeType: string): any {
    this.logger.debug('buildComponent for :', shapeType);
    switch (shapeType) {
      case 'Line':
        return LineComponent;
      case 'Circle':
        return CircleComponent;
      case 'Rectangle':
        return RectangleComponent;
      case 'Square':
        return SquareComponent;
      case 'Ellipse':
        return EllipseComponent;
      case 'TextBox':
        return TextComponent;
      case 'Image':
        return ImageComponent;
      case 'Freehand':
        return FreehandComponent;
      case 'PolyLine':
        return PolyLineComponent;
      case 'Path':
        return PathComponent;
    }
    return null;
  }


  public selectShape(shapeType$: any) {
    this.logger.debug('SVGCanvas selecting shape: ' + shapeType$);
    this.shapeTypeToCreate = shapeType$;
    this.state = SVGCanvasState.eDrawing;
  }


  onMouseDown(event): void {
    this.logger.debug('SVGCanvas mouse down');
    this.changeMousePosition(event);

    if (this.selectedComponent) {
      this.selectedComponent.isSelected = false;
      this.selectedComponent.isEditing = false;
    }

    switch (this.state) {
      case SVGCanvasState.eIdle:
        this.svgMouseEventContent.svgPosition = this.currentPosition;
        this.svgMouseEventContent.mouseEvent = event;
        this.svgMouseEvent.emit(this.svgMouseEventContent);
        break;
      case SVGCanvasState.eDrawing:
        this.createShape();
        break;
      case SVGCanvasState.eSelecting:
      case SVGCanvasState.eEditing:
        this.deselect();
        this.selectedComponent = this.findShapeComponent(event.target.id);
        if (this.selectedComponent) {
          this.selectedComponent.isSelected = true;
          this.svgShapeSelected.emit(this.selectedComponent);
          if (this.state === SVGCanvasState.eEditing) {
            this.state = SVGCanvasState.eMoving;
            this.selectedComponent.isEditing = true;
          }
        } else {
          this.svgShapeSelected.emit(null); // unselect
          // TODO - create selection rectangle
        }
        break;
    }
  }

  private createComponent(shapeType: string): ShapeComponent {
    const componentClass = this.buildComponent(shapeType);
    const injector = Injector.create([], this.viewContainerRef.parentInjector);
    const factory = this.componentFactoryResolver.resolveComponentFactory(componentClass);
    const componentRef = factory.create(injector);
    const result: ShapeComponent = <ShapeComponent> componentRef.instance;
    this.logger.debug('Created ' + this.selectedComponent + ' of class ' + componentClass);
    return result;
  }

  private createShape() {
    this.selectedComponent = this.createComponent(this.shapeTypeToCreate);
    this.shapesComponents.push(this.selectedComponent);
    this.selectedComponent.startDrawing(this.currentPosition);
  }

  private deselect() {
    if (this.selectedComponent) {
      this.selectedComponent.isSelected = false;
      this.svgShapeDeselected.emit(this.selectedComponent);
      this.selectedComponent = null;
    }
  }

  onMouseMove(event): void {
    this.changeMousePosition(event);

    switch (this.state) {
      case SVGCanvasState.eIdle:
        this.svgMouseEventContent.svgPosition = this.currentPosition;
        this.svgMouseEventContent.mouseEvent = event;
        this.svgMouseEvent.emit(this.svgMouseEventContent);
        break;
      case SVGCanvasState.eDrawing:
        if (this.selectedComponent) {
          this.selectedComponent.draw(this.currentPosition);
        }
        break;
      case SVGCanvasState.eEditing:
        if (this.selectedComponent && this.selectedComponent.isHandleSelected()) {
            this.selectedComponent.onHandleMouseMove(this.currentPosition.x, this.currentPosition.y);
        }
        break;
      case SVGCanvasState.eMoving:
        if (this.selectedComponent) {
            this.selectedComponent.drag(this.currentPosition);
        }
        break;
    }
  }

  onMouseUp($event): void {
    this.logger.debug('SVGCanvas mouse up');
    this.changeMousePosition($event);
    switch (this.state) {
      case SVGCanvasState.eIdle:
        this.svgMouseEventContent.svgPosition = this.currentPosition;
        this.svgMouseEventContent.mouseEvent = $event;
        this.svgMouseEvent.emit(this.svgMouseEventContent);
        $event.stopPropagation();
        break;
      case SVGCanvasState.eDrawing:
        this.svgShapeCreated.emit(this.selectedComponent);
        this.selectedComponent = null;
        $event.stopPropagation();
        break;
      case SVGCanvasState.eMoving:
        this.state = SVGCanvasState.eEditing;
        $event.stopPropagation();
        // this.deselect();
        break;
      case SVGCanvasState.eEditing:
        if (this.selectedComponent && this.selectedComponent.isHandleSelected()) {
          this.selectedComponent.deselectHandle();
          this.svgShapeChanged.emit(this.selectedComponent);
          $event.stopPropagation();
        }
        break;
    }
  }

  public clear() {
    this.shapesComponents = new Array<ShapeComponent>();
  }

  findShapeComponent(name: string): ShapeComponent {
    console.log('find name : ', name);
    /*for (let i = 0; i < this.shapesComponents.length; i++) {
      console.log('FIND JSON : ', JSON.stringify(this.shapesComponents[i].shape));
    }*/

    return this.shapesComponents.find(x => x.shape.shapeProperties.name === name);
  }

  drawRectangle(x: number, y: number, width: number, height: number, label: string): ShapeComponent {
    const rect = this.createComponent('Rectangle');
    if (rect instanceof RectangleComponent) {
      rect.setPosition(x, y);
      rect.setDimensions(width, height);
      rect.label = label;
    }
    this.assignDefaultProperties(rect);
    this.shapesComponents.push(rect);
    return rect;
  }

  drawFreeHand(positions: Array<MousePosition>): FreehandComponent {
    const fh = this.createComponent('Freehand');
    if (fh instanceof FreehandComponent) {
      let first = true;
      positions.forEach(position => {
        if (first) {
          fh.startDrawing(position);
          first = false;
        } else {
          fh.draw(position);
        }
      });
      this.assignDefaultProperties(fh);
      this.shapesComponents.push(fh);
      return fh;
    } else {
      throw new Error('Should be a freehand component');
    }
  }


  drawLine(fromX: number, fromY: number, toX: number, toY: number): ShapeComponent {
    const line = this.createComponent('Line');
    if (line instanceof LineComponent) {
      line.setPosition(fromX, fromY);
      line.setEndPosition(toX, toY);
    }
    this.assignDefaultProperties(line);
    this.shapesComponents.push(line);
    return line;
  }

  private assignDefaultProperties(component: ShapeComponent) {
    component.shape.shapeProperties.fillColor = this.defaultFillColor;
    component.shape.shapeProperties.strokeColor = this.defaultStrokeColor;
    component.shape.shapeProperties.strokeWidth = this.defaultStrokeWidth;
  }

  remove(shapeComponent: ShapeComponent) {
    const index: number = this.shapesComponents.indexOf(shapeComponent);
    if (index !== -1) {
      this.shapesComponents.splice(index, 1);
    }
  }

  selectShapeProperties(fillColor: string, strokeWidth: number, strokeColor: string) {
    this.defaultFillColor = fillColor;
    this.defaultStrokeWidth = strokeWidth;
    this.defaultStrokeColor = strokeColor;
  }

  trackByShapeFn(index, item: ShapeComponent) {
    return index; // TODO ¿mejor un ID?
  }
}
