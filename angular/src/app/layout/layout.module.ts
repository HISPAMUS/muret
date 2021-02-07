import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { LayoutComponent } from './components/layout/layout.component';
import {NgbModule, NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import {BreadcrumbsComponent} from "./components/breadcrumbs/breadcrumbs.component";
import {StoreModule} from "@ngrx/store";
import {breadcrumbsReducers} from "./store/reducers/breadcrumbs.reducers";
import { ServerStateComponent } from './components/server-state/server-state.component';
import { AvatarComponent } from './components/avatar/avatar.component';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { HamburguerMenuComponent } from './components/hamburguer-menu/hamburguer-menu.component';
import {EffectsModule} from "@ngrx/effects";
import {BreadcrumbsEffects} from "./store/effects/breadcrumbs.effects";
import {BreadcrumbsService} from "./services/breadcrumbs.service";

@NgModule({
  declarations: [LayoutComponent, BreadcrumbsComponent, ServerStateComponent, AvatarComponent, HamburguerMenuComponent],
  imports: [
    CommonModule,
    RouterModule,
    NgbTooltipModule,
    NgbModule,
    StoreModule.forFeature('breadcrumbs', breadcrumbsReducers),
    EffectsModule.forFeature([BreadcrumbsEffects]),
    FontAwesomeModule
  ],
  exports: [
    LayoutComponent,
    BreadcrumbsComponent
  ],
  providers: [
    BreadcrumbsService
  ]

})
export class LayoutModule { }
