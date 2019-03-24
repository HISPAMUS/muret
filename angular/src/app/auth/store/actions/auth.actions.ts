import { Action } from '@ngrx/store';
import {Credentials} from '../../../auth/models/credentials';
import {JwtResponse} from '../../../auth/models/jwt-response';
import {SessionData} from '../../models/session-data';

export enum AuthActionTypes {
  LOGIN = '[Auth] Login',
  LOGIN_SUCCESS = '[Auth] Login Success',
  LOGIN_FAILURE = '[Auth] Login Failure',
  LOGOUT = '[Auth] Logout',
  GET_STATUS = '[Auth] GetStatus',
  REFRESH = '[Auth] Refresh',
  REFRESH_LOGGED = '[Auth] Refresh logged',
}

export class LogIn implements Action {
  readonly type = AuthActionTypes.LOGIN;
  constructor(public payload: Credentials) {}
}

export class LogInSuccess implements Action {
  readonly type = AuthActionTypes.LOGIN_SUCCESS;
  constructor(public payload: JwtResponse) {}
}

export class LogInFailure implements Action {
  readonly type = AuthActionTypes.LOGIN_FAILURE;
  constructor(public payload: string) {}
}

export class LogOut implements Action {
  readonly type = AuthActionTypes.LOGOUT;
}

export class GetStatus implements Action {
  readonly type = AuthActionTypes.GET_STATUS;
}

export class Refresh implements Action {
  readonly type = AuthActionTypes.REFRESH;
  constructor() {}
}

export class RefreshLogged implements Action {
  readonly type = AuthActionTypes.REFRESH_LOGGED;
  constructor(public sessionData: SessionData) {}
}

export type AuthActions =
  | LogIn
  | LogInSuccess
  | LogInFailure
  | LogOut
  | GetStatus
  | Refresh
  | RefreshLogged;
