import {Point} from './point';

export class Stroke {
  points: Array<Point>;

  constructor(points: Array<Point>) {
    this.points = points;
  }
}

