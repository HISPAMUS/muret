import { Action } from '@ngrx/store';
import {User} from '../../model/entities/user';

export enum UserActionTypes {
  GetUser = '[User] Get User',
  GetUserSuccess = '[User] Get User Success',
  GetUserPermissions = '[User] Get User Permissions',
  GetUserPermissionsSuccess = '[User] Get User Permissions Success',
}

export class GetUser implements Action {
  public readonly type = UserActionTypes.GetUser;
  constructor(public payload: number) {}
}

export class GetUserSuccess implements Action {
  public readonly type = UserActionTypes.GetUserSuccess;
  constructor(public payload: User) {}
}

export class GetUserPermissions implements Action{
  public readonly type = UserActionTypes.GetUserPermissions;
  constructor(){}
}

export class GetUserPermissionsSuccess implements Action
{
  public readonly type = UserActionTypes.GetUserPermissionsSuccess;
  constructor(public payload: any) {}
}

export type UserActions = GetUser | GetUserSuccess | GetUserPermissions | GetUserPermissionsSuccess;
