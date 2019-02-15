import {BoundingBox} from './bounding-box';
import {Strokes} from './strokes';

export interface Symbol {
  id: number;
  boundingBox: BoundingBox;
  strokes: Strokes;
  positionInStaff: string;
  agnosticSymbolType: string;
}
