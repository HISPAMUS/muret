import {Part} from '../entities/part';

/**
 * This complex structure has been used in order to avoid too many server API calls
 */
export interface PartUse {
  partName?: string;
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

export function findPartsUsed(usesOfParts: UsesOfParts, imageID: number): Array<string> {
  const partsUsed: Array<string> = [];

  usesOfParts.uses.forEach(usesOfPart => {
    if (usesOfPart.images.indexOf(imageID) >= 0 ||
      (usesOfPart.pages.find(page => page.imageId === imageID)) ||
      (usesOfPart.regions.find(region => region.imageId === imageID)) ||
      (usesOfPart.symbols.find(symbol => symbol.imageId === imageID))) {
      partsUsed.push(usesOfPart.part.name);
    }
  });
  return partsUsed;

}

