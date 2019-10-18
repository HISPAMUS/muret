/**
 * Needs to be class rather than an interface for the component instantiation method
 */
import {ShapeComponent} from '../components/shape/shape.component';

export class Shape {
  id: string;
  fromX: number;
  fromY: number;
  originX: number;
  originY: number;
  strokeColor: string;
  fillColor: string;
  strokeWidth: number;
  strokeDashArray?: string; // see SVG stroke-dasharray
  hidden = false;
  label?: string;
  layer: string;
  data?: any;
  shapeComponent: ShapeComponent;

  constructor(public type: string) {
    this.fromX = 0;
    this.fromY = 0;
    this.originX = this.fromX;
    this.originY = this.fromY;
  }
}
