import {Entity} from './entity';
import {RegionInteractionType} from "./region-interaction-type";

export interface RegionType extends Entity {
  name: string;
  hexargb: string; // without the #
  help: string;
  regionInteractionType?: RegionInteractionType;
}
