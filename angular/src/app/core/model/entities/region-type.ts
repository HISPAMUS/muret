import {Entity} from './entity';

export interface RegionType extends Entity {
  name: string;
  hexargb: string; // without the #
  help: string;
}
