import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { LayoutComponent } from './components/layout/layout.component';
import {NgbModule, NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import {BreadcrumbComponent} from "./components/breadcrumb/breadcrumb.component";
import {StoreModule} from "@ngrx/store";
import {breadcrumbsReducers} from "./store/reducers/breadcrumbs.reducers";
import { ServerStateComponent } from './components/server-state/server-state.component';
import { AvatarComponent } from './components/avatar/avatar.component';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { HamburguerMenuComponent } from './components/hamburguer-menu/hamburguer-menu.component';

@NgModule({
  declarations: [LayoutComponent, BreadcrumbComponent, ServerStateComponent, AvatarComponent, HamburguerMenuComponent],
  imports: [
    CommonModule,
    RouterModule,
    NgbTooltipModule,
    NgbModule,
    StoreModule.forFeature('breadcrumbs', breadcrumbsReducers),
    FontAwesomeModule
  ],
  exports: [
    LayoutComponent,
    BreadcrumbComponent
  ]
})
export class LayoutModule { }
