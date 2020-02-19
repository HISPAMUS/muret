import {Region} from './region';
import {BoundingBox} from './bounding-box';
import {Entity} from './entity';
import {Part} from './part';

export interface Page extends Entity {
  boundingBox?: BoundingBox;
  regions?: Region[];
  part?: Part;
}
