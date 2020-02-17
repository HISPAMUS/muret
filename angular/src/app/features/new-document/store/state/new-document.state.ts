import {Document} from '../../../../core/model/entities/document';
import {Collection} from '../../../../core/model/entities/collection';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface NewDocumentState {
  document: Document;
  collections: Collection[];
  apiRestServerError: APIRestServerError;
}

export const initialNewDocumentState: NewDocumentState = {
  document: null,
  collections: null,
  apiRestServerError: null
};

export function getInitialState(): NewDocumentState {
  return initialNewDocumentState;
}
