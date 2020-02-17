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
import {DocumentsModule} from './features/documents/documents.module';
import {NewDocumentModule} from './features/new-document/new-document.module';
import {DocumentAnalysisModule} from './features/document-analysis/document-analysis.module';
import {AgnosticRepresentationModule} from './features/agnostic-representation/agnostic-representation.module';
import {SemanticRepresentationModule} from './features/semantic-representation/semantic-representation.module';
import {SharedModule} from './shared/shared.module';
import {intersectionObserverPreset, LazyLoadImageModule} from 'ng-lazyload-image';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import {FontAwesomeModule, FaIconLibrary} from '@fortawesome/angular-fontawesome';
import {faSearchMinus} from '@fortawesome/free-solid-svg-icons';
import { faSearchPlus } from '@fortawesome/free-solid-svg-icons';
import { faExpand } from '@fortawesome/free-solid-svg-icons';
import { faCheck } from '@fortawesome/free-solid-svg-icons';
import { faCheckDouble } from '@fortawesome/free-solid-svg-icons';
import { faUserClock} from '@fortawesome/free-solid-svg-icons';
import {CoreModule} from './core/core.module';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {environment} from '../environments/environment';
import {StoreDevtoolsModule} from '@ngrx/store-devtools';
import {faAngleDown} from '@fortawesome/free-solid-svg-icons/faAngleDown';
import {faAngleUp} from '@fortawesome/free-solid-svg-icons/faAngleUp';
import {faAngleDoubleUp} from '@fortawesome/free-solid-svg-icons/faAngleDoubleUp';
import {faAngleDoubleDown} from '@fortawesome/free-solid-svg-icons/faAngleDoubleDown';
import {faTrash} from '@fortawesome/free-solid-svg-icons/faTrash';
import {faPlus} from '@fortawesome/free-solid-svg-icons/faPlus';
import {faEdit} from '@fortawesome/free-solid-svg-icons/faEdit';
import {faMinus} from '@fortawesome/free-solid-svg-icons/faMinus';
import {faEye} from '@fortawesome/free-solid-svg-icons/faEye';
import {faExpandArrowsAlt} from '@fortawesome/free-solid-svg-icons/faExpandArrowsAlt';
import {faCompressArrowsAlt} from '@fortawesome/free-solid-svg-icons/faCompressArrowsAlt';
import {faCommentDots} from '@fortawesome/free-solid-svg-icons/faCommentDots';
import {AgGridModule} from 'ag-grid-angular';
import {PartsModule} from './features/parts/parts.module';
import { AdminDashboardModule } from './features/admin-dashboard/admin-dashboard.module';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AgGridModule.withComponents([]),
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    FontAwesomeModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(), // ToastrModule added
    SharedModule,
    CoreModule,
    LayoutModule,
    AuthModule,
    AppRoutingModule,
    AboutModule,
    ExportModule,
    PartsModule,
    DocumentsModule,
    NewDocumentModule,
    DocumentAnalysisModule,
    AgnosticRepresentationModule,
    SemanticRepresentationModule,
    AdminDashboardModule,
    StoreModule.forRoot({
      /* an empty object here  */
    }),
    EffectsModule.forRoot([]),
    LazyLoadImageModule.forRoot({
      preset: intersectionObserverPreset
    }),
    LoggerModule.forRoot({level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR}),
    !environment.production ? StoreDevtoolsModule.instrument() : [],
    NgbModule,
  ],
  providers: [], // don't add here singleton services if using @Injectable( providedIn: 'root'})
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(library: FaIconLibrary) {
    library.addIcons(faSearchMinus);
    library.addIcons(faSearchPlus);
    library.addIcons(faExpand);
    library.addIcons(faCheck);
    library.addIcons(faCheckDouble);
    library.addIcons(faUserClock);
    library.addIcons(faAngleDown);
    library.addIcons(faAngleUp);
    library.addIcons(faAngleDoubleDown);
    library.addIcons(faAngleDoubleUp);
    library.addIcons(faTrash);
    library.addIcons(faPlus);
    library.addIcons(faEdit);
    library.addIcons(faMinus);
    library.addIcons(faEye);
    library.addIcons(faExpandArrowsAlt);
    library.addIcons(faCompressArrowsAlt);
    library.addIcons(faCompressArrowsAlt);
    library.addIcons(faCommentDots);
  }
}
