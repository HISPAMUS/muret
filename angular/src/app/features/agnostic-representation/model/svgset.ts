import {AgnosticTypeSVGPath} from './agnostic-type-svgpath';

export interface SVGSet {
  ascent: number;
  descent: number;
  em: number;
  paths: Array<AgnosticTypeSVGPath>;
}
