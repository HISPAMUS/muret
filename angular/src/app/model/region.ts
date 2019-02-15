import {BoundingBox} from './bounding-box';
import {Symbol} from './symbol';
import {RegionType} from './region-type';

export interface Region {
  id: number;
  boundingBox: BoundingBox;
  symbols: Symbol[];
  regionType: RegionType;
}
