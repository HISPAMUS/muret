import { Component, OnInit } from '@angular/core';
import {ImageRecognitionBaseAbstractComponent} from "../image-recognition-base-abstract/image-recognition-base-abstract.component";
import {ImageRecognitionPutComments} from "../../../store/actions/image-recognition.actions";

@Component({
  selector: 'app-image-overview',
  templateUrl: './image-overview.component.html',
  styleUrls: ['./image-overview.component.css']
})
export class ImageOverviewComponent extends ImageRecognitionBaseAbstractComponent implements OnInit {
  commentsChanged: boolean = false;
  comments: string;

  ngOnInit() {
    super.ngOnInit();
  }

  protected onImageOverviewChanged() {
    super.onImageOverviewChanged();
    this.comments = this.imageOverview.comments;
    this.commentsChanged = false;
  }

  onCommentsChanged($event: any) {
    this.commentsChanged = true;
  }

  saveComments() {
    this.store.dispatch(new ImageRecognitionPutComments(this.imageID, this.comments));
  }

  protected isPageSelectable(): boolean {
    return true;
  }

}
