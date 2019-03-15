import {Point} from '../../core/model/entities/point';

export class Polyline {
  firstTime: number;
  pointsValue: Point[];
  svgPoints: string;

  constructor(points: Point[]) {
    this.pointsValue = points;
    this.recomputeSVGPoints();
  }

  /*get points() {
    return this.pointsValue;
  }

  set points(val) {
    this.pointsValue = val;
    this.recomputeSVGPoints();
  }*/

  addPoint(absoluteTimeInMS: number, integerX: number, integerY: number) {
    if (this.pointsValue.length === 0) {
      this.firstTime = absoluteTimeInMS;
    }
    const point: Point = {
      time: absoluteTimeInMS - this.firstTime,
      x: integerX,
      y: integerY
    };
    this.pointsValue.push(point);
    this.recomputeSVGPoints();
  }

  private recomputeSVGPoints() {
    this.svgPoints = this.pointsValue.map(p => [p.x, p.y]).join(','); // first extract just x and y, then concatenate with ,
  }
}
