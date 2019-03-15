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
import {
  ChangeSymbolPositionInStaff,
  ChangeSymbolType,
  CreateSymbolFromBoundingBox, CreateSymbolFromStrokes,
  DeleteSymbol, DeselectSymbol,
  GetRegion,
  SelectSymbol
} from '../../store/actions/agnostic-representation.actions';
import {selectAgnosticSymbols, selectSelectedRegion, selectSelectedSymbol} from '../../store/selectors/agnostic-representation.selector';
import {AgnosticSymbolToolbarCategory} from '../../model/agnostic-symbol-toolbar-category';
import {AGNOSTIC_SYMBOL_TOOLBAR_CATEGORIES} from '../../model/agnostic-symbol-toolbar-categories';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {Polylines} from '../../../../svg/model/polylines';
import {Polyline} from '../../../../svg/model/polyline';
import {Strokes} from '../../../../core/model/entities/strokes';
import {Stroke} from '../../../../core/model/entities/stroke';
import {Point} from '../../../../core/model/entities/point';

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
  private selectedSymbol: AgnosticSymbol;
  selectedRegion: Region;
  selectedRegion$: Observable<Region>;
  selectedSymbolSubscription: Subscription;
  imagePreviewShapes: Shape[];
  imagePreviewZoomFactor = 1;
  selectedRegionShapes: Shape[];
  selectedRegionZoomFactor = 1;

  // TODO manuscript vs printed - data from store
  agnosticSymbolToolbarCategories: AgnosticSymbolToolbarCategory[] = AGNOSTIC_SYMBOL_TOOLBAR_CATEGORIES.get('eMensural');
  notationType = 'eMensural';
  manuscriptType = 'eHandwritten';

  private mode: 'eIdle' | 'eAdding' | 'eEditing' | 'eSelecting';
  private selectedShapeValue: Shape;
  nextShapeToDraw: 'Rectangle' | 'Polylines';
  selectedAgnosticSymbolType: string;
  private selectedRegionShapeValue: Shape;
  addMethodTypeValue: 'boundingbox' | 'strokes' ;

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<any>,
              private dialogsService: DialogsService) {
    this.selectedRegion$ = store.select(selectSelectedRegion);
    this.mode = 'eIdle';
    this.selectedRegionShapeValue = null;
    this.addMethodType = 'boundingbox';
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
    this.selectedSymbolSubscription = this.store.select(selectSelectedSymbol).subscribe(next => {
      this.setSelectedSymbol(next);
    });

    this.mode = 'eIdle';
  }

  ngOnDestroy() {
    this.pagesSubscription.unsubscribe();
    this.agnosticSymbolsSubscription.unsubscribe();
    this.selectedRegionSubscription.unsubscribe();
    this.selectedSymbolSubscription.unsubscribe();
  }

  get selectedShape() {
    return this.selectedShapeValue;
  }

  /**
   * It comes from the svg canvas through image component
   */
  set selectedShape(shape: Shape) {
    if (this.selectedShapeValue !== shape) {
      this.selectedShapeValue = shape;
      if (shape && shape.data !== this.selectedSymbol) {
        this.store.dispatch(new SelectSymbol(shape.data));
      } else if (!shape) {
        this.store.dispatch(new DeselectSymbol());
      }
    }
  }

  private setSelectedSymbol(symbol: AgnosticSymbol) {
    this.selectedSymbol = symbol;
    if (symbol) {
      this.selectedAgnosticSymbolType = symbol.agnosticSymbolType;
      const srs = this.selectedRegionShapes.find(s => s.data === symbol);
      this.selectedShape = srs;
    } else {
        this.selectedShape = null;
    }
  }

  get selectedRegionShape() {
    return this.selectedRegionShapeValue;
  }

  set selectedRegionShape(shape: Shape) {
    if (this.selectedRegionShapeValue !== shape) {
      this.selectedRegionShapeValue = shape;
      if (shape) {
        this.store.dispatch(new GetRegion(shape.data.id));
      }
    }
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.imageID]);
  }

  openSemanticRepresentation() {
    this.router.navigate(['semanticrepresentation', this.imageID]);
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
    console.log('drawing');

    this.selectedShape = null; // if not, previous shape is still selected and concurrency errors are raised
    this.selectedRegionShapes = new Array();
    if (agnosticSymbols) {
      agnosticSymbols.forEach(symbol => {
        this.drawBox(this.selectedRegionShapes, symbol,
          symbol.agnosticSymbolType, symbol.id, symbol.boundingBox, 'red').data = symbol;
        // console.log(JSON.stringify(symbol.boundingBox, null, 4));
      });
    }
  }

  isAddOrEditMode() {
    return this.mode === 'eAdding' || this.mode === 'eEditing';
  }

  onSymbolCreated(shape: Shape) {
    console.log('Created shape for ' + this.selectedAgnosticSymbolType);
    if (!this.selectedAgnosticSymbolType) {
      this.dialogsService.showError('Shape creation', 'A symbol type must be selected first');
      this.selectedRegionShapes = this.selectedRegionShapes.filter(s => s !== shape); // remove erroneous shape
    } else {
      if (shape instanceof Rectangle) {
        const rect = shape;
        this.store.dispatch(new CreateSymbolFromBoundingBox(
          this.selectedRegion.id,
          {
            fromX: rect.fromX,
            fromY: rect.fromY,
            toX: rect.fromX + rect.width,
            toY: rect.fromY + rect.height
          },
          this.selectedAgnosticSymbolType));
      } else if (shape instanceof Polylines) {
        this.store.dispatch(new CreateSymbolFromStrokes(
          this.selectedRegion.id,
          shape.polylines.map(polyline => polyline.pointsValue),
          this.selectedAgnosticSymbolType));
      } else {
        throw new Error('Unsupported shape type: ' + shape.constructor.name);
      }
    }
  }

  onAgnosticSymbolTypeSelected($event: string) {
    if (this.selectedSymbol && this.selectedSymbol.agnosticSymbolType !== $event) {
      this.store.dispatch(new ChangeSymbolType(this.selectedSymbol, $event));
    } else {
      this.selectedAgnosticSymbolType = $event;
    }
  }

  movePitchDownSelectedSymbol() {
    if (this.selectedSymbol) {
      this.store.dispatch(new ChangeSymbolPositionInStaff(this.selectedSymbol, -1));
    }
  }

  movePitchUpSelectedSymbol() {
    if (this.selectedSymbol) {
      this.store.dispatch(new ChangeSymbolPositionInStaff(this.selectedSymbol, 1));
    }
  }


  deleteSelectedSymbol() {
    if (this.selectedSymbol) {
      this.store.dispatch(new DeleteSymbol(this.selectedSymbol.id));
    }
  }

  onModeChange($event: any) {
    if ($event === 'eAdding' && !this.selectedAgnosticSymbolType) {
      this.selectedAgnosticSymbolType = 'clef.G';
    }

    if ($event !== 'eEditing') {
      if (this.selectedSymbol) {
        this.store.dispatch(new DeselectSymbol());
      }
    }
  }

  isAddingMode() {
    return this.mode === 'eAdding';
  }

  isEditingMode() {
    return this.mode === 'eEditing';
  }

  get addMethodType() {
    return this.addMethodTypeValue;
  }

  set addMethodType(val) {
    this.addMethodTypeValue = val;
    if (this.addMethodTypeValue === 'boundingbox') {
      this.nextShapeToDraw = 'Rectangle';
    } else if (this.addMethodType === 'strokes') {
      this.nextShapeToDraw = 'Polylines';
    } else {
      throw Error('Invalid add method type: ' + this.addMethodType);
    }
  }

}
