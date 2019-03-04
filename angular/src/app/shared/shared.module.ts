import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StateComponent} from './components/state/state.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {SimpleModalModule} from 'ngx-simple-modal';
import { AlertComponent } from './components/error-modal-message/alert.component';
import { ConfirmDialogComponent } from './components/confirm-dialog/confirm-dialog.component';

@NgModule({
  imports: [
    CommonModule,
    FontAwesomeModule,
    SimpleModalModule
  ],
  declarations: [
    StateComponent,
    AlertComponent,
    ConfirmDialogComponent
  ],
  exports: [
    StateComponent,
    AlertComponent,
    ConfirmDialogComponent
  ],
  entryComponents: [
    AlertComponent,
    ConfirmDialogComponent
  ],
  providers: []
})
export class SharedModule {
}
