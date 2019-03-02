import { ActionReducerMap } from '@ngrx/store';

import {trainingSetExportersReducer} from './training-set-exporter.reducer';
import {ExportState} from '../state/export.state';

export const exportReducers: ActionReducerMap<ExportState, any> = {
  trainingSetExporters: trainingSetExportersReducer
};
