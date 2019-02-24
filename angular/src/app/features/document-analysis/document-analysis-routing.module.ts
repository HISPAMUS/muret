import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DocumentAnalysisComponent} from './document-analysis/document-analysis.component';

const routes: Routes = [
  { path: ':id', component: DocumentAnalysisComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocumentAnalysisRoutingModule { }
