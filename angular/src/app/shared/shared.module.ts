import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StateComponent} from './components/state/state.component';
import { ImageAnnotateComponent } from './components/image-annotate/image-annotate.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faSearchMinus } from '@fortawesome/free-solid-svg-icons';
import { faSearchPlus } from '@fortawesome/free-solid-svg-icons';
import { faExpand } from '@fortawesome/free-solid-svg-icons';
import { faCheck } from '@fortawesome/free-solid-svg-icons';
import { faCheckDouble } from '@fortawesome/free-solid-svg-icons';
import { faUserClock} from '@fortawesome/free-solid-svg-icons';
import {SvgModule} from '../svg/svg.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    SvgModule
  ],
  declarations: [
    StateComponent,
    ImageAnnotateComponent
  ],
  exports: [
    StateComponent,
    ImageAnnotateComponent
  ],
  providers: []
})
export class SharedModule {
  constructor() {
    // Add an icon to the library for convenient access in other components
    library.add(faSearchMinus);
    library.add(faSearchPlus);
    library.add(faExpand);
    library.add(faCheck);
    library.add(faCheckDouble);
    library.add(faUserClock);
  }
}
