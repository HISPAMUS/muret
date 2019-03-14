import {Action} from '@ngrx/store';
import {Region} from '../../../../core/model/entities/region';
import {SVGSet} from '../../model/svgset';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {Polyline} from '../../../../svg/model/polyline';

export enum AgnosticRepresentationActionTypes {
  GetRegion = '[AgnosticRepresentation] Get region',
  GetRegionSuccess = '[AgnosticRepresentation] Get region success',
  SelectSymbol = '[AgnosticRepresentation] Select symbol',
  DeselectSymbol = '[AgnosticRepresentation] Deselect symbol',
  GetSVGSet = '[AgnosticRepresentation] Get SVG set',
  GetSVGSetSucccess = '[AgnosticRepresentation] Get SVG set success',
  ChangeSymbolType = '[AgnosticRepresentation] Change symbol type',
  ChangeSymbolTypeSuccess = '[AgnosticRepresentation] Change symbol type success',
  ChangeSymbolPositionInStaff = '[AgnosticRepresentation] Change symbol position in staff',
  ChangeSymbolPositionInStaffSuccess = '[AgnosticRepresentation] Change symbol position in staff success',
  CreateSymbolFromBoundingBox = '[AgnosticRepresentation] Create symbol from bounding box',
  CreateSymbolSuccess = '[AgnosticRepresentation] Create symbol success',
  DeleteSymbol = '[AgnosticRepresentation] Delete symbol',
  DeleteSymbolSuccess = '[AgnosticRepresentation] Delete symbol success'
}

export class GetRegion implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetRegion;
  constructor(public id: number) {}
}

export class GetRegionSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetRegionSuccess;
  constructor(public region: Region) {}
}

export class SelectSymbol implements Action {
  public readonly type = AgnosticRepresentationActionTypes.SelectSymbol;
  constructor(public agnosticSymbol: AgnosticSymbol) {}
}

export class DeselectSymbol implements Action {
  public readonly type = AgnosticRepresentationActionTypes.DeselectSymbol;
  constructor() {}
}

export class GetSVGSet implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetSVGSet;
  constructor(public notationType: string, public manuscriptType: string) {}
}

export class GetSVGSetSucccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetSVGSetSucccess;
  constructor(public svgSet: SVGSet) {}
}

export class ChangeSymbolType implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbolType;
  constructor(public agnosticSymbol: AgnosticSymbol, public agnosticSymbolType: string) {}
}

export class ChangeSymbolTypeSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbolTypeSuccess;
  constructor(public agnosticSymbol: AgnosticSymbol) {}
}

export class ChangeSymbolPositionInStaff implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbolPositionInStaff;
  constructor(public agnosticSymbol: AgnosticSymbol, public difference: number) {}
}

export class ChangeSymbolPositionInStaffSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbolPositionInStaffSuccess;
  constructor(public agnosticSymbol: AgnosticSymbol) {}
}

export class CreateSymbolFromBoundingBox implements Action {
  public readonly type = AgnosticRepresentationActionTypes.CreateSymbolFromBoundingBox;
  constructor(public regionID: number, public boundingBox: BoundingBox, public agnosticSymbolType: string) {}
}

export class CreateSymbolFromStrokes implements Action {
  public readonly type = AgnosticRepresentationActionTypes.CreateSymbolFromBoundingBox;
  constructor(public regionID: number, public polyline: Polyline[], public agnosticSymbolType: string) {}
}

export class CreateSymbolSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.CreateSymbolSuccess
  constructor(public createdSymbol: AgnosticSymbol) {}
}

export class DeleteSymbol implements Action {
  public readonly type = AgnosticRepresentationActionTypes.DeleteSymbol;
  constructor(public agnosticSymbolID: number) {}
}

export class DeleteSymbolSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.DeleteSymbolSuccess;
  constructor(public deletedAgnosticSymbolID: number) {}
}

export type AgnosticRepresentationActions =
  GetRegion | GetRegionSuccess | GetSVGSet | GetSVGSetSucccess | SelectSymbol | DeselectSymbol |
  ChangeSymbolType | ChangeSymbolTypeSuccess | ChangeSymbolPositionInStaff | ChangeSymbolPositionInStaffSuccess |
  CreateSymbolFromBoundingBox | CreateSymbolFromStrokes | CreateSymbolSuccess | DeleteSymbol | DeleteSymbolSuccess;
