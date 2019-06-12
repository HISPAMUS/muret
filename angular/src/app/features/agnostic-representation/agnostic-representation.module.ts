import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgnosticRepresentationRoutingModule } from './agnostic-representation-routing.module';
import { AgnosticRepresentationComponent } from './components/agnostic-representation/agnostic-representation.component';
import {AgnosticRepresentationService} from './services/agnostic-representation.service';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {agnosticRepresentationReducers} from './store/reducers/agnostic-representation.reducers';
import {AgnosticRepresentationEffects} from './store/effects/agnostic-representation.effects';
import {DocumentAnalysisModule} from '../document-analysis/document-analysis.module';
import { AgnosticStaffComponent } from './components/agnostic-staff/agnostic-staff.component';
import { AgnosticToolbarComponent } from './components/agnostic-toolbar/agnostic-toolbar.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {NgbButtonsModule, NgbCollapseModule, NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import {AngularSvgIconModule} from 'angular-svg-icon';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SharedModule} from '../../shared/shared.module';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';
import { AgnosticToolbarIconComponent } from './components/agnostic-toolbar-icon/agnostic-toolbar-icon.component';
import {PositionInStaffService} from './services/position-in-staff.service';
import { ImagePreviewComponent } from './components/image-preview/image-preview.component';

@NgModule({
  declarations: [AgnosticRepresentationComponent, AgnosticStaffComponent, AgnosticToolbarComponent, AgnosticToolbarIconComponent, ImagePreviewComponent],
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
    BreadcrumbModule,
    StoreModule.forFeature('agnostic-representation', agnosticRepresentationReducers),
    EffectsModule.forFeature([AgnosticRepresentationEffects]),
    // for Image component - set after routing for avoiding document analysis route override this module routes and store
    DocumentAnalysisModule
  ],
  exports: [
    ImagePreviewComponent
  ],
  entryComponents: [
    ImagePreviewComponent
  ],
  providers: [
    AgnosticRepresentationService, PositionInStaffService
  ]
})
export class AgnosticRepresentationModule { }
