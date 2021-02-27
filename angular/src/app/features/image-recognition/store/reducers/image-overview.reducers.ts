// recall the inmutability of state
import {ImageOverviewActions, ImageOverviewActionTypes} from "../actions/image-overview.actions";
import {ImageOverviewState, initialImageOverviewState} from "../state/image-overview.state";
import {klona} from "klona";

/**
 * We use the same effects, actions and reducers for overview and parts because they share the state
 */
export function imageOverviewReducers(state = initialImageOverviewState, action: ImageOverviewActions): ImageOverviewState {
  switch (action.type) {
    case ImageOverviewActionTypes.ImageRecognitionServerError: {
      return {
        ...state,
        apiRestServerError: action.serverError
      };
    }
    case ImageOverviewActionTypes.ImageRecognitionGetImageOverviewSuccess: {
      return {
        ...state,
        imageOverview: action.imageOverview,
        apiRestServerError: null
      };
    }
    case ImageOverviewActionTypes.ImageRecognitionGetPagesRegionsSymbolsSuccess: {
      return {
        ...state,
        pagesRegionsSymbols: action.pagesRegionsSymbols,
        apiRestServerError: null
      };
    }
    case ImageOverviewActionTypes.ImageRecognitionPutCommentsSuccess: {
      const newState: ImageOverviewState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        apiRestServerError: null
      };
      newState.imageOverview.comments = action.comments;
      return newState;
    }

    /// ----- Parts ----
    case ImageOverviewActionTypes.ImageRecognitionLinkPartSuccess:
    case ImageOverviewActionTypes.ImageRecognitionUnlinkPartSuccess: {
      const newState: ImageOverviewState = {
        pagesRegionsSymbols: action.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        apiRestServerError: null
      };
      return newState;
    }
    case ImageOverviewActionTypes.ImageRecognitionLinkNewPartSuccess: {
      const newState: ImageOverviewState = {
        pagesRegionsSymbols: action.pagesRegionsSymbolsAndNewPart.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        apiRestServerError: null
      };
      newState.imageOverview.documentParts.push(action.pagesRegionsSymbolsAndNewPart.part);
      return newState;
    }
    case ImageOverviewActionTypes.ImageRecognitionLinkImageToPartSuccess: {
      const newState: ImageOverviewState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        apiRestServerError: null
      };
      newState.imageOverview.imagePart = action.part;
      return newState;
      break;
    }
    case ImageOverviewActionTypes.ImageRecognitionLinkImageToNewPartSuccess: {
      const newState: ImageOverviewState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        apiRestServerError: null
      };
      newState.imageOverview.imagePart = action.part;
      newState.imageOverview.documentParts.push(action.part);
      return newState;
      break;
    }
    case ImageOverviewActionTypes.ImageRecognitionUnlinkImageFromPartSuccess: {
      const newState: ImageOverviewState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        apiRestServerError: null
      };
      newState.imageOverview.imagePart = null;
      return newState;
    }
    default:
      return state;
  }
}
