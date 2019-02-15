import {AfterViewInit, Component, ElementRef, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {RestClientService} from '../../../services/rest-client.service';
import {ActivatedRoute} from '@angular/router';
import {NGXLogger} from 'ngx-logger';
// import {ResizedEvent} from 'angular-resize-event/resized-event';
import {AgnosticSymbolSVGPath} from './agnostic-symbol-svgpath';
import {Project} from '../../../model/project';
import {SessionDataService} from '../../../services/session-data.service';
import {ComponentCanDeactivate} from '../../../routing/component-can-deactivate';
import {ImageToolBarService} from '../../../image-tool-bar/image-tool-bar.service';
import {SVGCanvasComponent, SVGCanvasState, SVGMousePositionEvent} from '../../../drawing/components/svgcanvas/components/svgcanvas/svgcanvas.component';
import {DocumentAnalysisViewComponent} from '../../../document-analysis/components/document-analysis-view/document-analysis-view.component';
import {ShapeComponent} from '../../../drawing/components/svgcanvas/components/shape/shape.component';
import {MousePosition, PolyLine, Rectangle} from '../../../drawing/components/svgcanvas/model/shape';
import {FreehandComponent} from '../../../drawing/components/svgcanvas/components/freehand/freehand.component';
import {AgnosticSymbolStrokes} from './agnostic-symbol-strokes';
import {Observable, timer} from 'rxjs';
import {Strokes} from '../../../model/strokes';
import {Point} from '../../../model/point';
import {SymbolCrudService} from "../../../services/crud/symbol-crud.service";
import {AgnosticRepresentationService} from "../../../services/businesslogic/agnostic-representation.service";
import {Region} from "../../../model/region";
import {Image} from "../../../model/image";
import {Symbol} from "../../../model/symbol";
import {Stroke} from "../../../model/stroke";

@Component({
  selector: 'app-symbols',
  templateUrl: './symbols.component.html',
  styleUrls: ['./symbols.component.css']
})

export class SymbolsComponent extends ComponentCanDeactivate implements OnInit, AfterViewInit, OnDestroy {
  private project: Project;
  private image: Image;
  private imageURL: string;

  @ViewChild('appDocumentAnalysisView') documentAnalysisView: DocumentAnalysisViewComponent;

  @ViewChild('selectedStaffInnerDIV') selectedStaffInnerDIV: ElementRef;

  selectedStaffImageURL: string;
  selectedStaffImageWidth: number; // the width of the domImage
  selectedStaffWidth: number;
  selectedStaffHeight: number;
  selectedStaffImageBackgroundPositionX: number;
  selectedStaffImageBackgroundPositionY: number;
  selectedStaffImageBackgroundPertentage: number;
  staffSelected = false;

  // svgOfSymbols: Array<string> = [];
  // private scale: number;
  /// private selectedElementGroup: Group;
  private selectedStaffFinalScale: number;
  private expectedStaffWidthPercentage: number;
  private selectedStaffScale: number;

  agnosticStaffHeight = 0;
  agnosticStaffWidth = 0;
  staffLineYCoordinates: number[];
  agnosticSymbols: Map<number, Symbol>; // number is the symbol ID
  agnosticSymbolSVGMap: Map<string, string>;
  agnosticSymbolSVGs: Map<number, AgnosticSymbolSVGPath>; // number is the symbol ID
  agnosticSymbolStrokes: Map<number, AgnosticSymbolStrokes>; // number is the symbol ID
  agnosticSVGScaleX: number;
  agnosticSVGScaleY: number;
  agnosticSVGem: number;
  staffSpaceHeight: number;
  staffMargin: number;
  private staffBottomLineY: number;

  @ViewChild('svgCanvas') svgCanvas: SVGCanvasComponent;
  private selectedRegion: Region;
  private selectedSymbol: Symbol;
  selectedStaffCursor = 'default';
  showSymbolStrokes: boolean;
  private currentTimerID = 0;
  private currentStrokes: Strokes = null;
  private currentStrokesFreeHandComponents: Array<ShapeComponent>;

  constructor(
    private agnosticRepresentationService: AgnosticRepresentationService,
    private symbolService: SymbolCrudService, //TODO Quitar
    private sessionDataService: SessionDataService,
    private route: ActivatedRoute,
    private logger: NGXLogger,
    private toolbarService: ImageToolBarService
  ) {
    super();
    this.agnosticSymbolSVGMap = new Map();
  }

  ngOnInit() {
    /*if (true) {
      /// ------- DEVELOPMENT FIXED VALUES ----
      this.im3wsService.getProject$(37).subscribe(next => {
        this.sessionDataService.currentProject = next;
        this.project = this.sessionDataService.currentProject;
        this.loadSVGSet();
      });

      this.im3wsService.getImage$(198).subscribe(next => {
        console.log('next = ' + next);
        this.sessionDataService.currentImage = next;
        this.sessionDataService.currentImageMastersURL = 'http://localhost:8888/muret/villancico-al-smo--sto--al-molino-del-amor/masters/';

        this.image = this.sessionDataService.currentImage;
        this.imageURL = this.sessionDataService.currentImageMastersURL + '/' + this.image.filename;

        this.toolbarService.currentActivePanel = 'symbolsMode';
        this.logger.debug('Working with image ' + this.imageURL);
      });
    } else {*/
      this.project = this.sessionDataService.currentProject;
      this.image = this.sessionDataService.currentImage;
      this.logger.debug('Working with image ' + this.imageURL);
      this.loadSVGSet();
    // }
    this.initToolBarInteraction();
    this.documentAnalysisView.activateSelectMode();
  }

  // TODO - usado en el *nfFor con keyvalue, ver si podemos coger el id del símbolo mejor - lo hacemos en dos sitios
  trackByFn(index, item) {
    return index;
  }

  private loadSVGSet() {
    this.agnosticRepresentationService.getSVGSet$(this.project.notationType, this.project.manuscriptType).
    subscribe(next => {
        this.agnosticSVGScaleX = next.x;
        this.agnosticSVGScaleY = next.y;
        this.agnosticSVGem = next.em;
        this.staffSpaceHeight = this.agnosticSVGem / 4.0;

        this.agnosticSymbolSVGMap = new Map();
        next.paths.forEach(item => {
          this.agnosticSymbolSVGMap.set(item.agnosticTypeString, item.svgPathD);
        });
        this.logger.debug('Using SVG scales: (' + this.agnosticSVGScaleX + ', ' + this.agnosticSVGScaleY
          + '), with default em=' + this.agnosticSVGem
        + ' with ' + this.agnosticSymbolSVGMap.size + ' SVG elements');

        this.drawStaff();
        this.drawAgnosticToolBar();
      }
    );
  }

  private drawAgnosticToolBar() {
    // TODO ordenar
  }

  private initToolBarInteraction() {
    this.toolbarService.selectedTool$.subscribe(next => {
      this.logger.debug('Using interaction: ' + next);
      this.selectedStaffCursor = 'default';
      switch (next) {
        case '200': // symbols select
          this.svgCanvas.changeState(SVGCanvasState.eEditing);
          break;
        case '201': // symbols bounding boxes
          this.svgCanvas.selectShapeProperties('transparent', 2, 'lightgreen'); // TODO values
          this.svgCanvas.selectShape('Rectangle');
          this.svgCanvas.changeState(SVGCanvasState.eDrawing);
          this.selectedStaffCursor = 'cell';
          break;
        case '202': // symbols strokes
          this.svgCanvas.selectShapeProperties('transparent', 2, 'lightgreen'); // TODO values
          this.svgCanvas.selectShape('Freehand');
          this.svgCanvas.changeState(SVGCanvasState.eDrawing);
          this.selectedStaffCursor = 'crosshair';
          break;

      }
    });
    this.toolbarService.selectedTool = '200';
  }


  public ngAfterViewInit(): void {
  }


  public ngOnDestroy() {
  }

  /*onResized(event: ResizedEvent): void {
    this.logger.debug('Resized');
    if (this.imageSurface) {
      this.scale = this.domImage.nativeElement.width / this.domImage.nativeElement.naturalWidth;
      this.drawBoundingBoxes();
    } // else it is invoked before ngAfterViewInit
  }
*/

  private doSelectRegion(region: Region) {
    this.staffSelected = true;
    this.selectedRegion = region;
    this.drawSelectedRegion(region);
    this.agnosticStaffWidth = this.selectedStaffWidth;
    this.drawSelectedRegionSymbols(region);
  }


  private drawSymbol(symbol: Symbol) {
    this.agnosticSymbols.set(symbol.id, symbol);
    this.drawSymbolStrokes(symbol);
    this.drawSymbolBoundingBox(symbol);
    this.drawSymbolAgnostic(this.selectedRegion, symbol);
  }

  private drawSymbolStrokes(symbol: Symbol) {
    this.logger.debug('Drawing symbol ' + symbol.id);
    if (symbol.strokes != null) {
      this.logger.debug('Drawing ' + symbol.strokes.strokeList.length + ' strokes');
      const agnosticStrokes = new AgnosticSymbolStrokes();
      symbol.strokes.strokeList.forEach(stroke => {
        const component = this.drawStroke(symbol, stroke);
        agnosticStrokes.freehandComponents.push(component);
      });
      this.agnosticSymbolStrokes.set(symbol.id, agnosticStrokes);
    }
  }

  private drawStaff() {
    this.staffMargin = this.agnosticSVGem;
    this.staffLineYCoordinates = new Array(5);
    let i = 0;
    for (i = 0 ; i < 5; i++) {
      const y = i * this.staffSpaceHeight + this.staffMargin;
      this.staffLineYCoordinates[i] = y;
      if (i === 4) {
        this.staffBottomLineY = y;
      }
    }
    this.agnosticStaffHeight = this.staffMargin * 2 + this.staffSpaceHeight * 5;
    this.agnosticSymbolSVGs = new Map<number, AgnosticSymbolSVGPath>();
    this.agnosticSymbolStrokes = new Map<number, AgnosticSymbolStrokes>();
  }

  private drawSelectedRegion(region: Region) {
    this.selectedStaffImageURL = this.imageURL;
    const regionWidth = region.boundingBox.toX - region.boundingBox.fromX;
    const regionHeight = region.boundingBox.toY - region.boundingBox.fromY;
    this.selectedStaffWidth = this.selectedStaffInnerDIV.nativeElement.offsetWidth;
    this.selectedStaffImageWidth = this.documentAnalysisView.getImageNaturalWidth();
    this.selectedStaffScale = this.selectedStaffImageWidth / regionWidth;
    const expectedStaffWidth = regionWidth / this.selectedStaffScale;
    this.expectedStaffWidthPercentage = this.selectedStaffWidth / expectedStaffWidth;
    this.selectedStaffImageBackgroundPertentage = this.selectedStaffScale * 100.0;
    this.selectedStaffImageBackgroundPositionX = this.expectedStaffWidthPercentage * (-region.boundingBox.fromX / this.selectedStaffScale);
    this.selectedStaffImageBackgroundPositionY = this.expectedStaffWidthPercentage * (-region.boundingBox.fromY / this.selectedStaffScale);
    this.selectedStaffHeight = (regionHeight / this.selectedStaffScale) * this.expectedStaffWidthPercentage;
    this.selectedStaffFinalScale = this.selectedStaffScale;
    this.logger.debug('Selected staff scale: ' + this.selectedStaffScale
      + ', regionBBoxY=' + region.boundingBox.fromY
      + ', selectedStaffImageBackgroundPositionY=' + this.selectedStaffImageBackgroundPositionY
      + ', expectedStaffWidthPercentage= ' + this.expectedStaffWidthPercentage

  );
  }

 /* private drawSelectedRegionSymbolBoxes(region: Region) {
    this.logger.debug('Drawing region symbol boxes');
    /// this.selectedStaffBoundingBoxesGroup.clear();
    if (region.symbols) {
      region.symbols.forEach(symbol => {
        this.logger.debug('Drawing symbol ' + symbol);

        const fromX = ((symbol.boundingBox.fromX - region.boundingBox.fromX) / this.selectedStaffScale) * this.expectedStaffWidthPercentage;
        const fromY = ((symbol.boundingBox.fromY - region.boundingBox.fromY) / this.selectedStaffScale) * this.expectedStaffWidthPercentage;
        const toX = ((symbol.boundingBox.toX - region.boundingBox.fromX) / this.selectedStaffScale) * this.expectedStaffWidthPercentage;
        const toY = ((symbol.boundingBox.toY - region.boundingBox.fromY) / this.selectedStaffScale) * this.expectedStaffWidthPercentage;

        const translatedAndScaledBoundingBox = new BoundingBox(
          fromX, fromY, toX, toY
        );

        this.drawBoundingBox(this.selectedStaffBoundingBoxesGroup, symbol, translatedAndScaledBoundingBox,
          1,
          'blue', 1);
      });
    }
  }*/

  computeAgnosticStaffSymbolY(region: Region, symbol: Symbol): number {
    const lineSpace = this.positionInStaffToLineSpace(symbol.positionInStaff);
    const heightDifference = -(this.staffSpaceHeight * (lineSpace / 2.0));
    const y = this.staffBottomLineY  + heightDifference;
    return y;
  }

  /* TODO Posición */
  private drawSymbolAgnostic(region: Region, symbol: Symbol) {
    this.logger.debug('Drawing SVG ' + symbol);
    if (symbol.agnosticSymbolType) {
      const x = ((symbol.boundingBox.fromX - region.boundingBox.fromX) / this.selectedStaffScale) * this.expectedStaffWidthPercentage;
      const svg = this.agnosticSymbolSVGMap.get(symbol.agnosticSymbolType);
      const y = this.computeAgnosticStaffSymbolY(region, symbol);
      const asvg = new AgnosticSymbolSVGPath(svg, x, y);
      this.agnosticSymbolSVGs.set(symbol.id, asvg);
      /*if (!svg) {
        this.im3wsService.getSVGFromAgnosticSymbolType$(
          this.project.notationType,
          this.project.manuscriptType,
          symbol.agnosticSymbolType).subscribe(next => {
          const svgD = next.response;
          this.agnosticSymbolSVGMap.set(symbol.agnosticSymbolType, svgD);
          const asvg = new AgnosticSymbolSVGPath(svgD, x, y);
          this.agnosticSymbolSVGs.push(asvg);
        });
      } else {
        const asvg = new AgnosticSymbolSVGPath(svg, x, y);
        this.agnosticSymbolSVGs.push(asvg);
      }*/ // TODO
    }
  }

  private drawSelectedRegionSymbols(region: Region) {
    this.svgCanvas.clear();
    this.agnosticSymbolSVGs = new Map<number, AgnosticSymbolSVGPath>(); // empty it
    this.agnosticSymbols = new Map<number, Symbol>(); // empty it
    region.symbols.forEach(symbol => {
      this.drawSymbol(symbol);
    });
  }

  // TODO Sacar todo esto a componentes
  private positionInStaffToLineSpace(positionInStaff: string): number {
    const value = Number(positionInStaff.substr(1));
    if (positionInStaff.charAt(0) === 'L') {
      return (value - 1) * 2;
    } else if (positionInStaff.charAt(0) === 'S') {
      return (value) * 2 - 1;
    } else {
      throw new Error('Invalid positionInStaff, it should start with L or S: ' + positionInStaff);
    }
  }

  canDeactivate(): boolean {
    return false; // TODO
  }
  onMouseEvent($event: SVGMousePositionEvent) {
  }

  onRegionSelected($event: ShapeComponent) {
    if ($event.modelObjectType === 'Region') {
      // look for the region ID
      const region = this.documentAnalysisView.findRegionID($event.modelObjectID);
      if (!region) {
        this.logger.warn('Cannot find region with id ' + $event.modelObjectID);
      } else {
        this.logger.debug('Region with id ' + $event.modelObjectID + ' selected');
        this.doSelectRegion(region);
      }
    }
  }

  onShapeSelected($event: ShapeComponent) {
    if ($event == null) {
      this.selectedSymbol = null;
    } else if ($event.modelObjectType === 'Symbol') {
      const symbol = this.agnosticSymbols.get($event.modelObjectID);
      if (!symbol) {
        this.logger.warn('Cannot find symbol with id ' + $event.modelObjectID);
      } else {
        this.logger.debug('Symmbol with id ' + $event.modelObjectID + ' selected');
        this.doSelectSymbol(symbol);
      }
    }
  }


  onShapeCreated($event: ShapeComponent) {
    this.logger.debug('New bounding box: ' + $event);
    if ($event.shape instanceof Rectangle) {
      const shape = $event.shape;

     /* const fromX = this.selectedRegion.boundingBox.fromX + ((shape.originX) * this.selectedStaffScale)
        / this.expectedStaffWidthPercentage;
      const fromY = this.selectedRegion.boundingBox.fromY + (( shape.originY) * this.selectedStaffScale)
        / this.expectedStaffWidthPercentage;
      const toX = this.selectedRegion.boundingBox.fromX  + (( shape.originX + shape.width) * this.selectedStaffScale)
        / this.expectedStaffWidthPercentage;
      const toY = this.selectedRegion.boundingBox.fromY + ((shape.originY + shape.height) * this.selectedStaffScale)
        / this.expectedStaffWidthPercentage;*/
      const fromX = this.fromScreenX(shape.originX);
      const fromY = this.fromScreenY(shape.originY);

      const toX = this.fromScreenX(shape.originX + shape.width);
      const toY = this.fromScreenY(shape.originY + shape.height);


      const prevCursor = this.selectedStaffCursor;
      this.selectedStaffCursor = 'wait';
      this.agnosticRepresentationService.createSymbolFromBoundingBox$(this.selectedRegion, fromX, fromY,
        toX, toY).subscribe(next => {
          this.selectedStaffCursor = prevCursor;
          this.logger.debug('New symbol created ' + next.id);
          this.svgCanvas.remove($event);
          this.drawSymbol(next);
          this.selectedRegion.symbols.push(next); // the im3ws spring service just returns the new symbol, not the complete region on each symbol insert
      });
    } else if ($event.shape instanceof PolyLine) {
        const shape = $event.shape;

        const source = timer(300); // TODO timer duration, now 300ms
        this.currentTimerID ++;
        const subscribe = source.subscribe(val =>
          this.onStrokesTimer(this.currentTimerID)
        );

        if (this.currentStrokes == null) {
          //this.currentStrokes = new Strokes(new Array<Stroke>());
          this.currentStrokes = {strokeList: []};
        }

        const points = new Array<Point>();
        let prevTimeStamp = 0;
        shape.points.forEach(p => {
          let t: number;
          if (prevTimeStamp === 0) {
            t = 0;
          } else {
            t = p.timestamp - prevTimeStamp;
          }
          prevTimeStamp = p.timestamp;
          const point = {time: t, x: this.fromScreenX(p.x), y: this.fromScreenY(p.y)};
          points.push(point);
        });
      //const stroke = new Stroke(points);
      const stroke = {points: points};
      this.currentStrokes.strokeList.push(stroke);

      if (this.currentStrokesFreeHandComponents == null) {
        this.currentStrokesFreeHandComponents = new Array<ShapeComponent>();
      }
      this.currentStrokesFreeHandComponents.push($event);
    }
  }

  private onStrokesTimer(timerID: number) {
    if (timerID === this.currentTimerID) {
      // generate strokes
      const prevCursor = this.selectedStaffCursor;
      this.selectedStaffCursor = 'wait';
      this.agnosticRepresentationService.createSymbolFromStrokes$(this.selectedRegion, this.currentStrokes).subscribe(next => {
        this.selectedStaffCursor = prevCursor;
        this.logger.debug('New symbol created ' + next.id);

        this.currentStrokesFreeHandComponents.forEach(shape => {
          this.svgCanvas.remove(shape);
        });

        this.currentStrokes = null;
        this.currentStrokesFreeHandComponents = null;
        this.drawSymbol(next);
        this.selectedRegion.symbols.push(next); // the im3ws spring service just returns the new symbol, not the complete region on each symbol insert
      });
    } // else discard it because it has been overwritten by the new one
  }

  private toScreenX(x: number): number {
    return ((x - this.selectedRegion.boundingBox.fromX) / this.selectedStaffScale)
      * this.expectedStaffWidthPercentage;
  }

  private toScreenY(y: number): number {
    return ((y - this.selectedRegion.boundingBox.fromY) / this.selectedStaffScale)
      * this.expectedStaffWidthPercentage;
  }

  public fromScreenX(x: number): number {
    return this.selectedRegion.boundingBox.fromX + (x * this.selectedStaffScale)
      / this.expectedStaffWidthPercentage;
  }

  public fromScreenY(y: number): number {
    return this.selectedRegion.boundingBox.fromY + (y * this.selectedStaffScale)
      / this.expectedStaffWidthPercentage;
  }

  private drawSymbolBoundingBox(symbol: Symbol) {
    if (symbol.boundingBox) {
      const fromX = this.toScreenX(symbol.boundingBox.fromX);
      const fromY = this.toScreenY(symbol.boundingBox.fromY);
      const toX = this.toScreenX(symbol.boundingBox.toX);
      const toY = this.toScreenY(symbol.boundingBox.toY);
      /*const fromX = symbol.boundingBox.fromX;
      const fromY = symbol.boundingBox.fromY;
      const toX = symbol.boundingBox.toX;
      const toY = symbol.boundingBox.toY;*/

      const shapeComponent = this.svgCanvas.drawRectangle(fromX, fromY, toX - fromX, toY - fromY, '');
      shapeComponent.shape.shapeProperties.fillColor = 'transparent';
      shapeComponent.shape.shapeProperties.strokeWidth = 1;
      shapeComponent.shape.shapeProperties.strokeColor = 'lightgreen'; // TODO
      shapeComponent.modelObjectType = 'Symbol';
      shapeComponent.modelObjectID = symbol.id;
    }
  }

  private drawStroke(symbol: Symbol, stroke: Stroke): FreehandComponent {
    if (stroke) {
      const mousePositions = new Array<MousePosition>();
      stroke.points.forEach(point => {
        const mousePosition = new MousePosition();

        mousePosition.x = this.toScreenX(point.x);
        mousePosition.y = this.toScreenY(point.y);
        mousePositions.push(mousePosition);
      });

      const shapeComponent = this.svgCanvas.drawFreeHand(mousePositions);

      shapeComponent.shape.shapeProperties.fillColor = 'transparent';
      shapeComponent.shape.shapeProperties.strokeWidth = 2;
      shapeComponent.shape.shapeProperties.strokeColor = 'blue'; // TODO
      shapeComponent.modelObjectType = 'Symbol';
      shapeComponent.modelObjectID = symbol.id;

      return shapeComponent;
    } else {
      return null;
    }
  }


  private doSelectSymbol(symbol: Symbol) {
    this.selectedSymbol = symbol;
    // it is automatically selected in agnostic staff (see getAgnosticStaffSymbolColor)
  }

  onAgnosticStaffSymbolSelected(symbolID: number) {
    // select symbol
    // TODO
  }

  getAgnosticStaffSymbolColor(symbolID: number): string {
    if (this.selectedSymbol != null && this.selectedSymbol.id === symbolID) {
      return 'red';
    } else {
      return 'black'; // TODO Constantes
    }
  }

  deleteSelectedSymbol() {
    if (this.selectedSymbol != null) {
      this.agnosticRepresentationService.deleteSymbol$(this.selectedRegion.id, this.selectedSymbol.id).subscribe(() => {
        this.agnosticSymbols.delete(this.selectedSymbol.id);
        this.agnosticSymbolSVGs.delete(this.selectedSymbol.id);
        this.svgCanvas.remove(this.svgCanvas.selectedComponent);

        const strokes = this.agnosticSymbolStrokes.get(this.selectedSymbol.id);
        if (strokes) {
          strokes.freehandComponents.forEach(component => {
            this.svgCanvas.remove(component);
          });
          this.agnosticSymbolStrokes.delete(this.selectedSymbol.id);
        }
        this.selectedSymbol = null;
      });
    }
  }

  movePitchSelectedSymbol(upOrDown: string) {
    if (this.selectedSymbol != null) {
      this.agnosticRepresentationService.changeAgnosticPositionInStaffUpOrDown$(this.selectedSymbol.id, upOrDown).subscribe( next => {
        this.selectedSymbol.positionInStaff = next.positionInStaff;
        const newY = this.computeAgnosticStaffSymbolY(this.selectedRegion, this.selectedSymbol);
        const svgPath = this.agnosticSymbolSVGs.get(this.selectedSymbol.id);
        if (!svgPath) {
          throw new Error('Cannot find an agnostic staff symbol for id ' + this.selectedSymbol.id);
        }

        svgPath.y = newY;
      });
    }
  }

  movePitchUpSelectedSymbol() {
    this.movePitchSelectedSymbol('up');
  }

  movePitchDownSelectedSymbol() {
    this.movePitchSelectedSymbol('down');
  }

  changeAgnosticType(type: string) {
    this.agnosticRepresentationService.changeAgnosticSymbolType$(this.selectedSymbol.id, type).subscribe( next => {
      this.selectedSymbol.positionInStaff = next.positionInStaff;
      const svgPath = this.agnosticSymbolSVGs.get(this.selectedSymbol.id);
      if (!svgPath) {
        throw new Error('Cannot find an agnostic staff symbol for id ' + this.selectedSymbol.id);
      }
      const newSVG = this.agnosticSymbolSVGMap.get(type);
      svgPath.d = newSVG;
    });
  }

}
