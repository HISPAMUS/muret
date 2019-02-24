import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import {LayoutModule} from './layout/layout.module';
import {AppRoutingModule} from './app-routing.module';
import {AboutModule} from './features/about/about.module';
import { HttpClientModule } from '@angular/common/http';
import {AuthModule} from './auth/auth.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {ExportModule} from './features/export/export.module';
import {LoggerModule, NgxLoggerLevel} from 'ngx-logger';
import {ProjectsModule} from './features/projects/projects.module';
import {NewProjectModule} from './features/new-project/new-project.module';
import {DocumentAnalysisModule} from './features/document-analysis/document-analysis.module';
import {AgnosticRepresentationModule} from './features/agnostic-representation/agnostic-representation.module';
import {SemanticRepresentationModule} from './features/semantic-representation/semantic-representation.module';
import {SharedModule} from './shared/shared.module';
import {intersectionObserverPreset, LazyLoadImageModule} from 'ng-lazyload-image';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    LayoutModule,
    AuthModule,
    AppRoutingModule,
    AboutModule,
    ExportModule,
    ProjectsModule,
    NewProjectModule,
    DocumentAnalysisModule,
    AgnosticRepresentationModule,
    SemanticRepresentationModule,
    LazyLoadImageModule.forRoot({
      preset: intersectionObserverPreset
    }),
    LoggerModule.forRoot({level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR}),
    NgbModule.forRoot()
  ],
  providers: [], // don't add here singleton services if using @Injectable( providedIn: 'root'})
  bootstrap: [AppComponent]
})
export class AppModule {
}
