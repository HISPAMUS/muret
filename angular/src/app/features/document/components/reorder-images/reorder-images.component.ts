import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {DocumentState} from "../../store/state/document.state";
import {Store} from "@ngrx/store";
import {selectDocumentSection} from "../../store/selectors/document.selector";
import {Image} from "../../../../core/model/entities/image";
import {compareOrdering} from "../../../../core/model/entities/iordered";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {DocumentGetSection, DocumentReorderImages, DocumentReorderSections} from "../../store/actions/document.actions";
import {ImageFilesService} from "../../../../core/services/image-files.service";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";
import {Lightbox, LightboxConfig} from "ngx-lightbox";
import {map} from "rxjs/operators";
import {Section} from "../../../../core/model/entities/section";
import {CdkDragDrop, moveItemInArray} from "@angular/cdk/drag-drop";
import {Ordering} from "../../../../core/model/restapi/ordering";

@Component({
  selector: 'app-reorder-images',
  templateUrl: './reorder-images.component.html',
  styleUrls: ['./reorder-images.component.css']
})
export class ReorderImagesComponent implements OnInit, OnDestroy {
  sectionSubscription: Subscription;
  sortedImages: [Image, Observable<SafeResourceUrl>][];
  loadingImage = "assets/images/loading.svg";
  section: Section;

  constructor(private route: ActivatedRoute, private store: Store<DocumentState>,
              private imageFilesService: ImageFilesService, private sanitizer: DomSanitizer, private lightbox: Lightbox,
              private lighboxConfig: LightboxConfig) {
    this.sectionSubscription = store.select(selectDocumentSection).subscribe(next => {
      if (next) {
        this.sortedImages = [];
        this.section = next;
        const sorted = next.images.slice().sort(compareOrdering);
        sorted.forEach(image => {
          const loadedImage$ =
            this.imageFilesService.getThumbnailImageBlob$(next.documentPath, image.id).pipe(
            //map(imageBlob => this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)))
            map(imageBlob => window.URL.createObjectURL(imageBlob))
          );

          const entry: [Image, Observable<SafeResourceUrl>] = [
            image,
            loadedImage$
          ];
          this.sortedImages.push(entry);
        });
      }
    });
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      const sectionID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new DocumentGetSection(sectionID));
    });
  }

  ngOnDestroy(): void {
    this.sectionSubscription.unsubscribe();
  }

  sortedImagesTracking(index, item): number {
    return index;
  }


  drop(event: CdkDragDrop<[Image, Observable<SafeResourceUrl>][]>) {
    moveItemInArray(this.sortedImages, event.previousIndex, event.currentIndex);
    // translate this ordering into the list of ids
    const ordering: Ordering = {
      idsSequence: []
    }
    for (let i=0; i<this.sortedImages.length; i++) {
      ordering.idsSequence.push(this.sortedImages[i][0].id);
    }
    this.store.dispatch(new DocumentReorderImages(ordering));
  }
}
