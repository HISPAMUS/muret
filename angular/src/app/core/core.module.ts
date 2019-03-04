import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {EffectsModule} from '@ngrx/effects';
import {StoreModule} from '@ngrx/store';
import {StoreRouterConnectingModule} from '@ngrx/router-store';
import {environment} from '../../environments/environment';
import {StoreDevtoolsModule} from '@ngrx/store-devtools';
import {coreReducers} from './store/reducers/core.reducers';
import {UserEffects} from './store/effects/user.effects';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    StoreModule.forFeature('core', coreReducers),
    StoreRouterConnectingModule.forRoot(),
    StoreRouterConnectingModule.forRoot({ stateKey: 'router' }),
    EffectsModule.forFeature([UserEffects]),
    environment.production
      ? []
      : StoreDevtoolsModule.instrument({
        name: 'MuRET'
      }),  ]
})
export class CoreModule { }