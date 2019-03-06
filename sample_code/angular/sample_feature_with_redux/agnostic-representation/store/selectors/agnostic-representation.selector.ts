import {createFeatureSelector, createSelector} from '@ngrx/store';
import {AgnosticRepresentationState} from '../state/agnostic-representation.state';

export const agnosticRepresentationState = createFeatureSelector<AgnosticRepresentationState>('agnostic-representation');

export const selectNada = createSelector(
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) => state.nada
);
