import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';

export interface DocumentState {
  document: Document;
  images: Image[];
  mei: string;
  statistics: DocumentStatistics;
}

export const initialDocumentState: DocumentState = {
  document: null,
  images: null,
  mei: null,
  statistics: null
};

export function getInitialState(): DocumentState {
  return initialDocumentState;
}
