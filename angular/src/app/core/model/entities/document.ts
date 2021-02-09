import {Image} from './image';
import {State} from './state';
import {Entity} from './entity';
import {Collection} from './collection';
import {Part} from './part';
import {Section} from "./section";

export interface Document extends Entity {
  name: string;
  path: string;
  thumbnailBase64Encoding: string;
  images: Image[];
  comments: string;
  imagesOrdering: string;
  notationType: string;
  manuscriptType: string;
  state: State;
  composer: string;
  collection: Collection;
  parts: Part[];
  sections: Section[];
}
