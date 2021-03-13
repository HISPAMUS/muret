import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {ClassifierModel} from "../../../../../../core/model/entities/classifier-model";
import {Notation} from "../../../../../semantic-representation/services/notation";
import {Region} from "../../../../../../core/model/entities/region";
import {GetNotation} from "../../../../../semantic-representation/store/actions/semantic-representation.actions";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";
import {selectNotation} from "../../../../../semantic-representation/store/selectors/semantic-representation.selector";

@Component({
  selector: 'app-music-region-semantic-representation',
  templateUrl: './music-region-semantic-representation.component.html',
  styleUrls: ['./music-region-semantic-representation.component.css']
})
export class MusicRegionSemanticRepresentationComponent implements OnInit, OnChanges, OnDestroy {
  @Input() semanticClassifiers: Observable<ClassifierModel[]>;
  @Input() region: Region;
  notation: Notation;
  notationSubscription: Subscription;

  constructor(private store: Store<ImageRecognitionState>) {
  }

  ngOnInit(): void {
    this.notationSubscription = this.store.select(selectNotation).subscribe(next => {
      if (next) {
        if (next.semanticEncoding) {
          //TODO 2021 this.drawSemanticEncoding(next.semanticEncoding);
          //TODO this.waitingForSemantic = false;
          //TODO this.semanticLabel = "Convert from agnostic";
        }
        this.notation = next;
      }
    });

  }


  ngOnDestroy(): void {
    this.notationSubscription.unsubscribe();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.region && this.region) {
      console.log('Changing notation');
      this.store.dispatch(new GetNotation(this.region, false, 'verovio')); // TODO 2021
    }
  }

  onExecuteClassifier(classifierModel: ClassifierModel) {

  }

}
