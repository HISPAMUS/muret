import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {AuthGuard} from './auth/auth.guard';

const routes = [
  {
    path: 'login',
    loadChildren: './auth/auth.module#AuthModule'
  },
  {
    path: 'about',
    loadChildren: './features/about/about.module#AboutModule'
  },
  {
    path: 'home',
    canActivate: [AuthGuard],
    loadChildren: './features/home/home.module#HomeModule'
  },
  {
    canActivate: [AuthGuard],
    path: 'export',
    loadChildren: './features/export/export.module#ExportModule'
  },
  {
    canActivate: [AuthGuard],
    path: 'projects',
    loadChildren: './features/projects/projects.module#ProjectsModule'
  },
  {
    canActivate: [AuthGuard],
    path: 'project',
    loadChildren: './features/project/project.module#ProjectModule'
  },
  {
    canActivate: [AuthGuard],
    path: 'newproject',
    loadChildren: './features/new-project/new-project.module#NewProjectModule'
  },
  {
    canActivate: [AuthGuard],
    path: 'documentanalysis',
    loadChildren: './features/document-analysis/document-analysis.module#DocumentAnalysisModule'
  },
  {
    canActivate: [AuthGuard],
    path: 'agnosticrepresentation',
    loadChildren: './features/agnostic-representation/agnostic-representation.module#AgnosticRepresentationModule'
  },
  {
    canActivate: [AuthGuard],
    path: 'semanticrepresentation',
    loadChildren: './features/semantic-representation/semantic-representation.module#SemanticRepresentationModule'
  },
  {
    canActivate: [AuthGuard],
    path: '',
    loadChildren: './features/home/home.module#HomeModule'
  }
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {}
