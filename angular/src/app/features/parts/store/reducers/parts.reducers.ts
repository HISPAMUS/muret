import {initialSemanticRepresentationState, PartsState} from '../state/parts.state';
import {PartsActions, PartsActionTypes} from '../actions/parts.actions';

export function partsReducers(state = initialSemanticRepresentationState, action: PartsActions):
  PartsState {
  switch (action.type) {
    case PartsActionTypes.GetImagePartSuccess:
    case PartsActionTypes.CreateImagePartSuccess:
    case PartsActionTypes.UpdateImagePartSuccess: {
      return {
        ...state,
        imagePart: action.part
      };
      break;
    }
    case PartsActionTypes.CreatePagePartSuccess:
    case PartsActionTypes.UpdatePagePartSuccess:
    case PartsActionTypes.GetPagePartSuccess: {
      return {
        ...state,
        pagePart: action.part
      };
      break;
    }
    case PartsActionTypes.CreateRegionPartSuccess:
    case PartsActionTypes.UpdateRegionPartSuccess:
    case PartsActionTypes.GetRegionPartSuccess: {
      return {
        ...state,
        regionPart: action.part
      };
      break;
    }
    case PartsActionTypes.CreateSymbolPartSuccess:
    case PartsActionTypes.UpdateSymbolPartSuccess:
    case PartsActionTypes.GetSymbolPartSuccess: {
      return {
        ...state,
        symbolPart: action.part
      };
      break;
    }
    default: {
      return state;
    }
  }
}
