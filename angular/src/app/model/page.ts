import {Region} from './region';
import {BoundingBox} from './bounding-box';

export interface Page {
  id: number;
  boundingBox: BoundingBox;
  regions: Region[];
}
