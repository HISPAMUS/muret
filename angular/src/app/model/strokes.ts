import {Stroke} from './stroke';

export class Strokes {
  strokeList: Array<Stroke>;

  constructor(strokeList: Array<Stroke>) {
    this.strokeList = strokeList;
  }
}
