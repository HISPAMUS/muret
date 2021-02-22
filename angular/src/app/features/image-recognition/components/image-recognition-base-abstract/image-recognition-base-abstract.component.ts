import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {ImageOverview} from "../../model/image-overview";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Store} from "@ngrx/store";
import {ImageRecognitionGetImageOverview} from "../../store/actions/image-recognition.actions";
import {selectImageRecognitionImageOverview} from "../../store/selectors/image-recognition.selector";
import {BreadcrumbsUpdateImage} from "../../../../layout/store/actions/breadcrumbs.actions";
import {RegionType} from "../../../../core/model/entities/region-type";
import {ImageRecognitionState} from "../../store/state/image-recognition.state";
import {DocumentAnalysisGetRegionTypes} from "../../store/actions/document-analysis.actions";
import {selectDocumentAnalysisRegionTypes} from "../../store/selectors/document-analysis.selector";

@Component({
  selector: 'app-image-recognition-base-abstract-component',
  templateUrl: './image-recognition-base-abstract-component.component.html',
  styleUrls: ['./image-recognition-base-abstract-component.component.css']
})
export abstract class ImageRecognitionBaseAbstractComponent implements OnInit, OnDestroy {
  private _imageID: number;
  private _imageOverview: ImageOverview;
  private imageOverviewSubscription: Subscription;
  regionTypes$: Observable<RegionType[]>;

  constructor(private route: ActivatedRoute, private store: Store<ImageRecognitionState>) {
    this.store.dispatch(new DocumentAnalysisGetRegionTypes());
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this._imageID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new ImageRecognitionGetImageOverview(this.imageID))
      this.store.dispatch(new BreadcrumbsUpdateImage(this.imageID));
      //TODO update breadcrumb including the image
    });

    this.imageOverviewSubscription = this.store.select(selectImageRecognitionImageOverview).subscribe(next => {
      if (next) {
        this._imageOverview = next;
      }
    });

    this.regionTypes$ = this.store.select(selectDocumentAnalysisRegionTypes);

  }

  ngOnDestroy() {
    this.imageOverviewSubscription.unsubscribe();
  }

  get imageOverview() {
    return this._imageOverview;
  }

  get imageID() {
    return this._imageID;
  }
}
