import deepcopy from 'ts-deepcopy';
import {SampleActions, SampleActionTypes} from '../actions/sample.actions';
import {SampleState, initialSampleState} from '../state/sample.state';

export function sampleReducers(state = initialSampleState, action: SampleActions):
  SampleState {
  switch (action.type) {
    case SampleActionTypes.AccionSuccess: {
      return {
        ...initialSampleState
      };
    }
    default: {
      return state;
    }
  }
}
