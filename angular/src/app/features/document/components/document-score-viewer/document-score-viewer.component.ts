import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {DocumentState} from '../../store/state/document.state';
import {
  ExportMEI,
  ExportMEIPartsFacsimile,
  ExportMensurstrich,
  ExportMusicXML,
  GetImages,
  GetDocument, PreflightCheck
} from '../../store/actions/document.actions';
import {selectImages, selectDocument, selectDocumentMEI, selectPreflightCheckResults} from '../../store/selectors/document.selector';
import {Observable, Subscription} from 'rxjs';
import {NotationService} from '../../../semantic-representation/services/notation.service';
import { saveAs } from 'file-saver';
import {Document} from '../../../../core/model/entities/document';
import {selectUsesOfParts} from '../../../parts/store/selectors/parts.selector';
import {findPartsUsed, UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';
import {GetUsesOfParts} from '../../../parts/store/actions/parts.actions';
import {Image} from '../../../../core/model/entities/image';
import {
  PreflightCheckResult,
  PreflightCkeckImageResult,
  PreflightCkeckRegionResult
} from '../../../../core/model/restapi/preflight-check-result';

interface SelectedImage {
  checked: boolean;
  image: Image;
}

@Component({
  selector: 'app-document-score-viewer',
  templateUrl: './document-score-viewer.component.html',
  styleUrls: ['./document-score-viewer.component.css']
})
// don't use here REDUX for the FileUploader
export class DocumentScoreViewerComponent implements OnInit, OnDestroy {
  private documentID: number;
  private meiSubscription: Subscription;
  notationAsSVG: any;
  private mei: string;
  document$: Observable<Document>;

  usesOfParts: UsesOfParts;
  public selectedImages: SelectedImage[];
  private usesOfPartsSubscription: Subscription;
  private imageSubscription: Subscription;
  public preflightCheckResults$: Observable<PreflightCheckResult>;

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<DocumentState>,
              private notationService: NotationService) {
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
    this.meiSubscription = this.store.select(selectDocumentMEI).subscribe(next => {
      this.notationAsSVG = this.notationService.renderScore(next);
      this.mei = next;
    });

    this.preflightCheckResults$ = this.store.select(selectPreflightCheckResults);
  }

  ngOnDestroy(): void {
    this.meiSubscription.unsubscribe();
    this.usesOfPartsSubscription.unsubscribe();
    this.imageSubscription.unsubscribe();
  }

  saveFile() {
    const headers = new Headers();
    headers.append('Accept', 'text/plain');
    this.saveToFileSystem(this.mei);
  }

  private saveToFileSystem(mei: string) {
    const blob = new Blob([mei], { type: 'text/plain' });
    saveAs(blob, 'export_' + this.documentID + '.mei');
  }

  getIDOfSelectedImages(): Array<number> {
    const result: Array<number> = new Array<number>();
    this.selectedImages.forEach(selectedImage => {
      if (selectedImage.checked) {
        result.push(selectedImage.image.id);
      }
    });
    return result;
  }

  renderFullScore() {
    this.store.dispatch(new ExportMEI(this.documentID, null, this.getIDOfSelectedImages()));
  }

  render(partID: number) {
    this.store.dispatch(new ExportMEI(this.documentID, partID, this.getIDOfSelectedImages()));
  }

  exportPartsAndFacsimile() {
    this.store.dispatch(new ExportMEIPartsFacsimile(this.documentID, this.getIDOfSelectedImages()));
  }

  exportFullMensurstrich() {
    this.store.dispatch(new ExportMensurstrich(this.documentID, this.getIDOfSelectedImages()));
  }

  exportMusicXML() {
    this.store.dispatch(new ExportMusicXML(this.documentID, this.getIDOfSelectedImages()));
  }

  trackByImageFn(index, item: Image) {
    return item.id; // unique id corresponding to the item
  }

  trackByPartNameFn(index, item: string) {
    return index;
  }

  trackByPreflightResultImageFn(index, item: PreflightCkeckImageResult) {
    return item.imageID;
  }

  trackByPreflightResultRegionMessageFn(index, item: PreflightCkeckRegionResult) {
    return item.regionID;
  }

  trackByPreflightResultMessageFn(index, item: string) {
    return index;
  }

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
  preflightCheck() {
    this.store.dispatch(new PreflightCheck(this.documentID, this.getIDOfSelectedImages()));
  }

  openSemanticRegion(imageID: number, regionID: number) {
    this.router.navigate(['semanticrepresentation', imageID, {region_id: regionID}]); // region_id is an optional parameter
  }

  openSemanticImage(imageID: number) {
    this.router.navigate(['semanticrepresentation', imageID]);
  }
}
