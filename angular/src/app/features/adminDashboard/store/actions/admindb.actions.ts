import { Action } from '@ngrx/store';
import { NewUser } from '../../models/newusermodel';

export enum AdminDBActionTypes {
    REGISTER_START = '[Admin] Register new user start',
    REGISTER_SUCCESS = '[Admin] Register new user success',
    REGISTER_FAIL = '[Admin] Register new user fail'
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

export type AdminDBActions = 
    | RegisterStart
    | RegisterSuccess
    | RegisterFail; 