import {AfterViewInit, Component, ElementRef, HostListener, OnDestroy, OnInit, Self, ViewChild, SimpleChanges} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Rectangle} from '../../../../svg/model/rectangle';
import {Shape} from '../../../../svg/model/shape';
import {RegionType} from '../../../../core/model/entities/region-type';
import {Page} from '../../../../core/model/entities/page';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {Region} from '../../../../core/model/entities/region';
import {Store} from '@ngrx/store';
import {DocumentAnalysisState} from '../../store/state/document-analysis.state';

import {
  ChangePageBoundingBox,
  ChangeRegionBoundingBox,
  ChangeRegionType, Clear, CreatePage, CreateRegion, DeletePage, DeleteRegion, GetImagePart,
  GetImageProjection,
  GetRegionTypes,
  GetDocumentAnModels,
  AutomaticDocumentAnalysis, CreatePages
} from '../../store/actions/document-analysis.actions';
import {
  selectFileName, selectImagePart,
  selectPages,
  selectRegionTypes,
  selectImageWidth,
  selectImageHeight,
  selectDocumentAnalysisClassifierModels, selectDocumentAnalysisServerError
} from '../../store/selectors/document-analysis.selector';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {ActivateLink} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Part} from '../../../../core/model/entities/part';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';
import {ShowErrorService} from '../../../../core/services/show-error.service';

@Component({
  selector: 'app-document-analysis',
  templateUrl: './document-analysis.component.html',
  styleUrls: ['./document-analysis.component.css'],
  providers: []
})
export class DocumentAnalysisComponent implements OnInit, OnDestroy, AfterViewInit {
  imageID: number;
  filename$: Observable<string>;
  regionTypes$: Observable<RegionType[]>;
  imagePart$: Observable<Part>;
  documentAnalysisModels$: Observable<ClassifierModel[]>;
  pagesSubscription: Subscription;
  regionTypesSubscription: Subscription;
  imagewidthSubscription: Subscription;
  imageheightSubscription: Subscription;
  mode: 'eIdle' |'eSelecting' | 'eEditing' | 'eAdding';
  selectedRegionTypeID: number | 'page';
  zoomFactor = 1;

  processing: boolean = false;

  @ViewChild('regionTypesModal', {static: true}) regionTypesModal: ElementRef;

  // tools
  private selectedShapeValue: string;
  // private nextDrawShape: string | RegionType;
  shapes: Shape[];
  regionTypesEnum: RegionType[];

  regionTypeFilterOut: Set<string>;

  public regionTypeCSelected: number;
  public regionTypeINselected: number;

  imageWidth: number;
  imageHeight: number;

  analysisStatus: string;
  // end tools

  // @ViewChild('imageComponent') imageComponent: ImageComponent;
  private pages: Page[];
  private serverErrorSubscription: Subscription;

  constructor(private store: Store<DocumentAnalysisState>,
              private route: ActivatedRoute,
              private router: Router,
              private dialogsService: DialogsService,
              private modalService: NgbModal, private showErrorService: ShowErrorService
              ) {
    this.regionTypes$ = store.select(selectRegionTypes);

    this.regionTypesSubscription = this.regionTypes$.subscribe((result) => {
      this.regionTypesEnum = result;
    });

    this.filename$ = store.select(selectFileName);
    this.mode = 'eIdle';
    this.selectedRegionTypeID = 'page';
    this.regionTypeFilterOut = new Set<string>();

    this.regionTypeCSelected = 1;
    this.regionTypeINselected = 2;
  }

