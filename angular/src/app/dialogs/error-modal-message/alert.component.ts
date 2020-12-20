import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import {SimpleModalComponent} from 'ngx-simple-modal';

export interface AlertModel {
  title: string;
  message: string;
  specificMessage: string;
}

export interface ErrorModel
{
  errorStatus: number,
  errorType: string,
  errorMessage: string
}

@Component({
  selector: 'app-error-modal-message',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})

export class AlertComponent extends SimpleModalComponent<AlertModel, null> implements AlertModel {
  title: string;
  message: string;
  specificMessage: string;

  @ViewChild('info', {static: true}) infoBlock: ElementRef;

  constructor() 
  {
    super();
  }

  showInfo()
  {
    this.infoBlock.nativeElement.hidden = false;
  }
}
