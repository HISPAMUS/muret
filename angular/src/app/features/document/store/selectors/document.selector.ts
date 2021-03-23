import {createFeatureSelector, createSelector} from '@ngrx/store';
import {DocumentState} from '../state/document.state';

export const documentState = createFeatureSelector<DocumentState>('document');


export const selectDocumentOverview = createSelector(
  documentState,
  (state: DocumentState) => state.documentOverview
);


export const selectDocumentSection = createSelector(
  documentState,
  (state: DocumentState) => state.section
);

export const selectDocumentPartsInImages = createSelector(
  documentState,
  (state: DocumentState) => state.partsInImages
);

export const selectDocumentExportedFile = createSelector(
  documentState,
  (state: DocumentState) => state.exportedMEIFile
);

export const selectDocumentExportedMPEditorFile = createSelector(
  documentState,
  (state: DocumentState) => state.exportedMPEditorFile
);


export const selectDocumentMEI = createSelector(
  documentState,
  (state: DocumentState) => state.mei
);

/*
export const selectDocumentSelectedImagesForExport = createSelector(
  documentState,
  (state: DocumentState) => state.selectedImagesIDForExport
);
*/

// revisado hasta aquí
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


/*export const selectDocumentAPIRestErrorSelector = createSelector(
  documentState,
  (state: DocumentState) => state.apiRestServerError
)*/
