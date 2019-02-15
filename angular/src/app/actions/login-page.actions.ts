import { Action } from '@ngrx/store';

export enum ActionTypes {
  Login = '[Login Page] Login',
}

export class Login implements Action {
  readonly type = '[Login Page] Login';

  constructor(public payload: { username: string; password: string }) {}
}

export type Union = Login;
