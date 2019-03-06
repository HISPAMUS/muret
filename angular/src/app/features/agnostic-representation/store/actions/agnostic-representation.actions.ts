import {Action} from '@ngrx/store';

export enum AgnosticRepresentationActionTypes {
  Accion = '[AgnosticRepresentation] Acción',
  AccionSuccess = '[AgnosticRepresentation] Acción success'
}

export class Accion implements Action {
  public readonly type = AgnosticRepresentationActionTypes.Accion
  constructor(public payload: any) {}
}

export class AccionSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.AccionSuccess
  constructor(public payload: any) {}
}


export type AgnosticRepresentationActions =
  Accion | AccionSuccess;
