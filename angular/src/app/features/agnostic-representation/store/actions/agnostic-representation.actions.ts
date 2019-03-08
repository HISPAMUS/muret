import {Action} from '@ngrx/store';
import {Region} from '../../../../core/model/entities/region';
import {SVGSet} from '../../model/svgset';

export enum AgnosticRepresentationActionTypes {
  GetRegion = '[AgnosticRepresentation] Get region',
  GetRegionSuccess = '[AgnosticRepresentation] Get region success',
  GetSVGSet = '[AgnosticRepresentation] Get SVG set',
  GetSVGSetSucccess = '[AgnosticRepresentation] Get SVG set success'
}

export class GetRegion implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetRegion
  constructor(public id: number) {}
}

export class GetRegionSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetRegionSuccess
  constructor(public region: Region) {}
}


export class GetSVGSet implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetSVGSet
  constructor(public notationType: string, public manuscriptType: string) {}
}

export class GetSVGSetSucccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetSVGSetSucccess
  constructor(public svgSet: SVGSet) {}
}



export type AgnosticRepresentationActions =
  GetRegion | GetRegionSuccess | GetSVGSet | GetSVGSetSucccess;
