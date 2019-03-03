import {createFeatureSelector, createSelector} from '@ngrx/store';
import {DocumentAnalysisState} from '../state/document-analysis.state';

export const documentAnalysisState = createFeatureSelector<DocumentAnalysisState>('document-analysis');

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
  (state: DocumentAnalysisState) => state.filaname
);


export const selectProjectPath = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.projectPath
);


export const selectNotationType = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.notationType
);


export const selectManuscriptType = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.manuscriptType
);


export const selectPages = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.pages
);


export const selectImageURL = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.imageURL
);

export const selectRegionTypes = createSelector(
  documentAnalysisState,
  (state: DocumentAnalysisState) => state.regionTypes
);
