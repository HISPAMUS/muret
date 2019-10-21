import {createFeatureSelector, createSelector} from '@ngrx/store';
import {CoreState} from '../state/core.state';


export const selectCoreState = createFeatureSelector<CoreState>('core');

export const selectLoggedInUser = createSelector(
  selectCoreState,
  (state: CoreState) => state.user.loggedInUser
);

export const selectServerStatus = createSelector(
  selectCoreState,
  (state: CoreState) => state.server.status
);

