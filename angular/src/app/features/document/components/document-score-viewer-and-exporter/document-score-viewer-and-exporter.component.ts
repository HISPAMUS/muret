import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {DocumentState} from '../../store/state/document.state';
import {
  ExportMEI,
  ExportMEIPartsFacsimile,
  ExportMensurstrich,
  ExportMusicXML,
  GetDocument, GetImages, ResetDocumentServerError,
} from '../../store/actions/document.actions';
import {
  selectDocument,
  selectDocumentAPIRestErrorSelector,
  selectExportedFile,
  selectImages
} from '../../store/selectors/document.selector';
import {Observable, Subscription} from 'rxjs';
import {saveAs} from 'file-saver';
import {Document} from '../../../../core/model/entities/document';
import {selectUsesOfParts} from '../../../parts/store/selectors/parts.selector';
import {findPartsUsed, UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';
import {GetUsesOfParts} from '../../../parts/store/actions/parts.actions';
import {Image} from '../../../../core/model/entities/image';
import {DocumentExport, DocumentExportType} from '../../../../core/model/restapi/document-export';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {ShowErrorService} from '../../../../core/services/show-error.service';

interface SelectedImage {
  checked: boolean;
  image: Image;
}

@Component({
  selector: 'app-document-score-viewer',
  templateUrl: './document-score-viewer-and-exporter.component.html',
  styleUrls: ['./document-score-viewer-and-exporter.component.css']
})
// don't use here REDUX for the FileUploader
export class DocumentScoreViewerAndExporterComponent implements OnInit, OnDestroy {
  private documentID: number;
  // private meiSubscription: Subscription;
  document$: Observable<Document>;

  usesOfParts: UsesOfParts;
  public selectedImages: SelectedImage[];
  private usesOfPartsSubscription: Subscription;
  private imageSubscription: Subscription;
  private exportingSubscription: Subscription;
  private serverErrorSubscription: Subscription;
  exportingState: Map<DocumentExportType, boolean> = new Map<DocumentExportType, boolean>();
  private generatingMEIVisualization = false;

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<DocumentState>,
              private dialogsService: DialogsService,
              private showErrorService: ShowErrorService) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.documentID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new GetDocument(this.documentID));

      this.store.dispatch(new GetUsesOfParts(this.documentID));
      this.store.dispatch(new GetImages(this.documentID));

      /// this.store.dispatch(new GetDocumentParts(this.documentID));

      this.usesOfPartsSubscription = this.store.select(selectUsesOfParts).subscribe(next => {
        this.usesOfParts = next;
      });

      this.imageSubscription = this.store.select(selectImages).subscribe(next => {
        if (next) {
          this.selectedImages = new Array();
          next.forEach(nextImage => {
            this.selectedImages.push({
              checked: true,
              image: nextImage
            });
          });
        }
      });
    });

    this.document$ = this.store.select(selectDocument);
    this.store.dispatch(new GetUsesOfParts(this.documentID));
    /*this.meiSubscription = this.store.select(selectDocumentMEI).subscribe(next => {
      this.notationAsSVG = this.notationService.renderScore(next);
      this.mei = next;
    });*/

    // this.preflightCheckResults$ = this.store.select(selectPreflightCheckResults); // remove

    this.exportingSubscription = this.store.select(selectExportedFile).subscribe(next => {
      if (next && this.exportingState.get(next.type)) {
          if (next.type === DocumentExportType.mei_score && this.generatingMEIVisualization) {
            this.exportingState.set(next.type, false);
            this.openMEIRenderingScreen();
          } else {
            this.exportingState.set(next.type, false);
            this.saveExportedFile(next);
          }
        } else {
          if (next) {
            this.exportingState.set(next.type, false);
          }
        }
    });

    this.serverErrorSubscription = this.store.select(selectDocumentAPIRestErrorSelector).subscribe(next => {
      if (next) {
        this.exportingState.clear();
        this.showErrorService.warning(next);
        this.store.dispatch(new ResetDocumentServerError());
      }
    });
  }

  ngOnDestroy(): void {
    // this.meiSubscription.unsubscribe();
    this.usesOfPartsSubscription.unsubscribe();
    this.imageSubscription.unsubscribe();
    this.exportingSubscription.unsubscribe();
    this.serverErrorSubscription.unsubscribe();
  }

  /*saveFile() {
    const headers = new Headers();
    headers.append('Accept', 'text/plain');
    this.saveToFileSystem(this.mei_score);
  }*/

  /* private saveToFileSystem(mei_score: string) {
    const blob = new Blob([mei_score], { type: 'text/plain' });
    saveAs(blob, 'export_' + this.documentID + '.mei_score');
  } */

  getIDOfSelectedImages(): Array<number> {
    const result: Array<number> = new Array<number>();
    this.selectedImages.forEach(selectedImage => {
      if (selectedImage.checked) {
        result.push(selectedImage.image.id);
      }
    });
    return result;
  }

  exportMEI() {
    this.generatingMEIVisualization = false;
    this.exportingState.set(DocumentExportType.mei_score, true);
    this.store.dispatch(new ExportMEI(this.documentID, null, this.getIDOfSelectedImages()));
  }

  visualizeMEI() {
    this.generatingMEIVisualization = true;
    this.exportingState.set(DocumentExportType.mei_score, true);
    this.store.dispatch(new ExportMEI(this.documentID, null, this.getIDOfSelectedImages()));
  }

  exportPartsAndFacsimile() {
    this.exportingState.set(DocumentExportType.mei_parts_facsimile, true);
    this.store.dispatch(new ExportMEIPartsFacsimile(this.documentID, this.getIDOfSelectedImages()));
  }

  exportFullMensurstrich() {
    this.exportingState.set(DocumentExportType.mensurstrich_svg, true);
    this.store.dispatch(new ExportMensurstrich(this.documentID, this.getIDOfSelectedImages()));
  }

  exportMusicXML() {
    this.exportingState.set(DocumentExportType.musicxml, true);
    this.store.dispatch(new ExportMusicXML(this.documentID, this.getIDOfSelectedImages()));
  }

  trackByImageFn(index, item: Image) {
    return item.id; // unique id corresponding to the item
  }

  trackByPartNameFn(index, item: string) {
    return index;
  }

  /*trackByPreflightResultImageFn(index, item: PreflightCkeckImageResult) {
    return item.imageID;
  }

  trackByPreflightResultRegionMessageFn(index, item: PreflightCkeckRegionResult) {
    return item.regionID;
  }

  trackByPreflightResultMessageFn(index, item: string) {
    return index;
  }*/

  partsUsedByImage(image: Image): Array<string> {
    if (this.usesOfParts != null) {
      return findPartsUsed(this.usesOfParts, image.id);
    } else {
      return [];
    }
  }

  selectAllImages() {
    this.selectedImages.forEach(selectedImage => {
      selectedImage.checked = true;
    });
  }

  selectNoImage() {
    this.selectedImages.forEach(selectedImage => {
      selectedImage.checked = false;
    });
  }

  /**
   * @deprecated Use AlignmentPreviewController
   */
  /*preflightCheck() {
    this.store.dispatch(new PreflightCheck(this.documentID, this.getIDOfSelectedImages()));
  }*/

  openSemanticRegion(imageID: number, regionID: number) {
    this.router.navigate(['semanticrepresentation', imageID, {region_id: regionID}]); // region_id is an optional parameter
  }

  openSemanticImage(imageID: number) {
    this.router.navigate(['semanticrepresentation', imageID]);
  }

  private saveExportedFile(next: DocumentExport) {
    this.dialogsService.showInput('Save file as',
      'Please, input a file name', next.type + '_' + this.documentID + '.' + next.fileExtension).subscribe(filename => {
       if (filename) {
         saveAs(next.file, filename);
       }
    });
  }

  isExportingMensurstrich() {
    return this.exportingState.get(DocumentExportType.mensurstrich_svg);
  }

  isExportingMusicXML() {
    return this.exportingState.get(DocumentExportType.musicxml);
  }

  isExportingPartsAndFacsimile() {
    return this.exportingState.get(DocumentExportType.mei_parts_facsimile);
  }

  isExportingMEI() {
    return this.exportingState.get(DocumentExportType.mei_score) && !this.generatingMEIVisualization;
  }

  isVisualizingMEI() {
    return this.exportingState.get(DocumentExportType.mei_score) && this.generatingMEIVisualization;
  }

  private openMEIRenderingScreen() {
    // the MEI content and file are stored in the store
    this.router.navigate(['/document/meiScoreView', this.documentID]);
  }

  /*aaa() {
    this.toastr.warning('Hello world!', 'Toastr fun!');
  }*/
  exportToVHV() {
    window.open("http://verovio.humdrum.org", "_blank");
  }
}
