import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ImagePhaseComponent} from "./image-phase.component";
import {Router} from "@angular/router";
import {NgbTooltipConfig} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-image-phase-overview',
  templateUrl: './image-phase.component.html',
  styleUrls: ['./image-phase.component.css']
})
export class ImagePhaseOverviewComponent extends ImagePhaseComponent implements OnChanges{
  @Input() imageID: number;
  @Input() size: string;
  @Input() status: string; // not used in this base component but required by the angular html
  @Input() selected: string;

  public constructor(public router: Router, public config: NgbTooltipConfig) {
    super(router, config);
    this.iconName = 'tasks';
    this.route = '/imageRecognition/overview';
    this.tooltip = 'Overview';
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.imageID) {
      super.imageID = this.imageID;
    }
  }

}
