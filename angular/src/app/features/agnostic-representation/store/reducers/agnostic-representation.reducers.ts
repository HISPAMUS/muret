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
    case AgnosticRepresentationActionTypes.DeselectSymbol: {
      const newState = {...state};
      newState.selectedSymbol = null;
      return newState;
    }
    case AgnosticRepresentationActionTypes.ChangeSymbolSuccess: {
      const newState = {...state};
      if (action.agnosticSymbol != null) { // if no error
        const symbolsWithoutChangedOne: AgnosticSymbol[] =
          state.agnosticSymbols.filter(symbol => symbol.id !== action.agnosticSymbol.id);
        newState.agnosticSymbols = [...symbolsWithoutChangedOne, action.agnosticSymbol];
        newState.selectedRegion.symbols = newState.agnosticSymbols; // it is the same object
        newState.selectedSymbol = null;
      }
      return newState;
    }
    case AgnosticRepresentationActionTypes.CreateSymbolSuccess: {
      const newState = {...state};
      newState.selectedSymbol = null;
      newState.agnosticSymbols = [...newState.agnosticSymbols, action.createdSymbol];
      newState.selectedRegion.symbols = newState.agnosticSymbols; // same object
      return newState;
    }
    case AgnosticRepresentationActionTypes.DeleteSymbolSuccess: {
      const newState = {...state};
      newState.selectedSymbol = null;

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


