import {Collection} from '../../../../core/model/entities/collection';

export interface DocumentsState {
  collection: Collection;
  changedCollectionID: number;
}

export const initialDocumentsState: DocumentsState = {
  collection: null,
  changedCollectionID: null
};

export function getInitialState(): DocumentsState {
  return initialDocumentsState;
}
