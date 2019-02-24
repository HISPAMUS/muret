import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExportRoutingModule } from './export-routing.module';
import {TrainingSetsComponent} from './components/training-sets/training-sets.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [TrainingSetsComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ExportRoutingModule
  ]
})
export class ExportModule { }
