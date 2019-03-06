import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgnosticRepresentationRoutingModule } from './agnostic-representation-routing.module';
import { AgnosticRepresentationComponent } from './components/agnostic-representation/agnostic-representation.component';
import {AgnosticRepresentationService} from './services/agnostic-representation.service';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {agnosticRepresentationReducers} from './store/reducers/agnostic-representation.reducers';
import {AgnosticRepresentationEffects} from './store/effects/agnostic-representation.effects';

@NgModule({
  declarations: [AgnosticRepresentationComponent],
  imports: [
    CommonModule,
    AgnosticRepresentationRoutingModule,
    StoreModule.forFeature('agnostic-representation', agnosticRepresentationReducers),
    EffectsModule.forFeature([AgnosticRepresentationEffects]),

  ],
  providers: [
    AgnosticRepresentationService
  ]
})
export class AgnosticRepresentationModule { }
