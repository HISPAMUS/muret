import {RouterReducerState} from '@ngrx/router-store';
import {initialUserState, UserState} from './user.state';

export interface CoreState {
  router?: RouterReducerState;
  user: UserState;
}

export const initialCoreState: CoreState = {
  user: initialUserState
};

export function getInitialState(): CoreState {
  return initialCoreState;
}
