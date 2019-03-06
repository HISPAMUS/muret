import {Component, OnDestroy, OnInit, Self, ViewChild} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Rectangle} from '../../../../svg/model/rectangle';
import {Shape} from '../../../../svg/model/shape';
import {SvgCanvasComponent} from '../../../../svg/components/svg-canvas/svg-canvas.component';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {SVGCanvasState} from '../../../../svg/services/svg-canvas-state.service';
import {RegionType} from '../../../../core/model/entities/region-type';
import {Page} from '../../../../core/model/entities/page';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {Region} from '../../../../core/model/entities/region';
import {Store} from '@ngrx/store';
import {DocumentAnalysisState} from '../../store/state/document-analysis.state';
import {
  ChangePageBoundingBox,
  ChangeRegionBoundingBox,
  ChangeRegionType, Clear, CreatePage, CreateRegion, DeletePage, DeleteRegion,
  GetImageProjection,
  GetRegionTypes
} from '../../store/actions/document-analysis.actions';
import {
  selectFileName,
  selectManuscriptType,
  selectNotationType, selectPages,
  selectRegionTypes
} from '../../store/selectors/document-analysis.selector';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {ImageComponent} from '../../image/image.component';

@Component({
  selector: 'app-document-analysis',
  templateUrl: './document-analysis.component.html',
  styleUrls: ['./document-analysis.component.css'],
  providers: []
})
export class DocumentAnalysisComponent implements OnInit, OnDestroy {
  private imageID: number;
  filename$: Observable<string>;
  notationType$: Observable<'eMensural' | 'eModern'>;
  manuscriptType$: Observable<'eHandwritten' | 'ePrinted'>;
  regionTypes$: Observable<RegionType[]>;
  regionTypesSubscription: Subscription;
  pagesSubscription: Subscription;

  private zoomFactor = 1;

  layersCheckboxes: FormGroup;

  // tools
  public toolRadioGroup: FormGroup;
  public regionTypesRadioGroupForm: FormGroup;
  private selectedShape: Shape;
  private nextDrawShape: string | RegionType;
  private shapes: Shape[];
  // end tools

  @ViewChild('imageComponent') imageComponent: ImageComponent;

  constructor(private store: Store<DocumentAnalysisState>,
              private route: ActivatedRoute,
              private router: Router,
              private formBuilder: FormBuilder,
              private dialogsService: DialogsService
              ) {
    this.regionTypes$ = store.select(selectRegionTypes);
    this.filename$ = store.select(selectFileName);
    this.notationType$ = store.select(selectNotationType);
    this.manuscriptType$ = store.select(selectManuscriptType);
  }

  ngOnInit() {
    this.store.dispatch(new GetRegionTypes());

    // request store data
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.imageID = +params.get('id'); // + converts the string to number
      this.store.dispatch(new GetImageProjection(+this.imageID));

      // when changing image, reset buttons
      if (this.toolRadioGroup) {
        this.toolRadioGroup.setValue({
          model: 'idle'
        });
      }

      if (this.regionTypesRadioGroupForm) {
        this.regionTypesRadioGroupForm.setValue({
          regionTypeRadioButton: 'none'
        });
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
  }

  ngOnDestroy(): void {
    this.regionTypesSubscription.unsubscribe();
    this.pagesSubscription.unsubscribe();
  }

  zoomIn() {
    this.zoomFactor += 0.5;
  }

  zoomOut() {
    this.zoomFactor = Math.max(1, this.zoomFactor - 0.5);
  }

  zoomFit() {
    this.zoomFactor = 1;
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
    if (pages) {
      pages.forEach(page => {
        this.drawPage(page);
        if (page.regions) {
          page.regions.forEach(region => {
            this.drawRegion(region);
          });
        }
      });
    }
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
    if (this.shapes) {
      this.shapes.forEach(shape => {
        const checkBox = this.layersCheckboxes.get(shape.layer);
        shape.hidden = !this.layersCheckboxes.get(shape.layer).value;
      });
    }
  }

  // ------------- METHODS that deal with actual data -------------
  isAddingMode(): boolean {
    return this.toolRadioGroup.value.model === 'draw';
  }

  isEditingMode(): boolean {
    return this.toolRadioGroup.value.model === 'edit';
  }

  setRegionType(regionType: RegionType) {
    if (this.isEditingMode()) {
      const shape = this.selectedShape;
      if (!shape) {
        throw new Error('No selected shape');
      }

      if (shape.layer === 'page') {
        this.dialogsService.showError('Region type change', 'Cannot change a page to be a region');
      } else {
        this.store.dispatch(new ChangeRegionType(shape.data, regionType));
      }
    } else {
      this.nextDrawShape = regionType;
    }
  }

  setPage() {
    if (this.isEditingMode()) {
      this.dialogsService.showError('Page', 'Cannot set page in editing mode');
    } else {
      this.nextDrawShape = 'page';
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
    this.dialogsService.showConfirmarion('Clear document analysis?', 'This action cannot be undone')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          this.store.dispatch(new Clear(this.imageID));
        }
      });
  }

  onShapeCreated(shape: Shape) {
    if (!this.nextDrawShape) {
      this.dialogsService.showError('Shape creation', 'Page or region type must be selected first');
      this.shapes = [...this.shapes]; // force shapes redrawing
    } else {
      const rectangle = shape as Rectangle;

      if (this.nextDrawShape === 'page') {
        this.store.dispatch(new CreatePage(this.imageID, {fromX: rectangle.fromX,
          fromY: rectangle.fromY,
          toX: rectangle.fromX + rectangle.width,
          toY: rectangle.fromY + rectangle.height}));
      } else {
        this.store.dispatch(new CreateRegion(this.imageID, this.nextDrawShape as RegionType,
          {fromX: rectangle.fromX,
          fromY: rectangle.fromY,
          toX: rectangle.fromX + rectangle.width,
          toY: rectangle.fromY + rectangle.height}));
      }
    }
  }


  deleteSelected() {
    if (this.selectedShape) {
      if (this.selectedShape.layer === 'page') {
        this.store.dispatch(new DeletePage(+this.selectedShape.data.id));
      } else {
        this.store.dispatch(new DeleteRegion(+this.selectedShape.data.id));
      }
    }
  }

  editSelected() {
    return false;
  }

  editOrAddSelected() {
    return false;
  }

  openAgnosticRepresentation() {
    this.router.navigate(['agnosticrepresentation', this.imageID]);
  }

  openSemanticRepresentation() {
    this.router.navigate(['semanticrepresentation', this.imageID]);
  }

  idle() {
    this.imageComponent.idle();
  }

  draw() {
    this.imageComponent.draw();
  }

  edit() {
    this.imageComponent.edit();
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
