import {DocumentActions, DocumentActionTypes} from '../actions/document.actions';
import {DocumentState, initialDocumentState} from '../state/document.state';
import {saveAs} from 'file-saver';

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
    case DocumentActionTypes.ExportMEI: {
      return {
        ...state,
        mei: null
      };
    }
    case DocumentActionTypes.ExportMEISuccess: {
      return {
        ...state,
        mei: action.mei
      };
    }
    case DocumentActionTypes.ExportMEIPartsFacsimileSuccess: {
      const blob = new Blob([action.mei], { type: 'text/plain' });
      saveAs(blob, 'parts_facsimile.mei');
      return {...state};
    }
    case DocumentActionTypes.ExportMensurstrichSuccess: {
      const blob = new Blob([action.payload], { type: 'application/x-gzip' });
      saveAs(blob, 'mensurstrich.tgz');
      return {...state};
    }
    case DocumentActionTypes.ExportMusicXMLSuccess: {
      const blob = new Blob([action.payload], { type: 'application/x-gzip' });
      saveAs(blob, 'musicxml.tgz');
      return {...state};
    }
    case DocumentActionTypes.GetDocumentStatisticsSuccess: {
      return {
        ...state,
        statistics: action.documentStatistics
      };
    }
    case DocumentActionTypes.PreflightCheckSuccess: {
      return {
        ...state,
        preflightCheckResults: action.preflightCheckResult
      };
    }
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
