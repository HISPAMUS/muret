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
import {
  GetImageProjection
} from '../../../document-analysis/store/actions/document-analysis.actions';
import {
  ChangeSymbolBoundingBox,
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
import {Strokes} from '../../../../core/model/entities/strokes';
import {Polyline} from '../../../../svg/model/polyline';

const USE_SYMBOL_CLASSIFIER = 'USE_SYMBOL_CLASSIFIER'; // see es.ua.dlsi.grfia.im3ws.muret.model.AgnosticRepresentationModel

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

  mode: 'eIdle' | 'eAdding' | 'eEditing' | 'eSelecting';
  private selectedShapeValue: Shape;
  nextShapeToDraw: 'Rectangle' | 'Polylines';
  selectedAgnosticSymbolTypeValue: string;
  private selectedRegionShapeValue: Shape;
  addMethodTypeValue: 'boundingbox' | 'strokes' ;
  classifier = true;

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
        this.store.dispatch(new SelectSymbol(shape.data.id));
      } else if (!shape) {
        this.store.dispatch(new DeselectSymbol());
      }
    }
  }

  get selectedAgnosticSymbolType() {
    return this.selectedAgnosticSymbolTypeValue;
  }

  set selectedAgnosticSymbolType(val) {
    if (val !== this.selectedAgnosticSymbolTypeValue) {
      this.selectedAgnosticSymbolTypeValue = val;
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

  private drawStrokes(shapes: Shape[], modelObject: AgnosticSymbol, layer: string, id: number, strokes: Strokes, color: string) {
    const polylines = new Polylines();
    polylines.id = layer + 'strokes' + id;
    polylines.polylines = strokes.strokeList.map(
      stroke => {
        return new Polyline(stroke.points);
      }
    );
    polylines.fillColor = 'transparent';
    polylines.strokeColor = color;
    polylines.strokeWidth = 1;
    polylines.layer = layer;
    polylines.data = modelObject;
    shapes.push(polylines);
    return polylines;
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
          symbol.agnosticSymbolType, symbol.id, symbol.boundingBox, 'red');
        // console.log(JSON.stringify(symbol.boundingBox, null, 4));

        if (symbol.strokes) {
          this.drawStrokes(this.selectedRegionShapes, symbol,
            symbol.agnosticSymbolType, symbol.id, symbol.strokes, 'red');
        }
      });
    }
  }



  isAddOrEditMode() {
    return this.mode === 'eAdding' || this.mode === 'eEditing';
  }

  onSymbolCreated(shape: Shape) {
    if (!this.selectedAgnosticSymbolType) {
      this.dialogsService.showError('Shape creation', 'A symbol type must be selected first');
      this.selectedRegionShapes = this.selectedRegionShapes.filter(s => s !== shape); // remove erroneous shape
    } else {
      const agnosticSymbolType = this.classifier ? USE_SYMBOL_CLASSIFIER : this.selectedAgnosticSymbolType;

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
          agnosticSymbolType));
      } else if (shape instanceof Polylines) {
        this.store.dispatch(new CreateSymbolFromStrokes(
          this.selectedRegion.id,
          shape.polylines.map(polyline => polyline.pointsValue),
          agnosticSymbolType
          ));
      } else {
        throw new Error('Unsupported shape type: ' + shape.constructor.name);
      }
    }
  }

  onAgnosticSymbolTypeSelected($event: string) {
    this.selectedAgnosticSymbolType = $event;

    if (this.isEditingMode()) {
      if (this.selectedSymbol && this.selectedSymbol.agnosticSymbolType !== $event) {
        this.store.dispatch(new ChangeSymbolType(this.selectedSymbol, $event));
      }
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
    if ($event !== 'eEditing') {
      if (this.selectedSymbol) {
        this.store.dispatch(new DeselectSymbol());
      }
    }
    if ($event === 'eAdding' && !this.selectedAgnosticSymbolType) {
      this.selectedAgnosticSymbolType = 'clef.G';
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

  onSymbolShapeChanged(shape: Shape) {
    // currently we only support bounding box change
    if (shape instanceof Rectangle) {
      this.store.dispatch(new ChangeSymbolBoundingBox(shape.data, {
        fromX: shape.fromX,
        fromY: shape.fromY,
        id: shape.data.id,
        toX: shape.fromX + shape.width,
        toY: shape.fromY + shape.height
      }));
    }
  }

  zoomIn() {
    this.selectedRegionZoomFactor += 0.15;
  }

  zoomOut() {
    this.selectedRegionZoomFactor = Math.max(0.5, this.selectedRegionZoomFactor - 0.15);
  }

  zoomFit() {
    this.selectedRegionZoomFactor = 1;
  }

  onClassifierChanged($event: boolean) {
    this.classifier = $event;
  }
}
