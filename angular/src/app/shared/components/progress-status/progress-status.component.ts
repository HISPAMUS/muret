import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgbTooltipConfig} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-progress-status',
  templateUrl: './progress-status.component.html',
  styleUrls: ['./progress-status.component.css']
})
export class ProgressStatusComponent implements OnInit {
  @Input() status: string;
  @Output() statusChange = new EventEmitter<string>();

  constructor(public config: NgbTooltipConfig) {
    config.placement = 'top';
    config.triggers = 'click';
  }

  ngOnInit() {
  }

  getButtonClass(status: string) {
    if (status === this.status) {
      return 'selected';
    } else {
      return 'unselected';
    }
  }

  changeStatus(status: string) {
    this.statusChange.emit(status);
  }
}
