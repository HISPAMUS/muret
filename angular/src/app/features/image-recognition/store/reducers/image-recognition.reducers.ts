// recall the inmutability of state
import {ImageRecognitionActions, ImageRecognitionActionTypes} from "../actions/image-recognition.actions";
import {ImageRecognitionState, initialImageRecognitionState} from "../state/image-recognition.state";

export function imageRecognitionReducers(state = initialImageRecognitionState, action: ImageRecognitionActions):
  ImageRecognitionState {
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
