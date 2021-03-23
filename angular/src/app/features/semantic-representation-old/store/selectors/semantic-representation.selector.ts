import {createFeatureSelector, createSelector} from '@ngrx/store';
import {SemanticRepresentationState} from '../state/semantic-representation.state';

export const semanticRepresentationState = createFeatureSelector<SemanticRepresentationState>('semantic-representation');

export const selectNotation = createSelector(
  semanticRepresentationState,
  (stateSemantic: SemanticRepresentationState) => stateSemantic.notation
);

export const selectTranslationModels = createSelector(
  semanticRepresentationState,
  (stateSemantic: SemanticRepresentationState) => stateSemantic.models
);

export const selectSemanticRepresentationServerError = createSelector(
  semanticRepresentationState,
  (stateSemantic: SemanticRepresentationState) => stateSemantic.apiRestServerError
);


/*TODO export const selectSelectedSymbol = createSelector (
  semanticRepresentationState,
  (state: SemanticRepresentationState) =>
    state.agnosticSymbols == null ? null : state.agnosticSymbols.find(s => s.id === state.selectedSymbolID)
);*/
