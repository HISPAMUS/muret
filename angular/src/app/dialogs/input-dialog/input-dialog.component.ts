import { Component, OnInit } from '@angular/core';
import {SimpleModalComponent} from 'ngx-simple-modal';

export interface InputModel {
  title: string;
  message?: string;
  currentValue?: string;
  singleLine?: boolean;
}

@Component({
  selector: 'app-confirm-dialog',
  templateUrl: './input-dialog.component.html',
  styleUrls: ['./input-dialog.component.css']
})
export class InputDialogComponent extends SimpleModalComponent<InputModel, string> implements InputModel {
  title: string;
  message: string;
  currentValue: string;
  singleLine?: boolean;

  constructor() {
    super();
    this.currentValue = '1';
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
