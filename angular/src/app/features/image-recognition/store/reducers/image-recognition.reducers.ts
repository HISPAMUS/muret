// recall the inmutability of state
import {ImageRecognitionActions, ImageRecognitionActionTypes} from "../actions/image-recognition.actions";
import {klona} from "klona";
import {ImageRecognitionState, initialImageRecognitionState} from "../state/image-recognition.state";
import {createServerError} from "../../../../core/model/restapi/apirest-server-error";

/**
 * We use the same effects, actions and reducers for overview and parts because they share the state
 */
export function imageRecognitionReducers(state = initialImageRecognitionState, action: ImageRecognitionActions): ImageRecognitionState {
  switch (action.type) {
    case ImageRecognitionActionTypes.ImageRecognitionServerError: {
      return {
        ...state,
        apiRestServerError: action.serverError
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionGetImageOverviewSuccess: {
      return {
        ...state,
        imageOverview: action.imageOverview,
        apiRestServerError: null
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionGetPagesRegionsSymbolsSuccess: {
      return {
        ...state,
        pagesRegionsSymbols: action.pagesRegionsSymbols,
        apiRestServerError: null
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionPutCommentsSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        apiRestServerError: null
      };
      newState.imageOverview.comments = action.comments;
      return newState;
    }

    case ImageRecognitionActionTypes.ImageRecognitionChangeStatusSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        apiRestServerError: null
      };
      newState.imageOverview.imageRecognitionProgressStatuses = action.statuses;
      return newState;
    }


    /// ----- Parts ----
    case ImageRecognitionActionTypes.ImageRecognitionLinkPartSuccess:
    case ImageRecognitionActionTypes.ImageRecognitionUnlinkPartSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: action.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        apiRestServerError: null
      };
      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionLinkNewPartSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: action.pagesRegionsSymbolsAndNewPart.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        apiRestServerError: null
      };
      newState.imageOverview.documentParts.push(action.pagesRegionsSymbolsAndNewPart.part);
      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionLinkImageToPartSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        apiRestServerError: null
      };
      newState.imageOverview.imagePart = action.part;
      return newState;
      break;
    }
    case ImageRecognitionActionTypes.ImageRecognitionLinkImageToNewPartSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        apiRestServerError: null
      };
      newState.imageOverview.imagePart = action.part;
      newState.imageOverview.documentParts.push(action.part);
      return newState;
      break;
    }
    case ImageRecognitionActionTypes.ImageRecognitionUnlinkImageFromPartSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        apiRestServerError: null
      };
      newState.imageOverview.imagePart = null;
      return newState;
    }

    /// ------ Document analysis
    case ImageRecognitionActionTypes.ImageRecognitionGetRegionTypesSuccess: {
      return {
        ...state,
        regionTypes: action.regionTypes,
        apiRestServerError: null
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionChangeRegionsTypeSuccess: {
      const regionType = state.regionTypes.find(regionType => regionType.id === action.changeRegionTypes.regionTypeID);
      if (!regionType) {
        return {
          ...state,
          apiRestServerError: createServerError('Region types change', 'Cannot find region type with id ' + action.changeRegionTypes.regionTypeID)
        };
      }

      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: klona(state.pagesRegionsSymbols),
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        apiRestServerError: null
      };
      const changedRegionTypesSet = new Set<number>();
      action.changeRegionTypes.regionIDs.values.forEach(id => changedRegionTypesSet.add(id));
      newState.pagesRegionsSymbols.forEach(page => {
        page.regions.forEach(region => {
          if (changedRegionTypesSet.has(region.id)) {
            region.regionType = regionType;
          }
        });
      });
      return newState;
    }

    default:
      return state;
  }
}
