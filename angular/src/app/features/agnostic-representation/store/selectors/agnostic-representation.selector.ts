import {createFeatureSelector, createSelector} from '@ngrx/store';
import {AgnosticRepresentationState} from '../state/agnostic-representation.state';

export const agnosticRepresentationState = createFeatureSelector<AgnosticRepresentationState>('agnostic-representation');

export const selectSelectedRegion = createSelector(
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) => state.selectedRegion
);

export const selectAgnosticSymbols = createSelector(
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) => state.agnosticSymbols
);

export const selectSVGAgnosticSymbolSet = createSelector(
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) => state.svgAgnosticSymbolsSet
);

export const selectSelectedSymbol = createSelector (
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) =>
    state.agnosticSymbols == null ? null : state.agnosticSymbols.find(s => s.id === state.selectedSymbolID)
);

