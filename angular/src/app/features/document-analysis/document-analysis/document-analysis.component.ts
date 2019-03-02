import {Component, OnInit, Self, ViewChild} from '@angular/core';
import {DocumentAnalysisService} from '../document-analysis.service';
import {observable, Observable, of} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {map, switchMap, tap} from 'rxjs/operators';
import {ImageFilesService} from '../../../core/services/image-files.service';
import {DocumentAnalysisImageProjection} from '../../../core/model/restapi/document-analysis-image-projection';
import {Rectangle} from '../../../svg/model/rectangle';
import {Line} from '../../../svg/model/line';
import {Text} from '../../../svg/model/text';
import {Path} from '../../../svg/model/path';
import {Shape} from '../../../svg/model/shape';
import {SvgCanvasComponent} from '../../../svg/components/svg-canvas/svg-canvas.component';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {SVGCanvasState} from '../../../svg/services/svg-canvas-state.service';
import {RegionType} from '../../../core/model/entities/region-type';
import {Page} from '../../../core/model/entities/page';
import {BoundingBox} from '../../../core/model/entities/bounding-box';
import {Region} from '../../../core/model/entities/region';
import {ChangeResponse} from '../../../core/model/restapi/change-response';
import {SimpleModalService} from 'ngx-simple-modal';
import {AlertComponent} from '../../../shared/components/error-modal-message/alert.component';

// TODO Ordenar este código
@Component({
  selector: 'app-document-analysis',
  templateUrl: './document-analysis.component.html',
  styleUrls: ['./document-analysis.component.css'],
  providers: [DocumentAnalysisService]
})
export class DocumentAnalysisComponent implements OnInit {
  documentAnalysisImageProjection$: Observable<DocumentAnalysisImageProjection>;
  loadingImage = 'assets/loading.svg';
  loadedImage$: Observable<string>;

  regionTypes$: Observable<RegionType[]>;

  private shapes = new Array<Shape>();
  private imageHeight: number;
  private imageWidth: number;


  @ViewChild('svgCanvasComponent') svgCanvasComponent: SvgCanvasComponent;
  canvasHeightPercentage: number;  // e.g. 100 for 100%
  canvasWidthPercentage: number;
  zoomFactor = 1;

  layersCheckboxes: FormGroup;

  // tools
  public toolRadioGroup: FormGroup;
  public regionTypesRadioGroupForm: FormGroup;
  private selectedShape: Shape;
  private lastRegionType: RegionType;
  private imageID: number;
  // end tools

  constructor(@Self() private documentAnalysisService: DocumentAnalysisService,
              private imageFilesService: ImageFilesService,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private simpleModalService: SimpleModalService
              ) {
  }

  ngOnInit() {
    this.imageID = Number(this.route.snapshot.paramMap.get('id'));

    // tools
    this.toolRadioGroup = this.formBuilder.group({
      model: 'idle'
    });

    this.regionTypesRadioGroupForm = this.formBuilder.group({
      regionTypeRadioButton: 'none'
    });

    this.layersCheckboxes = this.formBuilder.group({
      page: true
    });

    // get different region types
    this.regionTypes$ = this.documentAnalysisService.getRegionTypes$().pipe(
      tap(regionTypes => regionTypes.forEach(regionType => {
        this.layersCheckboxes.addControl(regionType.name, new FormControl(true));
        this.regionTypesRadioGroupForm.addControl('regionTypeRadioButton', new FormControl(false));
        }
      ))
    );
    this.layersCheckboxes.valueChanges.subscribe(val => {
      this.onLayerVisibilityChanged(val);
    });

    // download image
    this.reloadData();

    this.computeZoom();
  }

  private reloadData() {
    this.documentAnalysisImageProjection$ = this.documentAnalysisService.getDocumentAnalysisImageProjection$(this.imageID);
    this.loadedImage$ = this.documentAnalysisImageProjection$.pipe(
      switchMap(next => {
        return this.readImageContents(next);
      })
    );
  }

  private readImageContents(documentAnalysisImageProjection: DocumentAnalysisImageProjection) {
    this.imageWidth = documentAnalysisImageProjection.width;
    this.imageHeight = documentAnalysisImageProjection.height;
    this.drawPagesAndRegions(documentAnalysisImageProjection);

    return this.imageFilesService.getMasterImageBlob$(documentAnalysisImageProjection.projectPath, documentAnalysisImageProjection.id).
      pipe(map(imageBlob => window.URL.createObjectURL(imageBlob)));
  }

