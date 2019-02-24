import { Component, OnInit } from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';

@Component({
  selector: 'svg[app-line]',
  templateUrl: './line.component.html',
  styleUrls: ['./line.component.css']
})
export class LineComponent extends ShapeComponent implements OnInit {

  constructor() {
    super();
  }

  ngOnInit() {
  }

}
