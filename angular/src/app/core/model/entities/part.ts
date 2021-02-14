import {Entity} from './entity';
import {IOrdered} from "./iordered";

export interface Part extends Entity, IOrdered {
  name: string;
  comments?: string;
}
