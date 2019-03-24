import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProjectsRoutingModule } from './projects-routing.module';
import { ProjectsComponent } from './components/projects/projects.component';
import {SharedModule} from '../../shared/shared.module';
import {StoreModule} from '@ngrx/store';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';

@NgModule({
  declarations: [ProjectsComponent],
  imports: [
    CommonModule,
    ProjectsRoutingModule,
    SharedModule,
    BreadcrumbModule,
    StoreModule.forFeature('projects', [])
  ],
  providers: []
})
export class ProjectsModule { }
