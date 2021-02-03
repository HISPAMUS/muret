import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {LastDocumentExtract} from "../../model/last-document-extract";

export interface HomeState {
  lastDocuments: LastDocumentExtract[];
  apiRestServerError: APIRestServerError;
}

export const initialHomeState: HomeState = {
  lastDocuments: null,
  apiRestServerError: null
};
