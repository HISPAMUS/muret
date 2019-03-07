import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Observable, Subscription} from 'rxjs';
import {Shape} from '../../../../svg/model/shape';
import {Page} from '../../../../core/model/entities/page';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {Rectangle} from '../../../../svg/model/rectangle';
import {Region} from '../../../../core/model/entities/region';
import {selectPages} from '../../../document-analysis/store/selectors/document-analysis.selector';
import {Store} from '@ngrx/store';
import {GetImageProjection} from '../../../document-analysis/store/actions/document-analysis.actions';
import {SvgCanvasComponent} from '../../../../svg/components/svg-canvas/svg-canvas.component';
import {ImageComponent} from '../../../document-analysis/image/image.component';
import {GetRegion} from '../../store/actions/agnostic-representation.actions';
import {selectSelectedRegion} from '../../store/selectors/agnostic-representation.selector';
import {AgnosticSymbolToolbarCategory} from '../../agnostic-toolbar/agnostic-symbol-toolbar-category';
import {AGNOSTIC_SYMBOL_TOOLBAR_CATEGORIES} from '../../agnostic-toolbar/agnostic-symbol-toolbar-categories';

@Component({
  selector: 'app-agnostic-representation',
  templateUrl: './agnostic-representation.component.html',
  styleUrls: ['./agnostic-representation.component.css']
})
export class AgnosticRepresentationComponent implements OnInit, OnDestroy {
  imageID: number;
  private pagesSubscription: Subscription;
  private selectedRegionSubscription: Subscription;
  imagePreviewShapes: Shape[];
  imagePreviewZoomFactor = 1;
  selectedRegionShapes: any;
  selectedRegionZoomFactor = 1;

  // TODO manuscript vs printed - data from store
  agnosticSymbolToolbarCategories: AgnosticSymbolToolbarCategory[] = AGNOSTIC_SYMBOL_TOOLBAR_CATEGORIES.get('eMensural');
  notationType = 'eMensural';
  manuscriptType = 'eHandwritten';

  selectedRegion: Region = null;

  @ViewChild('imagePreview') imagePreview: ImageComponent;
  @ViewChild('selectedRegionImage') selectedRegionImage: ImageComponent;

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<any>) { }

  ngOnInit() {
    // request store data
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.imageID = +params.get('id'); // + converts the string to number
      this.store.dispatch(new GetImageProjection(+this.imageID));
    });

    this.pagesSubscription = this.store.select(selectPages).subscribe(next => {
      if (next) {
        this.drawImagePreviewRegions(next);
        this.imagePreview.select(); // set in select mode
      }
    });

    this.selectedRegionSubscription = this.store.select(selectSelectedRegion).subscribe(next => {
      if (next) {
        this.selectedRegion = next;
        this.drawSelectedRegionSymbols();
      }
    });
  }

  ngOnDestroy() {
    this.pagesSubscription.unsubscribe();
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.imageID]);
  }

  openSemanticRepresentation() {
    this.router.navigate(['semanticrepresentation', this.imageID]);
  }

  onPreviewImageShapeSelected($event: Shape) {
    if ($event) {
      this.selectedRegion = null; // it will have in the selectedRegionSubscription subscription
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

  private drawBox(shapes: Shape[], layer: string, id: number, boundingBox: BoundingBox, color: string): Rectangle {
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
    shapes.push(rect);
    return rect;
  }
  private drawImagePreviewRegion(region: Region) {
    this.drawBox(this.imagePreviewShapes,
      region.regionType.name, region.id, region.boundingBox, '#' + region.regionType.hexargb ).data = region;
  }

  private drawSelectedRegionSymbols() {
    this.selectedRegionShapes = new Array();
    if (this.selectedRegion.symbols) {
      this.selectedRegion.symbols.forEach(symbol => {
        this.drawBox(this.selectedRegionShapes,
          symbol.agnosticSymbolType, symbol.id, symbol.boundingBox, 'red').data = symbol;
        // console.log(JSON.stringify(symbol.boundingBox, null, 4));
      });
    }
  }
}
