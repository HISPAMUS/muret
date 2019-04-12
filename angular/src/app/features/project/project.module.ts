import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProjectRoutingModule } from './project-routing.module';
import { ProjectComponent } from './components/project/project.component';
import {ImageThumbnailComponent} from './components/image-thumbnail/image-thumbnail.component';
import {LightboxModule} from 'ngx-lightbox';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {ProjectService} from './services/project.service';
import {ProjectEffects} from './store/effects/project.effects';
import {projectReducers} from './store/reducers/project.reducers';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';
import { UploadImagesComponent } from './components/upload-images/upload-images.component';
import {FileUploadModule} from 'ng2-file-upload';

@NgModule({
  declarations: [ProjectComponent, ImageThumbnailComponent, UploadImagesComponent],
  imports: [
    CommonModule,
    ProjectRoutingModule,
    LightboxModule,
    FileUploadModule,
    StoreModule.forFeature('project', projectReducers),
    EffectsModule.forFeature([ProjectEffects]),
    BreadcrumbModule,
  ],
  providers: [
    ProjectService
  ]
})
export class ProjectModule { }
