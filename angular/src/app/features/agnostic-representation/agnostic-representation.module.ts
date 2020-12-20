import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgnosticRepresentationRoutingModule } from './agnostic-representation-routing.module';
import { AgnosticRepresentationComponent } from './components/agnostic-representation/agnostic-representation.component';
import {AgnosticRepresentationService} from './services/agnostic-representation.service';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {agnosticRepresentationReducers} from './store/reducers/agnostic-representation.reducers';
import {AgnosticRepresentationEffects} from './store/effects/agnostic-representation.effects';
import { AgnosticStaffComponent } from './components/agnostic-staff/agnostic-staff.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {NgbButtonsModule, NgbCollapseModule, NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import {AngularSvgIconModule} from 'angular-svg-icon';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SharedModule} from '../../shared/shared.module';
import { AgnosticOrSemanticToolbarIconComponent } from '../../shared/components/agnostic-or-semantic-toolbar-icon/agnostic-or-semantic-toolbar-icon.component';
import {PositionInStaffService} from '../../shared/services/position-in-staff.service';

@NgModule({
  declarations: [AgnosticRepresentationComponent, AgnosticStaffComponent],
  imports: [
    CommonModule,
    FontAwesomeModule,
    AgnosticRepresentationRoutingModule,
    AngularSvgIconModule,
    FormsModule,
    ReactiveFormsModule,
    NgbButtonsModule,
    NgbCollapseModule,
    NgbTooltipModule,
    SharedModule,
    StoreModule.forFeature('agnostic-representation', agnosticRepresentationReducers),
    EffectsModule.forFeature([AgnosticRepresentationEffects]),
  ],
  exports: [
    AgnosticStaffComponent
  ],
  providers: [
    AgnosticRepresentationService, PositionInStaffService
  ]
})
export class AgnosticRepresentationModule { }
