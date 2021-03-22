import {Component, Input, OnInit} from '@angular/core';
import {Notation} from "../../../../../../shared/services/notation";
import {Observable} from "rxjs";
import {selectImageRecognitionNotation} from "../../../../store/selectors/image-recognition.selector";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";

@Component({
  selector: 'app-meipreview',
  templateUrl: './meipreview.component.html',
  styleUrls: ['./meipreview.component.css']
})
export class MEIPreviewComponent implements OnInit {
  notation$: Observable<Notation>;

  constructor(private store: Store<ImageRecognitionState>) { }

  ngOnInit(): void {
    this.notation$ = this.store.select(selectImageRecognitionNotation);
  }
}
