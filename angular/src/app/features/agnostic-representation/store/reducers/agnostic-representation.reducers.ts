import deepcopy from 'ts-deepcopy';
import {AgnosticRepresentationActions, AgnosticRepresentationActionTypes} from '../actions/agnostic-representation.actions';
import {AgnosticRepresentationState, initialAgnosticRepresentationState} from '../state/agnostic-representation.state';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';

export function agnosticRepresentationReducers(state = initialAgnosticRepresentationState, action: AgnosticRepresentationActions):
  AgnosticRepresentationState {
  switch (action.type) {
    case AgnosticRepresentationActionTypes.GetRegion: {
      return {
        ...state // reset values
      };
    }
    case AgnosticRepresentationActionTypes.GetRegionSuccess: {
      const newState = {...state};
      newState.selectedRegion = action.region;
      newState.agnosticSymbols = action.region.symbols;
      return newState;
    }
    case AgnosticRepresentationActionTypes.GetSVGSetSucccess: {
      const newState = {...state};
      newState.svgAgnosticSymbolsSet = action.svgSet;
      return newState;
    }
    case AgnosticRepresentationActionTypes.SelectSymbol: {
      const newState = {...state};
      newState.selectedSymbol = action.agnosticSymbol;
      return newState;
    }

    case AgnosticRepresentationActionTypes.ChangeSymbolTypeSuccess: // the same in all cases
    case AgnosticRepresentationActionTypes.ChangeSymbolPositionInStaffSuccess: {
      const newState = {...state};
      if (action.agnosticSymbol != null) { // if no error
        newState.selectedSymbol.positionInStaff = action.agnosticSymbol.positionInStaff;
        newState.selectedSymbol.agnosticSymbolType = action.agnosticSymbol.agnosticSymbolType;

        // TODO - Urgente - que se cline
        /* newState.agnosticSymbols = deepcopy<AgnosticSymbol[]>(state.agnosticSymbols);
        newState.selectedRegion.symbols = newState.agnosticSymbols; // it is the same object

        const symbol = newState.agnosticSymbols.find(s => s.id === action.agnosticSymbol.id);
        if (symbol) {
          newState.selectedSymbol = symbol;
        }*/
      }
      return newState;
    }
    case AgnosticRepresentationActionTypes.CreateSymbolSuccess: {
      const newState = {...state};
      newState.selectedSymbol = null;
      newState.selectedRegion = action.region;
      newState.agnosticSymbols = newState.selectedRegion.symbols; // same object
      return newState;
    }
    case AgnosticRepresentationActionTypes.DeleteSymbolSuccess: {
      const newState = {...state};
      newState.selectedSymbol = null;
      newState.agnosticSymbols = deepcopy<AgnosticSymbol[]>(state.agnosticSymbols);

      if (action.deletedAgnosticSymbolID) { // if no error has occurred
        // remove the deleted symbol
        newState.agnosticSymbols = newState.agnosticSymbols.filter(symbol => symbol.id !== action.deletedAgnosticSymbolID);
      }
      newState.selectedRegion.symbols = newState.agnosticSymbols; // same object
      return newState;
    }
    default: {
      return state;
    }
  }
}


