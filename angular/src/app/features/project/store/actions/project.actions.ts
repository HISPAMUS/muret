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
  constructor(public projectID: number) {}
}

export class ExportMEISuccess implements Action {
  public readonly type = ProjectActionTypes.ExportMEISuccess;
  constructor(public mei: string) {}
}

export type ProjectActions =
  GetProject | GetProjectSuccess | GetImages | GetImagesSuccess | ExportMEI | ExportMEISuccess;
