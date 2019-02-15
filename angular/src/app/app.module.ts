import { BrowserModule } from '@angular/platform-browser';
import {ErrorHandler, NgModule} from '@angular/core';

import { AppComponent } from './app.component';

import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './routing/app-routing.module';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';


import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


import {RouterModule} from '@angular/router';

import {LoggerModule, NGXLogger, NgxLoggerLevel} from 'ngx-logger';
import {GlobalErrorHandlerService} from './error-handling/global-error-handler.service';

import { AngularResizedEventModule } from 'angular-resize-event';
import { ImageToolBarComponent } from './image-tool-bar/image-tool-bar.component';
import { StoreModule } from '@ngrx/store';
import { reducers, metaReducers } from './reducers';
import {LayoutModule} from "./layout/layout.module";
import {AboutModule} from "./about/about.module";
import {HomeModule} from "./home/home.module";

@NgModule({
  declarations: [
    AppComponent,
    ImageToolBarComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule,
    FormsModule,

    ReactiveFormsModule,
    NgbModule,
    AngularResizedEventModule, // TODo Quitar

    LayoutModule,
    AppRoutingModule,
    AboutModule,
    //HomeModule,

    // LoggerModule.forRoot({serverLoggingUrl: '/api/logs', level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR})
    LoggerModule.forRoot({level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR}),
    StoreModule.forRoot(reducers, { metaReducers })
  ],
  providers: [
    //RestClientService,
    NGXLogger,
    GlobalErrorHandlerService,
    { provide: ErrorHandler, useClass: GlobalErrorHandlerService },
  ], // singleton
  bootstrap: [AppComponent]
})
export class AppModule { }

