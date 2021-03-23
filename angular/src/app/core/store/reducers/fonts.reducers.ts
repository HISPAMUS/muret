import {FontsActions, FontsActionTypes} from "../actions/fonts.actions";
import {FontsState, initialFontsState} from "../state/fonts.state";

// recall the inmutability of state
export function fontsReducers(state = initialFontsState, action: FontsActions):
  FontsState {
  switch (action.type) {
    /*case FontsActionTypes.FontsServerError:
      return {
        ...state,
        apiRestServerError: action.serverError
      };*/
    case FontsActionTypes.GetSVGSetSucccess: {
      const newState = {...state, apiRestServerError: null};
      newState.svgAgnosticOrSemanticSymbolsSet = action.svgSet;
      return newState;
    }
    default: {
      return state;
    }
  }
}


