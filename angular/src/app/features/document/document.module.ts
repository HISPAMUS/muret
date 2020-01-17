import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocumentRoutingModule } from './document-routing.module';
import { DocumentComponent } from './components/document/document.component';
import {ImageThumbnailComponent} from './components/image-thumbnail/image-thumbnail.component';
import {LightboxModule} from 'ngx-lightbox';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {DocumentService} from './services/document.service';
import {DocumentEffects} from './store/effects/document.effects';
import {documentReducers} from './store/reducers/document.reducers';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';
import { UploadImagesComponent } from './components/upload-images/upload-images.component';
import {FileUploadModule} from 'ng2-file-upload';
import { DocumentScoreViewerComponent } from './components/document-score-viewer/document-score-viewer.component';
import {SharedModule} from '../../shared/shared.module';
import {NgbDropdownModule} from '@ng-bootstrap/ng-bootstrap';
import { InstrumentsComponent } from './components/instruments/instruments.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [DocumentComponent, ImageThumbnailComponent, UploadImagesComponent, DocumentScoreViewerComponent, InstrumentsComponent],
  imports: [
    CommonModule,
    DocumentRoutingModule,
    LightboxModule,
    FileUploadModule,
    NgbDropdownModule,
    StoreModule.forFeature('document', documentReducers),
    EffectsModule.forFeature([DocumentEffects]),
    BreadcrumbModule,
    SharedModule,
    FormsModule,
  ],
  providers: [
    DocumentService
  ]
})
export class DocumentModule { }
