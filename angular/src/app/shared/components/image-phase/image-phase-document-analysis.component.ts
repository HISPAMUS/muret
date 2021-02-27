import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ImagePhaseComponent} from "./image-phase.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-image-phase-document-analysis',
  templateUrl: './image-phase.component.html',
  styleUrls: ['./image-phase.component.css']
})
export class ImagePhaseDocumentAnalysisComponent extends ImagePhaseComponent implements OnChanges{
  @Input() imageID: number;
  @Input() size: string;

  public constructor(public router: Router) {
    super(router);
    this.iconName = 'object-group';
    this.route = '/imageRecognition/documentAnalysis';
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.imageID) {
      super.imageID = this.imageID;
    }
  }
}
