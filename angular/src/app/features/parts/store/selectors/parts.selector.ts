import {createFeatureSelector, createSelector} from '@ngrx/store';
import {PartsState} from '../state/parts.state';

export const partsState = createFeatureSelector<PartsState>('parts');

export const selectUsesOfParts = createSelector(
  partsState,
  (state: PartsState) => state.usesOfParts
);

/*export const selectPartsUsedInImage = createSelector(
  partsState,
  (state: PartsState) => state.partNamesUsedInImage
);*/
