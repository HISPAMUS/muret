import {DocumentActions, DocumentActionTypes} from '../actions/document.actions';
import {DocumentState, initialDocumentState} from '../state/document.state';
import {DocumentExportType} from '../../../../core/model/restapi/document-export';

export function documentReducers(state = initialDocumentState, action: DocumentActions): DocumentState {
  switch (action.type) {
    case DocumentActionTypes.DocumentGetOverviewSuccess: {
      return {
        ...state,
        documentOverview: action.documentOverview,
        apiRestServerError: null
      };
    }

    case DocumentActionTypes.DocumentServerError: {
      return {
        ...state,
        apiRestServerError: action.error
      };
    }

    // revisado hasta aquí
    case DocumentActionTypes.ResetDocumentServerError: {
      return {
        ...state,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentGetDocumentSuccess: {
      return {
        ...state,
        document: action.document,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentGetImagesSuccess: {
      return {
        ...state,
        images: action.images,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentExportMusicXML:
    case DocumentActionTypes.DocumentExportMensurstrich:
    case DocumentActionTypes.DocumentExportMEI: {
      return {
        ...state,
        exportedFile: null,
        mei: null,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentExportMEIPartsFacsimileSuccess: {
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
    case DocumentActionTypes.DocumentExportMEISuccess: {
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
    case DocumentActionTypes.DocumentExportMusicXMLSuccess: {
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
    case DocumentActionTypes.DocumentExportMensurstrichSuccess: {
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
    case DocumentActionTypes.DocumentGetDocumentStatisticsSuccess: {
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
    case DocumentActionTypes.DocumentGetAlignmentPreviewSuccess: {
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
