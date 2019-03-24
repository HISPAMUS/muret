import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SemanticRepresentationRoutingModule } from './semantic-representation-routing.module';
import { SemanticRepresentationComponent } from './components/semantic-representation/semantic-representation.component';
import {SemanticRepresentationService} from './services/semantic-representation.service';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {semanticRepresentationReducers} from './store/reducers/semantic-representation.reducers';
import {SemanticRepresentationEffects} from './store/effects/semantic-representation.effects';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';

@NgModule({
  declarations: [SemanticRepresentationComponent],
  imports: [
    CommonModule,
    FontAwesomeModule,
    BreadcrumbModule,
    StoreModule.forFeature('semantic-representation', semanticRepresentationReducers),
    EffectsModule.forFeature([SemanticRepresentationEffects]),

  ],
  providers: [
    SemanticRepresentationService
  ]
})
export class SemanticRepresentationModule { }
