import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Observable, Subscription} from 'rxjs';
import {Shape} from '../../../../svg/model/shape';
import {Page} from '../../../../core/model/entities/page';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {Rectangle} from '../../../../svg/model/rectangle';
import {Region} from '../../../../core/model/entities/region';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {selectPages} from '../../../document-analysis/store/selectors/document-analysis.selector';
import {Store} from '@ngrx/store';
import {GetImageProjection} from '../../../document-analysis/store/actions/document-analysis.actions';
import {ImageComponent} from '../../../document-analysis/image/image.component';
import {CreateSymbolFromBoundingBox, DeleteSymbol, GetRegion, SelectSymbol} from '../../store/actions/agnostic-representation.actions';
import {selectAgnosticSymbols, selectSelectedRegion} from '../../store/selectors/agnostic-representation.selector';
import {AgnosticSymbolToolbarCategory} from '../../model/agnostic-symbol-toolbar-category';
import {AGNOSTIC_SYMBOL_TOOLBAR_CATEGORIES} from '../../model/agnostic-symbol-toolbar-categories';
import {DialogsService} from '../../../../shared/services/dialogs.service';

@Component({
  selector: 'app-agnostic-representation',
  templateUrl: './agnostic-representation.component.html',
  styleUrls: ['./agnostic-representation.component.css']
})
export class AgnosticRepresentationComponent implements OnInit, OnDestroy {
  imageID: number;
  pagesSubscription: Subscription;
  agnosticSymbolsSubscription: Subscription;
  selectedRegionSubscription: Subscription;
  selectedRegion: Region;
  selectedRegion$: Observable<Region>;
  imagePreviewShapes: Shape[];
  imagePreviewZoomFactor = 1;
  selectedRegionShapes: any;
  selectedRegionZoomFactor = 1;

  // TODO manuscript vs printed - data from store
  agnosticSymbolToolbarCategories: AgnosticSymbolToolbarCategory[] = AGNOSTIC_SYMBOL_TOOLBAR_CATEGORIES.get('eMensural');
  notationType = 'eMensural';
  manuscriptType = 'eHandwritten';

  @ViewChild('imagePreview') imagePreview: ImageComponent;
  @ViewChild('selectedRegionImage') selectedRegionImage: ImageComponent;
  private crudMode: 'idle' | 'add' | 'edit' = 'idle';
  agnosticSmbolTypeSelected: string;
  private selectedShape: Shape;

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<any>, private dialogsService: DialogsService) {
    this.selectedRegion$ = store.select(selectSelectedRegion);
  }

  ngOnInit() {
    // request store data
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.imageID = +params.get('id'); // + converts the string to number
      this.store.dispatch(new GetImageProjection(+this.imageID));
    });

    this.pagesSubscription = this.store.select(selectPages).subscribe(next => {
      if (next) {
        this.drawImagePreviewRegions(next);
      }
    });

    this.agnosticSymbolsSubscription = this.store.select(selectAgnosticSymbols).subscribe(next => {
      if (next) {
        this.drawSelectedRegionSymbols(next);
      }
    });
    this.selectedRegionSubscription = this.store.select(selectSelectedRegion).subscribe(next => {
      this.selectedRegion = next;
    });

  }

  ngOnDestroy() {
    this.pagesSubscription.unsubscribe();
    this.agnosticSymbolsSubscription.unsubscribe();
    this.selectedRegionSubscription.unsubscribe();
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.imageID]);
  }

  openSemanticRepresentation() {
    this.router.navigate(['semanticrepresentation', this.imageID]);
  }

  onPreviewImageShapeSelected($event: Shape) {
    if ($event) {
      this.store.dispatch(new GetRegion($event.data.id));
    }
  }

  onPreviewImageShapeDeselected($event: Shape) {
  }

  private drawImagePreviewRegions(pages: Page[]) {
    this.imagePreviewShapes = new Array();
    if (pages) {
      pages.forEach(page => {
        if (page.regions) {
          page.regions.forEach(region => {
            this.drawImagePreviewRegion(region);
          });
        }
      });
    }
  }

  private drawBox(shapes: Shape[], modelObject: Region | AgnosticSymbol,
                  layer: string, id: number, boundingBox: BoundingBox, color: string): Rectangle {
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
    rect.data = modelObject;
    shapes.push(rect);
    return rect;
  }
  private drawImagePreviewRegion(region: Region) {
    this.drawBox(this.imagePreviewShapes, region,
      region.regionType.name, region.id, region.boundingBox, '#' + region.regionType.hexargb ).data = region;
  }

  private drawSelectedRegionSymbols(agnosticSymbols: AgnosticSymbol[]) {
    this.selectedRegionShapes = new Array();
    if (agnosticSymbols) {
      agnosticSymbols.forEach(symbol => {
        this.drawBox(this.selectedRegionShapes, symbol,
          symbol.agnosticSymbolType, symbol.id, symbol.boundingBox, 'red').data = symbol;
        // console.log(JSON.stringify(symbol.boundingBox, null, 4));
      });
    }
  }

  onSelectAgnosticSymbol(shape: Shape) {
    if (shape) {
      this.store.dispatch(new SelectSymbol(shape.data));
      this.selectedShape = shape;
    }
  }

  crudModeChanged($event: 'idle' | 'add' | 'edit') {
    this.crudMode = $event;
    if (this.selectedRegionImage) {
      this.setSelectedRegionImageMode();
    }
  }

  private setSelectedRegionImageMode() {
    switch (this.crudMode) {
      case 'edit':
        this.selectedRegionImage.select();
        break;
      case 'idle':
        this.selectedRegionImage.idle();
        break;
      case 'add':
        this.selectedRegionImage.draw(); // TODO dibujo ahora sólo rectángulos
        break;
    }
  }

  isAddOrEditMode() {
    return this.crudMode === 'add' || this.crudMode === 'edit';
  }

  getSelectedRegionImageMode() {
    switch (this.crudMode) {
      case 'edit':
        return 'eSelecting';
        break;
      case 'idle':
        return  'eIdle';
        break;
      case 'add':
        return 'eDrawing';
    }
  }

  onSymbolCreated(shape: Shape) {
    if (!this.agnosticSmbolTypeSelected) {
      this.dialogsService.showError('Shape creation', 'A symbol type must be selected first');
      this.selectedRegionShapes = [...this.selectedRegionShapes]; // force shapes redrawing
      // TODO Creo que no va - ver también en DocumentAnalysis
    } else {
      const rect = shape as Rectangle;

      this.store.dispatch(new CreateSymbolFromBoundingBox(
        this.selectedRegion.id,
        {
          fromX: rect.fromX,
          fromY: rect.fromY,
          toX: rect.fromX + rect.width,
          toY: rect.fromY + rect.height
        },
        this.agnosticSmbolTypeSelected));
    }
  }

  getShapeToDraw() {
    return 'Rectangle'; // TODO Cuando estemos dibujando trazos será otra cosa
  }

  onAgnosticSymbolTypeSelected($event: string) {
    this.agnosticSmbolTypeSelected = $event;
  }

  deleteSelectedSymbol() {
    if (this.selectedShape) {
      this.store.dispatch(new DeleteSymbol(this.selectedShape.data.id));
    }
  }

  onDeselectAgnosticSymbol($event: Shape) {
    this.selectedShape = null;
  }
}
