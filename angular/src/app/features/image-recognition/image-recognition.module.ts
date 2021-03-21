import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageOverviewComponent } from './components/phases/image-overview/image-overview.component';
import {ImageRecognitionRoutingModule} from "./image-recognition-routing.module";
import {StoreModule} from "@ngrx/store";
import {EffectsModule} from "@ngrx/effects";
import {imageRecognitionReducers} from "./store/reducers/image-recognition.reducers";
import {ImageOverviewEffects} from "./store/effects/image-recognition-effects.service";
import {ImageOverviewService} from "./services/image-overview.service";
import {DocumentAnalysisService} from "./services/document-analysis.service";
import { ImageDocumentAnalysisNavigatorComponent } from './components/subcomponents/image-document-analysis-navigator/image-document-analysis-navigator.component';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { PartsInImageComponentComponent } from './components/phases/parts-in-image/parts-in-image-component.component';
import { DocumentAnalysisComponent } from './components/phases/document-analysis/document-analysis/document-analysis.component';
import { TranscriptionComponentComponent } from './components/phases/transcription/transcription/transcription-component.component';
import {SharedModule} from "../../shared/shared.module";
import { DocumentAnalysisFiltersComponent } from './components/subcomponents/document-analysis-filters/document-analysis-filters.component';
import {NgbButtonsModule, NgbCollapseModule, NgbTooltipModule} from "@ng-bootstrap/ng-bootstrap";
import {SvgModule} from "../../svg/svg.module";
import {FormsModule} from "@angular/forms";
import {ContextMenuModule} from "ngx-contextmenu";
import {ImagePartsService} from "./services/image-parts.service";
import { DocumentAnalysisToolbarComponent } from './components/phases/document-analysis/document-analysis-toolbar/document-analysis-toolbar.component';
import { ImageRecognitionToolbarComponent } from './components/subcomponents/image-recognition-toolbar/image-recognition-toolbar.component';
import { RegionPreviewComponent } from './components/phases/transcription/region-preview/region-preview.component';
import { MusicRegionSemanticRepresentationComponent } from './components/phases/transcription/music-region-semantic-representation/music-region-semantic-representation.component';
import {ClassifiersComponent} from "./components/subcomponents/classifiers/classifiers.component";
import { TextRegionSemanticRepresentationComponent } from './components/phases/transcription/text-region-semantic-representation/text-region-semantic-representation.component';
import {AgnosticStaffComponent} from "./components/phases/transcription/agnostic-staff/agnostic-staff.component";
import {NotationComponent} from "./components/phases/transcription/notation/notation.component";
import { TextRegionAgnosticRepresentationComponent } from './components/phases/transcription/text-region-agnostic-representation/text-region-agnostic-representation.component';
import {AgnosticRepresentationService} from "./services/agnostic-representation.service";
import { MusicAgnosticRepresentationComponent } from './components/phases/transcription/music-agnostic-representation/music-agnostic-representation.component';
import { ChangePitchComponent } from './components/phases/transcription/change-pitch/change-pitch.component';
import {SemanticRepresentationService} from "./services/semantic-representation.service";


@NgModule({
  declarations: [ImageOverviewComponent, ImageDocumentAnalysisNavigatorComponent, PartsInImageComponentComponent,
    DocumentAnalysisComponent, TranscriptionComponentComponent, DocumentAnalysisFiltersComponent,
    DocumentAnalysisToolbarComponent, ImageRecognitionToolbarComponent, RegionPreviewComponent,
    ClassifiersComponent,
    MusicRegionSemanticRepresentationComponent,
    TextRegionSemanticRepresentationComponent,
    AgnosticStaffComponent, NotationComponent, TextRegionAgnosticRepresentationComponent, MusicAgnosticRepresentationComponent, ChangePitchComponent
  ],
    imports: [
        CommonModule,
        StoreModule.forFeature('imageRecognition', imageRecognitionReducers),
        EffectsModule.forFeature([ImageOverviewEffects]),
        ImageRecognitionRoutingModule,
        FontAwesomeModule,
        SharedModule,
        NgbCollapseModule,
        SvgModule,
        FormsModule,
        ContextMenuModule,
        NgbTooltipModule,
        NgbButtonsModule
    ],providers: [
    ImageOverviewService, DocumentAnalysisService, ImagePartsService, AgnosticRepresentationService, SemanticRepresentationService
  ]
})
export class ImageRecognitionModule { }
