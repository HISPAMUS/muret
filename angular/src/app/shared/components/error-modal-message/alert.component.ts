import { Component, OnInit } from '@angular/core';
import {SimpleModalComponent} from 'ngx-simple-modal';

export interface AlertModel {
  title: string;
  message: string;
}

@Component({
  selector: 'app-error-modal-message',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent extends SimpleModalComponent<AlertModel, null> implements AlertModel {
  title: string;
  message: string;
  constructor() {
    super();
  }
}
