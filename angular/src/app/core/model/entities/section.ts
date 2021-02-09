import {Entity} from './entity';
import {Image} from "./image";

export interface Section extends Entity {
  name: string;
  images: Image[];
}


