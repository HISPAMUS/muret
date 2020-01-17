import {Collection} from '../../../../core/model/entities/collection';

export interface DocumentsState {
  collection: Collection;
}

export const initialDocumentsState: DocumentsState = {
  collection: null,
};

export function getInitialState(): DocumentsState {
  return initialDocumentsState;
}
