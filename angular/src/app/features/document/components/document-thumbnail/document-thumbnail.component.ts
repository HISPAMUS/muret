import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Part} from "../../../../core/model/entities/part";
import {ImageFilesService} from "../../../../core/services/image-files.service";
import {map} from "rxjs/operators";
import {Observable} from "rxjs";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";
import {SelectionManager} from "../../../../shared/directives/selection-manager";
import {ContextMenuComponent} from "ngx-contextmenu";
import {Lightbox, LightboxConfig} from "ngx-lightbox";
import {Section} from "../../../../core/model/entities/section";
import {Store} from "@ngrx/store";
import {DocumentState} from "../../store/state/document.state";
import {DocumentLinkImagesToPart, DocumentMoveImagesToSection} from "../../store/actions/document.actions";
import {SectionImages} from "../../../../core/model/restapi/section-images";
import {PartsLinkPartToImage} from "../../../parts/store/actions/parts.actions";
import {NumberArray} from "../../../../core/model/restapi/number-array";

@Component({
  selector: 'app-document-thumbnail',
  templateUrl: './document-thumbnail.component.html',
  styleUrls: ['./document-thumbnail.component.css']
})
export class DocumentThumbnailComponent implements OnInit {
  @Input() documentPath: string;
  @Input() section: Section;
  @Input() sections: Section[];
  @Input() imageID: number;
  @Input() filename: string;
  @Input() documentParts: Part[];
  @Input() selectionManager: SelectionManager;
  @Input() imagePartIds: number[];

  loadedImage$: Observable<SafeResourceUrl>;
  loadingImage = "assets/images/loading.svg";
  imageClass: string;
  @ViewChild(ContextMenuComponent, { static: true }) public contextualMenu: ContextMenuComponent; // , { static: true } for avoiding ExpressionChangedAfterItHasCheckedError

  constructor(private imageFilesService: ImageFilesService, private sanitizer: DomSanitizer, private lightbox: Lightbox,
              private lighboxConfig: LightboxConfig, private store: Store<DocumentState>
  ) {
    lighboxConfig.fitImageInViewPort = true;
    this.imageClass = '';
    //TODO Quitar
    this.imagePartIds = [13];
  }

  ngOnInit(): void {
    this.loadedImage$ = this.imageFilesService.getThumbnailImageBlob$(this.documentPath, this.imageID).pipe(
      //map(imageBlob => this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)))
      map(imageBlob => window.URL.createObjectURL(imageBlob))
    );
  }

  onSelect() {
    this.imageClass = 'selected';
  }

  onDeselect() {
    this.imageClass = '';
  }

  preview() {
    this.imageFilesService.getPreviewImageBlob$(this.documentPath, this.imageID).subscribe(imageBlob => {
      const albums = []; // used by Lightbox

      const album = {
        src: this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)),
        caption: this.filename,
      };

      albums.push(album);
      this.lightbox.open(albums);
      // window.open(window.URL.createObjectURL(imageBlob), 'Preview ' + this.image.filename, 'widthPercentage=1280,heightPercentage=720');
    });
  }

  moveToSection(section: Section) {
    const sectionImages: SectionImages = {
      newSectionID: section ? section.id : null,
      imageIDS: []
    };
    if (this.selectionManager.getSelected().length > 0) {
      this.selectionManager.getSelected().forEach(selectable => {
        const id = selectable.getSelectedModelID();
        sectionImages.imageIDS.push(id);
      });
    } else {
      // no selectionManager has been done but the right clicked object must be moved
      sectionImages.imageIDS.push(this.imageID);
    }
    this.store.dispatch(new DocumentMoveImagesToSection(sectionImages));
  }

  sectionTracking(index, item): number {
    return index;
  }

  partTracking(index, item): number {
    return index;
  }

  getImageID() {
    return this.imageID;
  }

  linkToPart(part: Part) {
    const imageIDs: NumberArray = {
      values: []
    }
    if (this.selectionManager.getSelected().length > 0) {
      this.selectionManager.getSelected().forEach(selectable => {
        const id = selectable.getSelectedModelID();
        imageIDs.values.push(id);
      });
    } else {
      // no selectionManager has been done but the right clicked object must be moved
      imageIDs.values.push(this.imageID);
    }

    this.store.dispatch(new DocumentLinkImagesToPart(imageIDs, part.id));
  }
}
