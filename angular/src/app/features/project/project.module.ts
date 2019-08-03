import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProjectRoutingModule } from './project-routing.module';
import { ProjectComponent } from './components/project/project.component';
import {ImageThumbnailComponent} from './components/image-thumbnail/image-thumbnail.component';
// import {LightboxModule} from 'ngx-lightbox';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {ProjectService} from './services/project.service';
import {ProjectEffects} from './store/effects/project.effects';
import {projectReducers} from './store/reducers/project.reducers';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';
import { UploadImagesComponent } from './components/upload-images/upload-images.component';
import {FileUploadModule} from 'ng2-file-upload';
import { ProjectScoreViewerComponent } from './components/project-score-viewer/project-score-viewer.component';
import {SharedModule} from '../../shared/shared.module';
import {NgbDropdownModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [ProjectComponent, ImageThumbnailComponent, UploadImagesComponent, ProjectScoreViewerComponent],
  imports: [
    CommonModule,
    ProjectRoutingModule,
    // TODO When > 1.2.0
    /// LightboxModule,
    FileUploadModule,
    NgbDropdownModule,
    StoreModule.forFeature('project', projectReducers),
    EffectsModule.forFeature([ProjectEffects]),
    BreadcrumbModule,
    SharedModule,
  ],
  providers: [
    ProjectService
  ]
})
export class ProjectModule { }
