import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NgbDropdownModule} from '@ng-bootstrap/ng-bootstrap';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {partsReducers} from './store/reducers/parts.reducers';
import {PartsEffects} from './store/effects/parts-effects.service';
import { PartSelectionComponent } from './components/part-selection/part-selection.component';
import {PartsService} from './services/parts.service';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [PartSelectionComponent],
  imports: [
    CommonModule,
    NgbDropdownModule,
    FormsModule,
    StoreModule.forFeature('parts', partsReducers),
    EffectsModule.forFeature([PartsEffects]),
  ],
  exports: [
    PartSelectionComponent
  ],
  providers: [PartsService]
})
export class PartsModule { }
