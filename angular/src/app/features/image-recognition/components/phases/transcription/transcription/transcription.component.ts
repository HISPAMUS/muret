import { Component, OnInit } from '@angular/core';
import {ImageRecognitionBaseAbstractComponent} from "../../image-recognition-base-abstract/image-recognition-base-abstract.component";
import {ActivatedRoute} from "@angular/router";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";
import {DialogsService} from "../../../../../../shared/services/dialogs.service";
import {ContextMenuService} from "ngx-contextmenu";
import {Observable} from "rxjs";
import {
  selectImageRecognitionSelectedRegion,
} from "../../../../store/selectors/image-recognition.selector";
import {ImageFilesService} from "../../../../../../core/services/image-files.service";
import {DomSanitizer} from "@angular/platform-browser";
import {Region} from "../../../../../../core/model/entities/region";
import {Shape} from "../../../../../../svg/model/shape";
import {ShowErrorService} from "../../../../../../core/services/show-error.service";
import {
  ImageRecognitionChangeRegionBoundingBox,
  ImageRecognitionSelectRegion
} from "../../../../store/actions/image-recognition.actions";
import {Rectangle} from "../../../../../../svg/model/rectangle";

@Component({
  selector: 'app-transcription-component',
  templateUrl: './transcription.component.html',
  styleUrls: ['./transcription.component.css']
})
export class TranscriptionComponent extends ImageRecognitionBaseAbstractComponent implements OnInit {

  private regionInteractionType: string;
  selectedRegion$: Observable<Region>;
  changeLeftLayoutLabel: string;
  imageNavigatorHeight: string;
  toolsHeight: string;

  constructor(route: ActivatedRoute, store: Store<ImageRecognitionState>, dialogsService: DialogsService, private contextMenuService: ContextMenuService,
              protected imageFilesService: ImageFilesService, protected sanitizer: DomSanitizer, protected manageErrorsService: ShowErrorService) {
    super(route, store, dialogsService, imageFilesService, sanitizer, manageErrorsService);
    this.phase = 'transcription';
    this.changeLeftLayoutLabel = 'Enlarge image preview';
    this.imageNavigatorHeight = 'smallLeft';
    this.toolsHeight = 'bigLeft';
  }

  protected isPageSelectable(): boolean {
    return false;
  }

  ngOnInit() {
    super.ngOnInit();
    // the dispatch to get all the classifiers is found in the base class
    this.selectedRegion$ = this.store.select(selectImageRecognitionSelectedRegion);
  }

  onRegionShapeSelected(shapes: Shape[]) {
    // this.region = null;
    this.regionInteractionType = null;
    if (shapes) {
      const regionShape = shapes.find(shape => shape.data && shape.data.regionType); // if it is a region
      if (regionShape) {
        const selectedRegion = regionShape.data;
        this.regionInteractionType = selectedRegion.regionType.regionInteractionType.name;
        // this.region = region; Must use observables to orchestrate all dependencies (agnostic symbols...)
        this.store.dispatch(new ImageRecognitionSelectRegion(selectedRegion));
      }
    }
  }

  toggleLeftLayout() {
    if (this.changeLeftLayoutLabel == 'Enlarge image preview') {
      this.changeLeftLayoutLabel = 'Enlarge tools';
      this.imageNavigatorHeight = 'bigLeft';
      this.toolsHeight = 'smallLeft';
    } else {
      this.changeLeftLayoutLabel = 'Enlarge image preview';
      this.imageNavigatorHeight = 'smallLeft';
      this.toolsHeight = 'bigLeft';
    }
  }

}
