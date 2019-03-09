import {createFeatureSelector, createSelector} from '@ngrx/store';
import {AgnosticRepresentationState} from '../state/agnostic-representation.state';

export const agnosticRepresentationState = createFeatureSelector<AgnosticRepresentationState>('agnostic-representation');

export const selectSelectedRegion = createSelector(
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) => state.selectedRegion
);


export const selectSVGAgnosticSymbolSet = createSelector(
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) => state.svgAgnosticSymbolsSet
);
