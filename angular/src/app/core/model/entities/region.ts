import {BoundingBox} from './bounding-box';
import {AgnosticSymbol} from './agnosticSymbol';
import {RegionType} from './region-type';
import {Entity} from './entity';
import {Part} from './part';

export interface Region extends Entity {
  boundingBox?: BoundingBox;
  regionType?: RegionType;
  symbols?: AgnosticSymbol[];
  part?: Part;
}


