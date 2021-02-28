import {Page} from './page';
import {State} from './state';
import {Entity} from './entity';
import {Part} from './part';
import {IOrdered} from "./iordered";

export interface Image extends Entity, IOrdered {
  hidden: boolean;
  sectionId?: number;
  documentId?: number; // if the sectionID is null the image is unassigned to a section, then documentId must be not null
  filename: string;
  pages: Page[];
  state: State;
  part: Part;
}

