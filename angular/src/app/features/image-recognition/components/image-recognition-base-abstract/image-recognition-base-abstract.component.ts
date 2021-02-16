import {Component, OnChanges, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {ImageOverview} from "../../model/image-overview";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../store/state/image-recognition.state";
import {ImageRecognitionGetImageOverview} from "../../store/actions/image-recognition.actions";
import {selectImageRecognitionImageOverview} from "../../store/selectors/image-recognition.selector";
import {BreadcrumbsUpdateDocument, BreadcrumbsUpdateImage} from "../../../../layout/store/actions/breadcrumbs.actions";
import {selectAuthUserID} from "../../../../auth/store/selectors/auth.selector";
import {HomeUpdateLastDocuments} from "../../../home/store/actions/home.actions";

@Component({
  selector: 'app-image-recognition-base-abstract-component',
  templateUrl: './image-recognition-base-abstract-component.component.html',
  styleUrls: ['./image-recognition-base-abstract-component.component.css']
})
export abstract class ImageRecognitionBaseAbstractComponent implements OnInit, OnDestroy {
  private _imageID: number;
  private _imageOverview: ImageOverview;
  private imageOverviewSubscription: Subscription;
  private userIDSubscription: Subscription;
  private userID: any;

  constructor(private route: ActivatedRoute, private store: Store<ImageRecognitionState>) { }

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
        this.updateLastDocuments();
      }
    });

    this.userIDSubscription = this.store.select(selectAuthUserID).subscribe(next => {
      if (next) {
        this.userID = next;
        this.updateLastDocuments();
      }
    });
  }

  private updateLastDocuments() {
    if (this.userID && this.imageOverview) {
      this.store.dispatch(new HomeUpdateLastDocuments(this.userID, this.imageOverview.documentID));
    }
  }

  ngOnDestroy() {
    this.imageOverviewSubscription.unsubscribe();
    this.userIDSubscription.unsubscribe();
  }

  get imageOverview() {
    return this._imageOverview;
  }

  get imageID() {
    return this._imageID;
  }
}
