import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TrainingSetsComponent} from './components/training-sets/training-sets.component';

const routes: Routes = [
  { path: 'trainingsets', component: TrainingSetsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ExportRoutingModule { }
