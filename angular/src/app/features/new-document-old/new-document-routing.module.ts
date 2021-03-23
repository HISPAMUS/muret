import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NewDocumentComponent} from './components/new-document/new-document.component';

const routes: Routes = [
  { path: '', component: NewDocumentComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NewDocumentRoutingModule { }
