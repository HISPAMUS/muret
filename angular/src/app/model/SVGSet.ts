import {AgnosticTypeSVGPath} from './agnostic-type-svgpath';

export class SVGSet {
  x: number;
  y: number;
  em: number;
  paths: Array<AgnosticTypeSVGPath>;


  constructor(x: number, y: number, em: number, paths: Array<AgnosticTypeSVGPath>) {
    this.x = x;
    this.y = y;
    this.em = em;
    this.paths = paths;
  }
}
