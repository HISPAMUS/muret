import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExportRoutingModule } from './export-routing.module';
import {TrainingSetsComponent} from './components/training-sets/training-sets.component';
import {ReactiveFormsModule} from '@angular/forms';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {TrainingSetExportersEffects} from './store/effects/training-set-exporters.effects';
import {ExporterService} from './services/exporter.service';
import {TrainingSetExporterService} from './services/training-set-exporter.service';
import {exportReducers} from './store/reducers/export.reducers';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';

@NgModule({
  declarations: [TrainingSetsComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ExportRoutingModule,
    BreadcrumbModule,
    StoreModule.forFeature('export', exportReducers),
    EffectsModule.forFeature([TrainingSetExportersEffects]),
  ],
  providers: [
    ExporterService, TrainingSetExporterService
  ]
})
export class ExportModule { }
