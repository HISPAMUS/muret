import deepcopy from 'ts-deepcopy';
import {AgnosticRepresentationActions, AgnosticRepresentationActionTypes} from '../actions/agnostic-representation.actions';
import {AgnosticRepresentationState, initialAgnosticRepresentationState} from '../state/agnostic-representation.state';

export function agnosticRepresentationReducers(state = initialAgnosticRepresentationState, action: AgnosticRepresentationActions):
  AgnosticRepresentationState {
  switch (action.type) {
    case AgnosticRepresentationActionTypes.AccionSuccess: {
      return {
        ...initialAgnosticRepresentationState
      };
    }
    default: {
      return state;
    }
  }
}
