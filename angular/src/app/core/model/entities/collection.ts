import {Document} from './document';
import {Entity} from './entity';

export interface Collection extends Entity {
  name?: string;
  comments?: string;
  documents?: Document[];
  thumbnailBase64Encoding?: string;
}
