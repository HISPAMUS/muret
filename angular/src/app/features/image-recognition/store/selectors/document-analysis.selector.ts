import {createFeatureSelector, createSelector} from '@ngrx/store';
import {ImageRecognitionState} from "../state/image-recognition.state";

export const selectImageRecognitionState = createFeatureSelector<ImageRecognitionState>('imageRecognition');

export const selectDocumentAnalysisRegionTypes = createSelector(
  selectImageRecognitionState,
  (state: ImageRecognitionState) => state.documentAnalysis?state.documentAnalysis.regionTypes:null
);



// revisado hasta aquí
/*export const selectImageWidth = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.imageWidth
);

export const selectImageHeight = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.imageHeight
);

export const selectFileName = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.filename
);

export const selectImagePart = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.imagePart
);

export const selectDocumentType = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.documentType
);


export const selectPages = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.pages
);


export const selectImageURL = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.imageURL
);

export const selectImageDocumentID = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.documentID
);

export const selectDocumentAnalysisClassifierModels = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.documentAnalysisClassifierModels
)

export const selectDocumentAnalysisServerError = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.apiRestServerError
)*/


