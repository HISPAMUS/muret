import {initialTrainingSetExportersState, TrainingSetExportersState} from '../state/training-set-exporters-state';
import {ExportActions, ExportActionTypes} from '../actions/export.actions';

export function trainingSetExportersReducer(state = initialTrainingSetExportersState, action: ExportActions):
  TrainingSetExportersState {
  switch (action.type) {
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
    default:
      return state;
  }
}
