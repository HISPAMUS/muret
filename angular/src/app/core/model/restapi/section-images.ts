export interface SectionImages {
  newSectionID: number; // send and return
  imageIDS: number[]; // send and return
  previousSectionIDs?: number[]; // just return
}
