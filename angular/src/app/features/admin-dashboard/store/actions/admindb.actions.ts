import { Action } from '@ngrx/store';
import { NewUser } from '../../model/new-user';
import { Permissions } from '../../model/permissions';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export enum AdminDBActionTypes {
    RESET_ADMIN_SERVER_ERROR = '[Admin] Reset Admin server error',
    ADMIN_SERVER_ERROR = '[Admin] Admin server error',
    REGISTER_START = '[Admin] Register new user start',
    REGISTER_SUCCESS = '[Admin] Register new user success',
    REGISTER_FAIL = '[Admin] Register new user fail',
    REVOKE_PERMISSIONS = '[Admin] Revoke user permissions',
    REVOKE_PERMISSIONS_SUCCESS = '[Admin] Revoke user permissions successs',
    GRANT_PERMISSIONS = '[Admin] Grant permissions on user',
    GRANT_PERMISSIONS_SUCCESS = '[Admin] Grant permissions on user successfull'
}

export class ResetAdminDBServerError implements Action {
  readonly type = AdminDBActionTypes.RESET_ADMIN_SERVER_ERROR;
  constructor() {}
}

export class AdminDBServerError implements Action {
  readonly type = AdminDBActionTypes.ADMIN_SERVER_ERROR;
  constructor(public error: APIRestServerError) {}
}

export class RegisterStart implements Action {
    readonly type = AdminDBActionTypes.REGISTER_START;
    constructor(public payload: NewUser) {}
}

export class RegisterSuccess implements Action {
    readonly type = AdminDBActionTypes.REGISTER_SUCCESS;
}

export class RegisterFail implements Action {
    readonly type = AdminDBActionTypes.REGISTER_FAIL;
    constructor(public payload: string) {}
}

export class RevokePermissions implements Action {
    readonly type = AdminDBActionTypes.REVOKE_PERMISSIONS;
    constructor(public payload: Permissions) {}
}

export class RevokePermissionsSuccess implements Action {
    readonly type = AdminDBActionTypes.REVOKE_PERMISSIONS_SUCCESS;
}

export class GrantPermissions implements Action {
    readonly type = AdminDBActionTypes.GRANT_PERMISSIONS;
    constructor(public payload: Permissions) {}
}

export class GrantPermissionsSuccess implements Action {
    readonly type = AdminDBActionTypes.GRANT_PERMISSIONS_SUCCESS;
}

export type AdminDBActions =
    ResetAdminDBServerError
    | AdminDBServerError
    | RegisterStart
    | RegisterSuccess
    | RegisterFail
    | RevokePermissions
    | RevokePermissionsSuccess
    | GrantPermissions
    | GrantPermissionsSuccess;
