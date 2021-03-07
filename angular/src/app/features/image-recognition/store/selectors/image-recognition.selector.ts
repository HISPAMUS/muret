import {createFeatureSelector, createSelector} from '@ngrx/store';
import {ImageRecognitionState} from "../state/image-recognition.state";


export const selectImageRecognitionState = createFeatureSelector<ImageRecognitionState>('imageRecognition');

export const selectImageRecognitionImageOverview = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) => state.imageOverview
);

/**
 * The pages contain up to symbol information
 */
export const selectImageRecognitionPagesRegionsSymbols = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) => state.pagesRegionsSymbols
);

export const selectImageRecognitionRegionTypes = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) => state.regionTypes
);


