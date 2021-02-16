import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageOverviewComponent } from './components/image-overview/image-overview.component';
import {ImageRecognitionRoutingModule} from "./image-recognition-routing.module";
import {StoreModule} from "@ngrx/store";
import {EffectsModule} from "@ngrx/effects";
import {imageRecognitionReducers} from "./store/reducers/image-recognition.reducers";
import {ImageRecognitionEffects} from "./store/effects/image-recognition-effects.service";
import {ImageRecognitionService} from "./services/image-recognition-service";
import { ImageDocumentAnalysisNavigatorComponent } from './components/image-document-analysis-navigator/image-document-analysis-navigator.component';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { PartsInImageComponentComponent } from './components/parts-in-image/parts-in-image-component.component';
import { DocumentAnalysisComponent } from './components/document-analysis/document-analysis.component';
import { TranscriptionComponentComponent } from './components/transcription/transcription-component.component';
import {SharedModule} from "../../shared/shared.module";



@NgModule({
  declarations: [ImageOverviewComponent, ImageDocumentAnalysisNavigatorComponent, PartsInImageComponentComponent, DocumentAnalysisComponent, TranscriptionComponentComponent],
  imports: [
    CommonModule,
    StoreModule.forFeature('imageRecognition', imageRecognitionReducers),
    EffectsModule.forFeature([ImageRecognitionEffects]),
    ImageRecognitionRoutingModule,
    FontAwesomeModule,
    SharedModule
  ],providers: [
    ImageRecognitionService
  ]
})
export class ImageRecognitionModule { }