  zoomIn() {
    this.zoomFactor += 0.5;
    this.computeZoom();
  }

  zoomOut() {
    this.zoomFactor = Math.max(1, this.zoomFactor - 0.5);
    this.computeZoom();
  }

  zoomFit() {
    this.zoomFactor = 1;
    this.computeZoom();
  }

  private computeZoom() {
    this.canvasHeightPercentage = 100.0 * this.zoomFactor;
    this.canvasWidthPercentage = 100.0 * this.zoomFactor;
  }

  public select(): SVGCanvasState {
    return this.svgCanvasComponent.requestStateChange(SVGCanvasState.eSelecting);
  }

  public edit(): SVGCanvasState {
    return this.svgCanvasComponent.requestStateChange(SVGCanvasState.eEditing);
  }

  public draw(): SVGCanvasState {
    return this.svgCanvasComponent.requestStateChange(SVGCanvasState.eDrawing, Rectangle);
  }

  public idle(): SVGCanvasState {
    return this.svgCanvasComponent.requestStateChange(SVGCanvasState.eIdle);
  }

  onShapeSelected(shape: Shape) {
    this.selectedShape = shape;
    if (shape) {
      this.regionTypesRadioGroupForm.get('regionTypeRadioButton').setValue(shape.layer);
    }
  }

  onShapeDeselected(shape: Shape) {
    this.selectedShape = null;
  }

  trackByRegionTypeFn(index, item: RegionType) {
    return item.id; // unique id corresponding to the item
  }

  private drawPagesAndRegions(documentAnalysisImageProjection: DocumentAnalysisImageProjection) {
    documentAnalysisImageProjection.pages.forEach(page => {
      this.drawPage(page);
      page.regions.forEach(region => {
        this.drawRegion(region);
      });
    });
  }

  /*example() {
    const rect = new Rectangle();
    rect.id = '1';
    rect.fromX = 0;
    rect.fromY = 0;
    rect.width = 1000;
    rect.height  = 500;
    rect.strokeDashArray = '20';
    rect.fillColor = 'blue';
    rect.strokeColor = 'green';
    rect.strokeWidth = 20;

    this.shapes.push(rect);


    const line = new Line();
    line.id = '2';
    line.fromX = 0;
    line.fromY = 0;
    line.toX = 2965;
    line.toY = 2126;
    line.strokeColor = 'yellow';
    line.strokeWidth = 10;
    this.shapes.push(line);

    const text = new Text();
    text.id = '3';
    text.fromX = 125;
    text.fromY = 123;
    text.text = 'David';
    this.shapes.push(text);

    const path = new Path();
    path.id = '4';
    path.d = 'M150 0 L75 200 L225 200 Z';
    this.shapes.push(path);


    text.fromX = 0;
    text.fromY = 200;
  }*/

  private drawBox(layer: string, id: number, boundingBox: BoundingBox, color: string): Rectangle {
    const rect = new Rectangle();
    rect.id = layer + id;
    rect.fromX = boundingBox.fromX;
    rect.fromY = boundingBox.fromY;
    rect.width = boundingBox.toX - boundingBox.fromX;
    rect.height  = boundingBox.toY - boundingBox.fromY;
    rect.fillColor = 'transparent';
    rect.strokeColor = color;
    rect.strokeWidth = 3;
    rect.layer = layer;
    this.shapes.push(rect);
    return rect;
  }
  private drawPage(page: Page) {
    this.drawBox('page', page.id, page.boundingBox, 'red' ).data = page; // TODO color
  }

  private drawRegion(region: Region) {
    this.drawBox(region.regionType.name, region.id, region.boundingBox, '#' + region.regionType.hexargb ).data = region;
  }

  private onLayerVisibilityChanged(val: any) {
    this.shapes.forEach(shape => {
      const checkBox = this.layersCheckboxes.get(shape.layer);
      shape.hidden = !this.layersCheckboxes.get(shape.layer).value;
    });
  }

