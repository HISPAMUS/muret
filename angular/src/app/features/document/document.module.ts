import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocumentRoutingModule } from './document-routing.module';
import { DocumentComponentOld } from './components/document/document-component-old.component';
import {ImageThumbnailComponent} from './components/image-thumbnail/image-thumbnail.component';
import {LightboxModule} from 'ngx-lightbox';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {DocumentService} from './services/document.service';
import {DocumentEffects} from './store/effects/document.effects';
import {documentReducers} from './store/reducers/document.reducers';
import { UploadImagesComponent } from './components/upload-images/upload-images.component';
import {FileUploadModule} from 'ng2-file-upload';
import { DocumentScoreViewerAndExporterComponent } from './components/document-score-viewer-and-exporter/document-score-viewer-and-exporter.component';
import {SharedModule} from '../../shared/shared.module';
import {NgbDropdownModule} from '@ng-bootstrap/ng-bootstrap';
import { InstrumentsComponent } from './components/instruments/instruments.component';
import {FormsModule} from '@angular/forms';
import { AlignmentPreviewComponent } from './components/alignment-preview/alignment-preview.component';
import {SvgModule} from '../../svg/svg.module';
import { MEIScoreViewerComponent } from './components/mei-score-viewer/meiscore-viewer.component';
import { DocumentComponent } from './components/document/document.component';
import { SectionComponent } from './components/section/section.component';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { DocumentThumbnailComponent } from './components/document-thumbnail/document-thumbnail.component';
import { ImagePhasesComponent } from './components/image-phases/image-phases.component';
import { ImagePartsComponent } from './components/image-parts/image-parts.component';
import {LazyLoadImageModule} from "ng-lazyload-image";
import {ContextMenuModule} from "ngx-contextmenu";
import {DialogsModule} from "../../dialogs/dialogs.module";
import {DragDropModule} from "@angular/cdk/drag-drop";
import { ReorderSectionsComponent } from './components/reorder-sections/reorder-sections.component';

@NgModule({
  declarations: [DocumentComponentOld, ImageThumbnailComponent, UploadImagesComponent, DocumentScoreViewerAndExporterComponent, InstrumentsComponent, AlignmentPreviewComponent, MEIScoreViewerComponent, DocumentComponent, SectionComponent, DocumentThumbnailComponent, ImagePhasesComponent, ImagePartsComponent, ReorderSectionsComponent],
  imports: [
    CommonModule,
    DocumentRoutingModule,
    LightboxModule,
    FileUploadModule,
    NgbDropdownModule,
    StoreModule.forFeature('document', documentReducers),
    EffectsModule.forFeature([DocumentEffects]),
    FormsModule,
    SvgModule,
    SharedModule,
    FontAwesomeModule,
    LazyLoadImageModule,
    DialogsModule,
    ContextMenuModule.forRoot({
      useBootstrap4: true,
    }),
    DragDropModule
  ],
  providers: [
    DocumentService
  ]
})
export class DocumentModule { }
