import {createFeatureSelector, createSelector} from '@ngrx/store';
import {ImageRecognitionState} from "../state/image-recognition.state";

export const imageRecognitionState = createFeatureSelector<ImageRecognitionState>('imageRecognition');

export const selectImageRecognitionImageOverview = createSelector(
  imageRecognitionState,
  (state: ImageRecognitionState) => state.imageOverview
);
