import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'about',
    loadChildren: '../about/about.module#AboutModule'
  },
  {
    path: 'login',
    loadChildren: '../home/home.module#HomeModule'
  },
  { path: '', pathMatch: 'full', redirectTo: 'startup'},

/*
  { path: 'preferences', component: PreferencesComponent, canActivate: [AuthGuard]},
  { path: 'startup', component: StartupComponent, canActivate: [AuthGuard]},
  { path: 'projects', component: ProjectsComponent, canActivate: [AuthGuard]},
  { path: 'newproject', component: NewProjectFormComponent, canActivate: [AuthGuard]},
  { path: 'project/:id', component: ProjectComponent, canActivate: [AuthGuard], canDeactivate: [AuthGuard]},
  { path: 'image', component: ImageComponent, canActivate: [AuthGuard], canDeactivate: [AuthGuard]},
  { path: 'symbols', component: SymbolsComponent, canActivate: [AuthGuard], canDeactivate: [AuthGuard]},
  { path: 'uploadimages/:id', component: UploadImagesComponent, canActivate: [AuthGuard]},
  { path: 'export', component: TrainingSetsComponent, canActivate: [AuthGuard]},

  // usado para desarrollo //TODO Quitar
  { path: 'dev', component: DevComponent},
  { path: '**', redirectTo: '' },*/
];

@NgModule({
  imports: [ RouterModule.forRoot(routes,
    { enableTracing: false } // <-- debugging purposes only
    ) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
