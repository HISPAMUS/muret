import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocumentAnalysisRoutingModule } from './document-analysis-routing.module';
import { DocumentAnalysisComponent } from './components/document-analysis/document-analysis.component';
import {SharedModule} from '../../shared/shared.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {SvgModule} from '../../svg/svg.module';
import {NgbButtonsModule, NgbModule, NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {documentAnalysisReducers} from './store/reducers/document-analysis.reducers';
import {DocumentAnalysisEffects} from './store/effects/document-analysis.effects';
import {DocumentAnalysisService} from './services/document-analysis.service';
import { ImageComponent } from './components/image/image.component';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';

@NgModule({
  declarations: [DocumentAnalysisComponent, ImageComponent],
    imports: [
        CommonModule,
        DocumentAnalysisRoutingModule,
        SharedModule,
        SvgModule,
        FormsModule,
        ReactiveFormsModule,
        FontAwesomeModule,
        SharedModule,
        NgbButtonsModule,
        BreadcrumbModule,
        StoreModule.forFeature('document-analysis', documentAnalysisReducers),
        EffectsModule.forFeature([DocumentAnalysisEffects]),
        NgbTooltipModule,
    ],
  entryComponents: [
    ImageComponent
  ],
  exports: [
    ImageComponent
  ],
  providers: [
    DocumentAnalysisService
  ]
})
export class DocumentAnalysisModule {
}
