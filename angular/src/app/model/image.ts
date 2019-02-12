import {Page} from './page';
import {State} from './state';

export class Image {
  id: number;
  filename: string;
  pages: Array<Page>;
  state: State;
  constructor(id: number, filename: string, pages: Array<Page>, state: State) {
    this.id = id;
    this.filename = filename;
    this.pages = pages;
    this.state = state;
  }
}
