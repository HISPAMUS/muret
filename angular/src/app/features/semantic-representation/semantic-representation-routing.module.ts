import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SemanticRepresentationComponent} from './components/semantic-representation/semantic-representation.component';

const routes: Routes = [
  { path: ':id', component: SemanticRepresentationComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SemanticRepresentationRoutingModule { }
