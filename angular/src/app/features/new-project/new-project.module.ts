import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewProjectRoutingModule } from './new-project-routing.module';
import { NewProjectComponent } from './components/new-project/new-project.component';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';

@NgModule({
  declarations: [NewProjectComponent],
  imports: [
    CommonModule,
    NewProjectRoutingModule,
    BreadcrumbModule,
  ]
})
export class NewProjectModule { }
