import {createFeatureSelector, createSelector} from '@ngrx/store';
import {NewDocumentState} from '../state/new-document.state';

export const newDocumentState = createFeatureSelector<NewDocumentState>('new-document');

export const selectNewDocument = createSelector(
  newDocumentState,
  (state: NewDocumentState) => state.document
);

export const selectNewDocumentCollections = createSelector(
  newDocumentState,
  (state: NewDocumentState) => state.collections
);

export const selectNewDocumentServerError = createSelector(
  newDocumentState,
  (state: NewDocumentState) => state.apiRestServerError
);
