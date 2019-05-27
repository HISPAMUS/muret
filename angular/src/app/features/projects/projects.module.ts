import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProjectsRoutingModule } from './projects-routing.module';
import { ProjectsComponent } from './components/projects/projects.component';
import {SharedModule} from '../../shared/shared.module';
import {StoreModule} from '@ngrx/store';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';
import { CollectionsComponent } from './components/collections/collections.component';
import {EffectsModule} from '@ngrx/effects';
import {projectsReducers} from './store/reducers/projects.reducers';
import {ProjectsEffects} from './store/effects/projects.effects';
import {ProjectsService} from './services/projects.service';

@NgModule({
  declarations: [ProjectsComponent, CollectionsComponent],
  imports: [
    CommonModule,
    ProjectsRoutingModule,
    SharedModule,
    BreadcrumbModule,
    StoreModule.forFeature('projects', projectsReducers),
    EffectsModule.forFeature([ProjectsEffects]),
  ],
  providers: [ProjectsService]
})
export class ProjectsModule { }
