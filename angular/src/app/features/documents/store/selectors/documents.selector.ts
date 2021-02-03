import {createFeatureSelector, createSelector} from '@ngrx/store';
import {DocumentsState} from '../state/documents.state';

export const documentsState = createFeatureSelector<DocumentsState>('documents');

export const selectDocumentsCollection = createSelector(
  documentsState,
  (state: DocumentsState) => state.collection
);

export const selectDocumentsChangedCollectionID = createSelector(
  documentsState,
  (state: DocumentsState) => state.changedCollectionID
);

export const selectDocumentsServerError = createSelector(
  documentsState,
  (state: DocumentsState) => state.apiRestServerError
);
