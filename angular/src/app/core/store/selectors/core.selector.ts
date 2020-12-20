import {createFeatureSelector, createSelector} from '@ngrx/store';
import {CoreState} from '../state/core.state';


export const selectCoreState = createFeatureSelector<CoreState>('core');
//export const selectUser = createFeatureSelector<UserState>('user')
//export const selectFonts = createFeatureSelector<FontsState>('fonts')

export const selectLoggedInUser = createSelector(
  selectCoreState,
  (state: CoreState) => state.user.loggedInUser
);

export const selectServerStatus = createSelector(
  selectCoreState,
  (state: CoreState) => state.server.status
);

export const selectUserPermissions = createSelector(
  selectCoreState,
  (state: CoreState) => state.user.permissionsData
)

export const selectUserList = createSelector(
  selectCoreState,
  (state: CoreState) => state.user.userList
)

export const selectSVGAgnosticOrSemanticSymbolSet = createSelector(
  selectCoreState,
  (state: CoreState) => state.fonts.svgAgnosticOrSemanticSymbolsSet
);


