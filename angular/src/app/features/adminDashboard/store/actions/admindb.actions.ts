import { Action } from '@ngrx/store';
import { NewUser } from '../../models/newusermodel';
import { PermissionsModel } from '../../models/permissionsModel';

export enum AdminDBActionTypes {
    REGISTER_START = '[Admin] Register new user start',
    REGISTER_SUCCESS = '[Admin] Register new user success',
    REGISTER_FAIL = '[Admin] Register new user fail',
    REVOKE_PERMISSIONS = '[Admin] Revoke user permissions',
    REVOKE_PERMISSIONS_SUCCESS = '[Admin] Revoke user permissions successs'
}

export class RegisterStart implements Action 
{
    readonly type = AdminDBActionTypes.REGISTER_START
    constructor(public payload: NewUser){}
}

export class RegisterSuccess implements Action 
{
    readonly type = AdminDBActionTypes.REGISTER_SUCCESS
}

export class RegisterFail implements Action 
{
    readonly type = AdminDBActionTypes.REGISTER_FAIL
    constructor(public payload: string){}
}

export class RevokePermissions implements Action
{
    readonly type = AdminDBActionTypes.REVOKE_PERMISSIONS
    constructor(public payload: PermissionsModel){}
}

export class RevokePermissionsSuccess implements Action
{
    readonly type = AdminDBActionTypes.REVOKE_PERMISSIONS_SUCCESS
}

export type AdminDBActions = 
    | RegisterStart
    | RegisterSuccess
    | RegisterFail
    | RevokePermissions
    | RevokePermissionsSuccess; 