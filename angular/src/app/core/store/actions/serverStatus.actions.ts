import { Action } from '@ngrx/store';


export enum serverStatusActionTypes 
{
    GetStatus = "[STATUS] Get Server Status",
    StatusSuccess = "[STATUS] Server status received",
} 

export class GetServerStatus implements Action
{
    public readonly type = serverStatusActionTypes.GetStatus;
    public constructor() {}
}

export class GetStatusSuccess implements Action
{
    public readonly type = serverStatusActionTypes.StatusSuccess;
    public constructor(public payload: string) {}
}

export type ServerStatusActions = GetServerStatus | GetStatusSuccess;