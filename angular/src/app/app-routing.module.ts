import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {AuthGuardService as AuthGuard} from './auth/services/auth-guard.service';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {BlobErrorHttpInterceptor, TokenInterceptor} from './auth/token-interceptor.service';

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
    path: 'documents',
    loadChildren: () => import('./features/documents/documents.module').then(m => m.DocumentsModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'document',
    loadChildren: () => import('./features/document/document.module').then(m => m.DocumentModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'imageRecognition',
    loadChildren: () => import('./features/image-recognition/image-recognition.module').then(m => m.ImageRecognitionModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'newdocument',
    loadChildren: () => import('./features/new-document-old/new-document.module').then(m => m.NewDocumentModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'documentanalysis',
    loadChildren: () => import('./features/document-analysis-old/document-analysis.module').then(m => m.DocumentAnalysisModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'agnosticrepresentation',
    loadChildren: () => import('./features/agnostic-representation-old/agnostic-representation.module').
      then(m => m.AgnosticRepresentationModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'semanticrepresentation',
    loadChildren: () => import('./features/semantic-representation-old/semantic-representation.module').
      then(m => m.SemanticRepresentationModule)
  },
  {
    canActivate: [AuthGuard],
    path: '',
    loadChildren: () => import('./features/home/home.module').then(m => m.HomeModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'admin',
    loadChildren: () => import('./features/admin-dashboard-old/admin-dashboard.module').then( m => m.AdminDashboardModule)
  }
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, { useHash: true, relativeLinkResolution: 'legacy' }) // to allow reloading in production
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
    /*{
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptor,
      multi: true
    },*/
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BlobErrorHttpInterceptor,
      multi: true
    }
  ]
})
export class AppRoutingModule {}
