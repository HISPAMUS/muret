import {Entity} from './entity';

export interface Part extends Entity {
  name: string;
  comments?: string;
}
