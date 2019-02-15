import {Image} from './image';
import {State} from './state';

export interface Project {
  id: number;
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
