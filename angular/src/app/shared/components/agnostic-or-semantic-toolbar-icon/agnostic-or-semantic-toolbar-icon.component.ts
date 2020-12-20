import {Component, Input, OnInit} from '@angular/core';
import {PositionInStaffService} from '../../services/position-in-staff.service';

@Component({
  selector: 'app-agnostic-or-semantic-toolbar-icon',
  templateUrl: './agnostic-or-semantic-toolbar-icon.component.html',
  styleUrls: ['./agnostic-or-semantic-toolbar-icon.component.css']
})
export class AgnosticOrSemanticToolbarIconComponent implements OnInit {
  @Input() buttonWidth: number;
  @Input() buttonHeight: number;
  @Input() symbolViewBox: string;
  @Input() symbolPathD: string;
  @Input() symbolTransform: string;
  @Input() symbolID: string;
  @Input() positionInStaff: string;
  iconHeight: number;

  linesY: Array<number> = new Array<number>();

  buttonViewBox: string;
  private staffSpaceHeight: number;

  constructor(private positionInStaffService: PositionInStaffService) { }

  ngOnInit() {
    this.buttonViewBox = `0 0 ${this.buttonWidth} ${this.buttonHeight}`;

    const staffHeight = this.buttonHeight / 2;
    const marginTop = this.buttonHeight / 4;

    this.staffSpaceHeight = staffHeight / 4;
    for (let i = 0; i < 5; i++) {
      this.linesY[i] = marginTop + this.staffSpaceHeight * i;
    }

    this.iconHeight = staffHeight;
  }

  trackByLineFn(index, item: number) {
    return index;
  }

  computeAgnosticStaffSymbolY(): number {
    const lineSpace = this.positionInStaffService.positionInStaffToLineSpace(this.positionInStaff);
    const heightDifference = -(this.staffSpaceHeight * (lineSpace / 2.0));
    const y = this.linesY[4]  + heightDifference;
    return y;
  }

  getX() {
    return this.buttonWidth / 4;
  }
}
