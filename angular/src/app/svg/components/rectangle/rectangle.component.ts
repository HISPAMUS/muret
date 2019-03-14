import {Component, Input, OnInit} from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';
import {Rectangle} from '../../model/rectangle';
import {Coordinate} from '../../model/coordinate';
import {Shape} from '../../model/shape';

/**
 * We don't use the angular 7 capabilities because we are getting some troubles with zoom
 */
@Component({
  selector: '[appRectangle]',
  templateUrl: './rectangle.component.html',
  styleUrls: ['./rectangle.component.css']
})
export class RectangleComponent extends ShapeComponent implements OnInit {
  @Input() appRectangle: Rectangle;

  constructor() {
    super();
  }

  ngOnInit() {
    super.ngOnInit(); // important
  }

  // received from canvas
  onHandleMouseMove(x: number, y: number): boolean {
    if (this.handleSelected) {
      switch (this.handleSelected) {
        case 'svgTopLeftHandle':
          this.resizeNW(x, y);
          break;
        case 'svgTopRightHandle':
          this.resizeNE(x, y);
          break;
        case 'svgBottomLeftHandle':
          this.resizeSW(x, y);
          break;
        case 'svgBottomRightHandle':
          this.resizeSE(x, y);
          break;
      }
      return true;
    } else {
      return false;
    }
  }

  private resizeNW(x: number, y: number) {
    if (this.shape instanceof Rectangle) {
      const diffX = this.shape.fromX - x;
      const diffY = this.shape.fromY - y;
      const newWidth = this.shape.width + diffX;
      const newHeight = this.shape.height + diffY;

      if (newWidth > 0 && newHeight > 0) {
        this.shape.fromX = x;
        this.shape.fromY = y;
        this.shape.width = newWidth;
        this.shape.height = newHeight;
      }
    }
  }

  private resizeNE(x: number, y: number) {
    if (this.shape instanceof Rectangle) {
      const diffX = x - (this.shape.fromX + this.shape.width);
      const diffY = this.shape.fromY - y;
      const newWidth = this.shape.width + diffX;
      const newHeight = this.shape.height + diffY;

      if (newWidth > 0 && newHeight > 0) {
        this.shape.width = newWidth;
        this.shape.height = newHeight;
        this.shape.fromY = y;
      }
    }
  }

  private resizeSW(x: number, y: number) {
    if (this.shape instanceof Rectangle) {
      const diffX = this.shape.fromX - x;
      const diffY = y - (this.shape.fromY + this.shape.height);
      const newWidth = this.shape.width + diffX;
      const newHeight = this.shape.height + diffY;

      if (newWidth > 0 && newHeight > 0) {
        this.shape.fromX = x;
        this.shape.width = newWidth;
        this.shape.height = newHeight;
      }
    }
  }

  private resizeSE(x: number, y: number) {
    if (this.shape instanceof Rectangle) {
      const diffX = x - (this.shape.fromX + this.shape.width);
      const diffY = y - (this.shape.fromY + this.shape.height);
      const newWidth = this.shape.width + diffX;
      const newHeight = this.shape.height + diffY;

      if (newWidth > 0 && newHeight > 0) {
        this.shape.width = newWidth;
        this.shape.height = newHeight;
      }
    }
  }

  /*startDrawing(beginPosition: Coordinate): void {
    if (this.shape instanceof Rectangle) {
      this.shape.fromX = beginPosition.x;
      this.shape.fromY = beginPosition.y;
      this.shape.height = 0;
      this.shape.width = 0;
    }
  }*/

  draw(currentPosition: Coordinate): void {
    super.draw(currentPosition);
    if (this.shape instanceof Rectangle) {
      this.shape.width = Math.abs(currentPosition.x - this.shape.fromX);
      this.shape.height = Math.abs(currentPosition.y - this.shape.fromY);
    }
  }

}
