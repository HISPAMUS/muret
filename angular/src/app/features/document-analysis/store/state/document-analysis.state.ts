import {RegionType} from '../../../../core/model/entities/region-type';
import {Page} from '../../../../core/model/entities/page';
import {Part} from '../../../../core/model/entities/part';

export interface DocumentType {
  manuscriptType?: 'eHandwritten' | 'ePrinted';
  notationType?: 'eMensural' | 'eModern';
}

export interface DocumentAnalysisState {
  regionTypes: RegionType[];
  imageURL: string;
  filename: string;
  imageWidth: number;
  imageHeight: number;
  imagePart: Part;
  projectParts: Part[];
  pages: Page[];
  documentType: DocumentType;
//  selectedRegion: Region;
//  selectedPage: Page;
}

export const initialDocumentAnalysisState: DocumentAnalysisState = {
  regionTypes: null,
  imageURL: null,
  filename: null,
  imageWidth: 0,
  imageHeight: 0,
  imagePart: null,
  projectParts: null,
  pages: null,
  documentType: null
  // selectedRegion: null,
  // selectedPage: null
};

export function getInitialState(): DocumentAnalysisState {
  return initialDocumentAnalysisState;
}
