import {initialPartsState, PartsState} from '../state/parts.state';
import {PartsActions, PartsActionTypes} from '../actions/parts.actions';
import {PartUse, PartUsedIn, UsesOfAllParts} from '../../../../core/model/restapi/uses-of-all-parts';
import {Part} from '../../../../core/model/entities/part';

// recall the inmutability of state
export function partsReducers(state = initialPartsState, action: PartsActions):
  PartsState {
  switch (action.type) {
    case PartsActionTypes.ResetPartsServerError: {
      return {
        ...state,
        apiRestServerError: null
      };
    }
    case PartsActionTypes.PartsServerError: {
      return {
        ...state,
        apiRestServerError: action.serverError
      };
    }
    /** A new part is created and assigned to an image **/
    case PartsActionTypes.CreateImagePartSuccess: {
      const newState = {...initialPartsState};
      const newPart: Part = {
        id: action.partUse.id,
        name: action.partUse.partName,
        ordering: action.partUse.ordering
      };
      const newUseOfParts: PartUsedIn = {
        images: [action.partUse.imageId],
        pages: [],
        symbols: [],
        regions: [],
        part: newPart
      };
      newState.usesOfParts = {
        uses: [...state.usesOfParts.uses, newUseOfParts]
      };
      return newState;
    }
    /** A new part is created and assigned to a region **/
    case PartsActionTypes.CreateRegionPartSuccess: {
      const newState = {...initialPartsState};
      const newPart: Part = {
        id: action.partUse.id,
        name: action.partUse.partName,
        ordering: action.partUse.ordering
      };
      const regionPartUse: PartUse = {
        id: action.partUse.id,
        imageId: action.partUse.imageId,
        partId: action.partUse.partId,
      };
      const newUseOfParts: PartUsedIn = {
        images: [],
        pages: [],
        symbols: [],
        regions: [regionPartUse],
        part: newPart
      };
      newState.usesOfParts = {
        uses: [...state.usesOfParts.uses, newUseOfParts]
      };
      return newState;
    }
    /** A new part is created but not assigned to any element **/
    case PartsActionTypes.CreatePartSuccess: {
      const newState = {...initialPartsState};
      const newPart: Part = {
        id: action.part.id,
        name: action.part.name,
        ordering: action.part.ordering
      };
      const newUseOfParts: PartUsedIn = {
        images: [],
        pages: [],
        symbols: [],
        regions: [],
        part: newPart
      };
      newState.usesOfParts = {
        uses: [...state.usesOfParts.uses, newUseOfParts]
      };
      return newState;
    }
    /** Rename a part **/
    case PartsActionTypes.RenamePartSuccess: {
      if (action.part != null) { // if no error
        const newState = {... initialPartsState};
        newState.usesOfParts = {
          uses: []
        };
        state.usesOfParts.uses.forEach(uop => {
          const newUop = {...uop};
          if (uop.part.id === action.part.id) {
            newUop.part = action.part;
          }
          newState.usesOfParts.uses.push(newUop);
        });
        return newState;
      } else {
        return state;
      }
    }
    /** Remove a part **/
    case PartsActionTypes.DeletePartSuccess: {
      const newState = {... initialPartsState};
      newState.usesOfParts = {
        uses: state.usesOfParts.uses.filter(partsUses => partsUses.part.id !== action.deletedPartID)
      };
      return newState;
    }
    case PartsActionTypes.GetUsesOfPartsSuccess: {
        return {
          ...state,
          usesOfParts: action.usesOfParts
        };
    }
    /**
     * Link an existing part to an image3
     */
    case PartsActionTypes.LinkPartToImageSuccess: {
      if (action.partUse != null) { // if no error
        const newState = {... initialPartsState};
        newState.usesOfParts = {
          uses: []
        };
        state.usesOfParts.uses.forEach(uop => {
          const newUop = {...uop};
          if (uop.part.id === action.partUse.partId) {
            newUop.images = [...newUop.images, action.partUse.imageId];
          }
          newState.usesOfParts.uses.push(newUop);
        });
        return newState;
      } else {
        return state;
      }
    }
    /** Remove the link from the part **/
    case PartsActionTypes.UnlinkPartToImageSuccess: {
      if (action.partUse != null) { // if no error
        const newState = {... initialPartsState};
        newState.usesOfParts = {
          uses: []
        };
        state.usesOfParts.uses.forEach(uop => {
          const newUop = {...uop};
          if (uop.part.id === action.partUse.partId) {
            newUop.images = newUop.images.filter(value => value !== action.partUse.imageId);
          }
          newState.usesOfParts.uses.push(newUop);
        });
        return newState;
      } else {
        return state;
      }
    }
    /** Link to a given page **/
    case PartsActionTypes.LinkPartToPageSuccess: {
      if (action.partUse != null) { // if no error
        const newState = {... initialPartsState};
        newState.usesOfParts = {
          uses: []
        };
        const pagePartUse: PartUse = {
          id: action.partUse.id,
          imageId: action.partUse.imageId,
          partId: action.partUse.partId,
        };
        state.usesOfParts.uses.forEach(uop => {
          const newUop = {...uop};
          if (uop.part.id === action.partUse.partId) {
            newUop.pages = [...newUop.pages, pagePartUse];
          }
          newState.usesOfParts.uses.push(newUop);
        });
        return newState;
      } else {
        return state;
      }
    }
    /** Remove the link to the part use **/
    case PartsActionTypes.UnlinkPartToPageSuccess: {
      if (action.partUse != null) { // if no error
        const newState = {... initialPartsState};
        newState.usesOfParts = {
          uses: []
        };
        const pagePartUse: PartUse = {
          id: action.partUse.id,
          imageId: action.partUse.imageId,
          partId: action.partUse.partId,
        };
        state.usesOfParts.uses.forEach(uop => {
          const newUop = {...uop};
          if (uop.part.id === action.partUse.partId) {
            newUop.pages = newUop.pages.filter(value => value.id !== action.partUse.id);
          }
          newState.usesOfParts.uses.push(newUop);
        });
        return newState;
      } else {
        return state;
      }
    }
    /** Link an existing part use to a region **/
    case PartsActionTypes.LinkPartToRegionSuccess: {
      if (action.partUse != null) { // if no error
        const newState = {... initialPartsState};
        newState.usesOfParts = {
          uses: []
        };
        const pagePartUse: PartUse = {
          id: action.partUse.id,
          imageId: action.partUse.imageId,
          partId: action.partUse.partId,
        };
        state.usesOfParts.uses.forEach(uop => {
          const newUop = {...uop};
          if (uop.part.id === action.partUse.partId) {
            newUop.regions = [...newUop.pages, pagePartUse];
          }
          newState.usesOfParts.uses.push(newUop);
        });
        return newState;
      } else {
        return state;
      }
    }
    /** Remove the link to the region **/
    case PartsActionTypes.UnlinkPartToRegionSuccess: {
      if (action.partUse != null) { // if no error
        const newState = {... initialPartsState};
        newState.usesOfParts = {
          uses: []
        };
        const pagePartUse: PartUse = {
          id: action.partUse.id,
          imageId: action.partUse.imageId,
          partId: action.partUse.partId,
        };
        state.usesOfParts.uses.forEach(uop => {
          const newUop = {...uop};
          if (uop.part.id === action.partUse.partId) {
            newUop.regions = newUop.regions.filter(value => value.id !== action.partUse.id);
          }
          newState.usesOfParts.uses.push(newUop);
        });
        return newState;
      } else {
        return state;
      }
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
