import { Component, OnInit } from '@angular/core';
import { ShapeComponent } from '../shape/shape.component';
import { Shape } from '../../model/shape';

@Component({
    selector: 'app-group',
    templateUrl: './group.component.html',
    styleUrls: ['./group.component.css']
})
export class GroupComponent extends ShapeComponent implements OnInit {

    private groupObjects: Array<ShapeComponent>;

    constructor() {
        super();
        console.log('GroupComponent constructor');
      this.groupObjects = new Array<ShapeComponent>();
    }

    ngOnInit() {
    }

    clear() {
      this.groupObjects = new Array();
    }

  add(shape: ShapeComponent) {
      this.groupObjects.push(shape);
  }
}
