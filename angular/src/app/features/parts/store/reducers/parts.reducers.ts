import {initialSemanticRepresentationState, PartsState} from '../state/parts.state';
import {PartsActions, PartsActionTypes} from '../actions/parts.actions';
import {PartUse, PartUses} from '../../../../core/model/restapi/uses-of-parts';

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
    case PartsActionTypes.LinkPartToImageSuccess: {
      const newUsesOfParts = {...state.usesOfParts};
      const uses = newUsesOfParts.uses.find(value => value.part.id === action.partUse.partId );
      uses.images.push(action.partUse.imageId);
      const newState: PartsState = {
        usesOfParts: newUsesOfParts
      };
      return newState;
    }
    case PartsActionTypes.UnlinkPartToImageSuccess: {
      const newUsesOfParts = {...state.usesOfParts};
      const uses = newUsesOfParts.uses.find(value => value.part.id === action.partUse.partId );
      uses.images = uses.images.filter(value => value !== action.partUse.imageId);
      const newState: PartsState = {
        usesOfParts: newUsesOfParts
      };
      return newState;
    }
    case PartsActionTypes.LinkPartToPageSuccess: {
      const newState = {...state};
      const usesOfPart = newState.usesOfParts.uses.find(value => value.part.id === action.partUse.partId );
      const partUse: PartUse = {
        id: action.partUse.id,
        partId: action.partUse.partId,
        imageId: action.partUse.imageId
      };
      usesOfPart.pages.push(partUse);
      return newState;
    }
    case PartsActionTypes.UnlinkPartToPageSuccess: {
      const newState = {...state};
      const usesOfPart = newState.usesOfParts.uses.find(value => value.part.id === action.partUse.partId );
      usesOfPart.pages = usesOfPart.pages.filter(value => value.id !== action.partUse.id);
      return newState;
    }
    case PartsActionTypes.LinkPartToRegionSuccess: {
      const newState = {...state};
      const usesOfPart = newState.usesOfParts.uses.find(value => value.part.id === action.partUse.partId );
      const partUse: PartUse = {
        id: action.partUse.id,
        partId: action.partUse.partId,
        imageId: action.partUse.imageId
    };
      usesOfPart.regions.push(partUse);
      return newState;
    }
    case PartsActionTypes.UnlinkPartToRegionSuccess: {
      const newState = {...state};
      const usesOfPart = newState.usesOfParts.uses.find(value => value.part.id === action.partUse.partId );
      usesOfPart.regions = usesOfPart.regions.filter(value => value.id !== action.partUse.id);
      return newState;
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
