import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ImagePhaseComponent} from "./image-phase.component";
import {Router} from "@angular/router";
import {NgbTooltipConfig} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-image-phase-document-analysis',
  templateUrl: './image-phase.component.html',
  styleUrls: ['./image-phase.component.css']
})
export class ImagePhaseDocumentAnalysisComponent extends ImagePhaseComponent implements OnChanges{
  @Input() imageID: number;
  @Input() size: string;

  public constructor(public router: Router, public config: NgbTooltipConfig) {
    super(router, config);
    this.iconName = 'object-group';
    this.route = '/imageRecognition/documentAnalysis';
    this.tooltip = 'Document analysis';
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.imageID) {
      super.imageID = this.imageID;
    }
  }
}
