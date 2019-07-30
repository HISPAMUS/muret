import {createFeatureSelector, createSelector} from '@ngrx/store';
import {PartsState} from '../state/parts.state';

export const partsState = createFeatureSelector<PartsState>('parts');

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
