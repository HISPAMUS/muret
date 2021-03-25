import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {AlignmentPreview} from '../../../../core/model/restapi/alignment-preview';
import {DocumentExport} from '../../../../core/model/restapi/document-export';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {Section} from "../../../../core/model/entities/section";
import {PartsInImage} from "../../../../core/model/restapi/parts-in-image";
import {NumberArray} from "../../../../core/model/restapi/number-array";

export interface DocumentState {
  documentOverview: Document, // it contains images unassigned to sections), parts, sections (including images)
  section: Section, // used just in reorder images
  partsInImages: PartsInImage[];
  exportedMEIFile?: DocumentExport;
  exportedMPEditorFile?: DocumentExport;
  mei?: string;
  selectedImagesIDForExport?: NumberArray;
  statistics?: DocumentStatistics;

  //apiRestServerError: APIRestServerError;


  // revisado hasta aquí
  document?: Document;
  images?: Image[];
  alignmentPreview?: AlignmentPreview;

}

export const initialDocumentState: DocumentState = {
  documentOverview: null,
  section: null,
  partsInImages: null,
  exportedMEIFile: null,
  exportedMPEditorFile: null,
  mei: null,
  selectedImagesIDForExport: null,
  statistics: null,

  //apiRestServerError: null,
  // revisado hasta aquí
  document: null,
  images: null,
  alignmentPreview: null,

};

export function getInitialState(): DocumentState {
  return initialDocumentState;
}
