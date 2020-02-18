import {initialDocumentsState, DocumentsState} from '../state/documents.state';
import {DocumentsActions, DocumentsActionTypes} from '../actions/documents.actions';

export function documentsReducers(state = initialDocumentsState, action: DocumentsActions): DocumentsState {
  switch (action.type) {
    case DocumentsActionTypes.DocumentsServerError:
      return {
        ...state,
        apiRestServerError: action.serverError
      };
    case DocumentsActionTypes.GetCollectionSuccess: {
      return {
        ...state,
        collection: action.collection,
        apiRestServerError: null
      };
    }
    case DocumentsActionTypes.CreateSubcollectionSuccess: {
      const newState = {...state,
        apiRestServerError: null};
      newState.collection.subcollections = [...newState.collection.subcollections, action.collection];
      return newState;
    }
    case DocumentsActionTypes.DeleteSubcollectionSuccess: {
      const newState = {...state,
        apiRestServerError: null};
      newState.collection.subcollections =
        newState.collection.subcollections.filter(subcollection => subcollection.id !== action.deletedSubcollectionID);
      return newState;
    }
    case DocumentsActionTypes.MoveDocumentsToSubcollectionSuccess:
    case DocumentsActionTypes.MoveDocumentsToNewSubcollectionSuccess: {
      return {
        ...state,
        changedCollectionID: action.changedCollectionID,
        apiRestServerError: null
      };
    }
    default: {
      return state;
    }
  }
}
