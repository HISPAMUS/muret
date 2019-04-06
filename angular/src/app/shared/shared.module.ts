import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StateComponent} from './components/state/state.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {SimpleModalModule} from 'ngx-simple-modal';
import { AlertComponent } from './components/error-modal-message/alert.component';
import { ConfirmDialogComponent } from './components/confirm-dialog/confirm-dialog.component';
import { CrudToolbarComponent } from './components/crud-toolbar/crud-toolbar.component';
import {NgbButtonsModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FontAwesomeModule,
    SimpleModalModule,
    FormsModule,
    ReactiveFormsModule,
    NgbButtonsModule
  ],
  declarations: [
    StateComponent,
    AlertComponent,
    ConfirmDialogComponent,
    CrudToolbarComponent
  ],
  exports: [
    StateComponent,
    AlertComponent,
    ConfirmDialogComponent,
    CrudToolbarComponent
  ],
  entryComponents: [
    AlertComponent,
    ConfirmDialogComponent,
    CrudToolbarComponent
  ],
  providers: []
})
export class SharedModule {
}
