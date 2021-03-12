import {Component, Input, Output, OnInit, EventEmitter, OnChanges, SimpleChanges} from '@angular/core';
import {ClassifierModel} from "../../../../../core/model/entities/classifier-model";
import {Observable} from "rxjs";
import {DialogsService} from "../../../../../shared/services/dialogs.service";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../store/state/image-recognition.state";
import {selectImageRecognitionAnalyzing} from "../../../store/selectors/image-recognition.selector";

@Component({
  selector: 'app-classifiers',
  templateUrl: './classifiers.component.html',
  styleUrls: ['./classifiers.component.css']
})
export class ClassifiersComponent implements OnInit, OnChanges {
  @Input() models: ClassifierModel[];
  @Output() onExecuteClassifier = new EventEmitter<ClassifierModel>();

  selectedModel:string;
  sortedModels: ClassifierModel[];
  analyzing$: Observable<boolean>;

  constructor(protected dialogsService: DialogsService, protected store: Store<ImageRecognitionState>) { }

  ngOnInit(): void {
    this.analyzing$ = this.store.select(selectImageRecognitionAnalyzing);
  }

  // order setting last trained first
  ngOnChanges(changes: SimpleChanges): void {
    if (changes.models && this.models && this.models.length > 0) {
      this.sortedModels = this.models.sort((a, b) => {
        let result = b.last_train.localeCompare(a.last_train);
        if (result == 0) {
          return a.id.localeCompare(b.id);
        } else {
          return result;
        }
      })
    }
  }



  executeClassifier() {
    const classifierModel = this.models.find(model => model.id == this.selectedModel);
    if (!classifierModel) {
      throw new Error('Cannot find a classifier model with id "' + this.selectedModel + '"');
    }
    this.onExecuteClassifier.emit(classifierModel);
  }
}
