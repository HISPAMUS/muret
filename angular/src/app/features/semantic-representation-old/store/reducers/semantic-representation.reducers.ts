import {SemanticRepresentationActions, SemanticRepresentationActionTypes} from '../actions/semantic-representation.actions';
import {initialSemanticRepresentationState, SemanticRepresentationState} from '../state/semantic-representation.state';

export function semanticRepresentationReducers(state = initialSemanticRepresentationState, action: SemanticRepresentationActions):
  SemanticRepresentationState {
  switch (action.type) {
    case SemanticRepresentationActionTypes.ResetSemanticRepresentationServerError: {
      return {
        ...state,
        apiRestServerError: null
      };
    }
    case SemanticRepresentationActionTypes.SemanticRepresentationServerError: {
      return {
        ...state,
        apiRestServerError: action.serverError
      };
    }
    case SemanticRepresentationActionTypes.ConvertAgnostic2Semantic: {
      const newState = {
        apiRestServerError: null,
        ...state
      };
      return newState;
    }
    case SemanticRepresentationActionTypes.ConvertAgnostic2SemanticSuccess: {
      const newState = {
        apiRestServerError: null,
        ...state
      };
      newState.notation = action.notation;
      return newState;
    }
    case SemanticRepresentationActionTypes.ClearNotation: {
      const newState = {
        apiRestServerError: null,
        ...state
      };
      newState.notation = null;
      return newState;
    }
    case SemanticRepresentationActionTypes.GetNotationSuccess: {
      const newState = {
        apiRestServerError: null,
        ...state
      };
      newState.notation = action.notation;
      return newState;
    }
    case SemanticRepresentationActionTypes.SendSemanticEncodingSuccess: {
      const newState = {
        apiRestServerError: null,
        ...state
      };
      newState.notation = action.notation;
      return newState;
    }
    case SemanticRepresentationActionTypes.GetTranslationModels : {
      return {
        ...state,
        models: null,
        apiRestServerError: null
      };
    }
    case SemanticRepresentationActionTypes.GetTranslationModelsSuccess: {
      return {
        ...state,
        models: action.response,
        apiRestServerError: null
      };
    }
    case SemanticRepresentationActionTypes.SelectSymbol: {
      const newState = {...state, apiRestServerError: null};
      newState.selectedSymbolID = action.semanticSymbolID;
      return newState;
    }
    case SemanticRepresentationActionTypes.DeselectSymbol: {
      const newState = {...state, apiRestServerError: null};
      newState.selectedSymbolID = null;
      return newState;
    }
    case SemanticRepresentationActionTypes.ChangeNotationType: {
      const newState = {
        apiRestServerError: null,
        ...state
      };
      return newState;
    }
    default: {
      return state;
    }
  }
}
