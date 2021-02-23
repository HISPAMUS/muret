import {Part} from '../entities/part';

/**
 * This complex structure has been used in orderEntities to avoid too many server API calls
 */
export interface PartUse {
  id?: number;
  partName?: string;
  partId: number;
  imageId: number;
  ordering?: number;
}

/**
 * It contains the places where every part is used, either images, pagesWithRegions, regions or individual symbols.
 * In the case of images we only record the image id numbers.
 * For pagesWithRegions, regions, and symbols the PartUse symbol contain information about their parent image
 *
 */
export interface PartUsedIn {
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

/**
 * It contains the information of every use of all parts
 */
export interface UsesOfAllParts {
  uses: PartUsedIn[];
}

export function findPartsUsed(usesOfParts: UsesOfAllParts, imageID: number): Array<string> {
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

