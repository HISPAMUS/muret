import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Observable} from "rxjs";
import {ClassifierModel} from "../../../../core/model/entities/classifier-model";
import {DialogsService} from "../../../../shared/services/dialogs.service";
import {ImageRecognitionState} from "../../store/state/image-recognition.state";
import {Store} from "@ngrx/store";
import {
  ImageRecognitionAutomaticDocumentAnalysis,
  ImageRecognitionGetDocumentAnModels
} from "../../store/actions/image-recognition.actions";
import {
  selectImageRecognitionAnalyzing,
  selectImageRecognitionDocumentAnalysisClassifierModels
} from "../../store/selectors/image-recognition.selector";

@Component({
  selector: 'app-document-analysis-classifiers',
  templateUrl: './document-analysis-classifiers.component.html',
  styleUrls: ['./document-analysis-classifiers.component.css']
})
export class DocumentAnalysisClassifiersComponent implements OnInit, OnChanges {
  @Input() imageID: number;

  danalysisModel:string;
  analyzing$: Observable<boolean>;
  documentAnalysisModels$: Observable<ClassifierModel[]>;

  constructor(private dialogsService: DialogsService, private store: Store<ImageRecognitionState>) { }

  ngOnInit(): void {
    this.documentAnalysisModels$ = this.store.select(selectImageRecognitionDocumentAnalysisClassifierModels);
    this.analyzing$ = this.store.select(selectImageRecognitionAnalyzing);
  }


  ngOnChanges(changes: SimpleChanges): void {
    if (changes.imageID && this.imageID) {
      this.store.dispatch(new ImageRecognitionGetDocumentAnModels(this.imageID));
    }
  }

  attemptDocumentAnalysis() {
    this.dialogsService.showConfirmation('Automatic classification: it will erase previous analysis', 'This action cannot be undone')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          this.dialogsService.showInput('Automatic classification', 'How many vertical pagesWithRegions do you wish to create?',
            '1').subscribe(value => {
            if (value) {
              const pagesToCreate = Number(value);
              this.store.dispatch(new ImageRecognitionAutomaticDocumentAnalysis({
                imageID: this.imageID,
                modelToUse: this.danalysisModel,
                numPages: pagesToCreate
              }));
              // this.mode = 'eEditing';
            }
          });
        }
      });
  }

}
