import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SemanticRepresentationRoutingModule } from './semantic-representation-routing.module';
import { SemanticRepresentationComponent } from './components/semantic-representation/semantic-representation.component';

@NgModule({
  declarations: [SemanticRepresentationComponent],
  imports: [
    CommonModule,
    SemanticRepresentationRoutingModule
  ]
})
export class SemanticRepresentationModule { }
