import {createFeatureSelector, createSelector} from '@ngrx/store';
import {SemanticRepresentationState} from '../state/semantic-representation.state';

export const semanticRepresentationState = createFeatureSelector<SemanticRepresentationState>('semantic-representation');

export const selectNotation = createSelector(
  (state: SemanticRepresentationState)  => state,
  (state: SemanticRepresentationState) => state.notation
);
