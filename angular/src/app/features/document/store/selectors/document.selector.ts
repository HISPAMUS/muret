import {createFeatureSelector, createSelector} from '@ngrx/store';
import {DocumentState} from '../state/document.state';
import {CoreState} from '../../../../core/store/state/core.state';
import {selectCoreState} from '../../../../core/store/selectors/core.selector';

export const documentState = createFeatureSelector<DocumentState>('document');

export const selectDocument = createSelector(
  documentState,
  (state: DocumentState) => state.document
);

export const selectImages = createSelector(
  documentState,
  (state: DocumentState) => state.images
);

/*export const selectDocumentMEI = createSelector(
  documentState,
  (state: DocumentState) => state.mei
);
*/
export const selectDocumentStatistics = createSelector(
  documentState,
  (state: DocumentState) => state.statistics
);

/*export const selectPreflightCheckResults = createSelector(
  documentState,
  (state: DocumentState) => state.preflightCheckResults
);
*/
export const selectAlignmentPreview = createSelector(
  documentState,
  (state: DocumentState) => state.alignmentPreview
);

export const selectExportedFile = createSelector(
  documentState,
  (state: DocumentState) => state.exportedFile
);

export const selectMEI = createSelector(
  documentState,
  (state: DocumentState) => state.mei
);

export const selectDocumentAPIRestErrorSelector = createSelector(
  documentState,
  (state: DocumentState) => state.apiRestServerError
)
