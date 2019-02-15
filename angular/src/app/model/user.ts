import {Project} from './project';
import {Permissions} from './permissions';

export interface User {
  id: number;
  username: string;
  projectsCreated: Array<Project>;
  permissions: Array<Permissions>;
}
