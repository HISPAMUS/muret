import {Page} from './page';
import {State} from './state';

export interface Image {
  id: number;
  filename: string;
  pages: Page[];
  state: State;
}
