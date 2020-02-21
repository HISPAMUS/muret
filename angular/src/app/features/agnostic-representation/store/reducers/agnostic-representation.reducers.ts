import {AgnosticRepresentationActions, AgnosticRepresentationActionTypes} from '../actions/agnostic-representation.actions';
import {AgnosticRepresentationState, initialAgnosticRepresentationState} from '../state/agnostic-representation.state';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';

export function agnosticRepresentationReducers(state = initialAgnosticRepresentationState, action: AgnosticRepresentationActions):
  AgnosticRepresentationState {
  switch (action.type) {
    case AgnosticRepresentationActionTypes.ResetAgnosticRepresentationServerError:
      return {
        ...state,
        apiRestServerError: null
      };
    case AgnosticRepresentationActionTypes.AgnosticRepresentationServerError:
      return {
        ...state,
        apiRestServerError: action.serverError
      };
    case AgnosticRepresentationActionTypes.InitRegion: {
      return initialAgnosticRepresentationState;
    }
    case AgnosticRepresentationActionTypes.GetRegion: {
      return {
        apiRestServerError: null,
        ...state // reset values (when loading it)
      };
    }
    case AgnosticRepresentationActionTypes.GetRegionSuccess: {
      const newState = {...state, apiRestServerError: null};
      newState.selectedRegion = action.region;
      newState.agnosticSymbols = action.region.symbols;
      return newState;
    }
    case AgnosticRepresentationActionTypes.GetSVGSetSucccess: {
      const newState = {...state, apiRestServerError: null};
      newState.svgAgnosticSymbolsSet = action.svgSet;
      return newState;
    }
    case AgnosticRepresentationActionTypes.SelectSymbol: {
      const newState = {...state, apiRestServerError: null};
      newState.selectedSymbolID = action.agnosticSymbolID;
      newState.classifiedSymbols = null;
      return newState;
    }
    case AgnosticRepresentationActionTypes.DeselectSymbol: {
      const newState = {...state, apiRestServerError: null};
      newState.selectedSymbolID = null;
      return newState;
    }
    case AgnosticRepresentationActionTypes.ChangeSymbolSuccess: {
      const newState = {...state, apiRestServerError: null};
      if (action.agnosticSymbol != null) { // if no error
        const symbolsWithoutChangedOne: AgnosticSymbol[] =
          state.agnosticSymbols.filter(symbol => symbol.id !== action.agnosticSymbol.id);
        newState.agnosticSymbols = [...symbolsWithoutChangedOne, action.agnosticSymbol];
        newState.selectedRegion.symbols = newState.agnosticSymbols; // it is the same object
      }
      return newState;
    }
   case AgnosticRepresentationActionTypes.CreateSymbolSuccess: {
      const newState = {...state, apiRestServerError: null};
      newState.selectedRegion.symbols = newState.agnosticSymbols; // same object
      if (action.symbolCreationResult) {
        if (newState.agnosticSymbols) {
          newState.agnosticSymbols = [...newState.agnosticSymbols, action.symbolCreationResult.agnosticSymbol];
        } else {
          newState.agnosticSymbols = [action.symbolCreationResult.agnosticSymbol];
        }

        newState.selectedSymbolID = action.symbolCreationResult.agnosticSymbol.id;
        newState.classifiedSymbols = action.symbolCreationResult.classifiedSymbols;
      } else {
        newState.agnosticSymbols = [...newState.agnosticSymbols, null];
        newState.selectedSymbolID = null;
        newState.classifiedSymbols = null;
      }
      return newState;
    }
    /*case AgnosticRepresentationActionTypes.ClassifySymbolSuccess: {
      const newState = {...state};
      newState.classifiedSymbols = [...action.classifiedSymbols];
      return newState;
    }*/
    case AgnosticRepresentationActionTypes.DeleteSymbolSuccess: {
      const newState = {...state, apiRestServerError: null};
      newState.selectedSymbolID = null;

      if (action.deletedAgnosticSymbolID) { // if no error has occurred
        // remove the deleted symbol
        newState.agnosticSymbols = newState.agnosticSymbols.filter(symbol => symbol.id !== action.deletedAgnosticSymbolID);
      }
      newState.selectedRegion.symbols = newState.agnosticSymbols; // same object
      return newState;
    }
    case AgnosticRepresentationActionTypes.ClassifyRegionEndToEndSuccess: {
      const newState = {...state, apiRestServerError: null};
      newState.classifiedSymbols = null;
      newState.agnosticSymbols = action.classifiedSymbols;
      newState.selectedSymbolID = null;
      return newState;
    }
    case AgnosticRepresentationActionTypes.ClearRegionSymbolsSuccess: {
      const newState = {...state, apiRestServerError: null};
      newState.classifiedSymbols = null;
      newState.agnosticSymbols = null;
      newState.selectedSymbolID = null;
      return newState;
    }
    case AgnosticRepresentationActionTypes.GetSymbolClassifierModelsSuccess: {
      const newState = {...state, apiRestServerError: null};
      newState.symbolClassifierModels = action.classifierModels;
      return newState;
    }
    case AgnosticRepresentationActionTypes.GetAgnosticEnd2EndClassifierModelsSuccess: {
      const newState = {...state, apiRestServerError: null};
      newState.end2endClassifierModels = action.classifierModels;
      return newState;
    }
    case AgnosticRepresentationActionTypes.ResetSelectedRegion: {
      const newState = {...state, apiRestServerError: null};
      newState.selectedRegion = null;
      return newState;
    }
    default: {
      return state;
    }
  }
}


