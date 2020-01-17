import {createFeatureSelector, createSelector} from '@ngrx/store';
import {DocumentState} from '../state/document.state';

export const documentState = createFeatureSelector<DocumentState>('document');

export const selectDocument = createSelector(
  documentState,
  (state: DocumentState) => state.document
);

export const selectImages = createSelector(
  documentState,
  (state: DocumentState) => state.images
);

export const selectDocumentMEI = createSelector(
  documentState,
  (state: DocumentState) => state.mei
);

export const selectDocumentStatistics = createSelector(
  documentState,
  (state: DocumentState) => state.statistics
);

