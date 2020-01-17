import {createFeatureSelector, createSelector} from '@ngrx/store';
import {DocumentsState} from '../state/documents.state';

export const documentsState = createFeatureSelector<DocumentsState>('documents');

export const selectCollection = createSelector(
  documentsState,
  (state: DocumentsState) => state.collection
);

