import {Shape} from './shape';

export class Path extends Shape {
  d: string;
  constructor() {
    super('Path');
  }
}
