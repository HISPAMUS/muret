import {initialSemanticRepresentationState, PartsState} from '../state/parts.state';
import {PartsActions, PartsActionTypes} from '../actions/parts.actions';

export function partsReducers(state = initialSemanticRepresentationState, action: PartsActions):
  PartsState {
  switch (action.type) {
    case PartsActionTypes.GetImagePartSuccess: {
      const newState = {...state};
      newState.imagePart = action.part;
      break;
    }
    case PartsActionTypes.UpdateImagePartSuccess: {
      const newState = {...state};
      newState.imagePart = action.image.part;
      break;
    }
    case PartsActionTypes.GetPagePartSuccess: {
      const newState = {...state};
      newState.pagePart = action.part;
      break;
    }
    case PartsActionTypes.UpdatePagePartSuccess: {
      const newState = {...state};
      newState.pagePart = action.page.part;
      break;
    }
    case PartsActionTypes.GetPagePartSuccess: {
      const newState = {...state};
      newState.pagePart = action.part;
      break;
    }
    case PartsActionTypes.UpdatePagePartSuccess: {
      const newState = {...state};
      newState.pagePart = action.page.part;
      break;
    }
    case PartsActionTypes.GetSymbolPartSuccess: {
      const newState = {...state};
      newState.symbolPart = action.part;
      break;
    }
    case PartsActionTypes.UpdateSymbolPartSuccess: {
      const newState = {...state};
      newState.symbolPart = action.symbol.part;
      break;
    }
    default: {
      return state;
    }
  }
}
