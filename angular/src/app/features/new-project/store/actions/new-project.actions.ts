import {Action} from '@ngrx/store';
import {Project} from '../../../../core/model/entities/project';
import {User} from '../../../../core/model/entities/user';

export enum NewProjectActionTypes {
  CreateProjectReset = '[NewProject] Create project reset',
  CreateProject = '[NewProject] Create project',
  CreateProjectSuccess = '[NewProject] Create project success'
}

export class CreateProject implements Action {
  public readonly type = NewProjectActionTypes.CreateProject;
  constructor(public user: User,
              public name: string, public composer: string,
              public notationType: string, public manuscriptType: string,
              public comments: any, public imgSrc: string) {}
}

export class CreateProjectSuccess implements Action {
  public readonly type = NewProjectActionTypes.CreateProjectSuccess;
  constructor(public project: Project) {}
}

export class CreateProjectReset implements Action {
  public readonly type = NewProjectActionTypes.CreateProjectReset;
  constructor() {}
}

export type NewProjectActions =
  CreateProjectReset | CreateProject | CreateProjectSuccess;
