import {Page} from './page';
import {State} from './state';
import {Entity} from './entity';
import {Part} from './part';
import {Section} from "./section";

export interface Image extends Entity {
  sectionId?: number;
  documentId?: number; // if the sectionID is null the image is unassigned to a section, then documentId must be not null
  filename: string;
  pages: Page[];
  state: State;
  part: Part;
}
