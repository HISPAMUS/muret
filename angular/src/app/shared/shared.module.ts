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
import {SvgModule} from "../svg/svg.module";
import {AgnosticOrSemanticToolbarIconComponent} from "./components/agnostic-or-semantic-toolbar-icon/agnostic-or-semantic-toolbar-icon.component";

@NgModule({
  imports: [
    CommonModule,
    FontAwesomeModule,
    SimpleModalModule,
    FormsModule,
    ReactiveFormsModule,
    NgbButtonsModule,
    NgbTooltipModule,
    SvgModule
  ],
  declarations: [
    StateComponent,
    CrudToolbarComponent,
    SafePipe,
    AgnosticOrSemanticToolbarComponent,
    AgnosticOrSemanticToolbarIconComponent,
    ImagePreviewComponent,
    ImageComponent
  ],
  exports: [
    StateComponent,
    CrudToolbarComponent,
    SafePipe,
    AgnosticOrSemanticToolbarComponent,
    ImagePreviewComponent,
    ImageComponent
  ],
  entryComponents: [
    CrudToolbarComponent,
    AgnosticOrSemanticToolbarComponent,
    ImagePreviewComponent,
    ImageComponent
  ],
  providers: []
})
export class SharedModule {
}
