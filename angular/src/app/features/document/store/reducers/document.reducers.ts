import {DocumentActions, DocumentActionTypes} from '../actions/document.actions';
import {DocumentState, initialDocumentState} from '../state/document.state';
import {DocumentExportType} from '../../../../core/model/restapi/document-export';

export function documentReducers(state = initialDocumentState, action: DocumentActions): DocumentState {
  switch (action.type) {
    case DocumentActionTypes.GetDocumentSuccess: {
      return {
        ...state,
        document: action.document
      };
    }
    case DocumentActionTypes.GetImagesSuccess: {
      return {
        ...state,
        images: action.images
      };
    }
    case DocumentActionTypes.ExportMusicXML:
    case DocumentActionTypes.ExportMensurstrich:
    case DocumentActionTypes.ExportMEI: {
      return {
        ...state,
        exportedFile: null,
        mei: null
      };
    }
    case DocumentActionTypes.ExportMEIPartsFacsimileSuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.mei_parts_facsimile,
          file: action.mei != null ? new Blob([action.mei], {type: 'text/plain'}) : null,
          fileExtension: 'mei',
          error: action.mei == null
        }
      };
    }
    case DocumentActionTypes.ExportMEISuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.mei_score,
          file: action.mei != null ? new Blob([action.mei], {type: 'text/plain'}) : null,
          fileExtension: 'mei',
          error: action.mei == null,
        },
        mei: action.mei
      };
    }
    case DocumentActionTypes.ExportMusicXMLSuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.musicxml,
          file: action.payload != null ? new Blob([action.payload], {type: 'application/x-gzip'}) : null,
          fileExtension: 'tgz',
          error: action.payload === null,
        }
      };
    }
    case DocumentActionTypes.ExportMensurstrichSuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.mensurstrich_svg,
          file: action.payload != null ? new Blob([action.payload], {type: 'application/x-gzip'}) : null,
          fileExtension: 'tgz',
          error: action.payload === null,
        }
      };
    }
    case DocumentActionTypes.GetDocumentStatisticsSuccess: {
      return {
        ...state,
        statistics: action.documentStatistics
      };
    }
    /*case DocumentActionTypes.PreflightCheckSuccess: {
      return {
        ...state,
        preflightCheckResults: action.preflightCheckResult
      };
    }*/
    case DocumentActionTypes.GetAlignmentPreviewSuccess: {
      return {
        ...state,
        alignmentPreview: action.alignmentPreview
      };
    }
    default: {
      return state;
    }
  }
}
