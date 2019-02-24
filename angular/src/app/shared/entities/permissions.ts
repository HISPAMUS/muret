import {Project} from './project';
import {Entity} from './entity';

export interface Permissions extends Entity {
  permission: string;
  project: Project;
}
