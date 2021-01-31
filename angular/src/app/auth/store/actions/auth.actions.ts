import { Action } from '@ngrx/store';
import {Credentials} from '../../../auth/models/credentials';
import {JwtResponse} from '../../../auth/models/jwt-response';
import {SessionData} from '../../models/session-data';
import { ResetPWD } from '../../models/resetpwd';

export enum AuthActionTypes {
  LOGIN = '[Auth] Login',
  LOGIN_SUCCESS = '[Auth] Login Success',
  LOGIN_FAILURE = '[Auth] Login Failure',
  LOGOUT = '[Auth] Logout',
  GET_STATUS = '[Auth] GetStatus',
  REFRESH = '[Auth] Refresh',
  REFRESH_LOGGED = '[Auth] Refresh logged',
  RESET_PASSWORD = '[Auth] Reset password',
  RESET_PASSWORD_SUCCESS = '[Auth] Reset password success',
  RESET_PASSWORD_FAIL = '[Auth] Reset password fail'
}

export class AuthLogIn implements Action {
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

export class AuthLogOut implements Action {
  readonly type = AuthActionTypes.LOGOUT;
}

export class AuthGetStatus implements Action {
  readonly type = AuthActionTypes.GET_STATUS;
}

export class AuthRefresh implements Action {
  readonly type = AuthActionTypes.REFRESH;
  constructor() {}
}

export class RefreshLogged implements Action {
  readonly type = AuthActionTypes.REFRESH_LOGGED;
  constructor(public sessionData: SessionData) {}
}

export class AuthResetPassword implements Action {
  readonly type = AuthActionTypes.RESET_PASSWORD;
  constructor(public payload: ResetPWD){}
}

export class ResetPasswordSuccess implements Action
{
  readonly type = AuthActionTypes.RESET_PASSWORD_SUCCESS;
}

export class ResetPasswordFail implements Action
{
  readonly type = AuthActionTypes.RESET_PASSWORD_FAIL;
}

export type AuthActions =
  | AuthLogIn
  | LogInSuccess
  | LogInFailure
  | AuthLogOut
  | AuthGetStatus
  | AuthRefresh
  | RefreshLogged
  | AuthResetPassword
  | ResetPasswordSuccess
  | ResetPasswordFail;
