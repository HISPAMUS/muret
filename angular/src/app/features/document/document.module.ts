import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocumentRoutingModule } from './document-routing.module';
import { DocumentComponentOld } from './components/document-old/document-component-old.component';
import {LightboxModule} from 'ngx-lightbox';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {DocumentService} from './services/document.service';
import {DocumentEffects} from './store/effects/document.effects';
import {documentReducers} from './store/reducers/document.reducers';
import {FileUploadModule} from 'ng2-file-upload';
import {SharedModule} from '../../shared/shared.module';
import {NgbDropdownModule, NgbPaginationModule, NgbTypeaheadModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {SvgModule} from '../../svg/svg.module';
import { SectionComponent } from './components/section/section.component';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { DocumentThumbnailComponent } from './components/document-thumbnail/document-thumbnail.component';
import { ImagePhasesComponent } from '../../shared/components/image-phases/image-phases.component';
import { ImagePartsComponent } from './components/image-parts/image-parts.component';
import {LazyLoadImageModule} from "ng-lazyload-image";
import {ContextMenuModule} from "ngx-contextmenu";
import {DialogsModule} from "../../dialogs/dialogs.module";
import {DragDropModule} from "@angular/cdk/drag-drop";
import { ReorderSectionsComponent } from './components/reorder-sections/reorder-sections.component';
import { ReorderImagesComponent } from './components/reorder-images/reorder-images.component';
import {UploadImagesComponent} from "./components/upload-images-old/upload-images.component";
import {DocumentScoreViewerAndExporterComponentOLD} from "./components/document-score-viewer-and-exporter-old/document-score-viewer-and-exporter-component-o-l-d.component";
import {InstrumentsComponent} from "./components/instruments-old/instruments.component";
import {AlignmentPreviewComponent} from "./components/alignment-preview-old/alignment-preview.component";
import {MEIScoreViewerComponent} from "./components/mei-score-viewer/meiscore-viewer.component";
import {ImageThumbnailComponent} from "./components/image-thumbnail-old/image-thumbnail.component";
import { DocumentCompilationComponent } from './components/document-types/document-compilation/document-compilation.component';
import { DocumentIncipitsComponent } from './components/document-types/document-incipits/document-incipits.component';
import { DocumentOverviewComponent } from './components/document-overview/document-overview.component';
import {DocumentPieceComponent} from "./components/document-types/document-piece/document-piece.component";
import { ImagesTableComponent } from './components/images-table/images-table.component';

@NgModule({
  declarations: [DocumentComponentOld, ImageThumbnailComponent, UploadImagesComponent, DocumentScoreViewerAndExporterComponentOLD, InstrumentsComponent, AlignmentPreviewComponent, MEIScoreViewerComponent, DocumentPieceComponent, SectionComponent, DocumentThumbnailComponent, ImagePartsComponent, ReorderSectionsComponent, ReorderImagesComponent, DocumentCompilationComponent, DocumentIncipitsComponent, DocumentOverviewComponent, ImagesTableComponent],
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
    DragDropModule,
    NgbTypeaheadModule,
    NgbPaginationModule
  ],
  providers: [
    DocumentService
  ]
})
export class DocumentModule { }
