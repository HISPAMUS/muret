import {Entity} from './entity';
import {Image} from "./image";

export interface Section extends Entity {
  name: string;
  images: Image[];
  ordering: number;
}

export function compare(a: Section, b: Section): number {
  return a.ordering - b.ordering;
}



