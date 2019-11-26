import {createFeatureSelector, createSelector} from '@ngrx/store';
import {AuthState} from '../state/auth.state';

export const selectAuthState = createFeatureSelector<AuthState>('auth');

export const selectIsAuthenticated = createSelector(
  selectAuthState,
  (state: AuthState) => state.isAuthenticated
);

export const selectUsername = createSelector(
  selectAuthState,
  (state: AuthState) => state.username
);

export const selectAuthErrorMessage = createSelector(
  selectAuthState,
  (state: AuthState) => state.errorMessage
);

export const selectAccessToken = createSelector(
  selectAuthState,
  (state: AuthState) => state.accessToken
);

export const selectResetPWDStatus = createSelector(
  selectAuthState,
  (state: AuthState) => state.passwordresetmess
);

export const selectRole = createSelector(
  selectAuthState,
  (state: AuthState) => state.roles
);

