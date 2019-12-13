import {initialSemanticRepresentationState, PartsState} from '../state/parts.state';
import {PartsActions, PartsActionTypes} from '../actions/parts.actions';
import {PartUses} from '../../../../core/model/restapi/uses-of-parts';

export function partsReducers(state = initialSemanticRepresentationState, action: PartsActions):
  PartsState {
  switch (action.type) {
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
    /*case PartsActionTypes.GetPartNamesUsedByImageSuccess: {
      return {
        ...state,
        partNamesUsedInImage: action.parts
      };
    }*/
    default: {
      return state;
    }
  }
}
