import {createFeatureSelector, createSelector} from '@ngrx/store';
import {AuthState} from '../state/auth.state';

export const selectAuthState = createFeatureSelector<AuthState>('auth');

export const selectAuthIsAuthenticated = createSelector(
  selectAuthState,
  (state: AuthState) => state.isAuthenticated
);

export const selectAuthUsername = createSelector(
  selectAuthState,
  (state: AuthState) => state.username
);

export const selectAuthErrorMessage = createSelector(
  selectAuthState,
  (state: AuthState) => state.errorMessage
);

export const selectAuthAccessToken = createSelector(
  selectAuthState,
  (state: AuthState) => state.accessToken
);

export const selectAuthUserID = createSelector(
  selectAuthState,
  (state: AuthState) => state.userID
);

export const selectAuthResetPWDStatus = createSelector(
  selectAuthState,
  (state: AuthState) => state.passwordresetmess
);

export const selectAuthRoles = createSelector(
  selectAuthState,
  (state: AuthState) => state.roles
);

export const selectAuthIsAdmin = createSelector(
  selectAuthState,
  //(state: AuthState) => state.roles.find(role => role.authority == 'ADMIN') != undefined
  (state: AuthState) => state.roles.find(role => role.authority == 'ADMIN') != undefined
);
