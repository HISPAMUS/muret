import {Action} from '@ngrx/store';
import {Region} from '../../../../core/model/entities/region';

export enum AgnosticRepresentationActionTypes {
  GetRegion = '[AgnosticRepresentation] Get region',
  GetRegionSuccess = '[AgnosticRepresentation] Get region success'
}

export class GetRegion implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetRegion
  constructor(public id: number) {}
}

export class GetRegionSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetRegionSuccess
  constructor(public region: Region) {}
}


export type AgnosticRepresentationActions =
  GetRegion | GetRegionSuccess;
