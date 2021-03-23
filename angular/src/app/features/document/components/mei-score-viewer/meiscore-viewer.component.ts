import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';
import {NotationService} from '../../../../shared/services/notation.service';
import {Subscription} from 'rxjs';
import {Store} from '@ngrx/store';
import {DocumentState} from '../../store/state/document.state';
import {
  selectDocumentExportedFile, selectDocumentExportedMPEditorFile,
  selectDocumentMEI,
} from '../../store/selectors/document.selector';
import {DocumentExportMEI, DocumentExportMEIPartsFacsimile} from "../../store/actions/document.actions";
import {NumberArray} from "../../../../core/model/restapi/number-array";
import {DocumentExport} from "../../../../core/model/restapi/document-export";
import {DialogsService} from "../../../../shared/services/dialogs.service";
import {saveAs} from 'file-saver';

//TODO Mejorar el mecanismo de exportación
@Component({
  selector: 'app-meiscore-viewer',
  templateUrl: './meiscore-viewer.component.html',
  styleUrls: ['./meiscore-viewer.component.css']
})
export class MEIScoreViewerComponent implements OnInit, OnDestroy {
  private _selectedImages: NumberArray;
  private documentPath: string;

  notationAsSVG: any;
  meiSubscription: Subscription;
  private exportingSubscription: Subscription;


  documentExport: DocumentExport;
  private selectDocumentExportedMPEditorFileSubscription: Subscription;


  constructor(private notationService: NotationService, private store: Store<DocumentState>, private dialogsService: DialogsService) {
  }


  ngOnInit() {
    // data is stored in store after DocumentExportMEI action
    this.meiSubscription = this.store.select(selectDocumentMEI).subscribe(next => {
      if (next) {
        this.notationAsSVG = this.notationService.renderScore(next);
      }
    });

    this.exportingSubscription = this.store.select(selectDocumentExportedFile).subscribe(next => {
      if (next) {
        this.documentExport = next; // generated on creating the MEI for Verovio
      }
    });

    this.selectDocumentExportedMPEditorFileSubscription = this.store.select(selectDocumentExportedMPEditorFile).subscribe(next => {
      if (next) {
        this.saveExportedFile(next, '_mpeditor.mei');
      }
    });
  }


  public init(selectedImages: NumberArray, documentPath: string) {
    this._selectedImages = selectedImages;
    this.documentPath = documentPath;
    this.store.dispatch(new DocumentExportMEI(null, this._selectedImages));
  }

  ngOnDestroy(): void {
    this.meiSubscription.unsubscribe();
    this.exportingSubscription.unsubscribe();
    this.selectDocumentExportedMPEditorFileSubscription.unsubscribe();
  }

  downloadMEI() {
    if (!this.documentExport) {
      throw new Error('The MEI has not been generated');
    }
    this.saveExportedFile(this.documentExport, '.mei');
  }

  private saveExportedFile(next: DocumentExport, suffix: string) {
    const defaultFileName = this.documentPath + '_' + this._selectedImages.values.join('-') + suffix;
    saveAs(next.file, defaultFileName);
    /*this.dialogsService.showInput('Save file as',
      //next.fileExtension
      'Please, input a file name', defaultFileName, true).subscribe(filename => {
      if (filename) {
        saveAs(next.file, filename);
      }
    });*/
  }


  exportMPEditor() {
    this.store.dispatch(new DocumentExportMEIPartsFacsimile(this._selectedImages, true));
  }

}
