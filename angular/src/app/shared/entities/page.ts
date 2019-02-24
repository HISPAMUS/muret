import {Region} from './region';
import {BoundingBox} from './bounding-box';
import {Entity} from './entity';

export interface Page extends Entity {
  boundingBox: BoundingBox;
  regions: Region[];
}
