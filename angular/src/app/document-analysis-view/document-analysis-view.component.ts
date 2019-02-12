import {AfterViewInit, Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {RestClientService} from '../services/rest-client.service';
import {ActivatedRoute} from '@angular/router';
import {Image} from '../model/image';
import {Page} from '../model/page';
import {BoundingBox} from '../model/bounding-box';
import {NGXLogger} from 'ngx-logger';
// import {ResizedEvent} from 'angular-resize-event/resized-event';
import {Region} from '../model/region';
import {Project} from '../model/project';
import {SessionDataService} from '../services/session-data.service';
import {SVGCanvasComponent, SVGCanvasState, SVGMousePositionEvent} from '../svgcanvas/components/svgcanvas/svgcanvas.component';
import {ShapeComponent} from '../svgcanvas/components/shape/shape.component';
import {LineComponent} from '../svgcanvas/components/line/line.component';
import {Rectangle} from '../svgcanvas/model/shape';
import {RegionType} from '../model/region-type';
import {RectangleComponent} from '../svgcanvas/components/rectangle/rectangle.component';
import {RegionService} from "../services/region.service";
import {ImageService} from "../services/image.service";

export enum DocumentAnalysisMode {
  eSelecting, eEditing, eSplittingPages, eSplittingRegions
}

@Component({
  selector: 'app-document-analysis-view',
  templateUrl: './document-analysis-view.component.html',
  styleUrls: ['./document-analysis-view.component.css']
})

export class DocumentAnalysisViewComponent implements OnInit, AfterViewInit {
  canvasCursor = 'default';
  documentAnalysisMode: DocumentAnalysisMode = DocumentAnalysisMode.eSelecting;
  image: Image;
  imageURL: string;
  project: Project;

  regionIDs: Map<number, Region> = new Map<number, Region>();
  regionTypes: RegionType[];

  @ViewChild('domImage')
  private domImage: ElementRef;

  private projectURLs: string;
  private scale: number;
  domImageHeight: number;
  domImageWidth: number;
  domImagePaddingLeft: number;

  @ViewChild('svgCanvas') svgCanvas: SVGCanvasComponent;
  private interactionLine: LineComponent;

  @Output() mouseEvent = new EventEmitter<SVGMousePositionEvent>();
  @Output() svgShapeCreated = new EventEmitter<ShapeComponent>();
  @Output() svgShapeSelected = new EventEmitter<ShapeComponent>(); // in order to observe it from other components such as symbol editing
  showLabels = true;
  private selectedRegion: ShapeComponent = null;

  constructor(
    private regionService: RegionService,
    private imageService: ImageService,
    private sessionDataService: SessionDataService,
    private route: ActivatedRoute,
    private logger: NGXLogger,
  ) {
    this.project = sessionDataService.currentProject;
    this.image = sessionDataService.currentImage;
    this.logger.debug('Working with image ' + this.imageURL);

    if (!sessionDataService.regionTypes) {
      this.regionService.getRegionTypes().subscribe(value => {
        sessionDataService.regionTypes = value;
        this.logger.debug('Fetched #' + sessionDataService.regionTypes.length + ' region types');
        this.regionTypes = value;
      }).unsubscribe();
    } else {
      this.regionTypes = sessionDataService.regionTypes;
    }
  }

  ngOnInit() {
    this.logger.debug('fullImageSVGCanvas= ' + this.svgCanvas);
  }


  public ngAfterViewInit(): void {
    this.logger.debug('ngAfterViewInit');
  }

  onImageLoad() {
    this.logger.debug('OnImageLoad');
    this.scale = this.domImage.nativeElement.width / this.domImage.nativeElement.naturalWidth;
    this.logger.debug('Using scale ' + this.scale);
    this.domImageHeight = this.domImage.nativeElement.height;
    this.domImageWidth = this.domImage.nativeElement.width;
    this.domImagePaddingLeft = this.domImage.nativeElement.paddingLeft;
    this.drawBoundingBoxes();
  }

  private drawBoundingBox(objectType: string, objectID: number, boundingBox: BoundingBox, targetScale: number,
                          strokeColor: string, strokeWidth: number, label: string) {

    const rx = boundingBox.fromX * targetScale;
    const ry = boundingBox.fromY * targetScale;
    const rwidth = targetScale * (boundingBox.toX - boundingBox.fromX);
    const rheight = targetScale * (boundingBox.toY - boundingBox.fromY);

    const rectangle = this.svgCanvas.drawRectangle(rx, ry, rwidth, rheight, label);
    rectangle.modelObjectType = objectType;
    rectangle.modelObjectID = objectID;
    rectangle.shape.shapeProperties.fillColor = 'transparent';
    rectangle.shape.shapeProperties.stroke = true;
    rectangle.shape.shapeProperties.strokeColor = strokeColor;
    rectangle.shape.shapeProperties.strokeWidth = strokeWidth;
  }


  private drawBoundingBoxes() {
    this.drawImagePages();
  }

  //TODO Centralizar imageService / regionService en lo mismo
  private splitPage(imageX: number) {
    this.logger.debug('Splitting page at X: ' + imageX);
    const prevCursor = this.canvasCursor;
    this.canvasCursor = 'wait';
    try {
      this.imageService.splitPage$(this.image.id, imageX).subscribe(next => {
        this.image.pages = next;
        this.drawImagePages();
        this.canvasCursor = prevCursor;
        this.clearInteractiveLines();
      });
    } catch (e) {
      this.canvasCursor = prevCursor;
      this.clearInteractiveLines();
    }
  }

  private splitRegion(imageX: number, imageY: number) {
    this.logger.debug('Splitting region at X: ' + imageX + ', Y: ' + imageY);
    const prevCursor = this.canvasCursor;
    this.canvasCursor = 'wait';
    try {
      this.imageService.splitRegion$(this.image.id, imageX, imageY).subscribe(next => {
        this.image.pages = next;
        this.drawImagePages();
        this.canvasCursor = prevCursor;
        this.clearInteractiveLines();
      });
    } catch (e) {
      this.canvasCursor = prevCursor;
      this.clearInteractiveLines();
    }
  }

  public clearDocumentAnalysis() {
    this.imageService.clearDocumentAnalysis$(this.image.id).subscribe(next => {
      this.image.pages = next;
      this.drawImagePages();
      this.clearInteractiveLines();
    });
  }

  private drawInteractiveVerticalLine() {
    this.interactionLine = <LineComponent>this.svgCanvas.drawLine(0, 0, 0, this.domImageWidth);
    this.interactionLine.shape.shapeProperties.strokeColor = 'red';
    this.interactionLine.shape.shapeProperties.strokeWidth = 2;
    this.svgCanvas.changeState(SVGCanvasState.eIdle);
  }

  private drawInteractiveHorizontalLine() {
    this.interactionLine = <LineComponent>this.svgCanvas.drawLine(0, 0, this.domImageWidth, 0);
    this.interactionLine.shape.shapeProperties.strokeColor = 'red';
    this.interactionLine.shape.shapeProperties.strokeWidth = 2;
    this.svgCanvas.changeState(SVGCanvasState.eIdle);
  }

  private drawImagePages() {
    this.svgCanvas.clear();
    this.logger.debug('Drawing bounding boxes for image ' + this.image);
    this.image.pages.forEach(page => {
      this.logger.debug('Page ' + page);
      this.drawBoundingBox('Page', page.id, page.boundingBox, this.scale, 'red', 12, '');
      page.regions.forEach(region => {
        this.logger.debug('Region ' + region);

        let color: string;
        if (region.regionType) {
          color = '#' + region.regionType.hexargb;
        } else {
          this.logger.debug('Region without region type');
          color = 'black';
        }
        this.drawBoundingBox('Region', region.id, region.boundingBox, this.scale, color, 3, region.regionType.name);
        this.regionIDs.set(region.id, region);
      });
    });
  }

  public findRegionID(id: number): Region {
    return this.regionIDs.get(id);
  }

  private clearInteractiveLines() {
    this.svgCanvas.remove(this.interactionLine);
  }

  onMouseEvent($event: SVGMousePositionEvent) {
    if ($event.mouseEvent.type === 'mousemove') {
      switch (this.documentAnalysisMode) {
        case DocumentAnalysisMode.eSplittingPages:
          // this.splitLine.transform(transform().translate(event.layerX, 0));
          this.interactionLine.moveHorizontallyTo($event.svgPosition.x);
          break;
        case DocumentAnalysisMode.eSplittingRegions:
          this.interactionLine.moveVerticallyTo($event.svgPosition.y);
          // this.splitLine.transform(transform().translate(0, event.layerY));
          break;
        default:
          this.mouseEvent.emit($event);
      }
    } else if ($event.mouseEvent.type === 'mousedown') {
      switch (this.documentAnalysisMode) {
        case DocumentAnalysisMode.eSplittingPages:
          this.splitPage($event.svgPosition.x / this.scale);
          break;
        case DocumentAnalysisMode.eSplittingRegions:
          this.splitRegion($event.svgPosition.x / this.scale, $event.svgPosition.y / this.scale);
          break;
        default:
          this.mouseEvent.emit($event);
      }
    } else {
      this.mouseEvent.emit($event);
    }
  }

  onShapeCreated($event: ShapeComponent) {
    // TODO para crear objetos dibujando
  }

  onShapeSelected($event: ShapeComponent) {
    this.logger.debug('Shape selected ' + $event);
    this.svgShapeSelected.emit($event);
    this.selectedRegion = $event;
  }
  onShapeDeselected($event: ShapeComponent) {
    this.selectedRegion = null;
  }

  onShapeChanged($event: ShapeComponent) {
    this.logger.debug('Image: detected a shape change on a ' + $event.modelObjectType
      + ' with ID=' + $event.modelObjectID);

    if ($event.shape instanceof Rectangle) {
      // TODO Si da error la actualización que se repinte
      if ($event.modelObjectType === 'Region') {
        this.imageService.updateRegionBoundingBox$($event.modelObjectID,
          $event.shape.originX / this.scale, $event.shape.originY / this.scale,
          ($event.shape.originX + $event.shape.width)  / this.scale,
          ($event.shape.originX + $event.shape.height) / this.scale);
      } else if ($event.modelObjectType === 'Page') {
        this.imageService.updatePageBoundingBox$($event.modelObjectID,
          $event.shape.originX / this.scale, $event.shape.originY / this.scale,
          ($event.shape.originX + $event.shape.width)  / this.scale,
          ($event.shape.originX + $event.shape.height) / this.scale);
      }
    } else {
      this.logger.debug('Image: shape change not on a rectangle');
    }
  }

  activatePageSplitMode() {
    this.documentAnalysisMode = DocumentAnalysisMode.eSplittingPages;
    this.drawInteractiveVerticalLine();
    this.canvasCursor = 'col-resize';

  }

  activateRegionSplitMode() {
    this.documentAnalysisMode = DocumentAnalysisMode.eSplittingRegions;
    this.drawInteractiveHorizontalLine();
    this.canvasCursor = 'row-resize';
  }


  activateEditMode() {
    this.documentAnalysisMode = DocumentAnalysisMode.eEditing;
    this.canvasCursor = 'move';
    this.svgCanvas.changeState(SVGCanvasState.eEditing);
  }

  activateSelectMode() {
    this.documentAnalysisMode = DocumentAnalysisMode.eSelecting;
    this.canvasCursor = 'default';
    this.svgCanvas.changeState(SVGCanvasState.eSelecting);
  }

  getImageNaturalWidth() {
    return this.domImage.nativeElement.naturalWidth;
  }

  changeRegionType(regionType: RegionType) {
    if (this.selectedRegion != null) {
      const region = this.findRegionID(this.selectedRegion.modelObjectID);
      if (region) {
        this.imageService.updateRegionType$(region.id, regionType).subscribe(next => {
          if (this.selectedRegion instanceof RectangleComponent) {
            region.regionType = regionType;
            this.selectedRegion.label = regionType.name;
          }
        });
      }
    }
  }

  trackByRegionTypeFn(index, item: RegionType) {
    return item.id; // unique id corresponding to the item
  }
}
