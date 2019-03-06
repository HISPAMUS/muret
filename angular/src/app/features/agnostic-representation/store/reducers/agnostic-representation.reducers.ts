import deepcopy from 'ts-deepcopy';
import {AgnosticRepresentationActions, AgnosticRepresentationActionTypes} from '../actions/agnostic-representation.actions';
import {AgnosticRepresentationState, initialAgnosticRepresentationState} from '../state/agnostic-representation.state';

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
      return newState;
    }
    default: {
      return state;
    }
  }
}
