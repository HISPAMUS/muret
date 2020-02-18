import {DocumentActions, DocumentActionTypes} from '../actions/document.actions';
import {DocumentState, initialDocumentState} from '../state/document.state';
import {DocumentExportType} from '../../../../core/model/restapi/document-export';

export function documentReducers(state = initialDocumentState, action: DocumentActions): DocumentState {
  switch (action.type) {
    case DocumentActionTypes.DocumentServerError: {
      return {
        ...state,
        apiRestServerError: action.error
      };
    }
    case DocumentActionTypes.GetDocumentSuccess: {
      return {
        ...state,
        document: action.document,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.GetImagesSuccess: {
      return {
        ...state,
        images: action.images,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.ExportMusicXML:
    case DocumentActionTypes.ExportMensurstrich:
    case DocumentActionTypes.ExportMEI: {
      return {
        ...state,
        exportedFile: null,
        mei: null,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.ExportMEIPartsFacsimileSuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.mei_parts_facsimile,
          file: action.mei != null ? new Blob([action.mei], {type: 'text/plain'}) : null,
          fileExtension: 'mei',
        },
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.ExportMEISuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.mei_score,
          file: action.mei != null ? new Blob([action.mei], {type: 'text/plain'}) : null,
          fileExtension: 'mei',
        },
        mei: action.mei,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.ExportMusicXMLSuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.musicxml,
          file: action.payload != null ? new Blob([action.payload], {type: 'application/x-gzip'}) : null,
          fileExtension: 'tgz',
        },
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.ExportMensurstrichSuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.mensurstrich_svg,
          file: action.payload = new Blob([action.payload], {type: 'application/x-gzip'}),
          fileExtension: 'tgz',
        },
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.GetDocumentStatisticsSuccess: {
      return {
        ...state,
        statistics: action.documentStatistics,
        apiRestServerError: null
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
        alignmentPreview: action.alignmentPreview,
        apiRestServerError: null
      };
    }
    default: {
      return state;
    }
  }
}
