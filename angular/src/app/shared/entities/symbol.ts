import {BoundingBox} from './bounding-box';
import {Strokes} from './strokes';
import {Entity} from './entity';

export interface Symbol extends Entity {
  boundingBox: BoundingBox;
  strokes: Strokes;
  positionInStaff: string;
  agnosticSymbolType: string;
}
