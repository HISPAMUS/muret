import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './components/home/home.component';
import {StoreModule} from "@ngrx/store";
import {EffectsModule} from "@ngrx/effects";
import {HomeEffects} from "./store/effects/home-effects.service";
import {homeReducers} from "./store/reducers/home.reducers";
import {HomeService} from "./services/home.service";

@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,
    StoreModule.forFeature('home', homeReducers),
    EffectsModule.forFeature([HomeEffects]),
    HomeRoutingModule
  ],
  providers: [
    HomeService
  ]
})
export class HomeModule { }
