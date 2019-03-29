import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProjectComponent} from './components/project/project.component';
import {UploadImagesComponent} from './components/upload-images/upload-images.component';

const routes: Routes = [
  { path: ':id', component: ProjectComponent },
  { path: 'uploadImages/:id', component: UploadImagesComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectRoutingModule { }
