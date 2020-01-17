import deepcopy from 'ts-deepcopy';
import {SemanticRepresentationActions, SemanticRepresentationActionTypes} from '../actions/semantic-representation.actions';
import {SemanticRepresentationState, initialSemanticRepresentationState} from '../state/semantic-representation.state';

export function semanticRepresentationReducers(state = initialSemanticRepresentationState, action: SemanticRepresentationActions):
  SemanticRepresentationState {
  switch (action.type) {
    case SemanticRepresentationActionTypes.ConvertAgnostic2Semantic: {
      const newState = {...state};
      return newState;
    }
    case SemanticRepresentationActionTypes.ConvertAgnostic2SemanticSuccess: {
      const newState = {...state};
      newState.notation = action.notation;
      return newState;
    }
    case SemanticRepresentationActionTypes.ClearNotation: {
      const newState = {...state};
      newState.notation = null;
      return newState;
    }
    case SemanticRepresentationActionTypes.GetNotationSuccess: {
      const newState = {...state};
      newState.notation = action.notation;
      return newState;
    }
    case SemanticRepresentationActionTypes.SendSemanticEncodingSuccess: {
      const newState = {...state};
      newState.notation = action.notation;
      return newState;
    }
    case SemanticRepresentationActionTypes.GetTranslationModels : {
      return {
        ...state,
        models: null
      }
    }
    case SemanticRepresentationActionTypes.GetTranslationModelsSuccess: {
      return {
        ...state,
        models: action.response
      }
    }
    default: {
      return state;
    }
  }
}
