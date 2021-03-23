import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SemanticRepresentationComponent } from './components/semantic-representation/semantic-representation.component';
import {SemanticRepresentationService} from './services/semantic-representation.service';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {semanticRepresentationReducers} from './store/reducers/semantic-representation.reducers';
import {SemanticRepresentationEffects} from './store/effects/semantic-representation.effects';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {SemanticRepresentationRoutingModule} from './semantic-representation-routing.module';
import { NotationComponent } from './components/notation/notation.component';
import {SharedModule} from '../../shared/shared.module';
import {NgbCollapseModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {AgGridModule} from 'ag-grid-angular';

@NgModule({
  declarations: [SemanticRepresentationComponent, NotationComponent],
  imports: [
    CommonModule,
    FontAwesomeModule,
    FormsModule,
    SharedModule,
    SemanticRepresentationRoutingModule,
    StoreModule.forFeature('semantic-representation', semanticRepresentationReducers),
    EffectsModule.forFeature([SemanticRepresentationEffects]),
    NgbCollapseModule,
    FormsModule,
    AgGridModule,

  ],
  providers: [
    SemanticRepresentationService
  ]
})
export class SemanticRepresentationModule { }
