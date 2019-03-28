import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewProjectRoutingModule } from './new-project-routing.module';
import { NewProjectComponent } from './components/new-project/new-project.component';
import {BreadcrumbModule} from '../../breadcrumb/breadcrumb.module';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {newProjectReducers} from './store/reducers/new-project.reducers';
import {NewProjectEffects} from './store/effects/new-project.effects';
import {NewProjectService} from './new-project.service';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [NewProjectComponent],
  imports: [
    CommonModule,
    NewProjectRoutingModule,
    BreadcrumbModule,
    ReactiveFormsModule,
    StoreModule.forFeature('new-project', newProjectReducers),
    EffectsModule.forFeature([NewProjectEffects]),
  ],
  providers: [NewProjectService]
})
export class NewProjectModule { }
