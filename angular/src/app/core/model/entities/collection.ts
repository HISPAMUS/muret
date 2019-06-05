import {Project} from './project';
import {Entity} from './entity';

export interface Collection extends Entity {
  name?: string;
  comments?: string;
  projects?: Project[];
  thumbnailBase64Encoding?: string;
}
