import {BoundingBox} from '../entities/bounding-box';

export interface AlignmentPreviewItem {
  /**
   * Absolute value
   */
  time: number;
  type: 'note' | 'rest' | 'fermata' | 'keyChange' | 'timeSignatureChange' | 'barline';
  description: string;
}

export interface AlignmenPreviewTimeSignature extends AlignmentPreviewItem {
  measureDuration: number;
}
export interface AlignmentPreviewItemWithDuration extends AlignmentPreviewItem {
  figure: string; // used to render different colors
  dots: number;
  duration: number;
}

export interface AlignmentPreviewPitch extends AlignmentPreviewItemWithDuration {
  midiPitch: number;
}

export interface AlignmentPreviewStaff {
  id: number; // region ID
  imageID: number; // the image where the region is located
  pageNumber: number; // the number of page (1 for left, 2 for right ...)
  order: number; // the orderEntities number among the staves from top to bottom in the page
  boundingBox: BoundingBox;
  items: AlignmentPreviewItem[];
}

export interface AlignmentPreviewImage {
  id: number;
  filename: string;
}

export interface AlignmentPreviewPart {
  id: number;
  name: string;
  staves: AlignmentPreviewStaff[];
}

export interface AlignmentPreviewDissonance {
  time: number;
  dissonance: number;
}

export interface AlignmentPreviewDissonanceMap {
  map: AlignmentPreviewDissonance[];
}


export interface AlignmentPreviewProblem {
  imageID?: number;
  regionID?: number;
  problem: string;
}

export interface AlignmentPreview {
  parts: AlignmentPreviewPart[];
  images: AlignmentPreviewImage[];
  problems: AlignmentPreviewProblem[];
  dissonanceMap: AlignmentPreviewDissonanceMap;
}
