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
      const newState = {...state};
      const uses = newState.usesOfParts.uses.find(value => value.part.id === action.partID );
      uses.images.push(action.imageID);
      return newState;
    }
    case PartsActionTypes.UnlinkPartToImageSuccess: {
      const newState = {...state};
      const uses = newState.usesOfParts.uses.find(value => value.part.id === action.partID );
      uses.images = uses.images.filter(value => value !== action.imageID);
      return newState;
    }
    case PartsActionTypes.LinkPartToPageSuccess: {
      const newState = {...state};
      const usesOfPart = newState.usesOfParts.uses.find(value => value.part.id === action.partID );
      const partUse: PartUse = {
        id: action.pageID,
        partId: action.partID,
        imageId: action.imageID
      };
      usesOfPart.pages.push(partUse);
      return newState;
    }
    case PartsActionTypes.UnlinkPartToPageSuccess: {
      const newState = {...state};
      const usesOfPart = newState.usesOfParts.uses.find(value => value.part.id === action.partID );
      usesOfPart.pages = usesOfPart.pages.filter(value => value.id !== action.pageID);
      return newState;
    }
    case PartsActionTypes.LinkPartToRegionSuccess: {
      const newState = {...state};
      const usesOfPart = newState.usesOfParts.uses.find(value => value.part.id === action.partID );
      const partUse: PartUse = {
        id: action.regionID,
        partId: action.partID,
        imageId: action.imageID
    };
      usesOfPart.regions.push(partUse);
      return newState;
    }
    case PartsActionTypes.UnlinkPartToRegionSuccess: {
      const newState = {...state};
      const usesOfPart = newState.usesOfParts.uses.find(value => value.part.id === action.partID );
      usesOfPart.regions = usesOfPart.regions.filter(value => value.id !== action.regionID);
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
