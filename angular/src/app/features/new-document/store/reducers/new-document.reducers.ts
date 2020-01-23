import {initialNewDocumentState, NewDocumentState} from '../state/new-document.state';
import {NewDocumentActions, NewDocumentActionTypes} from '../actions/new-document.actions';

export function newDocumentReducers(state = initialNewDocumentState, action: NewDocumentActions):
  NewDocumentState {
  switch (action.type) {
    case NewDocumentActionTypes.CreateDocumentSuccess: {
      const result: NewDocumentState =  {
        document: action.document,
        collections: state.collections
      };
      return result;
    }
    case NewDocumentActionTypes.CreateDocumentReset: {
      return {...initialNewDocumentState};
    }
    case NewDocumentActionTypes.GetCollectionsSuccess: {
      const result: NewDocumentState =  {
        document: state.document,
        collections: action.collections
      };
      return result;
    }
    default: {
      return state;
    }
  }
}