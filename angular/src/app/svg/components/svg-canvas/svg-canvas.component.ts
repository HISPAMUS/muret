import {
  AfterContentChecked,
  Component,
  ComponentFactoryResolver,
  ElementRef,
  EventEmitter, HostListener,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
  ViewChild,
} from '@angular/core';
import {Rectangle} from '../../model/rectangle';
import {Shape} from '../../model/shape';
import {Coordinate} from '../../model/coordinate';
import {Line} from '../../model/line';
import {Text} from '../../model/text';
import {DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';
import {BoundingBox} from '../../../core/model/entities/bounding-box';
import {Polylines} from '../../model/polylines';
import {SVGSelectionManager} from "../../model/svgselection-manager";
import {ContextMenuSVGSelectionEvent} from "../../model/context-menu-s-v-g-selection-event";
import {ShapeComponent} from "../shape/shape.component";


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
export class SvgCanvasComponent implements OnInit, OnChanges, AfterContentChecked {
  /**
   * Optional
   */
  @Input() backgroundImage: string;
  @Input() shapes: Shape[];
  @Input() zoomFactor: number;
  @Input() imageRotation: number = 0;

  @Input() singleSelectionInEditMode: boolean; // if this value is set just one symbol can be selected in editing mode

  @Input() singleSelectionMode: boolean; // if this value is set just one symbol can be selected
  /**
   * These values are optional, they can be inferred from the background image (if present). If no image is present, it is compulsory
   */
  @Input() viewPortHeight = 0;
  @Input() viewPortWidth = 0;

  //@Input() selectedShapeFillColor: string;

  /**
   * Optional
   */
  @Input() crop: BoundingBox;
  @Input() nextShapeToAdd: 'Rectangle' | 'Line' | 'Text' | 'Polylines';

  @Input() selectByX: boolean; // if true, the selection will be done using first the X coordinate

  @Output() svgMouseEvent = new EventEmitter<Coordinate>(); // only emitted on eIdle state
  @Output() svgShapeCreated = new EventEmitter<Shape>();
  @Output() svgShapeChanged = new EventEmitter<Shape>();
  @Output() selectedShapesIDChange = new EventEmitter<string[]>(); // TODO @deprecated
  @Output() modeChange = new EventEmitter(); // must have this name in order to be input / output
  @Output() onContextMenu = new EventEmitter<ContextMenuSVGSelectionEvent>();
  @Output() selectedShapesChange = new EventEmitter<Shape[]>(true); // keep this name for having input / output -- async to avoid ExpressionChangedAfterItHasBeenCheckedError

  @ViewChild('canvas', {static: true}) canvas: ElementRef; // with false it fails
  @ViewChild('svgContent', {static: true}) svgContent: ElementRef;

  private selectedShapesValue: Shape[] = [];
  private modeValue: 'eAdding' | 'eEditing' | 'eSelecting';
  private isOnDrawProcess: boolean;

  // interaction

  cursorClass = 'cursorDefault';
  // end of interaction

  viewBox: string;
  scaledImageWidth: any;
  scaledImageHeight: any;

  // heightPercentString: string;
  // widthPercentString: string;
  //private selectedComponents: ShapeComponent[];
  //2021 private selectedComponent: ShapeComponent;
  private unsafeBackgroundImage: SafeResourceUrl;
  private newAddingShape: Rectangle | Line | Text | Polylines; // shape being added now
  private polylinesCreationTimeout: any;
  private proportion: number;
  private TIMEOUT = 500;

  // Variables to check if user is going backside
  private originX = 0;
  private originY = 0;

  private lastSelectedElement: SVGGraphicsElement;
  private selectionManager: SVGSelectionManager;
  private shapesMap: Map<string, Shape>;

  constructor(private componentFactoryResolver: ComponentFactoryResolver,
              private sanitizer: DomSanitizer) {
    this.modeValue = 'eSelecting';
    this.selectionManager = new SVGSelectionManager();
    this.updateCursor();
  }

  ngOnInit() {
    if (this.backgroundImage) {
      this.unsafeBackgroundImage = this.sanitizer.bypassSecurityTrustResourceUrl(this.backgroundImage);
    } else if (this.viewPortHeight !== 0 && this.viewPortWidth !== 0) { // when not using image use the specified height and width
      this.computeViewBox();
      this.scaledImageHeight = this.viewPortHeight;
      this.scaledImageWidth = this.viewPortWidth;
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.computeViewBox(); // it costs less to compute the change than checking if it has changed
    this.computeScaledImageSize();
    if (changes.shapes && this.shapes) {
      this.shapesMap = new Map<string, Shape>();

      let previouslySelectedIDs: Set<string> = new Set<string>();
      if (this.selectionManager && this.selectionManager.getSelected().length > 0) {
        this.selectionManager.getSelected().forEach(shape => {
          previouslySelectedIDs.add(shape.id);
        });
      }

      this.selectionManager = new SVGSelectionManager();
      this.selectionManager.selectableElements = this.shapes;
      this.shapes.forEach(shape => {
        this.shapesMap.set(shape.id, shape);
        if (previouslySelectedIDs.has(shape.id)) {
          this.selectionManager.add(shape);
        }
      });

    }

    if (changes.selectByX) {
      this.selectionManager.selectByX = true;
    }
  }

  ngAfterContentChecked(): void {
    /*febrero2021 if (this.mode === 'eEditing') {
      this.selectedComponent = this.findEventTargetComponent(this.selectedShapeIDValue);
    }*/
  }

  private getSelectedComponent(): ShapeComponent {
    if (this.newAddingShape) {
      return this.newAddingShape.shapeComponent;
    } else if (this.selectionManager && this.selectionManager.hasJustOneSelectedShape()) {
      const selectedShape = this.selectionManager.getSelected()[0];
      return this.selectionManager.getSelected()[0].shapeComponent;
    } else {
      return null;
    }
  }

  @Input()
  get selectedShapes() {
    return this.selectedShapesValue;
  }

  set selectedShapes(val: Shape[]) {
    this.selectedShapesValue = val;
    this.selectionManager.clear();
    if (this.selectedShapes) {
      // in order to avoid synchronization problems of object, we select it using the ID
      this.selectionManager.addAll(this.selectedShapes);
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
      this.updateCursor();
    }

    if (this.modeValue == 'eEditing' && this.singleSelectionInEditMode && !this.selectionManager.hasJustOneSelectedShape()) {
      this.selectionManager.leaveJustOneSelected();
      this.emitSelectedShapes();
    } else if (this.modeValue == 'eAdding') {
      this.selectionManager.clear();
      this.emitSelectedShapes();
    }
   /*2021 if (this.modeValue == 'eSelecting' || this.modeValue == 'eEditing') {
      if (this.selectionManager && this.selectionManager.hasJustOneSelectedShape()) {
        this.selectedComponent = this.selectionManager.getSelected()[0].shapeComponent;
      }
    } else {
      this.selectedComponent = null;
    }*/
    //TODO this.selectedShapeIDs = null;
    //
  }

  /*febrero2021 @Input()
  get selectedShapeIDs(): string[] {
    return this.selectionManager.getSelected().map(shape => shape.id);
  }*/

 /* private findShape(id: string): Shape {
    const result = this.shapesMap.get(id);
    if (!result) {
      throw new Error('Cannot find shape with id=' + id);
    }
    return result;
  }*/


  /*private select(shape: Shape) {
    this.selectionManager.add(shape);
    const target = this.canvas.nativeElement.getElementById(shape.id);
    if (target) {
      this.highlightSelectedSVGElement(target);
    }
  }*/

  //@deprecated
  set selectedShapeIDs(ids: string[]) {
   /* this.selectionManager.clear();
    if (this.shapes) {
      ids.forEach(id => {
        const shape = this.findShape(id);
        if (!this.selectionManager.isSelected(shape)) {
          this.select(shape);
        }
      });
    }*/
  }


  private computeViewBox() {
    if (this.crop) {
      this.viewBox = `${this.crop.fromX} ${this.crop.fromY} ${this.crop.toX - this.crop.fromX} ${this.crop.toY - this.crop.fromY}`;
      this.proportion = (this.crop.toX - this.crop.fromX) / (this.crop.toY - this.crop.fromY);
    } else {
      this.viewBox = `0 0 ${this.viewPortWidth} ${this.viewPortHeight}`;
      this.proportion = this.viewPortWidth / this.viewPortHeight;
    }
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

  updateCursor() {
    switch (this.mode) {
      case 'eAdding':
        this.changeCursor('cursorCrosshair');
        break;
      case 'eSelecting':
        this.changeCursor('cursorDefault');
        break;
      case 'eEditing':
        this.changeCursor('cursorCell');
        break;
    }
  }

  private changeCursor(cursor: string) {
    this.cursorClass = cursor;
  }

  // ----------- Interaction ---------
  onDrawStart(target: any, timeStamp: number, x: number, y: number) {
    const svgCoordinate = this.screenCoordinateToSVGCoordinate(timeStamp, x, y);
    switch (this.mode) {
      case 'eAdding':
        /// this.selectedShapeIDs = null;
        if (this.polylinesCreationTimeout) {
          clearTimeout(this.polylinesCreationTimeout);
          this.polylinesCreationTimeout = null;
        } else {
          if (!this.isOnDrawProcess) {
            this.createShape(svgCoordinate);
            this.originX = svgCoordinate.x;
            this.originY = svgCoordinate.y;
            this.isOnDrawProcess = true;
          }
        }
        break;
      /*case 'eSelecting':
        const selectedElement = (target as SVGGraphicsElement);
        //this.highlightSelectedSVGElement(selectedElement);
        this.selectedShapeIDs = target.id;
        this.selectedShapesIDChange.emit(this.selectedShapeIDs);
        break;*/
      case 'eEditing':
        // 2021 this.selectedShapeIDs = null;
        // when auth clicks over a svg shape, it is sent to this method as event
        // 2021 this.selectedShapeIDs = target.id;
        //2021 this.selectedShapesIDChange.emit(this.selectedShapeIDs);
        break;
    }
  }


  screenCoordinateToSVGCoordinate(timestamp: number, x: number, y: number): Coordinate {
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
      x: x * xScale + xOffset,
      y: y * yScale + yOffset
    };
  }

  onDrawMove(timeStamp: number, x: number, y: number): boolean {
    const selectedComponent = this.getSelectedComponent();
    switch (this.mode) {
      case 'eAdding':
        /*2021 if (!this.selectedComponent && this.newAddingShape) {
          this.selectedComponent = this.newAddingShape.shapeComponent;
          this.newAddingShape = null;
        }*/
        if (selectedComponent && !this.polylinesCreationTimeout) {
          const svgCoordinate = this.screenCoordinateToSVGCoordinate(timeStamp, x, y);
          selectedComponent.draw(svgCoordinate);
        }
        return true;
      case 'eEditing':
        if (selectedComponent && selectedComponent.isHandleSelected()) {
          const svgCoordinate = this.screenCoordinateToSVGCoordinate(timeStamp, x, y);
          selectedComponent.onHandleMouseMove(svgCoordinate.x, svgCoordinate.y);
        }
        return true;
    }
    return false;
  }

  onDrawEnd(): void {
    const selectedComponent = this.getSelectedComponent();
    switch (this.mode) {
      case 'eAdding':
        this.endShapeDraw();
        break;
      case 'eEditing':
        if (selectedComponent && selectedComponent.isHandleSelected()) {
          selectedComponent.deselectHandle();
          this.svgShapeChanged.emit(selectedComponent.shape);
        }
        break;
    }
  }

  private createShape(coordinate: Coordinate) {
    const shape = this.createShapeFromTypeName(this.nextShapeToAdd);
    shape.fillColor = 'transparent';
    shape.strokeColor = 'lightgreen';
    shape.strokeWidth = 2;
    shape.fromX = coordinate.x;
    shape.fromY = coordinate.y;
    shape.originY = coordinate.y;
    shape.originX = coordinate.x;
    this.shapes.push(shape);

    this.newAddingShape = shape;
  }

  private endShapeDraw() {
    const selectedComponent = this.getSelectedComponent();
    if (selectedComponent) {
      if (selectedComponent.isDrawStarted()) { // if no drag has been done no shape is inserted
        const shape = selectedComponent.shape;
        if (shape instanceof Polylines) {
          shape.startNewPolyline = true;
          this.polylinesCreationTimeout = setTimeout(() => {
            this.isOnDrawProcess = false;
            //2021 this.selectedShapeIDs = null;
            this.svgShapeCreated.emit(shape);
            this.polylinesCreationTimeout = null;
            //2021 this.selectedComponent = null;
          }, this.TIMEOUT);
        } else {
          this.selectedShapeIDs = null;
          this.newAddingShape = null;
          this.svgShapeCreated.emit(shape);
          //2021 this.selectedComponent = null;
          this.isOnDrawProcess = false;
          // this.shapes = this.shapes.filter(s => s != null);
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
    this.computeScaledImageSize();
  }

  isEditing() {
    return this.mode === 'eEditing';
  }

  isSelected(shape: Shape) {
    return this.selectionManager.isSelected(shape);
  }

  @HostListener('window:resize', ['$event'])
  onResize($event) {
    this.computeScaledImageSize();
  }

  @HostListener('window:keyup', ['$event'])
  keyEvent(event: KeyboardEvent) {
    /*if (event.code === 'Escape') {
      this.mode = 'eSelecting';
      this.selectionManager.clear();
      this.selectedShapesChange.emit(null);
    }*/
  }

  private computeScaledImageSize() {
    if (this.svgContent.nativeElement && this.proportion) {
      this.scaledImageWidth = Math.round(this.zoomFactor * this.svgContent.nativeElement.clientWidth);
      this.scaledImageHeight = Math.round(this.scaledImageWidth / this.proportion);
      /*TODOif(this.isAgnostic && this.scaledImageHeight > 250)
        this.scaledImageHeight = 250;*/
    }
  }


  //TODO
  onTouchStart($event) {
    this.preventScroll($event);

    if ($event.targetTouches) {
      const coord = this.recoverOffsetValues($event);
      //TODO Selección
      this.onDrawStart($event.target, $event.timeStamp, coord[0], coord[1]);
    }
  }

  onMouseDown($event) {
    if (!this.isTouchDevice()) {
      this.handleMouse($event);
    }
    else
    {
      //TODO Document this
      if(this.isChrome() && navigator.appVersion.indexOf("Linux")!=-1)
        this.handleMouse($event);
    }
  }

  onDblClick(event: MouseEvent) {
    if (this.mode === 'eSelecting') {
      event.stopPropagation();
      this.mode = 'eEditing';
      if (event.target instanceof Shape) {
        this.selectionManager.replace(event.target);
      }
      ///2021 this.selectedShapesIDChange.emit(this.selectedShapeIDs); // TODO quitar

    }
  }


  handleMouse(event: MouseEvent)
  {
    if (this.mode === "eSelecting"  || this.mode === "eEditing") {
      this.onSelectEvent(event);
      event.stopPropagation();
    } else if (this.mode === "eAdding") {
      this.onDrawStart(event.target, event.timeStamp, event.offsetX, event.offsetY);
      event.stopPropagation();
    }
  }

  private onSelectEvent(event: MouseEvent) {
    const shape = this.findShapeOnMouseEvent(event);
    if (event.button == 0) { // left click
      if (shape && shape.selectable && !shape.hidden && shape.id) {
        // @ts-ignore
        const singleSelection =  this.singleSelectionMode || this.singleSelectionInEditMode && this.modeValue == 'eEditing';
        if (!singleSelection && event.shiftKey) {
          this.mode = 'eSelecting';
          this.selectionManager.selectRange(shape);
          // @ts-ignore
        } else if (!singleSelection && event.metaKey) {
          this.mode = 'eSelecting';
          this.selectionManager.addOrRemove(shape);
        } else {
          this.selectionManager.replace(shape);
          //2021 this.selectedComponent = shape.shapeComponent;
        }
        //event.stopPropagation();
      } else {
        this.selectionManager.clear();
      }
      this.emitSelectedShapes();
    }
  }


  private findShapeOnMouseEvent(event: MouseEvent): Shape {
    let shape: Shape = null;
    if (this.shapesMap && event.target instanceof SVGGraphicsElement) {
      shape = this.shapesMap.get(event.target.id);
    }
    return shape;
  }

  onContextMenuEvent(event: MouseEvent) {
    if (!this.selectionManager.hasSelectedShapes()) {
      const shape = this.findShapeOnMouseEvent(event);
      if (shape) {
        this.selectionManager.replace(shape);
      }
    }
    const contextEvent: ContextMenuSVGSelectionEvent = {
      selectedShapes: this.selectionManager.getSelected(),
      contextMenuTarget: event.target
    };
    this.onContextMenu.emit(contextEvent);
    event.stopPropagation();
    event.preventDefault();
  }

  //TODO This method should be in a shared service
  isChrome()
  {
      const agent = window.navigator.userAgent.toLowerCase()
      return (agent.indexOf('chrome') > -1 && !!(<any>window).chrome)
  }

  //TODO This method should be in a shared service
  isTouchDevice() {
    return 'ontouchstart' in document.documentElement;
  }

  // https://stackoverflow.com/questions/17130940/retrieve-the-same-offsetx-on-touch-like-mouse-event/33756703
  recoverOffsetValues(e) {
    // const rect = e.target.getBoundingClientRect();
    // const bodyRect = document.body.getBoundingClientRect();
    const rect = this.canvas.nativeElement.getBoundingClientRect();
    const bodyRect = document.body.getBoundingClientRect();
    const x = Math.round(e.targetTouches[0].pageX - (rect.left - bodyRect.left));
    const y = Math.round(e.targetTouches[0].pageY - (rect.top - bodyRect.top));

    return [x, y];
  }

  preventScroll($event) {
    if (this.mode === 'eAdding' || this.mode === 'eEditing' && this.selectedShapeIDs) {
      $event.preventDefault(); // avoid scrolling
    }
  }
  onTouchMove($event) {
    this.preventScroll($event);

    if ($event.targetTouches) {
      const coord = this.recoverOffsetValues($event);
      this.onDrawMove($event.timeStamp, coord[0], coord[1]);
    }
  }

  onMouseMove(event: MouseEvent) {
    event.preventDefault(); // prevent the region type label being selected
    if (this.onDrawMove(event.timeStamp, event.offsetX, event.offsetY)) {
      event.stopPropagation();
    }
  }

  onTouchEnd($event) {
    this.preventScroll($event);
    this.onDrawEnd();
  }

  onMouseUp($event) {
    $event.stopPropagation();
    this.onDrawEnd();
  }


  /*private highlightSelectedSVGElement(selectedElement: SVGGraphicsElement) {
    if (this.selectedShapeFillColor) {
      if (this.lastSelectedElement) {
        this.lastSelectedElement.setAttribute("fill", "transparent");
      }
      selectedElement.setAttribute("fill", this.selectedShapeFillColor);
      selectedElement.setAttribute("fill-opacity", '0.2');
      this.lastSelectedElement = selectedElement;
    }
  }*/

  private emitSelectedShapes() {
    this.selectedShapesChange.emit(this.selectionManager.getSelected());
  }
}

