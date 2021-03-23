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
  documentID: number;
  regionTypes: RegionType[];
  imageURL: string;
  filename: string;
  imageWidth: number;
  imageHeight: number;
  imagePart: Part;
  pages: Page[];
  documentType: DocumentType;
//  region: Region;
//  selectedPage: Page;
  documentAnalysisClassifierModels: ClassifierModel[];
  apiRestServerError: APIRestServerError;
}

export const initialDocumentAnalysisState: DocumentAnalysisState = {
  documentID: null,
  regionTypes: null,
  imageURL: null,
  filename: null,
  imageWidth: 0,
  imageHeight: 0,
  imagePart: null,
  pages: null,
  documentType: null,
  documentAnalysisClassifierModels: null,
  apiRestServerError: null
  // region: null,
  // selectedPage: null
};

export function getInitialState(): DocumentAnalysisState {
  return initialDocumentAnalysisState;
}
