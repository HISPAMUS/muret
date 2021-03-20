import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {NgbTooltipConfig} from "@ng-bootstrap/ng-bootstrap";

/*@Component({
  selector: 'app-image-phase',
  templateUrl: './image-phase.component.html',
  styleUrls: ['./image-phase.component.css']
})*/
@Component({
  template: ''
})
export abstract class ImagePhaseComponent implements OnInit {
  //@Input not supported in inheritance
  protected imageID: number;
  iconName: string;
  route: string
  tooltip: string;

  protected constructor(public router: Router, public config: NgbTooltipConfig) {
    config.placement = 'bottom';
    config.triggers = 'hover';
  }

  ngOnInit(): void {
  }

  onClick() {
    this.router.navigate([this.route, this.imageID]);
  }


}
