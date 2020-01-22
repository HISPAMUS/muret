import {initialDocumentsState, DocumentsState} from '../state/documents.state';
import {DocumentsActions, DocumentsActionTypes} from '../actions/documents.actions';
import {DocumentActionTypes} from '../../../document/store/actions/document.actions';

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
    case DocumentsActionTypes.MoveDocumentsToSubcollectionSuccess:
    case DocumentsActionTypes.MoveDocumentsToNewSubcollectionSuccess: {
      return {
        ...state,
        changedCollectionID: action.changedCollectionID
      };
    }
    default: {
      return state;
    }
  }
}
