import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocumentAnalysisRoutingModule } from './document-analysis-routing.module';
import { DocumentAnalysisComponent } from './document-analysis/document-analysis.component';
import {SharedModule} from '../../shared/shared.module';

@NgModule({
  declarations: [DocumentAnalysisComponent],
  imports: [
    CommonModule,
    DocumentAnalysisRoutingModule,
    SharedModule
  ]
})
export class DocumentAnalysisModule { }
