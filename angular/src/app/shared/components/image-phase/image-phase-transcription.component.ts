import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ImagePhaseComponent} from "./image-phase.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-image-phase-transcription',
  templateUrl: './image-phase.component.html',
  styleUrls: ['./image-phase.component.css']
})
export class ImagePhaseTranscriptionComponent extends ImagePhaseComponent implements OnChanges {
  @Input() imageID: number;
  @Input() size: string;

  public constructor(public router: Router) {
    super(router);
    this.iconName = 'music';
    this.route = '/imageRecognition/transcription';
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.imageID) {
      super.imageID = this.imageID;
    }
  }
}
