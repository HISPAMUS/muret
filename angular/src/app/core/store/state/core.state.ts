import {RouterReducerState} from '@ngrx/router-store';
import {initialUserState, UserState} from './user.state';
import { ServerStatusState, initialServerStatusState } from './status.state';


export interface CoreState {
  router?: RouterReducerState;
  user: UserState;
  server: ServerStatusState;
}

export const initialCoreState: CoreState = {
  user: initialUserState,
  server: initialServerStatusState,
};

export function getInitialState(): CoreState {
  return initialCoreState;
}
