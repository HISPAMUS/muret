import {Shape} from './shape';
import {BoundingBox} from "../../core/model/entities/bounding-box";

export class Rectangle extends Shape {
  width: number;
  height: number;
  labelColor = 'black';

  constructor() {
    super('Rectangle');
    this.width = 0;
    this.height = 0;
  }

  toBoundingBox(): BoundingBox {
    const result: BoundingBox = {
      fromX: this.fromX,
      fromY: this.fromY,
      id: this.data.id,
      toX: this.fromX + this.width,
      toY: this.fromY + this.height
    };
    return result;
  }

}
