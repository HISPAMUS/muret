import {BoundingBox} from './bounding-box';
import {Strokes} from './strokes';

export class Symbol {
  id: number;
  boundingBox: BoundingBox;
  strokes: Strokes;
  positionInStaff: string;
  agnosticSymbolType: string;

  constructor(id: number, boundingBox: BoundingBox, strokes: Strokes, positionInStaff: string, agnosticSymbolType: string) {
    this.id = id;
    this.boundingBox = boundingBox;
    this.strokes = strokes;
    this.positionInStaff = positionInStaff;
    this.agnosticSymbolType = agnosticSymbolType;
  }
}
