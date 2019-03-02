import { Action } from '@ngrx/store';
import {User} from '../../model/entities/user';

export enum UserActionTypes {
  GetUser = '[User] Get User',
  GetUserSuccess = '[User] Get User Success'
}

export class GetUser implements Action {
  public readonly type = UserActionTypes.GetUser;
  constructor(public payload: number) {}
}

export class GetUserSuccess implements Action {
  public readonly type = UserActionTypes.GetUserSuccess;
  constructor(public payload: User) {}
}

export type UserActions = GetUser | GetUserSuccess;
