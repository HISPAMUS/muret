import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DocumentComponentOld} from './components/document/document-component-old.component';
import {UploadImagesComponent} from './components/upload-images/upload-images.component';
import {DocumentScoreViewerAndExporterComponent} from './components/document-score-viewer-and-exporter/document-score-viewer-and-exporter.component';
import {InstrumentsComponent} from './components/instruments/instruments.component';
import {AlignmentPreviewComponent} from './components/alignment-preview/alignment-preview.component';
import {MEIScoreViewerComponent} from './components/mei-score-viewer/meiscore-viewer.component';
import {DocumentComponent} from "./components/document/document.component";
import {ReorderSectionsComponent} from "./components/reorder-sections/reorder-sections.component";
import {ReorderImagesComponent} from "./components/reorder-images/reorder-images.component";

const routes: Routes = [
  { path: 'old/:id', component: DocumentComponentOld },
  { path: ':id', component: DocumentComponent },
  { path: 'reorderSections/:id', component: ReorderSectionsComponent },
  { path: 'reorderImages/:id', component: ReorderImagesComponent },
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
