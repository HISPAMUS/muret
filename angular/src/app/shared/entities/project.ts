import {Image} from './image';
import {State} from './state';
import {Entity} from './entity';

export interface Project extends Entity {
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
}
