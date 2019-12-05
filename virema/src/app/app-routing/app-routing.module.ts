import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from '../dashboard/dashboard.component'
import {LogoMarkOneColorExperimentComponent} from '../logo-mark-one-color-experiment/logo-mark-one-color-experiment.component';

const routes: Routes = [
  {
    path: 'onecolorlogomark',
    component: LogoMarkOneColorExperimentComponent,
  },
  {
    path: '',
    component: DashboardComponent,
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
