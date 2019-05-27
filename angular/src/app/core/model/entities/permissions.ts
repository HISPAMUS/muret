import {Entity} from './entity';
import {Collection} from './collection';

export interface Permissions extends Entity {
  permission: string;
  collection: Collection;
}
