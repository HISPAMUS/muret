import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {AlignmentPreview} from '../../../../core/model/restapi/alignment-preview';
import {DocumentExport} from '../../../../core/model/restapi/document-export';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface DocumentState {
  document: Document;
  images: Image[];
  statistics: DocumentStatistics;
  alignmentPreview: AlignmentPreview;
  exportedFile: DocumentExport;
  mei: string;
  apiRestServerError: APIRestServerError;
}

export const initialDocumentState: DocumentState = {
  document: null,
  images: null,
  statistics: null,
  alignmentPreview: null,
  exportedFile: null,
  mei: null,
  apiRestServerError: null
};

export function getInitialState(): DocumentState {
  return initialDocumentState;
}
