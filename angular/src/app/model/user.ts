import {Project} from './project';
import {Permissions} from './permissions';

export class User {
  id: number;
  username: string;
  projectsCreated: Array<Project>;
  permissions: Permissions;
}
