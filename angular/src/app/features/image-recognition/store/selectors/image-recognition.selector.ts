import {createFeatureSelector, createSelector} from '@ngrx/store';
import {ImageRecognitionState} from "../state/image-recognition.state";


export const selectImageRecognitionState = createFeatureSelector<ImageRecognitionState>('imageRecognition');

export const selectImageRecognitionImageOverview = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) => state.imageOverview?state.imageOverview.imageOverview:null
);

/**
 * The pages contain up to symbol information
 */
export const selectImageRecognitionImageOverviewPagesRegionsSymbols = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) => state.imageOverview?state.imageOverview.pagesRegionsSymbols:null
);