import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocumentsRoutingModule } from './documents-routing.module';
import { DocumentsComponent } from './components/documents/documents.component';
import {SharedModule} from '../../shared/shared.module';
import {StoreModule} from '@ngrx/store';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';
import { CollectionsComponent } from './components/collections/collections.component';
import {EffectsModule} from '@ngrx/effects';
import {documentsReducers} from './store/reducers/documents.reducers';
import {DocumentsEffects} from './store/effects/documents.effects';
import {DocumentsService} from './services/documents.service';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [DocumentsComponent, CollectionsComponent],
    imports: [
        CommonModule,
        DocumentsRoutingModule,
        SharedModule,
        BreadcrumbModule,
        StoreModule.forFeature('documents', documentsReducers),
        EffectsModule.forFeature([DocumentsEffects]),
        FormsModule,
    ],
  providers: [DocumentsService]
})
export class DocumentsModule { }