  // ------------- METHODS that deal with actual data -------------
  onShapeCreated(shape: Shape) {
    const rectangle = shape as Rectangle;
    const selectedRegionTypeOrPage = this.regionTypesRadioGroupForm.value.regionTypeRadioButton;
    let boxTypeName: string;
    if (!selectedRegionTypeOrPage || selectedRegionTypeOrPage === 'none') {
      this.showError('Shape creation', 'Select page or the type of region first'); // TODO que esté seleccionado el último por defecto
      this.shapes = [...this.shapes]; // propagate error by not changing anything on shapes
    } else {
      let response: Observable<ChangeResponse<any>>;
      if (selectedRegionTypeOrPage === 'page') {
        boxTypeName = 'Page';
        response = this.documentAnalysisService.createPage(this.imageID, rectangle.fromX, rectangle.fromY,
          rectangle.fromX + rectangle.width, rectangle.fromY + rectangle.height);
      } else {
        boxTypeName = 'Region';
        response = this.documentAnalysisService.createRegion(this.imageID, this.lastRegionType, rectangle.fromX, rectangle.fromY,
          rectangle.fromX + rectangle.width, rectangle.fromY + rectangle.height);
      }

      response.subscribe(next => {
        if (!next.ok) {
          this.showError('Cannot create ' + boxTypeName, next.errorMessage);
          this.shapes = [...this.shapes]; // propagate error by not changing anything on shapes
        }
      });
    }

    // TODO crear páginas
    // TODO
    // shape.id = '10202';
    // the array address must be changed in order to propagate changes to the @Input onChange
    /*const error = false;
    const regionTypeName = this.regionTypesRadioGroupForm.get('regionTypeRadioButton').value;

    // TODO algo más elegante....
    const regionType = this.regionTypes.find(rt => rt.name === regionTypeName);
    shape.layer = regionTypeName;
    // TODO (shape.data as Region).regionType = regionType;
    shape.strokeColor = '#' + regionType.hexargb; // TODO TODO TODO

    if (!error) {
      this.shapes = [...this.shapes, shape];
    } else {
      this.shapes = [...this.shapes]; // error - propagate error by not adding the shape
    }*/
  }

  onShapeChanged(shape: Shape) {
    let response: Observable<ChangeResponse<any>>;
    const rectangle = shape as Rectangle;

    if (shape.layer === 'page') {
      response = this.documentAnalysisService.updatePageBoundingBox(rectangle.data, rectangle.fromX, rectangle.fromY,
        rectangle.fromX + rectangle.width, rectangle.fromY + rectangle.height);
    } else {
      response = this.documentAnalysisService.updateRegionBoundingBox(rectangle.data, rectangle.fromX, rectangle.fromY,
        rectangle.fromX + rectangle.width, rectangle.fromY + rectangle.height);
    }

    response.subscribe(next => {
      if (!next.ok) {
        this.showError('Cannot save region bounding box change', next.errorMessage); // TODO - restaurar al que tenía
      }
    });
  }

  isAddingMode(): boolean {
    return this.toolRadioGroup.value.model === 'draw';
  }

  isEditingMode(): boolean {
    return this.toolRadioGroup.value.model === 'edit';
  }

  setRegionType(regionType: RegionType) {
    this.lastRegionType = regionType;

    if (this.isEditingMode()) {
      let response: Observable<ChangeResponse<any>>;

      const shape = this.selectedShape;
      if (!shape) {
        throw new Error('No selected shape');
      }

      if (shape.layer === 'page') {
        throw new Error('Cannot change a page to any region type');
      } else {
        response = this.documentAnalysisService.updateRegionType(shape.data, regionType);
      }

      response.subscribe(next => {
        if (next.ok) {
          shape.layer = regionType.name;
          shape.strokeColor = '#' + regionType.hexargb;
        } else {
          this.showError('Cannot change region type', next.errorMessage);
        }
      });
    }
  }

  clear() {
    const response: Observable<ChangeResponse<Page[]>> = this.documentAnalysisService.clear(this.imageID);

    response.subscribe(next => {
      if (next.ok) {
        // this.drawPagesAndRegions(next.content as Page[]); // TODO tenemos pages diferentes en this.documentAnalysisImageProjection$ y aquí, ¿deberíamos recargarlo todo de nuevo?
        this.reloadData();
      } else {
        this.showError('Cannot clear image', next.errorMessage);
      }
    });

  }

  // todo - generalizarlo
  showError(title: string, message: string) {
    this.simpleModalService.addModal(AlertComponent, {title, message});
  }

}
