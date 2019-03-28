import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SampleRoutingModule } from './sample-routing.module';
import { SampleComponent } from './components/sample/sample.component';
import {SampleService} from './services/sample.service';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {sampleReducers} from './store/reducers/sample.reducers';
import {SampleEffects} from './store/effects/sample.effects';

@NgModule({
  declarations: [SampleComponent],
  imports: [
    CommonModule,
    SampleRoutingModule,
    StoreModule.forFeature('sample', sampleReducers),
    EffectsModule.forFeature([SampleEffects]),

  ],
  providers: [
    SampleService
  ]
})
export class SampleModule { }
