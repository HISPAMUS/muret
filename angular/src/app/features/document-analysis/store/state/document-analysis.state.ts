import {RegionType} from '../../../../core/model/entities/region-type';
import {Page} from '../../../../core/model/entities/page';

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
  pages: null,
  documentType: null
  // selectedRegion: null,
  // selectedPage: null
};

export function getInitialState(): DocumentAnalysisState {
  return initialDocumentAnalysisState;
}
