import {Document} from './document';
import {Permissions} from './permissions';
import {Entity} from './entity';

export interface User extends Entity {
  username: string;
  documentsCreated?: Document[];
  permissions?: Permissions[];
}
