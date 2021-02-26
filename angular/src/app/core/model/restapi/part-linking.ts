import {PartLinkedTo} from "./part-assigned-to.enum";
import {NumberArray} from "./number-array";

/**
 * Used for all part linking operations
 */
export interface PartLinking {
  imageID: number; // for new part creation to return the image overview data
  partID?: number; // when linking to existing part or returning a new one
  documentID?: number; // when creating new part
  partName?: string; // when creating new part
  partAssignedTo: PartLinkedTo;
  toIDs: NumberArray;
}
