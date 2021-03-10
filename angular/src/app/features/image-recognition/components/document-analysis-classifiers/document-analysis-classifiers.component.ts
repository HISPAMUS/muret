import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Observable} from "rxjs";
import {ClassifierModel} from "../../../../core/model/entities/classifier-model";
import {AutomaticDocumentAnalysis} from "../../../document-analysis/store/actions/document-analysis.actions";
import {DialogsService} from "../../../../shared/services/dialogs.service";
import {ImageRecognitionState} from "../../store/state/image-recognition.state";
import {Store} from "@ngrx/store";
import {ImageRecognitionGetDocumentAnModels} from "../../store/actions/image-recognition.actions";
import {selectImageRecognitionDocumentAnalysisClassifierModels} from "../../store/selectors/image-recognition.selector";

@Component({
  selector: 'app-document-analysis-classifiers',
  templateUrl: './document-analysis-classifiers.component.html',
  styleUrls: ['./document-analysis-classifiers.component.css']
})
export class DocumentAnalysisClassifiersComponent implements OnInit, OnChanges {
  @Input() imageID: number;

  analysisStatus: string;
  danalysisModel:string;
  processing: boolean = false;
  documentAnalysisModels$: Observable<ClassifierModel[]>;

  constructor(private dialogsService: DialogsService, private store: Store<ImageRecognitionState>) { }

  ngOnInit(): void {
    this.analysisStatus = 'Analyze';
    this.documentAnalysisModels$ = this.store.select(selectImageRecognitionDocumentAnalysisClassifierModels);
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
              this.analysisStatus = 'Analyzing...';
              this.processing = true;
              this.store.dispatch(new AutomaticDocumentAnalysis({
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
