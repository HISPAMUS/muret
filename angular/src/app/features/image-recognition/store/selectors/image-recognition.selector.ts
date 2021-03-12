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


export const selectImageRecognitionClassifierModels = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) => state.classifierModels
);

export const selectImageRecognitionDocumentAnalysisClassifierModels = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) =>
    state.classifierModels == null?null:state.classifierModels.filter(classifier => classifier.classifier_type == 'eDocumentAnalysis')
);

export const selectImageRecognitionAgnosticSymbolsClassifierModels = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) => state.classifierModels == null?null:state.classifierModels.filter(classifier => classifier.classifier_type == 'eAgnosticSymbols')
);

export const selectImageRecognitionAgnosticEnd2EndClassifierModels = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) => state.classifierModels == null?null:state.classifierModels.filter(classifier => classifier.classifier_type == 'eAgnosticEnd2End')
);

export const selectImageRecognitionSemanticClassifierModels = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) => state.classifierModels == null?null:state.classifierModels.filter(classifier => classifier.classifier_type == 'eSemanticEnd2End' || classifier.classifier_type == 'eAgnostic2SemanticTranslator')
);


export const selectImageRecognitionAnalyzing = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) => state.analyzing
);
