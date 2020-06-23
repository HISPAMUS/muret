import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { LayoutComponent } from './components/layout/layout.component';
import {BreadcrumbModule} from '../breadcrumb/breadcrumb.module';
import { NgbTooltipModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [LayoutComponent],
  imports: [
    CommonModule,
    RouterModule,
    BreadcrumbModule,
    NgbTooltipModule
  ],
  exports: [
    LayoutComponent
  ]
})
export class LayoutModule { }
