import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ImageOverviewComponent} from "./components/image-overview/image-overview.component";
import {PartsInImageComponentComponent} from "./components/parts-in-image/parts-in-image-component.component";
import {DocumentAnalysisComponent} from "./components/document-analysis/document-analysis.component";
import {TranscriptionComponentComponent} from "./components/transcription/transcription-component.component";

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
