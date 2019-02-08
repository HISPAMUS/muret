import {Region} from './region';
import {BoundingBox} from './bounding-box';

export class Page {
  id: number;
  boundingBox: BoundingBox;
  regions: Array<Region>;

  constructor(id: number, boundingBox: BoundingBox, regions: Array<Region>) {
    this.id = id;
    this.boundingBox = boundingBox;
    this.regions = regions;
  }
}
