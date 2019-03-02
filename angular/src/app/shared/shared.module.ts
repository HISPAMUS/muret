import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StateComponent} from './components/state/state.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {SimpleModalModule} from 'ngx-simple-modal';
import { AlertComponent } from './components/error-modal-message/alert.component';

@NgModule({
  imports: [
    CommonModule,
    FontAwesomeModule,
    SimpleModalModule
  ],
  declarations: [
    StateComponent,
    AlertComponent
  ],
  exports: [
    StateComponent,
    AlertComponent
  ],
  entryComponents: [
    AlertComponent
  ],
  providers: []
})
export class SharedModule {
}
