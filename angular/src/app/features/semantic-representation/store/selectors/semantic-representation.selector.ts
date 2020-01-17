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