import { Component, OnInit } from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';

@Component({
  selector: 'svg[app-text]',
  templateUrl: './text.component.html',
  styleUrls: ['./text.component.css']
})
export class TextComponent extends ShapeComponent implements OnInit {

  constructor() {
    super();
  }

  ngOnInit() {
  }

}
