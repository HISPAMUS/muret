import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AlertComponent} from "./error-modal-message/alert.component";
import {ConfirmDialogComponent} from "./confirm-dialog/confirm-dialog.component";
import {InputDialogComponent} from "./input-dialog/input-dialog.component";
import {ConfirmDialogWarningComponent} from "./confirm-dialog-warning/confirm-dialog-warning.component";
import {OptionsDialogComponent} from "./options-dialog/options-dialog.component";
import {LinksModalDialogComponent} from "./links-modal-dialog/links-modal-dialog.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SimpleModalModule} from "ngx-simple-modal";



@NgModule({
  imports: [
    CommonModule,
    SimpleModalModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  declarations: [
    AlertComponent,
    ConfirmDialogComponent,
    InputDialogComponent,
    ConfirmDialogWarningComponent,
    OptionsDialogComponent,
    LinksModalDialogComponent,
  ],
  exports: [
    AlertComponent,
    ConfirmDialogComponent,
    InputDialogComponent,
    ConfirmDialogWarningComponent,
    OptionsDialogComponent,
    LinksModalDialogComponent
  ],
  entryComponents: [
    AlertComponent,
    ConfirmDialogComponent,
    InputDialogComponent,
    ConfirmDialogWarningComponent,
    OptionsDialogComponent,
    LinksModalDialogComponent
  ]
})
export class DialogsModule { }
