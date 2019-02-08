import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';
import { Shape, MousePosition } from '../../model/shape';
import { ShapeType } from '../../model/shape-types';
import {isDefined} from '@ng-bootstrap/ng-bootstrap/util/util';

@Component({
    selector: 'app-shape',
    templateUrl: './shape.component.html',
    styleUrls: ['./shape.component.css']
})
export class ShapeComponent implements OnInit {
    @ViewChild('shapeTemplate') shapeTemplate: TemplateRef<any>;

    shape: Shape;
    shapeType: ShapeType;
    offset: MousePosition;
    isSelected = false;
    isEditing = false;
    selectionPoints: MousePosition[] = [];

    handleSelected: string; // drizo
    handlesColor = 'green';
    handlesRadius = 4;
    modelObjectID: number;
    modelObjectType: string;

    constructor() {
        console.log('ShapeComponent constructor');
    }

    ngOnInit() {
        console.log('ShapeComponent ngOnInit');
    }

    startDrawing(beginPosition: MousePosition): void {
        console.log('ShapeComponent: startDrawing at ', beginPosition);
    }

    endDrawing(): void {
        console.log('ShapeComponent: endDrawing()');
    }

    draw(currentPosition: MousePosition): void {
        console.log('ShapeComponent: draw at ', currentPosition);
    }

    setPoint(point: MousePosition): void {
        console.log('ShapeComponent: setPoint at ', point);
    }

    drag(draqPosition: MousePosition): void {
        console.log(this.shape.shapeProperties.name + ' drag at ', draqPosition, ', offset : ', this.offset);

        if (this.offset === undefined) {
            this.offset = Object.assign({}, draqPosition);
            this.offset.x -= this.shape.originX;
            this.offset.y -= this.shape.originY;
        }
        this.shape.originX = (draqPosition.x - this.offset.x);
        this.shape.originY = (draqPosition.y - this.offset.y);
    }

  // drizo don't use mouseUp or move because it usually looses focus no movement
  // - it is handled

  onHandleMouseDown($event, handle: string) {
    console.log('Handle mouse down on ' + handle);
    this.handleSelected = handle;
    $event.stopPropagation();
  }


  onHandleMouseMove(x: number, y: number): boolean {
      return false;
  }

  deselectHandle(): boolean {
    if (this.handleSelected) {
      this.handleSelected = null;
      return true;
    } else {
      return false;
    }
  }

  isHandleSelected() {
    return this.handleSelected != null;
  }

  setPosition(x: number, y: number) {
    this.shape.originX = x;
    this.shape.originY = y;
  }
}
