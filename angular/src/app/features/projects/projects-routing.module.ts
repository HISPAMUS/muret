import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProjectsComponent} from './components/projects/projects.component';
import {CollectionsComponent} from './components/collections/collections.component';

const routes: Routes = [
  { path: 'collections', component: CollectionsComponent },
  { path: 'projects/:id', component: ProjectsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectsRoutingModule { }
