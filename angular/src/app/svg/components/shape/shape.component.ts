import {Component, Input, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Shape} from '../../model/shape';
import {Coordinate} from '../../model/coordinate';

@Component({
  selector: 'app-shape',
  templateUrl: './shape.component.html',
  styleUrls: ['./shape.component.css']
})
// Don't use angular CDK drag&drop because we are getting some problems with the zoom
export class ShapeComponent implements OnInit {
  @Input() selected: boolean;
  @Input() editing: boolean;
  @Input() shape: Shape;

  protected handleSelected: string;
  private drawStarted = false;

  constructor() {
  }

  ngOnInit() {
    this.shape.shapeComponent = this;
  }

  onHandleMouseDown($event, handle: string) {
    if (this.editing) {
      this.handleSelected = handle;
      $event.stopPropagation();
    }
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

  isDrawStarted() {
    return this.drawStarted;
  }

  onHandleMouseMove(x: number, y: number): boolean {
    return false; // it will be overriden by specific shapes
  }

  draw(coordinate: Coordinate) {
    // it will be overriden by specific shapes
    this.drawStarted = true;
  }


}
