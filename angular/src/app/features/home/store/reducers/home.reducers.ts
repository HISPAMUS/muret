import {HomeActions, HomeActionTypes} from '../actions/home.actions';
import {HomeState, initialHomeState} from '../state/home.state';
import {LastDocumentExtract} from "../../model/last-document-extract";

// recall the inmutability of state
export function homeReducers(state = initialHomeState, action: HomeActions):
  HomeState {
  switch (action.type) {
    case HomeActionTypes.HomeServerError: {
      return {
        ...state,
        apiRestServerError: action.serverError
      };
    }
    case HomeActionTypes.GetLastDocumentsSuccess: {
      return {
        ...state,
        lastDocuments: action.lastDocuments,
        apiRestServerError: null
      };
    }
    case HomeActionTypes.UpdateLastDocumentsSuccess: {
      const newState = {...state, apiRestServerError: null};
      if (action.lastDocument != null) { // if no error
        const documentsWithoutChangedOne: LastDocumentExtract[] =
          state.lastDocuments.filter(document => document.documentID !== action.lastDocument.documentID);
        newState.lastDocuments = [...documentsWithoutChangedOne, action.lastDocument];
      }
      return newState;
    }
    default:
      return state;
  }
}
