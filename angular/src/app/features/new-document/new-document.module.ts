import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewDocumentRoutingModule } from './new-document-routing.module';
import { NewDocumentComponent } from './components/new-document/new-document.component';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {newDocumentReducers} from './store/reducers/new-document.reducers';
import {NewDocumentEffects} from './store/effects/new-document.effects';
import {NewDocumentService} from './new-document.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [NewDocumentComponent],
  imports: [
    CommonModule,
    NewDocumentRoutingModule,
    BreadcrumbModule,
    ReactiveFormsModule,
    StoreModule.forFeature('new-document', newDocumentReducers),
    EffectsModule.forFeature([NewDocumentEffects]),
    FormsModule,
  ],
  providers: [NewDocumentService]
})
export class NewDocumentModule { }
