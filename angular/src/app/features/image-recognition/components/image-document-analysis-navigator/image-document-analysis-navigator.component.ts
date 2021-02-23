import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ImageFilesService} from "../../../../core/services/image-files.service";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";
import {ImageOverview} from "../../model/image-overview";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {RegionType} from "../../../../core/model/entities/region-type";
import {Shape} from "../../../../svg/model/shape";

@Component({
  selector: 'app-image-document-analysis-navigator',
  templateUrl: './image-document-analysis-navigator.component.html',
  styleUrls: ['./image-document-analysis-navigator.component.css']
})
export class ImageDocumentAnalysisNavigatorComponent implements OnChanges {
  @Input() imageOverview: ImageOverview;
  @Input() regionTypes: RegionType[];
  @Input() shapes: Shape[];
  filteredOutRegionNames: Set<string> = new Set<string>();

  loadedImage$: Observable<SafeResourceUrl>;
  zoomFactor = 1;

  constructor(private imageFilesService: ImageFilesService, private sanitizer: DomSanitizer,
              ) {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.imageOverview && this.imageOverview) { //} && this.imageOverview.documentPath && this.imageOverview.imageID) {
      this.loadedImage$ = this.imageFilesService.getMasterImageBlob$(this.imageOverview.documentPath, this.imageOverview.imageID).pipe(
        //map(imageBlob => this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)))
        map(imageBlob => window.URL.createObjectURL(imageBlob))
      );
    }
    if (changes.shapes) {
      this.doFilterOut();
    }
  }

  onFilterChange($event: Set<string>) {
    this.filteredOutRegionNames = $event;
    this.doFilterOut();
  }

  private doFilterOut() {
    if (this.shapes) {
      this.shapes.forEach(shape => {
        shape.hidden = this.filteredOutRegionNames.has(shape.layer);
      });
    }
  }
}
