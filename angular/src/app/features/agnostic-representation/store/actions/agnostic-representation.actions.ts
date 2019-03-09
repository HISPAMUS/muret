import {Action} from '@ngrx/store';
import {Region} from '../../../../core/model/entities/region';
import {SVGSet} from '../../model/svgset';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';

export enum AgnosticRepresentationActionTypes {
  GetRegion = '[AgnosticRepresentation] Get region',
  GetRegionSuccess = '[AgnosticRepresentation] Get region success',
  SelectSymbol = '[AgnosticRepresentation] Select symbol',
  GetSVGSet = '[AgnosticRepresentation] Get SVG set',
  GetSVGSetSucccess = '[AgnosticRepresentation] Get SVG set success',
  ChangeSymbolType = '[AgnosticRepresentation] Change symbol type',
  ChangeSymbolTypeSuccess = '[AgnosticRepresentation] Change symbol type success',
  ChangeSymbolPositionInStaff = '[AgnosticRepresentation] Change symbol position in staff',
  ChangeSymbolPositionInStaffSuccess = '[AgnosticRepresentation] Change symbol position in staff success'
}

export class GetRegion implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetRegion
  constructor(public id: number) {}
}

export class GetRegionSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetRegionSuccess
  constructor(public region: Region) {}
}

export class SelectSymbol implements Action {
  public readonly type = AgnosticRepresentationActionTypes.SelectSymbol
  constructor(public agnosticSymbol: AgnosticSymbol) {}
}

export class GetSVGSet implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetSVGSet
  constructor(public notationType: string, public manuscriptType: string) {}
}

export class GetSVGSetSucccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetSVGSetSucccess
  constructor(public svgSet: SVGSet) {}
}

export class ChangeSymbolType implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbolType
  constructor(public agnosticSymbol: AgnosticSymbol, public agnosticSymbolType: string) {}
}

export class ChangeSymbolTypeSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbolTypeSuccess
  constructor(public agnosticSymbol: AgnosticSymbol) {}
}

export class ChangeSymbolPositionInStaff implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbolPositionInStaff
  constructor(public agnosticSymbol: AgnosticSymbol, public difference: number) {}
}

export class ChangeSymbolPositionInStaffSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbolPositionInStaffSuccess
  constructor(public agnosticSymbol: AgnosticSymbol) {}
}


export type AgnosticRepresentationActions =
  GetRegion | GetRegionSuccess | GetSVGSet | GetSVGSetSucccess | SelectSymbol |
  ChangeSymbolType | ChangeSymbolTypeSuccess | ChangeSymbolPositionInStaff | ChangeSymbolPositionInStaffSuccess;
