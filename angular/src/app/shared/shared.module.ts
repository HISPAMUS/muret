import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StateComponent} from './components/state/state.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';

@NgModule({
  imports: [
    CommonModule,
    FontAwesomeModule
   ],
  declarations: [
    StateComponent
  ],
  exports: [
    StateComponent
  ],
  providers: []
})
export class SharedModule {
}
