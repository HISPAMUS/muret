import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {Notation} from "../../../../../../shared/services/notation";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";
import {selectImageRecognitionNotation} from "../../../../store/selectors/image-recognition.selector";
import {NotationService} from "../../../../../../shared/services/notation.service";

@Component({
  selector: 'app-paecpreview',
  templateUrl: './paecpreview.component.html',
  styleUrls: ['./paecpreview.component.css']
})
export class PAECPreviewComponent implements OnInit, OnDestroy {
  notationSubscription: Subscription;
  paec: string;

  constructor(private store: Store<ImageRecognitionState>, private notationService: NotationService) { }

  ngOnInit(): void {
    this.notationSubscription = this.store.select(selectImageRecognitionNotation).subscribe(next => {
      if (next && next.content) {
        this.paec = this.notationService.renderStaffToPAE(next.content);
      }
    });
  }

  ngOnDestroy(): void {
    this.notationSubscription.unsubscribe();
  }
}
