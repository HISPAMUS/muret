import {BrowserModule, HammerModule} from '@angular/platform-browser';
import {ErrorHandler, NgModule} from '@angular/core';
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
import {SharedModule} from './shared/shared.module';
import {LazyLoadImageModule} from 'ng-lazyload-image';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import {FontAwesomeModule, FaIconLibrary} from '@fortawesome/angular-fontawesome';
import {
  faCompressAlt,
  faExpandAlt,
  faGuitar,
  faMusic,
  faObjectGroup,
  faSearchMinus
} from '@fortawesome/free-solid-svg-icons';
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
import {faCaretRight} from '@fortawesome/free-solid-svg-icons/faCaretRight';
import {faCaretDown} from '@fortawesome/free-solid-svg-icons/faCaretDown';
import {faBomb} from '@fortawesome/free-solid-svg-icons/faBomb';
import {faExclamationTriangle} from '@fortawesome/free-solid-svg-icons/faExclamationTriangle';
import {AgGridModule} from 'ag-grid-angular';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import {DialogsModule} from "./dialogs/dialogs.module";
import {faEllipsisV} from "@fortawesome/free-solid-svg-icons/faEllipsisV";
import {faArrowsAlt} from "@fortawesome/free-solid-svg-icons/faArrowsAlt";
import {faTasks} from "@fortawesome/free-solid-svg-icons/faTasks";
import {faEyeSlash} from "@fortawesome/free-solid-svg-icons/faEyeSlash";
import {faSpinner} from "@fortawesome/free-solid-svg-icons/faSpinner";
import {faMousePointer} from "@fortawesome/free-solid-svg-icons/faMousePointer";
import {faServer} from "@fortawesome/free-solid-svg-icons/faServer";
import {GlobalErrorHandler} from "./core/services/global-error-handler.service";
import {PartsModule} from "./features/parts-old/parts.module";
import {DocumentAnalysisModule} from "./features/document-analysis-old/document-analysis.module";
import {AgnosticRepresentationModule} from "./features/agnostic-representation-old/agnostic-representation.module";
import {SemanticRepresentationModule} from "./features/semantic-representation-old/semantic-representation.module";
import {AdminDashboardModule} from "./features/admin-dashboard-old/admin-dashboard.module";
import {NewDocumentModule} from "./features/new-document-old/new-document.module";
import {faPlusSquare} from "@fortawesome/free-solid-svg-icons/faPlusSquare";
import {faLink} from "@fortawesome/free-solid-svg-icons/faLink";
import {faUnlink} from "@fortawesome/free-solid-svg-icons/faUnlink";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
   // removed dependency and added this module "hammerjs": "^2.0.8",
    HammerModule,
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
    DialogsModule,
    StoreModule.forRoot({
      /* an empty object here  */
    }),
    EffectsModule.forRoot([]),
    /*LazyLoadImageModule.forRoot({ // in Angular 9
      preset: intersectionObserverPreset
    }),*/
    LazyLoadImageModule,
    LoggerModule.forRoot({level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR}),
    !environment.production ? StoreDevtoolsModule.instrument() : [],
    NgbModule
  ],
  providers: [{provide: ErrorHandler, useClass: GlobalErrorHandler}], // don't add here singleton services if using @Injectable( providedIn: 'root'})
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
    library.addIcons(faCaretRight); // used in treeView
    library.addIcons(faCaretDown); // used in treeView
    library.addIcons(faBomb);
    library.addIcons(faExclamationTriangle); // showServerError icon
    library.addIcons(faCompressAlt); // used in section
    library.addIcons(faExpandAlt); // used in section
    library.addIcons(faObjectGroup); // used in document thumbnail
    library.addIcons(faMusic); // used in document thumbnail
    library.addIcons(faGuitar); // used in document thumbnail
    library.addIcons(faTasks); // used in document to show drag and drop
    library.addIcons(faEllipsisV); // used in section
    library.addIcons(faArrowsAlt); // used in document to show drag and drop
    library.addIcons(faEyeSlash); // used in ProgressStatus
    library.addIcons(faSpinner); // used in ProgressStatus
    library.addIcons(faMousePointer); // used in image recognition toolbar
    library.addIcons(faServer); // used in classifications
    library.addIcons(faPlusSquare); // used in kern / mens grid
    library.addIcons(faLink); // used in kern / mens grid
    library.addIcons(faUnlink); // used in kern / mens grid

  }
}
