import {initialSemanticRepresentationState, PartsState} from '../state/parts.state';
import {PartsActions, PartsActionTypes} from '../actions/parts.actions';
import {PartUses} from '../../../../core/model/restapi/uses-of-parts';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';

export function partsReducers(state = initialSemanticRepresentationState, action: PartsActions):
  PartsState {
  switch (action.type) {
    case PartsActionTypes.GetProjectPartsSuccess:
    case PartsActionTypes.GetImageProjectPartsSuccess:
      return {
        ...state,
        projectParts: action.parts
      };
      break;
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
    case PartsActionTypes.CreatePartSuccess: {
      const newState = {...state};
      const newUseOfParts: PartUses = {
        part: action.part
      };
      newState.usesOfParts.uses = [...newState.usesOfParts.uses, newUseOfParts];
      return newState;
    }
    case PartsActionTypes.RenamePartSuccess: {
      const newState = {...state};
      if (action.part != null) { // if no error
        newState.usesOfParts.uses.find(usesOfPart => usesOfPart.part.id === action.part.id).part.name = action.part.name;
      }
      return newState;
    }
    case PartsActionTypes.DeletePartSuccess: {
      const newState = {...state};
      newState.usesOfParts.uses = newState.usesOfParts.uses.filter(partsUses => partsUses.part.id !== action.deletedPartID);
      return newState;
    }
    case PartsActionTypes.GetUsesOfPartsSuccess: {
        return {
          ...state,
          usesOfParts: action.usesOfParts
        };
    }
    default: {
      return state;
    }
  }
}
