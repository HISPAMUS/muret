import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AgnosticRepresentationComponent} from './components/agnostic-representation/agnostic-representation.component';

const routes: Routes = [
  { path: '', component: AgnosticRepresentationComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AgnosticRepresentationRoutingModule { }
