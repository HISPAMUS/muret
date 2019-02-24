import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProjectRoutingModule } from './project-routing.module';
import { ProjectComponent } from './components/project/project.component';
import {ImageThumbnailComponent} from './components/image-thumbnail/image-thumbnail.component';
import {LightboxModule} from 'ngx-lightbox';

@NgModule({
  declarations: [ProjectComponent, ImageThumbnailComponent],
  imports: [
    CommonModule,
    ProjectRoutingModule,
    LightboxModule
  ]
})
export class ProjectModule { }
