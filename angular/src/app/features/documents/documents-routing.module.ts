import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DocumentsComponent} from './components/documents/documents.component';
import {CollectionsComponent} from './components/collections/collections.component';

const routes: Routes = [
  { path: 'collections', component: CollectionsComponent },
  { path: 'documents/:id', component: DocumentsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocumentsRoutingModule { }
