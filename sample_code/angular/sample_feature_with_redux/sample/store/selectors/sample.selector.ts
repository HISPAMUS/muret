import {createFeatureSelector, createSelector} from '@ngrx/store';
import {SampleState} from '../state/sample.state';

export const sampleState = createFeatureSelector<SampleState>('sample');

export const selectNada = createSelector(
  sampleState,
  (state: SampleState) => state.nada
);
