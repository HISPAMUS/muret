import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExportRoutingModule } from './export-routing.module';
import {TrainingSetsComponent} from './components/training-sets/training-sets.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {ExportEffects} from './store/effects/export-effects.service';
import {ExporterService} from './services/exporter.service';
import {NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import {TreeviewModule} from 'ngx-treeview';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {exportReducers} from './store/reducers/export.reducers';

@NgModule({
  declarations: [TrainingSetsComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ExportRoutingModule,
    StoreModule.forFeature('export', exportReducers),
    EffectsModule.forFeature([ExportEffects]),
    NgbTooltipModule,
    TreeviewModule.forRoot(),
    FontAwesomeModule,
    FormsModule
  ],
  providers: [
    ExporterService
  ]
})
export class ExportModule { }
