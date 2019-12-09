import { Component, OnInit } from '@angular/core';
import {SimpleModalComponent} from 'ngx-simple-modal';

export interface InputModel {
  title: string;
  currentValue?: string;
}

@Component({
  selector: 'app-confirm-dialog',
  templateUrl: './input-dialog.component.html',
  styleUrls: ['./input-dialog.component.css']
})
export class InputDialogComponent extends SimpleModalComponent<InputModel, string> implements InputModel {
  title: string;
  currentValue: string;
  message: string;
  constructor() {
    super();
    this.message = "How many pages do you want to create?"
    this.currentValue = "1";
  }
  confirm() {
    // on click on confirm button we set dialog result as true,
    // then we can get dialog result from caller code
    this.result = this.currentValue;
    this.close();
  }
  cancel() {
    this.result = null;
    this.close();
  }
}
