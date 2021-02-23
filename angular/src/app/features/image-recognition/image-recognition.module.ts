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
import {DocumentAnalysisEffects} from "./store/effects/document-analysis.effects";
import { ImageDocumentAnalysisNavigatorComponent } from './components/image-document-analysis-navigator/image-document-analysis-navigator.component';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { PartsInImageComponentComponent } from './components/parts-in-image/parts-in-image-component.component';
import { DocumentAnalysisComponent } from './components/document-analysis/document-analysis.component';
import { TranscriptionComponentComponent } from './components/transcription/transcription-component.component';
import {SharedModule} from "../../shared/shared.module";
import { DocumentAnalysisFiltersComponent } from './components/document-analysis-filters/document-analysis-filters.component';
import {NgbCollapseModule} from "@ng-bootstrap/ng-bootstrap";
import {SvgModule} from "../../svg/svg.module";



@NgModule({
  declarations: [ImageOverviewComponent, ImageDocumentAnalysisNavigatorComponent, PartsInImageComponentComponent, DocumentAnalysisComponent, TranscriptionComponentComponent, DocumentAnalysisFiltersComponent],
  imports: [
    CommonModule,
    StoreModule.forFeature('imageRecognition', imageRecognitionReducers),
    EffectsModule.forFeature([ImageOverviewEffects, DocumentAnalysisEffects]),
    ImageRecognitionRoutingModule,
    FontAwesomeModule,
    SharedModule,
    NgbCollapseModule,
    SvgModule
  ],providers: [
    ImageOverviewService, DocumentAnalysisService
  ]
})
export class ImageRecognitionModule { }
