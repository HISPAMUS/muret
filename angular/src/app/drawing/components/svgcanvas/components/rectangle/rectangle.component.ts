import { Component, OnInit } from '@angular/core';
import { ShapeComponent } from '../shape/shape.component';
import { ShapeType } from '../../model/shape-types';
import { MousePosition, Rectangle } from '../../model/shape';

@Component({
    selector: 'app-rectangle',
    templateUrl: './rectangle.component.html',
    styleUrls: ['./rectangle.component.css']
})
export class RectangleComponent extends ShapeComponent implements OnInit {
  label = '';

  constructor() {
        super();
        console.log('RectangleComponent constructor');
        this.shape = new Rectangle();
        this.shapeType = ShapeType.Rectangle;
    }

    ngOnInit() {
        console.log('RectangleComponent ngOnInit');
    }

    setStyles() {
        const styles = {
            'stroke': this.shape.shapeProperties.strokeColor,
            'fill': this.shape.shapeProperties.fillColor,
            'stroke-width': this.isSelected ? 5 : this.shape.shapeProperties.strokeWidth
        };
        return styles;
    }

    startDrawing(beginPosition: MousePosition): void {
        console.log('RectanleComponent startDrawing at ', beginPosition);
        if (this.shape instanceof Rectangle) {
            this.shape.originX = beginPosition.x;
            this.shape.originY = beginPosition.y;
        }
    }

    draw(currentPosition: MousePosition): void {
        console.log('RectangleComponent draw');
        if (this.shape instanceof Rectangle) {
            this.shape.width = Math.abs(currentPosition.x - this.shape.originX);
            this.shape.height = Math.abs(currentPosition.y - this.shape.originY);
        }
    }

    setDimensions(width: number, height: number) {
      if (this.shape instanceof Rectangle) {
        this.shape.width = width;
        this.shape.height = height;
      }
    }

  // drizo don't use mouseUp or move because it usually looses focus no movement
  // - it is handled

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
      const diffX = this.shape.originX - x;
      const diffY = this.shape.originY - y;
      const newWidth = this.shape.width + diffX;
      const newHeight = this.shape.height + diffY;

      if (newWidth > 0 && newHeight > 0) {
        this.shape.originX = x;
        this.shape.originY = y;
        this.shape.width = newWidth;
        this.shape.height = newHeight;
      }
    }
  }

  private resizeNE(x: number, y: number) {
    if (this.shape instanceof Rectangle) {
      const diffX = x - (this.shape.originX + this.shape.width);
      const diffY = this.shape.originY - y;
      const newWidth = this.shape.width + diffX;
      const newHeight = this.shape.height + diffY;

      if (newWidth > 0 && newHeight > 0) {
        this.shape.width = newWidth;
        this.shape.height = newHeight;
        this.shape.originY = y;
      }
    }
  }

  private resizeSW(x: number, y: number) {
    if (this.shape instanceof Rectangle) {
      const diffX = this.shape.originX - x;
      const diffY = y - (this.shape.originY + this.shape.height);
      const newWidth = this.shape.width + diffX;
      const newHeight = this.shape.height + diffY;

      if (newWidth > 0 && newHeight > 0) {
        this.shape.originX = x;
        this.shape.width = newWidth;
        this.shape.height = newHeight;
      }
    }
  }

  private resizeSE(x: number, y: number) {
    if (this.shape instanceof Rectangle) {
      const diffX = x - (this.shape.originX + this.shape.width);
      const diffY = y - (this.shape.originY + this.shape.height);
      const newWidth = this.shape.width + diffX;
      const newHeight = this.shape.height + diffY;

      if (newWidth > 0 && newHeight > 0) {
        this.shape.width = newWidth;
        this.shape.height = newHeight;
      }
    }
  }
}
