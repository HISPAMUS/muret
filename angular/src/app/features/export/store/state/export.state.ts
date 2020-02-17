import {RouterReducerState} from '@ngrx/router-store';
import {initialTrainingSetExportersState, TrainingSetExportersState} from './training-set-exporters-state';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface ExportState {
  trainingSetExporters: TrainingSetExportersState;
}

export const initialExportState: ExportState = {
  trainingSetExporters: initialTrainingSetExportersState,
};

export function getInitialState(): ExportState {
  return initialExportState;
}
