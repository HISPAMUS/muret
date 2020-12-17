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

export const selectSelectedSymbol = createSelector (
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) =>
    state.agnosticSymbols == null ? null : state.agnosticSymbols.find(s => s.id === state.selectedSymbolID)
);

export const selectClassifiedSymbols = createSelector (
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) => state.classifiedSymbols
);


export const selectAgnosticEnd2EndClassifierModels = createSelector (
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) => state.end2endClassifierModels
);

export const selectAgnosticSymbolClassifierModels = createSelector (
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) => state.symbolClassifierModels
);


export const selectAgnosticSymbolServerError = createSelector (
  agnosticRepresentationState,
  (state: AgnosticRepresentationState) => state.apiRestServerError
);
