import {createFeatureSelector, createSelector} from '@ngrx/store';
import {DocumentsState} from '../state/documents.state';

export const documentsState = createFeatureSelector<DocumentsState>('documents');

export const selectCollection = createSelector(
  documentsState,
  (state: DocumentsState) => state.collection
);

export const selectChangedCollectionID = createSelector(
  documentsState,
  (state: DocumentsState) => state.changedCollectionID
);

export const selectDocumentsServerError = createSelector(
  documentsState,
  (state: DocumentsState) => state.apiRestServerError
);
