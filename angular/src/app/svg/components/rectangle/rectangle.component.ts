import { Component, OnInit } from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';

@Component({
  selector: 'svg[app-rectangle]',
  templateUrl: './rectangle.component.html',
  styleUrls: ['./rectangle.component.css']
})
export class RectangleComponent extends ShapeComponent implements OnInit {
  constructor() {
    super();
  }

  ngOnInit() {
  }

}
