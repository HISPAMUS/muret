import {createFeatureSelector, createSelector} from '@ngrx/store';
import {CoreState} from '../state/core.state';


export const selectCoreState = createFeatureSelector<CoreState>('core');
//export const selectUser = createFeatureSelector<UserState>('user')
//export const selectFonts = createFeatureSelector<FontsState>('fonts')

export const selectCoreLoggedInUser = createSelector(
  selectCoreState,
  (state: CoreState) => state.user.loggedInUser
);

export const selectCoreUserPermissions = createSelector(
  selectCoreState,
  (state: CoreState) => state.user.permissionsData
)

export const selectCoreUserList = createSelector(
  selectCoreState,
  (state: CoreState) => state.user.userList
)


export const selectCoreServerStatus = createSelector(
  selectCoreState,
  (state: CoreState) => state.server.status
);

export const selectCoreSVGAgnosticOrSemanticSymbolSet = createSelector(
  selectCoreState,
  (state: CoreState) => state.fonts.svgAgnosticOrSemanticSymbolsSet
);


