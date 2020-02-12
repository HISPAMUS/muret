import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DocumentComponent} from './components/document/document.component';
import {UploadImagesComponent} from './components/upload-images/upload-images.component';
import {DocumentScoreViewerComponent} from './components/document-score-viewer/document-score-viewer.component';
import {InstrumentsComponent} from './components/instruments/instruments.component';
import {AlignmentPreviewComponent} from './components/alignment-preview/alignment-preview.component';

const routes: Routes = [
  { path: ':id', component: DocumentComponent },
  { path: 'instruments/:id', component: InstrumentsComponent },
  { path: 'uploadImages/:id', component: UploadImagesComponent },
  { path: 'scoreView/:id', component: DocumentScoreViewerComponent },
  { path: 'alignmentPreview/:id', component: AlignmentPreviewComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocumentRoutingModule { }
