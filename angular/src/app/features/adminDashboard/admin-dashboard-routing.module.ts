import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { RegisterComponent } from './components/register/register.component';
import { RegistermodelComponent } from './components/registermodel/registermodel.component';
import { PermissionsComponent } from './components/permissions/permissions.component';

const routes: Routes = [
  { path: '', component: AdminDashboardComponent },
  { path: 'register', component: RegisterComponent},
  { path: 'registermodel', component: RegistermodelComponent},
  { path: 'permissions', component: PermissionsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminDashboardRoutingModule { }