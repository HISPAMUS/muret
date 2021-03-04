import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ImagePhaseComponent} from "./image-phase.component";
import {Router} from "@angular/router";
import {NgbTooltipConfig} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-image-phase-parts',
  templateUrl: './image-phase.component.html',
  styleUrls: ['./image-phase.component.css']
})
export class ImagePhasePartsComponent extends ImagePhaseComponent implements OnChanges {
  @Input() imageID: number;
  @Input() size: string;
  @Input() status: string;

  public constructor(public router: Router, public config: NgbTooltipConfig) {
    super(router, config);
    this.iconName = 'guitar';
    this.route = '/imageRecognition/parts';
    this.tooltip = 'Parts / instruments';
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.imageID) {
      super.imageID = this.imageID;
    }
  }
}
