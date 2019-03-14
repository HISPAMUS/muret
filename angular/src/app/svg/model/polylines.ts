import {Shape} from './shape';
import {Polyline} from './polyline';

export class Polylines extends Shape {
  polylines: Polyline[];
  startNewPolyline: boolean;

  constructor() {
    super('Polylines');
    this.startNewPolyline = true;
    this.polylines = new Array();
  }

  addPoint(integerTimeStamp: number, integerX: number, integerY: number) {
    if (this.startNewPolyline) {
      this.startNewPolyline = false;
      this.polylines.push(new Polyline());
    }

    this.polylines[this.polylines.length - 1].addPoint(integerTimeStamp, integerX, integerY);
  }


}
