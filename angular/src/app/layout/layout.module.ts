import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { LayoutComponent } from './components/layout/layout.component';
import { NgbTooltipModule } from '@ng-bootstrap/ng-bootstrap';
import {BreadcrumbComponent} from "./components/breadcrumb/breadcrumb.component";
import {StoreModule} from "@ngrx/store";
import {breadcrumbsReducers} from "./store/reducers/breadcrumbs.reducers";
import { ServerStateComponent } from './components/server-state/server-state.component';
import { AvatarComponent } from './components/avatar/avatar.component';

@NgModule({
  declarations: [LayoutComponent, BreadcrumbComponent, ServerStateComponent, AvatarComponent],
  imports: [
    CommonModule,
    RouterModule,
    NgbTooltipModule,
    StoreModule.forFeature('breadcrumbs', breadcrumbsReducers),
  ],
  exports: [
    LayoutComponent,
    BreadcrumbComponent
  ]
})
export class LayoutModule { }
