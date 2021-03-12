import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ImageOverviewComponent} from "./components/phases/image-overview/image-overview.component";
import {PartsInImageComponentComponent} from "./components/phases/parts-in-image/parts-in-image-component.component";
import {DocumentAnalysisComponent} from "./components/phases/document-analysis/document-analysis/document-analysis.component";
import {TranscriptionComponentComponent} from "./components/phases/transcription/transcription/transcription-component.component";

const routes: Routes = [
  { path: 'overview/:id', component: ImageOverviewComponent },
  { path: 'documentAnalysis/:id', component: DocumentAnalysisComponent },
  { path: 'parts/:id', component: PartsInImageComponentComponent },
  { path: 'transcription/:id', component: TranscriptionComponentComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ImageRecognitionRoutingModule { }
