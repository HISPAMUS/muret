import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ImageFilesService} from "../../../../core/services/image-files.service";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";
import {ImageOverview} from "../../model/image-overview";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-image-document-analysis-navigator',
  templateUrl: './image-document-analysis-navigator.component.html',
  styleUrls: ['./image-document-analysis-navigator.component.css']
})
export class ImageDocumentAnalysisNavigatorComponent implements OnChanges {
  @Input() imageOverview: ImageOverview;
  loadedImage$: Observable<SafeResourceUrl>;

  constructor(private imageFilesService: ImageFilesService, private sanitizer: DomSanitizer) { }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.imageOverview && this.imageOverview) {
      this.loadedImage$ = this.imageFilesService.getPreviewImageBlob$(this.imageOverview.documentPath, this.imageOverview.imageID).pipe(
        map(imageBlob => this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)))
      );
    }
  }



}
