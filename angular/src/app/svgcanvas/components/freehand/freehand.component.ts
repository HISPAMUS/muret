import { Component, OnInit } from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';
import {MousePosition, PolyLine} from '../../model/shape';
import {ShapeType} from '../../model/shape-types';

@Component({
  selector: 'app-freehand',
  templateUrl: './freehand.component.html',
  styleUrls: ['./freehand.component.css']
})

export class FreehandComponent extends ShapeComponent implements OnInit {
  // quantize to integer
  lastX: number;
  lastY: number;
  svgValue: string;

  constructor() {
    super();
    console.log('Freehand constructor');
    this.shape = new PolyLine();
    this.shapeType = ShapeType.PolyLine;
    this.svgValue = '';
  }

  ngOnInit() {
  }

  setStyles() {
    const styles = {
      'stroke': this.shape.shapeProperties.strokeColor,
      'fill': 'transparent',
      'stroke-width': this.isSelected ? 5 : this.shape.shapeProperties.strokeWidth
    };
    return styles;
  }

  private savePosition(x: number, y: number) {
    this.lastX = Math.round(x);
    this.lastY = Math.round(y);

    this.svgValue += x + ',' + y + ' ';
  }
  startDrawing(beginPosition: MousePosition): void {
    console.log('FreehandComponent startDrawing at ', beginPosition);
    if (this.shape instanceof PolyLine) {
      this.savePosition(beginPosition.x, beginPosition.y);
      if (this.shape instanceof PolyLine) {
        this.shape.points.push(beginPosition);
      }
    }
  }

  draw(currentPosition: MousePosition): void {
    // console.log('FreehandComponent draw');
    if (this.shape instanceof PolyLine) {
      const x = Math.round(currentPosition.x);
      const y = Math.round(currentPosition.y);
      if (x !== this.lastX || y !== this.lastY) {
        const mp = new MousePosition();
        mp.x = x;
        mp.y = y;
        mp.timestamp = currentPosition.timestamp;
        this.shape.points.push(mp);
        this.savePosition(x, y);
        // console.log('FH: ' + currentPosition.x + ' ' + currentPosition.y + ' ' + currentPosition.timestamp);
      }
    }
  }
}
