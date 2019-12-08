import {Part} from '../entities/part';

export interface PartUses {
  part: Part;
  images: number[];
  pages: number[];
  regions: number[];
  symbols: number[];
}
export interface UsesOfParts {
  uses: PartUses[];
}

