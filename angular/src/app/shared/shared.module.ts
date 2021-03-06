import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StateComponent} from './components/state/state.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {SimpleModalModule} from 'ngx-simple-modal';
import { AlertComponent } from './components/error-modal-message/alert.component';
import { ConfirmDialogComponent } from './components/confirm-dialog/confirm-dialog.component';
import { CrudToolbarComponent } from './components/crud-toolbar/crud-toolbar.component';
import {NgbButtonsModule, NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {InputDialogComponent} from './components/input-dialog/input-dialog.component';
import { SafePipe } from './pipes/safe.pipe';
import { ConfirmDialogWarningComponent } from './components/confirm-dialog-warning/confirm-dialog-warning.component';
import { OptionsDialogComponent } from './components/options-dialog/options-dialog.component';
import { LinksModalDialogComponent } from './components/links-modal-dialog/links-modal-dialog.component';

@NgModule({
  imports: [
    CommonModule,
    FontAwesomeModule,
    SimpleModalModule,
    FormsModule,
    ReactiveFormsModule,
    NgbButtonsModule,
    NgbTooltipModule
  ],
  declarations: [
    StateComponent,
    AlertComponent,
    ConfirmDialogComponent,
    InputDialogComponent,
    CrudToolbarComponent,
    SafePipe,
    ConfirmDialogWarningComponent,
    OptionsDialogComponent,
    LinksModalDialogComponent
  ],
  exports: [
    StateComponent,
    AlertComponent,
    ConfirmDialogComponent,
    InputDialogComponent,
    CrudToolbarComponent,
    ConfirmDialogWarningComponent,
    OptionsDialogComponent,
    LinksModalDialogComponent,
    SafePipe
  ],
  entryComponents: [
    AlertComponent,
    ConfirmDialogComponent,
    ConfirmDialogWarningComponent,
    OptionsDialogComponent,
    InputDialogComponent,
    LinksModalDialogComponent,
    CrudToolbarComponent
  ],
  providers: []
})
export class SharedModule {
}
