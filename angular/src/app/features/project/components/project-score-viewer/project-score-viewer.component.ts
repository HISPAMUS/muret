import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {ProjectState} from '../../store/state/project.state';
import {
  ExportMEI,
  ExportMEIPartsFacsimile,
  ExportMensurstrich,
  ExportMusicXML,
  GetImages,
  GetProject
} from '../../store/actions/project.actions';
import {selectImages, selectProject, selectProjectMEI} from '../../store/selectors/project.selector';
import {Observable, Subscription} from 'rxjs';
import {NotationService} from '../../../semantic-representation/services/notation.service';
import { saveAs } from 'file-saver';
import {Project} from '../../../../core/model/entities/project';
import {selectUsesOfParts} from '../../../parts/store/selectors/parts.selector';
import {findPartsUsed, UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';
import {GetUsesOfParts} from '../../../parts/store/actions/parts.actions';
import {Image} from '../../../../core/model/entities/image';

interface SelectedImage {
  checked: boolean;
  image: Image;
}

@Component({
  selector: 'app-project-score-viewer',
  templateUrl: './project-score-viewer.component.html',
  styleUrls: ['./project-score-viewer.component.css']
})
// don't use here REDUX for the FileUploader
export class ProjectScoreViewerComponent implements OnInit, OnDestroy {
  private projectID: number;
  private meiSubscription: Subscription;
  notationAsSVG: any;
  private mei: string;
  project$: Observable<Project>;

  usesOfParts: UsesOfParts;
  public selectedImages: SelectedImage[];
  private usesOfPartsSubscription: Subscription;
  private imageSubscription: Subscription;

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<ProjectState>,
              private notationService: NotationService) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.projectID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new GetProject(this.projectID));

      this.store.dispatch(new GetUsesOfParts(this.projectID));
      this.store.dispatch(new GetImages(this.projectID));

      /// this.store.dispatch(new GetProjectParts(this.projectID));

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

    this.project$ = this.store.select(selectProject);
    this.store.dispatch(new GetUsesOfParts(this.projectID));
    this.meiSubscription = this.store.select(selectProjectMEI).subscribe(next => {
      this.notationAsSVG = this.notationService.renderScore(next);
      this.mei = next;
    });
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
    saveAs(blob, 'export_' + this.projectID + '.mei');
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
    this.store.dispatch(new ExportMEI(this.projectID, null, this.getIDOfSelectedImages()));
  }

  render(partID: number) {
    this.store.dispatch(new ExportMEI(this.projectID, partID, this.getIDOfSelectedImages()));
  }

  exportPartsAndFacsimile() {
    this.store.dispatch(new ExportMEIPartsFacsimile(this.projectID, this.getIDOfSelectedImages()));
  }

  exportFullMensurstrich() {
    this.store.dispatch(new ExportMensurstrich(this.projectID, this.getIDOfSelectedImages()));
  }

  exportMusicXML() {
    this.store.dispatch(new ExportMusicXML(this.projectID, this.getIDOfSelectedImages()));
  }

  trackByImageFn(index, item: Image) {
    return item.id; // unique id corresponding to the item
  }

  trackByPartNameFn(index, item: string) {
    return index; // unique id corresponding to the item
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
}
