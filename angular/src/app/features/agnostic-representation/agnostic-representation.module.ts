import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgnosticRepresentationRoutingModule } from './agnostic-representation-routing.module';
import { AgnosticRepresentationComponent } from './components/agnostic-representation/agnostic-representation.component';

@NgModule({
  declarations: [AgnosticRepresentationComponent],
  imports: [
    CommonModule,
    AgnosticRepresentationRoutingModule
  ]
})
export class AgnosticRepresentationModule { }
