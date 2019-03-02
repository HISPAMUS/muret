import {BoundingBox} from './bounding-box';
import {Symbol} from './symbol';
import {RegionType} from './region-type';
import {Entity} from './entity';

export interface Region extends Entity {
  boundingBox?: BoundingBox;
  regionType?: RegionType;
  symbols?: Symbol[];
}


