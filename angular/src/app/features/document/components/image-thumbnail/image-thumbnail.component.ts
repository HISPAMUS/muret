import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';
import {Image} from '../../../../core/model/entities/image';
import {ImageFilesService} from '../../../../core/services/image-files.service';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Document} from '../../../../core/model/entities/document';
import {Lightbox, LightboxConfig} from 'ngx-lightbox';
import {Store} from '@ngrx/store';
import {PartsState} from '../../../parts/store/state/parts.state';
import {findPartsUsed, UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';

/**
 * When entering here the usesOfParts should be loaded by the document
 */
@Component({
  selector: 'app-image-thumbnail',
  templateUrl: './image-thumbnail.component.html',
  styleUrls: ['./image-thumbnail.component.css']
})
// see https://stackoverflow.com/questions/49411283/angular-5-http-get-images-from-back-end
export class ImageThumbnailComponent implements OnInit {
  @Input() document: Document;
  @Input() image: Image;
  @Input() usesOfParts: UsesOfParts;
  @Input() documentPath: string;
  // loadingImage = 'assets/loading.svg';
  loadedImage$: Observable<SafeResourceUrl>;
  // partsUsedInImage$: Observable<string[]>;

  constructor(private router: Router,
              private imageFilesService: ImageFilesService,
              private lightbox: Lightbox,
              private lighboxConfig: LightboxConfig,
              private sanitizer: DomSanitizer,
              private store: Store<PartsState>,
  ) {
    lighboxConfig.fitImageInViewPort = true;
  }

  ngOnInit() {
    this.loadedImage$ = this.imageFilesService.getThumbnailImageBlob$(this.documentPath, this.image.id).pipe(
      map(imageBlob => this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)))
      );


    /*this.imageFilesService.getThumbnailImage$(this.documentPath, this.image.id).subscribe(
      imageBlob => this.imageThumbnail.nativeElement.src = window.URL.createObjectURL(imageBlob));*/

    // this.store.dispatch(new GetPartNamesUsedByImage(this.image.id));
    // this.store.dispatch(new GetUsesOfParts(this.documentID)); The use of parts should already be loaded at document component

    // this.partsUsedInImage$ = this.store.select(selectPartsUsedInImage);
  }

  previewImage() {
    this.imageFilesService.getPreviewImageBlob$(this.documentPath, this.image.id).subscribe(imageBlob => {
      const albums = []; // used by Lightbox

      const album = {
        src: this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)),
        caption: this.image.filename,
      };

      albums.push(album);
      this.lightbox.open(albums);
      // TODO volver a dejar Lightbox cuando se actualice de versión 1.2.0
      // window.open(window.URL.createObjectURL(imageBlob), 'Preview ' + this.image.filename, 'widthPercentage=1280,heightPercentage=720');
    });
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.image.id]);
  }

  openAgnostic() {
    this.router.navigate(['agnosticrepresentation', this.image.id]);
  }

  openSemantic() {
    this.router.navigate(['semanticrepresentation', this.image.id]);
  }

  trackByPartNameFn(index, item: string) {
    return index; // unique id corresponding to the item
  }

  partsUsed(): Array<string> {
    if (this.usesOfParts != null) {
      return findPartsUsed(this.usesOfParts, this.image.id);
    } else {
      return [];
    }
  }
}
