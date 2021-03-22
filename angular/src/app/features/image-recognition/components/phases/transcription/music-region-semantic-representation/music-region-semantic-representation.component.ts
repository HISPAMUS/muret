import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {ClassifierModel} from "../../../../../../core/model/entities/classifier-model";
import {Notation} from "../../../../../../shared/services/notation";
import {Region} from "../../../../../../core/model/entities/region";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";
import {
  selectImageRecognitionNotation,
  selectImageRecognitionSemanticClassifierModels
} from "../../../../store/selectors/image-recognition.selector";
import {
  ImageRecognitionChangeNotationType,
  ImageRecognitionConvertAgnostic2Semantic,
  ImageRecognitionGetNotation
} from "../../../../store/actions/image-recognition.actions";

@Component({
  selector: 'app-music-region-semantic-representation',
  templateUrl: './music-region-semantic-representation.component.html',
  styleUrls: ['./music-region-semantic-representation.component.css']
})
export class MusicRegionSemanticRepresentationComponent implements OnInit, OnChanges {
  @Input() region: Region;
  semanticClassifiers$: Observable<ClassifierModel[]>;
  notation$: Observable<Notation>;
  notationTypes: string[] = ['Same as whole document', 'ePlainChant', 'eMensural', 'eModern']; //TODO Get from server;
  specialNotationType: any;

  constructor(private store: Store<ImageRecognitionState>) {
    this.semanticClassifiers$ = this.store.select(selectImageRecognitionSemanticClassifierModels);
  }

  ngOnInit(): void {
    this.notation$ = this.store.select(selectImageRecognitionNotation);
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.region && this.region && this.region.semanticEncoding) {
      this.store.dispatch(new ImageRecognitionGetNotation(this.region, false, 'verovio'));
      if (this.region && this.region.notationType) {
        this.specialNotationType = this.region.notationType;
      } else {
        this.specialNotationType = this.notationTypes[0]; // same as document
      }

    }
  }

  onExecuteClassifier(classifierModel: ClassifierModel) {
    this.store.dispatch(new ImageRecognitionConvertAgnostic2Semantic(classifierModel.id, this.region, false, 'verovio'));
  }

  changeSpecialNotationType($event: any) {
    let notationType: string;
    if ($event === this.notationTypes[0]) {
      notationType = null;
    } else {
      notationType = $event;
    }

    this.store.dispatch(new ImageRecognitionChangeNotationType(this.region, notationType));
  }
}
