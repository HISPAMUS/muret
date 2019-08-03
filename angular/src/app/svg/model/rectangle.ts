import {Shape} from './shape';

export class Rectangle extends Shape {
  width: number;
  height: number;
  labelColor = 'black';

  constructor() {
    super('Rectangle');
    this.width = 0;
    this.height = 0;

  }
}
