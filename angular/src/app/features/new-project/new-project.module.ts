import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewProjectRoutingModule } from './new-project-routing.module';
import { NewProjectComponent } from './components/new-project/new-project.component';

@NgModule({
  declarations: [NewProjectComponent],
  imports: [
    CommonModule,
    NewProjectRoutingModule
  ]
})
export class NewProjectModule { }
