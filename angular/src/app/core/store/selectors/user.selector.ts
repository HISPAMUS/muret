import {createFeatureSelector, createSelector} from '@ngrx/store';
import {UserState} from '../state/user.state';
import {CoreState} from '../state/core.state';


export const selectCoreState = createFeatureSelector<CoreState>('core');

export const selectLoggedInUser = createSelector(
  selectCoreState,
  (state: CoreState) => state.user.loggedInUser
);

