import { Component, AfterViewInit } from '@angular/core';
import { SimpleModalComponent} from 'ngx-simple-modal';

export class ModalOptions {
  id: string;
  name: string;
}

export interface OptionsModel {
  title: string;
  ids?: string[];
  names?: string[];
  newValueMessage: string;
}

@Component({
  selector: 'app-options-dialog',
  templateUrl: './options-dialog.component.html',
  styleUrls: ['./options-dialog.component.css']
})
export class OptionsDialogComponent extends SimpleModalComponent<OptionsModel, ModalOptions> implements OptionsModel {

  title: string;
  ids: string[];
  names: string[];
  currentValue: number;
  inputValue: string;
  response: ModalOptions;
  newValueMessage: string;

  constructor() {
    super();
    this.currentValue = 0;
  }

  confirm() {
    this.response = new ModalOptions();

    if (+this.currentValue === -1) {
      this.response.id = null;
      this.response.name = this.inputValue;
    } else {
      this.response.id = this.ids[this.currentValue];
      this.response.name = this.names[this.currentValue];
    }

    this.result = this.response;

    this.close();
  }

  cancel() {
    this.result = null;
    this.close();
  }

}

