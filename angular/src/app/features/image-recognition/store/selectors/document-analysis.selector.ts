import {createFeatureSelector, createSelector} from '@ngrx/store';
import {DocumentAnalysisState} from '../state/document-analysis.state';

export const documentAnalysisState = createFeatureSelector<DocumentAnalysisState>('document-analysis');


export const selectDocumentAnalysisRegionTypes = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.regionTypes
);


// revisado hasta aquí
export const selectImageWidth = createSelector(
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
)


