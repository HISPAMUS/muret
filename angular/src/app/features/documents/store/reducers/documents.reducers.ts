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
    case DocumentsActionTypes.CreateSubcollectionSuccess: {
      const newState = {...state};
      newState.collection.subcollections = [...newState.collection.subcollections, action.collection];
      return newState;
    }
    case DocumentsActionTypes.DeleteSubcollectionSuccess: {
      const newState = {...state};
      newState.collection.subcollections =
        newState.collection.subcollections.filter(subcollection => subcollection.id !== action.deletedSubcollectionID);
      return newState;
    }
    default: {
      return state;
    }
  }
}
