/**
 * Needs to be class rather than an interface for the component instantiation method
 */
export class Shape {
  id: number;
  data?: any;
  fromX: number;
  fromY: number;
  strokeColor: string;
  fillColor: string;
  strokeWidth: number;
  strokeDashArray?: string; // see SVG stroke-dasharray
}
