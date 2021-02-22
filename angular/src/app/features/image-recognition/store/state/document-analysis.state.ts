import {RegionType} from '../../../../core/model/entities/region-type';
import {Page} from '../../../../core/model/entities/page';
import {Part} from '../../../../core/model/entities/part';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface DocumentType {
  manuscriptType?: 'eHandwritten' | 'ePrinted';
  notationType?: 'eMensural' | 'eModern';
}

export interface DocumentAnalysisState {
  regionTypes: RegionType[];




  // revisado hasta aquí
  documentID: number;
  imageURL: string;
  filename: string;
  imageWidth: number;
  imageHeight: number;
  imagePart: Part;
  pages: Page[];
  documentType: DocumentType;
//  selectedRegion: Region;
//  selectedPage: Page;
  documentAnalysisClassifierModels: ClassifierModel[];
  apiRestServerError: APIRestServerError;
}

export const initialDocumentAnalysisState: DocumentAnalysisState = {
  regionTypes: null,


  // revisado hasta aquí
  documentID: null,
  imageURL: null,
  filename: null,
  imageWidth: 0,
  imageHeight: 0,
  imagePart: null,
  pages: null,
  documentType: null,
  documentAnalysisClassifierModels: null,
  apiRestServerError: null
  // selectedRegion: null,
  // selectedPage: null
};

export function getInitialState(): DocumentAnalysisState {
  return initialDocumentAnalysisState;
}
