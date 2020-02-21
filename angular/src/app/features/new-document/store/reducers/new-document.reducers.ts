import {initialNewDocumentState, NewDocumentState} from '../state/new-document.state';
import {NewDocumentActions, NewDocumentActionTypes} from '../actions/new-document.actions';

export function newDocumentReducers(state = initialNewDocumentState, action: NewDocumentActions):
  NewDocumentState {
  switch (action.type) {
    case NewDocumentActionTypes.ResetNewDocumentServerError: {
      return {
        ...state,
        apiRestServerError: null
      };
    }
    case NewDocumentActionTypes.NewDocumentServerError: {
      return {
        ...state,
        apiRestServerError: action.serverError
      };
    }
    case NewDocumentActionTypes.CreateDocumentSuccess: {
      const result: NewDocumentState =  {
        document: action.document,
        collections: state.collections,
        apiRestServerError: null,
      };
      return result;
    }
    case NewDocumentActionTypes.CreateDocumentReset: {
      return {...initialNewDocumentState,
        apiRestServerError: null};
    }
    case NewDocumentActionTypes.GetCollectionsSuccess: {
      const result: NewDocumentState =  {
        document: state.document,
        collections: action.collections,
        apiRestServerError: null,
      };
      return result;
    }
    default: {
      return state;
    }
  }
}
