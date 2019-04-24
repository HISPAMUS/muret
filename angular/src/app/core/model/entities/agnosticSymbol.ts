import {BoundingBox} from './bounding-box';
import {Strokes} from './strokes';
import {Entity} from './entity';

// It is Symbol at the BackEnd - angular suggests not to use Symbol as class name
export interface AgnosticSymbol extends Entity {
  boundingBox?: BoundingBox;
  strokes?: Strokes;
  positionInStaff: string;
  agnosticSymbolType: string;
  approximateX?: number;
  comments: string;
}
