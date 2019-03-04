import { ActionReducerMap } from '@ngrx/store';

import { routerReducer } from '@ngrx/router-store';
import { CoreState } from '../state/core.state';
import {userReducers} from './user.reducers';

export const coreReducers: ActionReducerMap<CoreState, any> = {
  router: routerReducer,
  user: userReducers
};