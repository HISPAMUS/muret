import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageOverviewComponent } from './components/image-overview/image-overview.component';
import {ImageRecognitionRoutingModule} from "./image-recognition-routing.module";
import {StoreModule} from "@ngrx/store";
import {EffectsModule} from "@ngrx/effects";
import {imageRecognitionReducers} from "./store/reducers/image-recognition.reducers";
import {ImageOverviewEffects} from "./store/effects/image-recognition-effects.service";
import {ImageOverviewService} from "./services/image-overview.service";
import {DocumentAnalysisService} from "./services/document-analysis.service";
import { ImageDocumentAnalysisNavigatorComponent } from './components/image-document-analysis-navigator/image-document-analysis-navigator.component';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { PartsInImageComponentComponent } from './components/parts-in-image/parts-in-image-component.component';
import { DocumentAnalysisComponent } from './components/document-analysis/document-analysis.component';
import { TranscriptionComponentComponent } from './components/transcription/transcription-component.component';
import {SharedModule} from "../../shared/shared.module";
import { DocumentAnalysisFiltersComponent } from './components/document-analysis-filters/document-analysis-filters.component';
import {NgbButtonsModule, NgbCollapseModule, NgbTooltipModule} from "@ng-bootstrap/ng-bootstrap";
import {SvgModule} from "../../svg/svg.module";
import {FormsModule} from "@angular/forms";
import {ContextMenuModule} from "ngx-contextmenu";
import {ImagePartsService} from "./services/image-parts.service";
import { DocumentAnalysisToolbarComponent } from './components/document-analysis-toolbar/document-analysis-toolbar.component';
import { ImageRecognitionToolbarComponent } from './components/image-recognition-toolbar/image-recognition-toolbar.component';
import { DocumentAnalysisClassifiersComponent } from './components/document-analysis-classifiers/document-analysis-classifiers.component';


@NgModule({
  declarations: [ImageOverviewComponent, ImageDocumentAnalysisNavigatorComponent, PartsInImageComponentComponent, DocumentAnalysisComponent, TranscriptionComponentComponent, DocumentAnalysisFiltersComponent, DocumentAnalysisToolbarComponent, ImageRecognitionToolbarComponent, DocumentAnalysisClassifiersComponent],
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
    ImageOverviewService, DocumentAnalysisService, ImagePartsService
  ]
})
export class ImageRecognitionModule { }
