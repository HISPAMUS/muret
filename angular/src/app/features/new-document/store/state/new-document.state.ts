import {Document} from '../../../../core/model/entities/document';
import {Collection} from '../../../../core/model/entities/collection';

export interface NewDocumentState {
  document: Document;
  collections: Collection[];
}

export const initialNewDocumentState: NewDocumentState = {
  document: null,
  collections: null
};

export function getInitialState(): NewDocumentState {
  return initialNewDocumentState;
}
