import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { LayoutComponent } from './components/layout/layout.component';
import { NgbTooltipModule } from '@ng-bootstrap/ng-bootstrap';
import {BreadcrumbComponent} from "./components/breadcrumb/breadcrumb.component";
import {StoreModule} from "@ngrx/store";
import {breadcrumbsReducers} from "./store/reducers/breadcrumbs.reducers";

@NgModule({
  declarations: [LayoutComponent, BreadcrumbComponent],
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
