import {Component, Input, OnInit} from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';
import {Path} from '../../model/path';

@Component({
  selector: '[appPath]',
  templateUrl: './path.component.html',
  styleUrls: ['./path.component.css']
})
export class PathComponent extends ShapeComponent implements OnInit {
  @Input() appPath: Path;
  constructor() {
    super();
  }

  ngOnInit() {
    super.ngOnInit(); // important
  }

}
