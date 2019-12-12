import {Part} from '../entities/part';
import {KeyValue} from '@angular/common';

export interface PartUses {
  part: Part;
  images?: number[];
  /**
   * key = image, value = page
   */
  pages?: KeyValue<number, number> [];
  /**
   * key = image, value = region
   */
  regions?: KeyValue<number, number> [];
  /**
   * key = image, value = symbol
   */
  symbols?: KeyValue<number, number> [];
}
export interface UsesOfParts {
  uses: PartUses[];
}

