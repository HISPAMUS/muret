import { Action } from '@ngrx/store';
import {Project} from '../../../../core/model/entities/project';
import {Image} from '../../../../core/model/entities/image';

export enum ProjectActionTypes {
  GetProject = '[Project] Get project',
  GetProjectSuccess = '[Project] Get project success',
  GetImages = '[Project] Get images',
  GetImagesSuccess = '[Project] Get images success',
  ExportMEI = '[Project] Export MEI',
  ExportMEISuccess = '[Project] Export MEI success',
  ExportMEIPartsFacsimile = '[Project] Export MEI parts and facsimile',
  ExportMEIPartsFacsimileSuccess = '[Project] Export MEI parts and facsimile success',
  ExportMensurstrich = '[Project] Export mensurstrich',
  ExportMensurstrichSuccess = '[Project] Export mensurstrich success',
  ExportMusicXML = '[Project] Export MusicXML',
  ExportMusicXMLSuccess = '[Project] Export MusicXML success',
}

export class GetProject implements Action {
  public readonly type = ProjectActionTypes.GetProject;
  constructor(public projectID: number) {}
}

export class GetProjectSuccess implements Action {
  public readonly type = ProjectActionTypes.GetProjectSuccess;
  constructor(public project: Project) {}
}

export class GetImages implements Action {
  public readonly type = ProjectActionTypes.GetImages;
  constructor(public projectID: number) {}
}

export class GetImagesSuccess implements Action {
  public readonly type = ProjectActionTypes.GetImagesSuccess;
  constructor(public images: Image[]) {}
}

export class ExportMEI implements Action {
  public readonly type = ProjectActionTypes.ExportMEI;
  constructor(public projectID: number, public partID: number) {}
}

export class ExportMEISuccess implements Action {
  public readonly type = ProjectActionTypes.ExportMEISuccess;
  constructor(public mei: string) {}
}

export class ExportMEIPartsFacsimile implements Action {
  public readonly type = ProjectActionTypes.ExportMEIPartsFacsimile;
  constructor(public projectID: number) {}
}

export class ExportMEIPartsFacsimileSuccess implements Action {
  public readonly type = ProjectActionTypes.ExportMEIPartsFacsimileSuccess;
  constructor(public mei: string) {}
}

export class ExportMensurstrich implements Action {
  public readonly type = ProjectActionTypes.ExportMensurstrich;
  constructor(public projectID: number) {}
}

export class ExportMensurstrichSuccess implements Action {
  public readonly type = ProjectActionTypes.ExportMensurstrichSuccess;
  constructor(public payload: Blob) {}
}

export class ExportMusicXML implements Action {
  public readonly type = ProjectActionTypes.ExportMusicXML;
  constructor(public projectID: number) {}
}

export class ExportMusicXMLSuccess implements Action {
  public readonly type = ProjectActionTypes.ExportMusicXMLSuccess;
  constructor(public payload: Blob) {}
}
export type ProjectActions =
  GetProject | GetProjectSuccess | GetImages | GetImagesSuccess | ExportMEI | ExportMEISuccess |
  ExportMEIPartsFacsimile | ExportMEIPartsFacsimileSuccess |
  ExportMensurstrich | ExportMensurstrichSuccess |
  ExportMusicXML | ExportMusicXMLSuccess;
