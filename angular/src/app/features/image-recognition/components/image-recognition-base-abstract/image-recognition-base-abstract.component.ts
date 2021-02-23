import {AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {ImageOverview} from "../../model/image-overview";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Store} from "@ngrx/store";
import {
  ImageRecognitionGetImageOverview,
  ImageRecognitionGetPagesRegionsSymbols
} from "../../store/actions/image-recognition.actions";
import {
  selectImageRecognitionImageOverview,
  selectImageRecognitionImageOverviewPagesRegionsSymbols
} from "../../store/selectors/image-recognition.selector";
import {BreadcrumbsUpdateImage} from "../../../../layout/store/actions/breadcrumbs.actions";
import {RegionType} from "../../../../core/model/entities/region-type";
import {ImageRecognitionState} from "../../store/state/image-recognition.state";
import {
  DocumentAnalysisGetRegionTypes
} from "../../store/actions/document-analysis.actions";
import {
  selectDocumentAnalysisRegionTypes
} from "../../store/selectors/document-analysis.selector";
import {Page} from "../../../../core/model/entities/page";
import {BoundingBox} from "../../../../core/model/entities/bounding-box";
import {Region} from "../../../../core/model/entities/region";
import {Rectangle} from "../../../../svg/model/rectangle";
import {Shape} from "../../../../svg/model/shape";

@Component({
  selector: 'app-image-recognition-base-abstract-component',
  templateUrl: './image-recognition-base-abstract-component.component.html',
  styleUrls: ['./image-recognition-base-abstract-component.component.css']
})
export abstract class ImageRecognitionBaseAbstractComponent implements OnInit, OnDestroy, AfterViewInit {
  private _imageID: number;
  private _imageOverview: ImageOverview;
  private imageOverviewSubscription: Subscription;
  private pagesSubscription: Subscription;
  regionTypes$: Observable<RegionType[]>;
  private _documentAnalysisShapes: Shape[];

  constructor(private route: ActivatedRoute, private store: Store<ImageRecognitionState>) {
    this.store.dispatch(new DocumentAnalysisGetRegionTypes());
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this._imageID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new ImageRecognitionGetImageOverview(this.imageID))
      this.store.dispatch(new BreadcrumbsUpdateImage(this.imageID));
      this.store.dispatch(new ImageRecognitionGetPagesRegionsSymbols(+this.imageID));
    });

    this.regionTypes$ = this.store.select(selectDocumentAnalysisRegionTypes);

  }
  // To avoid expression changed error
  //TODO No va, sigue dando error
  ngAfterViewInit(): void {
    this.pagesSubscription = this.store.select(selectImageRecognitionImageOverviewPagesRegionsSymbols).subscribe(next => {
      if (next) {
        this.drawPagesAndRegions(next);
      }
      //this.pagesWithRegions = next;
    });

    this.imageOverviewSubscription = this.store.select(selectImageRecognitionImageOverview).subscribe(next => {
      if (next) {
        this._imageOverview = next;
      }
    });

  }

  ngOnDestroy() {
    this.imageOverviewSubscription.unsubscribe();
    this.pagesSubscription.unsubscribe();
  }

  get imageOverview() {
    return this._imageOverview;
  }

  get imageID() {
    return this._imageID;
  }

  get documentAnalysisShapes() {
    return this._documentAnalysisShapes;
  }

  private drawPagesAndRegions(pagesRegionsSymbols: Page[]) {
    this._documentAnalysisShapes = new Array();
    if (pagesRegionsSymbols) {
      pagesRegionsSymbols.forEach(page => {
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

  private applyRegionTypeFilter() {
    //TODO
    /*if (this.documentAnalysisShapes) {
      this.documentAnalysisShapes.forEach(shape => {
        shape.hidden = this.regionTypeFilterOut.has(shape.layer);
      });
    }*/
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
    rect.strokeWidth = 9;
    rect.layer = layer;
    rect.data = data;
    this._documentAnalysisShapes.push(rect);
    return rect;
  }
  private drawPage(page: Page) {
    this.drawBox('page', page.id, page.boundingBox, 'red', page); // TODO color
  }

  private drawRegion(region: Region) {
    this.drawBox(region.regionType.name, region.id, region.boundingBox, '#' + region.regionType.hexargb, region);
  }
}