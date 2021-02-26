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
  fillOpacity: number;
  strokeWidth: number;
  strokeDashArray?: string; // see SVG stroke-dasharray
  hidden = false;
  label?: string;
  layer: string;
  data?: any;
  shapeComponent: ShapeComponent;
  originalFillColor: string;
  selectable: boolean = true;

  constructor(public type: string) {
    this.fromX = 0;
    this.fromY = 0;
    this.originX = this.fromX;
    this.originY = this.fromY;
  }

  highlightSelected() {
    if (!this.originalFillColor) {
      this.originalFillColor = this.fillColor;
    }
    this.fillOpacity = 0.2;
    this.fillColor = 'red';
  }

  unHighlightSelected() {
    this.fillOpacity = 0.8;
    this.fillColor = this.originalFillColor;
  }

}
