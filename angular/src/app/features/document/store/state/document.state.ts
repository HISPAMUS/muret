import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {AlignmentPreview} from '../../../../core/model/restapi/alignment-preview';
import {DocumentExport} from '../../../../core/model/restapi/document-export';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface DocumentState {
  documentOverview: Document, // it contains images unassigned to sections), parts, sections (including images)

  apiRestServerError: APIRestServerError;

  // revisado hasta aquí
  document: Document;
  images: Image[];
  statistics: DocumentStatistics;
  alignmentPreview: AlignmentPreview;
  exportedFile: DocumentExport;
  mei: string;

}

export const initialDocumentState: DocumentState = {
  documentOverview: null,

  apiRestServerError: null,
  // revisado hasta aquí
  document: null,
  images: null,
  statistics: null,
  alignmentPreview: null,
  exportedFile: null,
  mei: null,

};

export function getInitialState(): DocumentState {
  return initialDocumentState;
}
