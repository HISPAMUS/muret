import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocumentAnalysisRoutingModule } from './document-analysis-routing.module';
import { DocumentAnalysisComponent } from './document-analysis/document-analysis.component';
import {SharedModule} from '../../shared/shared.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {SvgModule} from '../../svg/svg.module';

@NgModule({
  declarations: [DocumentAnalysisComponent],
  imports: [
    CommonModule,
    DocumentAnalysisRoutingModule,
    SharedModule,
    SvgModule,
    FormsModule,
    ReactiveFormsModule,
    FontAwesomeModule,
  ]
})
export class DocumentAnalysisModule {
}
