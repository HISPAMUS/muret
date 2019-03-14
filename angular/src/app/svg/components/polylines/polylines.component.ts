import {Component, Input, OnInit} from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';
import {Coordinate} from '../../model/coordinate';
import {Polylines} from '../../model/polylines';
import {Polyline} from '../../model/polyline';

@Component({
  selector: '[appPolylines]',
  templateUrl: './polylines.component.html',
  styleUrls: ['./polylines.component.css']
})
export class PolylinesComponent extends ShapeComponent implements OnInit {
  @Input() appPolylines: Polylines;
  constructor() {
    super();
  }

  ngOnInit() {
    super.ngOnInit(); // important
  }

  draw(currentPosition: Coordinate): void {
    super.draw(currentPosition);
    if (this.shape instanceof Polylines) {
      this.shape.addPoint(Math.round(currentPosition.timestamp), Math.round(currentPosition.x), Math.round(currentPosition.y));
    }
  }

  trackByPolylineFn(index, item: Polyline) {
    return index;
  }
}
