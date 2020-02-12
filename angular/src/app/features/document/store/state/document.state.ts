import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {PreflightCheckResult} from '../../../../core/model/restapi/preflight-check-result';
import {AlignmentPreview} from '../../../../core/model/restapi/alignment-preview';

export interface DocumentState {
  document: Document;
  images: Image[];
  mei: string;
  statistics: DocumentStatistics;
  preflightCheckResults: PreflightCheckResult;//TODO quitar
  alignmentPreview: AlignmentPreview
}

export const initialDocumentState: DocumentState = {
  document: null,
  images: null,
  mei: null,
  statistics: null,
  preflightCheckResults: null,
  alignmentPreview: null,
};

export function getInitialState(): DocumentState {
  return initialDocumentState;
}
