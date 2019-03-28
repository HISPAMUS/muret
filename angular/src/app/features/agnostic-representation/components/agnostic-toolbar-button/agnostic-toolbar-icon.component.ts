import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-agnostic-toolbar-icon',
  templateUrl: './agnostic-toolbar-icon.component.html',
  styleUrls: ['./agnostic-toolbar-icon.component.css']
})
export class AgnosticToolbarIconComponent implements OnInit {
  @Input() buttonWidth: number;
  @Input() buttonHeight: number;
  @Input() symbolViewBox: string;
  @Input() symbolPathD: string;
  @Input() symbolTransform: string;
  @Input() symbolID: string;
  @Input() defaultLineSpace: number;

  linesY: Array<number> = new Array<number>();

  private buttonViewBox: string;
  private staffSpaceHeight: number;

  constructor() { }

  ngOnInit() {
    this.buttonViewBox = `0 0 ${this.buttonWidth} ${this.buttonHeight}`;

    const staffHeight = this.buttonHeight / 2;
    const marginTop = this.buttonHeight / 4;

    this.staffSpaceHeight = staffHeight / 4;
    for (let i = 0; i < 5; i++) {
      this.linesY[i] = marginTop + this.staffSpaceHeight * i;
    }
  }

  trackByLineFn(index, item: number) {
    return index;
  }

  computeAgnosticStaffSymbolY(): number {
    const heightDifference = -(this.staffSpaceHeight * (this.defaultLineSpace / 2.0));
    const y = this.linesY[4]  + heightDifference;
    return y;
  }

  getX() {
    return this.buttonWidth / 4;
  }
}
