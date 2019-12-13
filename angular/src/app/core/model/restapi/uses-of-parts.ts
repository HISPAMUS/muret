import {Part} from '../entities/part';

/**
 * This complex structure has been used in order to avoid too many server API calls
 */
export interface PartUse {
  id: number;
  partId: number;
  imageId: number;
}

export interface PartUses {
  part: Part;
  images?: number[];
  /**
   * key = image, value = page
   */
  pages?: PartUse [];
  /**
   * key = image, value = region
   */
  regions?: PartUse [];
  /**
   * key = image, value = symbol
   */
  symbols?: PartUse [];
}
export interface UsesOfParts {
  uses: PartUses[];
}

