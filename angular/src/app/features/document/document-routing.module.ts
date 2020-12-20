import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DocumentComponent} from './components/document/document.component';
import {UploadImagesComponent} from './components/upload-images/upload-images.component';
import {DocumentScoreViewerAndExporterComponent} from './components/document-score-viewer-and-exporter/document-score-viewer-and-exporter.component';
import {InstrumentsComponent} from './components/instruments/instruments.component';
import {AlignmentPreviewComponent} from './components/alignment-preview/alignment-preview.component';
import {MEIScoreViewerComponent} from './components/mei-score-viewer/meiscore-viewer.component';

const routes: Routes = [
  { path: ':id', component: DocumentComponent },
  { path: 'instruments/:id', component: InstrumentsComponent },
  { path: 'uploadImages/:id', component: UploadImagesComponent },
  { path: 'documentScoreViewAndExport/:id', component: DocumentScoreViewerAndExporterComponent },
  { path: 'meiScoreView/:id', component: MEIScoreViewerComponent },
  { path: 'alignmentPreview/:id', component: AlignmentPreviewComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocumentRoutingModule { }
