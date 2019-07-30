import {Page} from './page';
import {State} from './state';
import {Entity} from './entity';
import {Part} from './part';

export interface Image extends Entity {
  project_id: number;
  filename: string;
  pages: Page[];
  state: State;
  part: Part;
}
