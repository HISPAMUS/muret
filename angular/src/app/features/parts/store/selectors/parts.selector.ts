import {createFeatureSelector, createSelector} from '@ngrx/store';
import {PartsState} from '../state/parts.state';

export const partsState = createFeatureSelector<PartsState>('parts');

export const selectProjectParts = createSelector(
  partsState,
  (state: PartsState) => state.projectParts
);

export const selectImagePart = createSelector(
  partsState,
  (state: PartsState) => state.imagePart
);

export const selectPagePart = createSelector(
  partsState,
  (state: PartsState) => state.pagePart
);

export const selectRegionPart = createSelector(
  partsState,
  (state: PartsState) => state.regionPart
);

export const selectSymbolPart = createSelector(
  partsState,
  (state: PartsState) => state.symbolPart
);

export const selectUsesOfParts = createSelector(
  partsState,
  (state: PartsState) => state.usesOfParts
);
