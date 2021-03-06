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
import { DocumentScoreViewerAndExporterComponent } from './components/document-score-viewer-and-exporter/document-score-viewer-and-exporter.component';
import {SharedModule} from '../../shared/shared.module';
import {NgbDropdownModule} from '@ng-bootstrap/ng-bootstrap';
import { InstrumentsComponent } from './components/instruments/instruments.component';
import {FormsModule} from '@angular/forms';
import { AlignmentPreviewComponent } from './components/alignment-preview/alignment-preview.component';
import {SvgModule} from '../../svg/svg.module';
import {DocumentAnalysisModule} from '../document-analysis/document-analysis.module';
import { MEIScoreViewerComponent } from './components/meiscore-viewer/meiscore-viewer.component';

@NgModule({
  declarations: [DocumentComponent, ImageThumbnailComponent, UploadImagesComponent, DocumentScoreViewerAndExporterComponent, InstrumentsComponent, AlignmentPreviewComponent, MEIScoreViewerComponent],
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
        SvgModule,
        DocumentAnalysisModule,
    ],
  providers: [
    DocumentService
  ]
})
export class DocumentModule { }
