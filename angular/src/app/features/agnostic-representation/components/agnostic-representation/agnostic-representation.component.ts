import {Component, HostListener, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Observable, Subscription} from 'rxjs';
import {Shape} from '../../../../svg/model/shape';
import {Page} from '../../../../core/model/entities/page';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {Rectangle} from '../../../../svg/model/rectangle';
import {Region} from '../../../../core/model/entities/region';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {
  selectFileName,
  selectDocumentType,
  selectPages
} from '../../../document-analysis/store/selectors/document-analysis.selector';
import {Store} from '@ngrx/store';
import {
  GetImageProjection
} from '../../../document-analysis/store/actions/document-analysis.actions';
import {
  ChangeSymbol,
  ChangeSymbolBoundingBox,
  CreateSymbolFromBoundingBox, CreateSymbolFromStrokes,
  DeleteSymbol, DeselectSymbol,
  GetRegion, GetSVGSet, InitRegion,
  SelectSymbol
} from '../../store/actions/agnostic-representation.actions';
import {
  selectAgnosticSymbols, selectClassifiedSymbols,
  selectSelectedRegion,
  selectSelectedSymbol, selectSVGAgnosticSymbolSet
} from '../../store/selectors/agnostic-representation.selector';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {Polylines} from '../../../../svg/model/polylines';
import {Strokes} from '../../../../core/model/entities/strokes';
import {Polyline} from '../../../../svg/model/polyline';
import {ActivateLink} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';
import {SVGSet} from '../../model/svgset';
import {AgnosticSymbolAndPosition} from '../../model/agnostic-symbol-and-position';
import {Point} from '../../../../core/model/entities/point';
import {AgnosticTypeSVGPath} from '../../model/agnostic-type-svgpath';
import {PositionInStaffService} from '../../services/position-in-staff.service';

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
  // agnosticSymbolToolbarCategories: AgnosticSymbolToolbarCategory[] = AGNOSTIC_SYMBOL_TOOLBAR_CATEGORIES.get('eMensural');

  mode: 'eIdle' | 'eAdding' | 'eEditing' | 'eSelecting';
  private selectedShapeIDValue: string;
  nextShapeToDraw: 'Rectangle' | 'Polylines';
  selectedAgnosticSymbolTypeValue: string;
  private selectedRegionShapeIDValue: string;
  addMethodTypeValue: 'boundingbox' | 'strokes' ;
  classifier = true;
  svgSet$: Observable<SVGSet>;
  filename$: Observable<string>;
  private documentTypeSubscription: Subscription;
  isImagePreviewMinimized = true;
  imagePreviewClass = 'col-4';
  classifiedSymbols: AgnosticSymbolAndPosition[];
  classifiedSymbolsSubscription: Subscription;
  private creatingBoundingBox: BoundingBox;
  private creatingStrokes: Point[][];

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<any>,
              private dialogsService: DialogsService, private positionInStaffService: PositionInStaffService) {
    this.selectedRegion$ = store.select(selectSelectedRegion);
    this.mode = 'eIdle';
    this.selectedRegionShapeIDValue = null;
    this.filename$ = store.select(selectFileName);
    this.documentTypeSubscription  = store.select(selectDocumentType).subscribe(next => {
      if (next) {
        this.store.dispatch(new GetSVGSet(next.notationType, next.manuscriptType));
      }
    });
    this.svgSet$ = store.select(selectSVGAgnosticSymbolSet);
    this.addMethodType = 'boundingbox';
  }

  ngOnInit() {
    this.store.dispatch(new InitRegion());
    // request store data
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.imageID = +params.get('id'); // + converts the string to number
      this.store.dispatch(new GetImageProjection(+this.imageID));

      setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
        this.store.dispatch(new ActivateLink({title: 'Agnostic', routerLink: 'agnosticrepresentation/' + this.imageID}));
      });

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
    this.classifiedSymbolsSubscription = this.store.select(selectClassifiedSymbols).subscribe(next => {
      this.classifiedSymbols = next;
    });

    this.mode = 'eIdle';
  }

  ngOnDestroy() {
    this.pagesSubscription.unsubscribe();
    this.agnosticSymbolsSubscription.unsubscribe();
    this.selectedRegionSubscription.unsubscribe();
    this.selectedSymbolSubscription.unsubscribe();
    this.documentTypeSubscription.unsubscribe();
    this.classifiedSymbolsSubscription.unsubscribe();
  }

  private findSelectedShape(): Shape {
    if (this.selectedShapeID) {
      return this.selectedRegionShapes.find(s => s.id === this.selectedShapeID);
    } else {
      return null;
    }
  }

  get selectedShapeID() {
    return this.selectedShapeIDValue;
  }

  /**
   * It comes from the svg canvas through image component
   */
  set selectedShapeID(id: string) {
    if (this.selectedShapeIDValue !== id) {
      this.selectedShapeIDValue = id;
      const shape = this.findSelectedShape();
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
      this.selectedShapeID = srs.id;
    } else {
        this.selectedShapeID = null;
    }
  }

  get selectedRegionShapeID() {
    return this.selectedRegionShapeIDValue;
  }

  set selectedRegionShapeID(id: string) {
    if (this.selectedRegionShapeIDValue !== id) {
      this.selectedRegionShapeIDValue = id;
      const shape = this.findSelectedRegionShape();
      if (shape) {
        this.store.dispatch(new GetRegion(shape.data.id));
      }
    }
  }

  private findSelectedRegionShape(): Shape {
    if (this.selectedRegionShapeID && this.imagePreviewShapes) {
      return this.imagePreviewShapes.find(s => s.id === this.selectedRegionShapeID);
    } else {
      return null;
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
    if (shape instanceof Rectangle) {
      const rect = shape;
      this.creatingBoundingBox = {
        fromX: rect.fromX,
        fromY: rect.fromY,
        toX: rect.fromX + rect.width,
        toY: rect.fromY + rect.height
      };

      this.store.dispatch(new CreateSymbolFromBoundingBox(
        this.selectedRegion.id, this.creatingBoundingBox, null, null));
    } else if (shape instanceof Polylines) {
      this.creatingStrokes = shape.polylines.map(polyline => polyline.pointsValue);
      this.store.dispatch(new CreateSymbolFromStrokes(
        this.selectedRegion.id, this.creatingStrokes, null, null
      ));
    } else {
      throw new Error('Unsupported shape type: ' + shape.constructor.name);
    }
  }

  private movePitch(displacement: number) {
    if (this.selectedSymbol) {
      const positionInStaff = this.selectedSymbol.positionInStaff;
      const newPositionInStaff = this.positionInStaffService.movePitch(positionInStaff, displacement);

      this.store.dispatch(new ChangeSymbol(this.selectedSymbol, this.selectedSymbol.agnosticSymbolType, newPositionInStaff));
    }

  }

  movePitchDownSelectedSymbol() {
    this.movePitch(-1);
  }

  movePitchUpSelectedSymbol() {
    this.movePitch(+1);
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

  @HostListener('window:keydown', ['$event']) // keydown to prevent scroll
  keyEvent(event: KeyboardEvent) {
    if (this.mode === 'eEditing' || this.mode === 'eAdding') {
      switch (event.code) {
        case 'Delete':
          this.deleteSelectedSymbol();
          break;
        case 'ArrowDown':
          event.stopImmediatePropagation();
          event.preventDefault(); // prevent scroll
          this.movePitchDownSelectedSymbol();
          break;
        case 'ArrowUp':
          event.stopImmediatePropagation();
          event.preventDefault(); // prevent scroll
          this.movePitchUpSelectedSymbol();
          break;
        case 'Escape':
          this.store.dispatch(new DeselectSymbol());
          this.mode = 'eIdle';
          break;
      }
    }
  }

  clear() {

  }

  toggleImagePreview() {
    this.isImagePreviewMinimized = !this.isImagePreviewMinimized;
    if (this.isImagePreviewMinimized) {
      this.imagePreviewZoomFactor = 1.01; // force recompute sizes
      this.imagePreviewClass = 'col-4';
    } else {
      this.imagePreviewZoomFactor = 0.99; // force recompute sizes
      this.imagePreviewClass = 'imagePreviewMaximized';
    }

  }

  trackClassifiedSymbol(index, item: AgnosticSymbolAndPosition) {
    return index;
  }

  /*onNewAgnosticSymbolTypeSelected(agnosticSymbolType: string) {
    if (agnosticSymbolType) {
      const agnosticSymbolTypeAndPosition = this.classifiedSymbols.find(cs => cs.agnosticSymbolType === agnosticSymbolType);

      if (this.creatingBoundingBox) {
        this.store.dispatch(new CreateSymbolFromBoundingBox(
          this.selectedRegion.id, this.creatingBoundingBox, agnosticSymbolTypeAndPosition.agnosticSymbolType,
          agnosticSymbolTypeAndPosition.positionInStaff));

      } else if (this.creatingStrokes) {
        this.store.dispatch(new CreateSymbolFromStrokes(
          this.selectedRegion.id, this.creatingStrokes, agnosticSymbolTypeAndPosition.agnosticSymbolType,
          agnosticSymbolTypeAndPosition.positionInStaff));
      } else {
        throw new Error('At least a bounding box or strokes should be not null');
      }
      this.creatingBoundingBox = null;
      this.creatingStrokes = null;
    }
  }*/

  onAgnosticSymbolTypeSelected(agnosticTypeSVGPath: AgnosticTypeSVGPath) {
    let agnosticSymbolTypeAndPosition = null;
    if (this.classifiedSymbols) {
      agnosticSymbolTypeAndPosition = this.classifiedSymbols.find(cs => cs.agnosticSymbolType === agnosticTypeSVGPath.agnosticTypeString);
    }

    const agnosticType = agnosticTypeSVGPath.agnosticTypeString;
    let positionInStaff: string;
    if (agnosticSymbolTypeAndPosition) {
      positionInStaff = agnosticSymbolTypeAndPosition.positionInStaff;
    } else {
      positionInStaff = agnosticTypeSVGPath.defaultPositionInStaff;
    }

    if (this.selectedSymbol &&
      (this.selectedSymbol.agnosticSymbolType !== agnosticType || this.selectedSymbol.positionInStaff !== positionInStaff)) {
      this.store.dispatch(new ChangeSymbol(this.selectedSymbol, agnosticType, positionInStaff));
    }
  }



  /*isAddingShape() {
    return this.creatingStrokes != null || this.creatingBoundingBox != null;
  }*/

}


/*if (!this.selectedAgnosticSymbolType) {
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
}*/
