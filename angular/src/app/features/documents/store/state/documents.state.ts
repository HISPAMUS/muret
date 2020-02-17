import {Collection} from '../../../../core/model/entities/collection';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface DocumentsState {
  collection: Collection;
  changedCollectionID: number;
  apiRestServerError: APIRestServerError;
}

export const initialDocumentsState: DocumentsState = {
  collection: null,
  changedCollectionID: null,
  apiRestServerError: null
};

export function getInitialState(): DocumentsState {
  return initialDocumentsState;
}
