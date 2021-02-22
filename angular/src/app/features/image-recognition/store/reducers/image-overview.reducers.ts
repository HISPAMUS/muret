// recall the inmutability of state
import {ImageRecognitionActions, ImageRecognitionActionTypes} from "../actions/image-recognition.actions";
import {ImageOverviewState, initialImageOverviewState} from "../state/image-overview.state";

export function imageOverviewReducers(state = initialImageOverviewState, action: ImageRecognitionActions): ImageOverviewState {
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
    default:
      return state;
  }
}
