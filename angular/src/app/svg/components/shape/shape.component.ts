import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Shape} from '../../model/shape';

@Component({
  selector: 'app-shape',
  templateUrl: './shape.component.html',
  styleUrls: ['./shape.component.css']
})
export class ShapeComponent implements OnInit {
  shape: Shape;

  constructor() { }

  ngOnInit() {
  }

}
