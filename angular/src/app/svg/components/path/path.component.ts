import { Component, OnInit } from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';

@Component({
  selector: 'svg[app-path]',
  templateUrl: './path.component.html',
  styleUrls: ['./path.component.css']
})
export class PathComponent extends ShapeComponent implements OnInit {

  constructor() {
    super();
  }

  ngOnInit() {
  }

}
