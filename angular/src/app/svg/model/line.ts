import {Shape} from './shape';

export class Line extends Shape {
  toX: number;
  toY: number;

  constructor() {
    super('Line');
  }
}
