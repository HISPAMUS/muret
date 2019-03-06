import {Action} from '@ngrx/store';

export enum SemanticRepresentationActionTypes {
  Accion = '[SemanticRepresentation] Acción',
  AccionSuccess = '[SemanticRepresentation] Acción success'
}

export class Accion implements Action {
  public readonly type = SemanticRepresentationActionTypes.Accion
  constructor(public payload: any) {}
}

export class AccionSuccess implements Action {
  public readonly type = SemanticRepresentationActionTypes.AccionSuccess
  constructor(public payload: any) {}
}


export type SemanticRepresentationActions =
  Accion | AccionSuccess;
