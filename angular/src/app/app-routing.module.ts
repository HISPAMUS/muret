import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {AuthGuardService as AuthGuard} from './auth/services/auth-guard.service';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {ErrorInterceptor, TokenInterceptor} from './auth/token-interceptor.service';

const routes = [
  {
    path: 'login',
    loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)
  },
  {
    path: 'about',
    loadChildren: () => import('./features/about/about.module').then(m => m.AboutModule)
  },
  {
    path: 'home',
    canActivate: [AuthGuard],
    loadChildren: () => import('./features/home/home.module').then(m => m.HomeModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'export',
    loadChildren: () => import('./features/export/export.module').then(m => m.ExportModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'projects',
    loadChildren: () => import('./features/projects/projects.module').then(m => m.ProjectsModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'project',
    loadChildren: () => import('./features/project/project.module').then(m => m.ProjectModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'newproject',
    loadChildren: () => import('./features/new-project/new-project.module').then(m => m.NewProjectModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'documentanalysis',
    loadChildren: () => import('./features/document-analysis/document-analysis.module').then(m => m.DocumentAnalysisModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'agnosticrepresentation',
    loadChildren: () => import('./features/agnostic-representation/agnostic-representation.module').then(m => m.AgnosticRepresentationModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'semanticrepresentation',
    loadChildren: () => import('./features/semantic-representation/semantic-representation.module').then(m => m.SemanticRepresentationModule)
  },
  {
    canActivate: [AuthGuard],
    path: '',
    loadChildren: () => import('./features/home/home.module').then(m => m.HomeModule)
  }
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, { useHash: true }) // to allow reloading in production
      // see https://stackoverflow.com/questions/52416210/angular-static-base-url-and-routing-with-hash-is-true#
    ],
    exports: [
        RouterModule
    ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptor,
      multi: true
    }
  ]
})
export class AppRoutingModule {}
