import {Entity} from './entity';

export interface State extends Entity {
  comments: string;
  state: 'doublechecked' | 'done' | 'inprogress';
  // TODO User
}
