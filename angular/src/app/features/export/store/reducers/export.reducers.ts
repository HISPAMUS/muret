import {ExportActions, ExportActionTypes} from '../actions/export.actions';
import {ExportState, initialExportState} from '../state/export.state';

export function exportReducers(state = initialExportState, action: ExportActions):
  ExportState {
  switch (action.type) {
    case ExportActionTypes.ResetExportServerError: {
      return {
        ...state,
        apiRestServerError: null
      };
    }
    case ExportActionTypes.ExportServerError: {
      return {
        ...state,
        apiRestServerError: action.serverError
      };
    }
    case ExportActionTypes.GetTrainingSetExportersSuccess: {
      return {
        ...state,
        trainingSetExporters: action.payload,
        apiRestServerError: null
      };
    }
    case ExportActionTypes.DownloadTrainingSetSuccess: {
      return {
        ...state,
        trainingSetExportedBlob: action.payload,
        apiRestServerError: null
      };
    }
    default:
      return state;
  }
}
