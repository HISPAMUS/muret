import {createFeatureSelector, createSelector} from '@ngrx/store';
import {ExportState} from '../state/export.state';

export const exportState = createFeatureSelector<ExportState>('export');

export const selectTrainingSetExporters = createSelector(
  exportState,
  (state: ExportState) => state.trainingSetExporters
);

export const selectTrainingSetExportersServerError = createSelector(
  exportState,
  (state: ExportState) => state.apiRestServerError
);

export const selectTrainingSetExportedBlob = createSelector(
  exportState,
  (state: ExportState) => state.trainingSetExportedBlob
);
