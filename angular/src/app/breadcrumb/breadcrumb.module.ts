import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BreadcrumbComponent } from './components/breadcrumb/breadcrumb.component';
import {RouterModule} from '@angular/router';
import {StoreModule} from '@ngrx/store';
import {breadcrumbsReducers} from './store/reducers/breadcrumbs.reducers';

/**
 * Use this manual breadcrumb component for simplicity and flexibility
 */
@NgModule({
  declarations: [
    BreadcrumbComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    StoreModule.forFeature('breadcrumbs', breadcrumbsReducers),
  ],
  exports: [
    BreadcrumbComponent
  ],
  entryComponents: [
    BreadcrumbComponent
  ]
})
export class BreadcrumbModule { }
