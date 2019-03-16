import { Component, OnInit } from '@angular/core';
import {SimpleModalComponent} from 'ngx-simple-modal';

export interface ConfirmModel {
  title: string;
  message: string;
}

@Component({
  selector: 'app-confirm-dialog',
  templateUrl: './confirm-dialog.component.html',
  styleUrls: ['./confirm-dialog.component.css']
})
export class ConfirmDialogComponent extends SimpleModalComponent<ConfirmModel, boolean> implements ConfirmModel {
  title: string;
  message: string;
  constructor() {
    super();
  }
  confirm() {
    // on click on confirm button we set dialog result as true,
    // ten we can get dialog result from caller code
    this.result = true;
    this.close();
  }
  cancel() {
    this.result = false;
    this.close();
  }
}
