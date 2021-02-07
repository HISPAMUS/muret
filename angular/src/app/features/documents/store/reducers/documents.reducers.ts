import {initialDocumentsState, DocumentsState} from '../state/documents.state';
import {DocumentsActions, DocumentsActionTypes} from '../actions/documents.actions';

// recall the inmutability of state -- see as example DocumentsActionTypes.DocumentsCreateSubcollectionSuccess
// https://medium.com/swlh/few-ways-to-update-a-state-array-in-redux-reducer-f2621ae8061
export function documentsReducers(state = initialDocumentsState, action: DocumentsActions): DocumentsState {
  switch (action.type) {
    case DocumentsActionTypes.DocumentsResetDocumentsServerError:
      return {
        ...state,
        apiRestServerError: null
      };
    case DocumentsActionTypes.DocumentsServerError:
      return {
        ...state,
        apiRestServerError: action.serverError
      };
    case DocumentsActionTypes.DocumentsGetCollectionSuccess: {
      return {
        ...state,
        collection: action.collection,
        apiRestServerError: null
      };
    }
    case DocumentsActionTypes.DocumentsCreateSubcollectionSuccess: {
      return { // returning a copy of original state
        ...state, //copying the original state
        collection: {
          ... state.collection,
          subcollections: [...state.collection.subcollections, action.collection]
        } //new todos array
      };
    }
    case DocumentsActionTypes.DocumentsDeleteSubcollectionSuccess: {
      return { // returning a copy of original state
        ...state, //copying the original state
        collection: {
          ... state.collection,
          subcollections: state.collection.subcollections.filter(subcollection => subcollection.id !== action.deletedSubcollectionID)
        } //new todos array
      };
/*
      const newState = {...state,
        apiRestServerError: null};
      newState.collection.subcollections =
        newState.collection.subcollections.filter(subcollection => subcollection.id !== action.deletedSubcollectionID);
      return newState;*/
    }
    case DocumentsActionTypes.DocumentsMoveDocumentsToSubcollectionSuccess:
    case DocumentsActionTypes.DocumentsMoveDocumentsToNewSubcollectionSuccess: {
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
