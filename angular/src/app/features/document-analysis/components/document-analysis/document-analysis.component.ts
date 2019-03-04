import {Component, OnDestroy, OnInit, Self, ViewChild} from '@angular/core';
import {DocumentAnalysisService} from '../../services/document-analysis.service';
import {observable, Observable, of, Subscription} from 'rxjs';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {map, share, switchMap, tap} from 'rxjs/operators';
import {DocumentAnalysisImageProjection} from '../../../../core/model/restapi/document-analysis-image-projection';
import {Rectangle} from '../../../../svg/model/rectangle';
import {Shape} from '../../../../svg/model/shape';
import {SvgCanvasComponent} from '../../../../svg/components/svg-canvas/svg-canvas.component';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {SVGCanvasState} from '../../../../svg/services/svg-canvas-state.service';
import {RegionType} from '../../../../core/model/entities/region-type';
import {Page} from '../../../../core/model/entities/page';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {Region} from '../../../../core/model/entities/region';
import {ServerError} from '../../../../core/model/restapi/server-error';
import {SimpleModalService} from 'ngx-simple-modal';
import {AlertComponent} from '../../../../shared/components/error-modal-message/alert.component';
import {Store} from '@ngrx/store';
import {DocumentAnalysisState} from '../../store/state/document-analysis.state';
import {
  ChangePageBoundingBox,
  ChangeRegionBoundingBox,
  ChangeRegionType,
  GetImageProjection,
  GetImageURL,
  GetRegionTypes
} from '../../store/actions/document-analysis.actions';
import {
  selectFileName,
  selectImageHeight, selectImageURL,
  selectImageWidth,
  selectManuscriptType,
  selectNotationType, selectPages, selectProjectPath,
  selectRegionTypes
} from '../../store/selectors/document-analysis.selector';

@Component({
  selector: 'app-document-analysis',
  templateUrl: './document-analysis.component.html',
  styleUrls: ['./document-analysis.component.css'],
  providers: []
})
export class DocumentAnalysisComponent implements OnInit, OnDestroy {
  private imageID: number;
  imageWidth$: Observable<number>;
  imageHeight$: Observable<number>;
  filename$: Observable<string>;
  imageURL$: Observable<string>;
  loadingImage = 'assets/loading.svg';
  projectPathSubscription: Subscription;
  notationType$: Observable<'eMensural' | 'eModern'>;
  manuscriptType$: Observable<'eHandwritten' | 'ePrinted'>;
  regionTypes$: Observable<RegionType[]>;
  regionTypesSubscription: Subscription;
  pagesSubscription: Subscription;

  private shapes = new Array<Shape>();





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
  // end tools

  constructor(private store: Store<DocumentAnalysisState>,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder
              ) {
    this.regionTypes$ = store.select(selectRegionTypes);
    this.imageWidth$ = store.select(selectImageWidth);
    this.imageHeight$ = store.select(selectImageHeight);
    this.filename$ = store.select(selectFileName);
    this.notationType$ = store.select(selectNotationType);
    this.manuscriptType$ = store.select(selectManuscriptType);
    this.imageURL$ = store.select(selectImageURL);
  }

  ngOnInit() {
    this.store.dispatch(new GetRegionTypes());

    // request store data
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.imageID = +params.get('id'); // + converts the string to number
      this.store.dispatch(new GetImageProjection(+this.imageID));
    });

    this.projectPathSubscription = this.store.select(selectProjectPath).subscribe(next => {
      if (next != null) {
        // the imageID parameter, even though it is a subcribed value, will be gathered always before the project path
        this.store.dispatch(new GetImageURL(this.imageID, next)); // request image URL
      }
    });

    // ------- menus --------
    this.toolRadioGroup = this.formBuilder.group({
      model: 'idle'
    });

    this.regionTypesRadioGroupForm = this.formBuilder.group({
      regionTypeRadioButton: 'none'
    });

    this.layersCheckboxes = this.formBuilder.group({
      page: true
    });

    // region type creation menu
    this.regionTypesSubscription = this.regionTypes$.subscribe(next => {
      if (next) {
        next.forEach(regionType => {
          this.layersCheckboxes.addControl(regionType.name, new FormControl(true));
          this.regionTypesRadioGroupForm.addControl('regionTypeRadioButton', new FormControl(false));
        });
      }
    });

    this.layersCheckboxes.valueChanges.subscribe(val => {
      this.onLayerVisibilityChanged(val);
    });

    this.pagesSubscription = this.store.select(selectPages).subscribe(next => {
      if (next) {
        this.drawPagesAndRegions(next);
      }
    });


    this.computeZoom();
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

  private drawPagesAndRegions(pages: Page[]) {
    this.shapes = new Array();
    pages.forEach(page => {
      this.drawPage(page);
      page.regions.forEach(region => {
        this.drawRegion(region);
      });
    });
  }

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
    /*const rectangle = shape as Rectangle;
    const selectedRegionTypeOrPage = this.regionTypesRadioGroupForm.value.regionTypeRadioButton;
    let boxTypeName: string;
    if (!selectedRegionTypeOrPage || selectedRegionTypeOrPage === 'none') {
      this.showError('Shape creation', 'Select page or the type of region first'); // TODO que esté seleccionado el último por defecto
      this.shapes = [...this.shapes]; // propagate error by not changing anything on shapes
    } else {
      let response: Observable<ServerError<any>>;
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
    }*/

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

  isAddingMode(): boolean {
    return this.toolRadioGroup.value.model === 'draw';
  }

  isEditingMode(): boolean {
    return this.toolRadioGroup.value.model === 'edit';
  }

  setRegionType(regionType: RegionType) {
    this.lastRegionType = regionType;

    if (this.isEditingMode()) {
      const shape = this.selectedShape;
      if (!shape) {
        throw new Error('No selected shape');
      }

      if (shape.layer === 'page') {
        throw new Error('Cannot change a page to any region type');
      } else {
        this.store.dispatch(new ChangeRegionType(shape.data, regionType));
      }
    }
  }

  onShapeChanged(shape: Shape) {
    const rectangle = shape as Rectangle;

    if (shape.layer === 'page') {
        this.store.dispatch(new ChangePageBoundingBox(shape.data, {
          fromX: rectangle.fromX,
          fromY: rectangle.fromY,
          id: rectangle.data.id,
          toX: rectangle.fromX + rectangle.width,
          toY: rectangle.fromY + rectangle.height
        }));
    } else {
      this.store.dispatch(new ChangeRegionBoundingBox(shape.data, {
        fromX: rectangle.fromX,
        fromY: rectangle.fromY,
        id: rectangle.data.id,
        toX: rectangle.fromX + rectangle.width,
        toY: rectangle.fromY + rectangle.height
      }));
    }
  }



  clear() {
    /* const response: Observable<ServerError<Page[]>> = this.documentAnalysisService.clear(this.imageID);

    response.subscribe(next => {
      if (next.ok) {
        // this.drawPagesAndRegions(next.content as Page[]);
        // TODO tenemos pages diferentes en this.documentAnalysisImageProjection$ y aquí, ¿deberíamos recargarlo todo de nuevo?
        this.reloadData();
      } else {
        this.showError('Cannot clear image', next.errorMessage);
      }
    }); */

  }

  // todo - generalizarlo
  ngOnDestroy(): void {
    this.regionTypesSubscription.unsubscribe();
    this.projectPathSubscription.unsubscribe();
    this.pagesSubscription.unsubscribe();
  }

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
