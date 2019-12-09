import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProjectComponent} from './components/project/project.component';
import {UploadImagesComponent} from './components/upload-images/upload-images.component';
import {ProjectScoreViewerComponent} from './components/project-score-viewer/project-score-viewer.component';
import {InstrumentsComponent} from './components/instruments/instruments.component';

const routes: Routes = [
  { path: ':id', component: ProjectComponent },
  { path: 'instruments/:id', component: InstrumentsComponent },
  { path: 'uploadImages/:id', component: UploadImagesComponent },
  { path: 'scoreView/:id', component: ProjectScoreViewerComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectRoutingModule { }
