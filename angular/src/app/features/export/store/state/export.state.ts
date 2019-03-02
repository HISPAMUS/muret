import {RouterReducerState} from '@ngrx/router-store';
import {initialTrainingSetExportersState, TrainingSetExportersState} from './training-set-exporters-state';

export interface ExportState {
  trainingSetExporters: TrainingSetExportersState;
}

export const initialExportState: ExportState = {
  trainingSetExporters: initialTrainingSetExportersState
};

export function getInitialState(): ExportState {
  return initialExportState;
}
