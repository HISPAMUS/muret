import {Component, OnChanges, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {ImageOverview} from "../../model/image-overview";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../store/state/image-recognition.state";
import {ImageRecognitionGetImageOverview} from "../../store/actions/image-recognition.actions";
import {selectImageRecognitionImageOverview} from "../../store/selectors/image-recognition.selector";

@Component({
  selector: 'app-image-recognition-base-abstract-component',
  templateUrl: './image-recognition-base-abstract-component.component.html',
  styleUrls: ['./image-recognition-base-abstract-component.component.css']
})
export abstract class ImageRecognitionBaseAbstractComponentComponent implements OnInit {
  private _imageID: number;
  private _imageOverview$: Observable<ImageOverview>;

  constructor(private route: ActivatedRoute, private store: Store<ImageRecognitionState>) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this._imageID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new ImageRecognitionGetImageOverview(this.imageID))
      //TODO update breadcrumb including the image
    });

    this._imageOverview$ = this.store.select(selectImageRecognitionImageOverview);
  }

  get imageOverview$() {
    return this._imageOverview$;
  }

  get imageID() {
    return this._imageID;
  }
}
