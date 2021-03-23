import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DocumentComponentOld} from './components/document-old/document-component-old.component';
import {DocumentComponent} from "./components/document/document.component";
import {ReorderSectionsComponent} from "./components/reorder-sections/reorder-sections.component";
import {ReorderImagesComponent} from "./components/reorder-images/reorder-images.component";
import {InstrumentsComponent} from "./components/instruments-old/instruments.component";
import {UploadImagesComponent} from "./components/upload-images-old/upload-images.component";
import {DocumentScoreViewerAndExporterComponentOLD} from "./components/document-score-viewer-and-exporter-old/document-score-viewer-and-exporter-component-o-l-d.component";
import {MEIScoreViewerComponent} from "./components/mei-score-viewer/meiscore-viewer.component";
import {AlignmentPreviewComponent} from "./components/alignment-preview-old/alignment-preview.component";

const routes: Routes = [
  { path: 'old/:id', component: DocumentComponentOld },
  { path: ':id', component: DocumentComponent },
  { path: 'reorderSections/:id', component: ReorderSectionsComponent },
  { path: 'reorderImages/:id', component: ReorderImagesComponent },
  { path: 'instruments/:id', component: InstrumentsComponent },
  { path: 'uploadImages/:id', component: UploadImagesComponent },
  { path: 'documentScoreViewAndExportOLD/:id', component: DocumentScoreViewerAndExporterComponentOLD },
  //used as a modal dialog { path: 'meiScoreView', component: MEIScoreViewerComponent },
  { path: 'alignmentPreview/:id', component: AlignmentPreviewComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocumentRoutingModule { }
