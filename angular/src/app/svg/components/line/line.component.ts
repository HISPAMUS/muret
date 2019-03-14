import {Component, Input, OnInit} from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';
import {Line} from '../../model/line';

@Component({
  selector: '[appLine]',
  templateUrl: './line.component.html',
  styleUrls: ['./line.component.css']
})
export class LineComponent extends ShapeComponent implements OnInit {
  @Input() appLine: Line;

  constructor() {
    super();
  }

  ngOnInit() {
    super.ngOnInit(); // important
  }

}
