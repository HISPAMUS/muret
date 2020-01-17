import {initialDocumentsState, DocumentsState} from '../state/documents.state';
import {DocumentsActions, DocumentsActionTypes} from '../actions/documents.actions';

export function documentsReducers(state = initialDocumentsState, action: DocumentsActions): DocumentsState {
  switch (action.type) {
    case DocumentsActionTypes.GetCollectionSuccess: {
      return {
        ...state,
        collection: action.collection
      };
    }
    default: {
      return state;
    }
  }
}
