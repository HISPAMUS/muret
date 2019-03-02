import {initialTrainingSetExportersState, TrainingSetExportersState} from '../state/training-set-exporters-state';
import {ExportActions, ExportActionTypes} from '../actions/export.actions';

export function trainingSetExportersReducer(state = initialTrainingSetExportersState, action: ExportActions):
  TrainingSetExportersState {
  switch (action.type) {
    case ExportActionTypes.GetTrainingSetExportersSuccess: {
      return {
        ...state,
        trainingSetExporters: action.payload
      };
    }
    default:
      return state;
  }
}
