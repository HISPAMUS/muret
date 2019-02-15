import {Project} from './project';

export interface Permissions {
  id: number;
  permission: string;
  project: Project;
}
