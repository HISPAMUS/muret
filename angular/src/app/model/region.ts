import {BoundingBox} from './bounding-box';
import {Symbol} from './symbol';
import {RegionType} from './region-type';

export class Region {
  id: number;
  boundingBox: BoundingBox;
  symbols: Array<Symbol>;
  regionType: RegionType;

  constructor(id: number, boundingBox: BoundingBox, regionType: RegionType, symbols: Array<Symbol>) {
    this.id = id;
    this.boundingBox = boundingBox;
    this.symbols = symbols;
    this.regionType = regionType;
  }
}
