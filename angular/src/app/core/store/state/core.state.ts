import {RouterReducerState} from '@ngrx/router-store';
import {initialUserState, UserState} from './user.state';
import { ServerStatusState, initialServerStatusState } from './status.state';
import {FontsState, initialFontsState} from "./fonts.state";


export interface CoreState {
  router?: RouterReducerState;
  user: UserState;
  server: ServerStatusState;
  fonts: FontsState;
}

export const initialCoreState: CoreState = {
  user: initialUserState,
  server: initialServerStatusState,
  fonts: initialFontsState,
};

export function getInitialState(): CoreState {
  return initialCoreState;
}
