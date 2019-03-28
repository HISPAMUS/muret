import {Action} from '@ngrx/store';

export enum SampleActionTypes {
  Accion = '[Sample] Acción',
  AccionSuccess = '[Sample] Acción success'
}

export class Accion implements Action {
  public readonly type = SampleActionTypes.Accion;
  constructor(public payload: any) {}
}

export class AccionSuccess implements Action {
  public readonly type = SampleActionTypes.AccionSuccess;
  constructor(public payload: any) {}
}


export type SampleActions =
  Accion | AccionSuccess;
