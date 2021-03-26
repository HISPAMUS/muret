import {Component, Input, OnInit, EventEmitter, Output} from '@angular/core';
import {Image} from "../../../core/model/entities/image";
import {ImageRecognitionState} from "../../../features/image-recognition/store/state/image-recognition.state";
import {Store} from "@ngrx/store";
import {NumberArray} from "../../../core/model/restapi/number-array";
import {DocumentChangeImagesVisibility} from "../../../features/document/store/actions/document.actions";

@Component({
  selector: 'app-image-show-hide',
  templateUrl: './image-show-hide.component.html',
  styleUrls: ['./image-show-hide.component.css']
})
export class ImageShowHideComponent implements OnInit {
  @Input() imageID: number;
  @Input() hidden: boolean;
  @Output() onShow = new EventEmitter<number>();
  @Output() onHide = new EventEmitter<number>();

  constructor(private store: Store<ImageRecognitionState>) { }

  ngOnInit(): void {
  }

  hideImage() {
    const ids: NumberArray = {
      values: [this.imageID]
    }
    this.store.dispatch(new DocumentChangeImagesVisibility(ids, true));
  }

  unhideImage() {
    const ids: NumberArray = {
      values: [this.imageID]
    }
    this.store.dispatch(new DocumentChangeImagesVisibility(ids, false));
  }
}
