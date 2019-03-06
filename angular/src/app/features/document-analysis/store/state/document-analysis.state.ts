import {RegionType} from '../../../../core/model/entities/region-type';
import {Page} from '../../../../core/model/entities/page';

export interface DocumentAnalysisState {
  regionTypes: RegionType[];
  imageURL: string;
  filename: string;
  imageWidth: number;
  imageHeight: number;
  pages: Page[];
  manuscriptType: 'eHandwritten' | 'ePrinted' | null;
  notationType: 'eMensural' | 'eModern' | null;
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
  manuscriptType: null,
  notationType: null,
  // selectedRegion: null,
  // selectedPage: null
};

export function getInitialState(): DocumentAnalysisState {
  return initialDocumentAnalysisState;
}
