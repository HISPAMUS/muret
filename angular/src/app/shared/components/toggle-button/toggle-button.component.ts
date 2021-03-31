import {Component, Input, OnInit, Output, EventEmitter, OnChanges, SimpleChanges} from '@angular/core';
import {NgbTooltipConfig} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-toggle-button',
  templateUrl: './toggle-button.component.html',
  styleUrls: ['./toggle-button.component.css']
})
export class ToggleButtonComponent implements OnInit, OnChanges {
  @Input() checked: boolean = false;
  @Output() checkedChange = new EventEmitter<boolean>();
  @Input() checkedTooltip: string;
  @Input() uncheckedTooltip: string;
  @Input() checkedIcon: string;
  @Input() uncheckedIcon: string;
  @Input() tooltipPosition: string;

  constructor(public config: NgbTooltipConfig) {
    config.placement = 'left';
    config.triggers = 'hover';
  }


  ngOnChanges(changes: SimpleChanges): void {
    if (changes.tooltipPosition && this.tooltipPosition) {
      this.config.placement = this.tooltipPosition;
    }
  }

  ngOnInit(): void {
  }

  getLabel() {
    if (this.checked) {
      return this.checkedTooltip;
    } else {
      return this.uncheckedTooltip;
    }
  }

  getClassName() {
    if (this.checked) {
      return 'checked';
    } else {
      return 'unchecked';
    }
  }

  onClick() {
    this.checked = !this.checked;
    this.checkedChange.emit(this.checked);
  }

  getIcon() {
    if (this.checked) {
      return this.checkedIcon;
    } else {
      return this.uncheckedIcon;
    }
  }

}