  ngOnInit() {

    this.analysisStatus = 'Analyze';

    this.store.dispatch(new GetRegionTypes());

    // request store data
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.imageID = +params.get('id'); // + converts the string to number
      this.store.dispatch(new GetImageProjection(+this.imageID));
      this.store.dispatch(new GetImagePart(+this.imageID));
      setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
        this.store.dispatch(new ActivateLink({title: 'Document analysis', routerLink: 'documentanalysis/' + this.imageID}));
      });
    });

    this.documentAnalysisModels$ = this.store.select(selectDocumentAnalysisClassifierModels);

    this.store.dispatch(new GetDocumentAnModels(this.imageID));

    this.imagePart$ = this.store.select(selectImagePart);
    this.imagewidthSubscription = this.store.select(selectImageWidth).subscribe(value => {
      this.imageWidth = value;
    });

    this.imageheightSubscription = this.store.select(selectImageHeight).subscribe(value => {
      this.imageHeight = value;
    });
    this.serverErrorSubscription = this.store.select(selectDocumentAnalysisServerError).subscribe(next => {
      if (next) {
        this.showErrorService.warning(next);
      }
    });

  }

  ngAfterViewInit(): void {
    this.pagesSubscription = this.store.select(selectPages).subscribe(next => {
      if (next) {
        this.drawPagesAndRegions(next);
        this.processing = false;
        this.analysisStatus = 'Analyze';
      }

      this.pages = next;
    });
  }

  ngOnDestroy(): void {
    this.pagesSubscription.unsubscribe();
    this.regionTypesSubscription.unsubscribe();
    this.serverErrorSubscription.unsubscribe();
  }

  zoomIn() {
    this.zoomFactor += 0.25;
  }

  zoomOut() {
    this.zoomFactor = Math.max(0.5, this.zoomFactor - 0.25);
  }

  zoomFit() {
    this.zoomFactor = 1;
  }

  get selectedShapeID() {
    return this.selectedShapeValue;
  }

  set selectedShapeID(id: string) {
    if (id !== this.selectedShapeValue) {
      this.selectedShapeValue = id;

      const shape = this.findSelectedShape();
      if (shape) {
        if (shape.data.regionType) {
          this.selectedRegionTypeID = shape.data.regionType.id;
        } else {
          this.selectedRegionTypeID = 'page';
        }
      } else {
        this.selectedRegionTypeID = null;
      }

      /*// console.log("Setting region type")
      // console.log(this.selectedRegionTypeID)*/

    }
  }

  private findSelectedShape(): Shape {
    if (this.selectedShapeID) {
      return this.shapes.find(s => s.id === this.selectedShapeID);
    } else {
      return null;
    }
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

    this.applyRegionTypeFilter();
  }

  private drawBox(layer: string, id: number, boundingBox: BoundingBox, color: string, data: Region | Page): Rectangle {
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
    rect.data = data;
    this.shapes.push(rect);
    return rect;
  }
  private drawPage(page: Page) {
    this.drawBox('page', page.id, page.boundingBox, 'red', page); // TODO color
  }

  private drawRegion(region: Region) {
    this.drawBox(region.regionType.name, region.id, region.boundingBox, '#' + region.regionType.hexargb, region);
  }

  onLayerVisibilityChanged($event) {
    if ($event.target.checked) {
      this.regionTypeFilterOut.delete($event.target.name);
    } else {
      this.regionTypeFilterOut.add($event.target.name);
    }

    this.applyRegionTypeFilter();
  }

  // ------------- METHODS that deal with actual data -------------
  isAddingMode(): boolean {
    return this.mode === 'eAdding';
  }

  isEditingMode(): boolean {
    return this.mode === 'eEditing';
  }

  setRegionType(regionType: RegionType) {

    if (this.isEditingMode() && this.selectedShapeID) {
      const shape = this.findSelectedShape();
      if (!shape) {
        throw new Error('No selected shape');
      }

      if (shape.layer === 'page') {
        this.dialogsService.showError('Region type change', 'Cannot change a page to be a region');
      } else {
        this.store.dispatch(new ChangeRegionType(shape.data, regionType));
      }
    }
  }

  setPage() {
    if (this.isEditingMode()) {
      this.dialogsService.showError('Page', 'Cannot set page in editing mode');
    } else {
      // this.nextDrawShape = 'page';
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
    this.dialogsService.showConfirmation('Clear document analysis?', 'This action cannot be undone')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {

          this.dialogsService.showConfirmation('Are you sure to clear the document analysis?', 'This action cannot be undone')
            .subscribe((isConfirmed2) => {
              if (isConfirmed2) {
                this.store.dispatch(new Clear(this.imageID));
              }
            });
        }
      });
  }

  clearAll()
  {
    console.log("Purging");
  }

  onShapeCreated(shape: Shape) {
    this.createNewShape(shape);

    /*if (!this.nextDrawShape) {
      this.dialogsService.showError('Shape creation', 'Page or region type must be selected first');
      this.shapes = this.shapes.filter(s => s !== shape); // remove erroneous shape
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
    }*/
  }


  deleteSelected() {
    if (this.selectedShapeID) {
      const shape = this.findSelectedShape();
      if (!shape) {
        throw new Error('Cannot find shape with ID= "' + this.selectedShapeID + '"');
      }
      if (shape.layer === 'page') {
        this.store.dispatch(new DeletePage(+shape.data.id));
      } else {
        this.store.dispatch(new DeleteRegion(+shape.data.id));
      }
    }
  }

  attemptDocumentAnalysis() {
    this.dialogsService.showConfirmation('Automatic classification: it will erase previous analysis', 'This action cannot be undone')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          this.dialogsService.showInput('Automatic classification', 'How many vertical pages do you wish to create?',
            '1').subscribe(value => {
              if (value) {
                const pagesToCreate = Number(value);
                this.analysisStatus = 'Analyzing...';
                this.processing = true;
                this.store.dispatch(new AutomaticDocumentAnalysis({
                  imageID: this.imageID,
                  modelToUse: 'simple-lan',
                  numPages: pagesToCreate
                }));
                this.mode = 'eEditing';
              }
          });
        }
      });
  }


  openAgnosticRepresentation() {
    this.router.navigate(['agnosticrepresentation', this.imageID]);
  }

  openSemanticRepresentation() {
    this.router.navigate(['semanticrepresentation', this.imageID]);
  }

  @HostListener('window:keyup', ['$event'])
  keyEvent(event: KeyboardEvent) {
    if (this.mode === 'eEditing' && event.code === 'Delete') {
      this.deleteSelected();
    } else if (event.code === 'Escape') {
      this.mode = 'eIdle';
    }
    if (this.isAddingMode() && event.code === 'KeyB') {
      this.regionTypeCSelected++;
      // console.log(this.regionTypeCSelected)
      if (this.regionTypeCSelected === this.regionTypesEnum.length) {
        // console.log('Changing...')
        this.regionTypeCSelected = -1;
        this.regionTypeINselected = -1;
        return;
      }

      if (!this.regionTypeCSelected) {
        this.regionTypeINselected = this.regionTypeCSelected;
      } else {
        this.regionTypeINselected = this.regionTypeCSelected + 1;
      }

      /*// console.log(this.regionTypeINselected);*/
    }
  }

  setRegionCreated(regionType: number) {
    this.regionTypeINselected = regionType;

    if (regionType > 0) {
      regionType -= 1;
    }

    this.regionTypeCSelected = regionType;
  }

  beautifyRegionName(name: string): string {
    const result = name.replace(/_/g, ' ');
    return result.charAt(0).toUpperCase() + result.slice(1); // first char uppercase
  }

  inIdleMode() {
    return this.mode === 'eIdle';
  }

  createNewShape(newShape: Shape) {
    const rectangle = newShape as Rectangle;

    let nextdraw;
    if (this.regionTypeCSelected > -1) {
      nextdraw = this.regionTypesEnum[this.regionTypeCSelected];
    } else {
      nextdraw = {name: 'page'};
    }

    const nextDrawShape = nextdraw;

    if (nextDrawShape.name === 'page') {
      this.store.dispatch(new CreatePage(this.imageID, {fromX: rectangle.fromX,
        fromY: rectangle.fromY,
        toX: rectangle.fromX + rectangle.width,
        toY: rectangle.fromY + rectangle.height}));
    } else {
      this.store.dispatch(new CreateRegion(this.imageID, nextDrawShape as RegionType,
        {fromX: rectangle.fromX,
          fromY: rectangle.fromY,
          toX: rectangle.fromX + rectangle.width,
          toY: rectangle.fromY + rectangle.height}));

  }
}

  openRegionSelectionModal() {
     this.modalService.open(this.regionTypesModal, {size: 'lg', ariaLabelledBy: 'Region types'}).result.then((result) => {
      //  // accepted
        this.regionTypeCSelected = result.id;
    });
  }

  private applyRegionTypeFilter() {
    if (this.shapes) {
      this.shapes.forEach(shape => {
        shape.hidden = this.regionTypeFilterOut.has(shape.layer);
      });
    }
  }

  createPages() {
      this.dialogsService.showInput('Page creation', 'No pages found. How many vertical pages do you wish to create?',
        '1').subscribe(value => {
        const pagesToCreate = Number(value);
        this.store.dispatch(new CreatePages(this.imageID, pagesToCreate));
      });
        /*if (pagesToCreate === 2 || pagesToCreate === 1) {
          const widthStep = this.imageWidth / pagesToCreate
          for (let i = 0; i < pagesToCreate; i++) {
            setTimeout(() => {this.store.dispatch(new CreatePage(this.imageID, {fromX: widthStep * i,
              fromY: 0,
              toX: (widthStep * i) + widthStep,
              toY: this.imageHeight}));
            }, 100 * i);
          }
        }
      });*/
  }

  onModeChange($event: 'eIdle' | 'eEditing' | 'eAdding' | 'eSelecting') {
    if ($event === 'eAdding') {
      if (!this.pages || !this.pages.length) {
        this.createPages();
      }
    }
  }

  isProcessing() : boolean
  {
    return this.processing;
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

  const path = new Polyline();
  path.id = '4';
  path.d = 'M150 0 L75 200 L225 200 Z';
  this.shapes.push(path);


  text.fromX = 0;
  text.fromY = 200;
}*/
