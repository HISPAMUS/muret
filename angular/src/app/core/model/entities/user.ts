import {Project} from './project';
import {Permissions} from './permissions';
import {Entity} from './entity';

export interface User extends Entity {
  username: string;
  projectsCreated?: Project[];
  permissions?: Permissions[];
}
