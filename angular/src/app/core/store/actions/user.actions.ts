import { Action } from '@ngrx/store';
import {User} from '../../model/entities/user';

export enum UserActionTypes {
  GetUser = '[User] Get User',
  GetUserSuccess = '[User] Get User Success',
  GetUserPermissions = '[User] Get User Permissions',
  GetUserPermissionsSuccess = '[User] Get User Permissions Success',
  GetUsers = '[User] Get all users',
  GetUsersSuccess = '[User] Get all users success'
}

export class CoreGetUser implements Action {
  public readonly type = UserActionTypes.GetUser;
  constructor(public userID: number) {}
}

export class GetUserSuccess implements Action {
  public readonly type = UserActionTypes.GetUserSuccess;
  constructor(public user: User) {}
}

export class CoreGetUserPermissions implements Action{
  public readonly type = UserActionTypes.GetUserPermissions;
  constructor(){}
}

export class GetUserPermissionsSuccess implements Action
{
  public readonly type = UserActionTypes.GetUserPermissionsSuccess;
  constructor(public payload: any) {}
}

export class CoreGetUsers implements Action
{
  public readonly type = UserActionTypes.GetUsers;
}

export class GetUsersSuccess implements Action
{
  public readonly type = UserActionTypes.GetUsersSuccess;
  constructor(public payload: string[]){}
}

export type UserActions = CoreGetUser | GetUserSuccess | CoreGetUserPermissions | GetUserPermissionsSuccess | CoreGetUsers | GetUsersSuccess;
