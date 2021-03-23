import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StateComponent} from './components/state/state.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {SimpleModalModule} from 'ngx-simple-modal';
import { CrudToolbarComponent } from './components/crud-toolbar/crud-toolbar.component';
import {NgbButtonsModule, NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { SafePipe } from './pipes/safe.pipe';
import {AgnosticOrSemanticToolbarComponent} from "./components/agnostic-or-semantic-toolbar/agnostic-or-semantic-toolbar.component";
import {ImagePreviewComponent} from "./components/image-preview/image-preview.component";
import {ImageComponent} from "./components/image/image.component";
import {AgnosticOrSemanticToolbarIconComponent} from "./components/agnostic-or-semantic-toolbar-icon/agnostic-or-semantic-toolbar-icon.component";
import { SelectableDirective } from './directives/selectable.directive';
import { SelectableContainerDirective } from './directives/selectable-container.directive';
import {ContextMenuModule} from "ngx-contextmenu";
import {ImagePhasesComponent} from "./components/image-phases/image-phases.component";
import {RouterModule} from "@angular/router";
import {ImagePhasePartsComponent} from "./components/image-phase/image-phase-parts.component";
import {ImagePhaseTranscriptionComponent} from "./components/image-phase/image-phase-transcription.component";
import {ImagePhaseDocumentAnalysisComponent} from "./components/image-phase/image-phase-document-analysis.component";
import {ImagePhaseOverviewComponent} from "./components/image-phase/image-phase-overview.component";
import { ProgressStatusComponent } from './components/progress-status/progress-status.component';
import {NotationService} from "./services/notation.service";

@NgModule({
  imports: [
    CommonModule,
    FontAwesomeModule,
    SimpleModalModule,
    FormsModule,
    ReactiveFormsModule,
    NgbButtonsModule,
    NgbTooltipModule,
    ContextMenuModule.forRoot({
      useBootstrap4: true,
    }),
    RouterModule
  ],
  declarations: [
    StateComponent,
    CrudToolbarComponent,
    SafePipe,
    AgnosticOrSemanticToolbarComponent,
    AgnosticOrSemanticToolbarIconComponent,
    ImagePreviewComponent,
    ImageComponent,
    ImagePhasesComponent,
    SelectableDirective,
    SelectableContainerDirective,
    ImagePhaseOverviewComponent,
    ImagePhaseDocumentAnalysisComponent,
    ImagePhasePartsComponent,
    ImagePhaseTranscriptionComponent,
    ProgressStatusComponent
  ],
    exports: [
        StateComponent,
        CrudToolbarComponent,
        SafePipe,
        AgnosticOrSemanticToolbarComponent,
        ImagePreviewComponent,
        ImageComponent,
        ImagePhasesComponent,
        SelectableDirective,
        SelectableContainerDirective,
        ImagePhaseDocumentAnalysisComponent,
        ImagePhasePartsComponent,
        ImagePhaseTranscriptionComponent,
        ProgressStatusComponent
    ],
  providers: [NotationService]
})
export class SharedModule {
}
