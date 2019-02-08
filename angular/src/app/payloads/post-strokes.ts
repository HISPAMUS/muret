// Used to send post strokes to the REST service
import {Point} from '../model/point';

export class PostStrokes {
  regionID: number;
  points: Point[][];

  constructor(regionID: number, points: Point[][]) {
    this.regionID = regionID;
    this.points = points;
  }
}
