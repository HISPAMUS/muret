import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {ImageFilesService} from "../../../../core/services/image-files.service";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";
import {ImageOverview} from "../../../../core/model/restapi/image-overview";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {RegionType} from "../../../../core/model/entities/region-type";
import {Shape} from "../../../../svg/model/shape";
import {SelectionManager} from "../../../../shared/directives/selection-manager";
import {ContextMenuSVGSelectionEvent} from "../../../../svg/model/context-menu-s-v-g-selection-event";
import {ZoomManager} from "../../../../shared/model/zoom-manager";

@Component({
  selector: 'app-image-document-analysis-navigator',
  templateUrl: './image-document-analysis-navigator.component.html',
  styleUrls: ['./image-document-analysis-navigator.component.css']
})
export class ImageDocumentAnalysisNavigatorComponent implements OnChanges {
  @Input() imageOverview: ImageOverview;
  @Input() regionTypes: RegionType[];
  @Input() shapes: Shape[];
  @Output() onNavigatorContextMenu = new EventEmitter<ContextMenuSVGSelectionEvent>();
  @Input() zoomManager: ZoomManager;

  filteredOutRegionNames: Set<string> = new Set<string>();

  loadedImage$: Observable<SafeResourceUrl>;
  selectionManager: SelectionManager;

  constructor(private imageFilesService: ImageFilesService, private sanitizer: DomSanitizer,
              ) {
    this.selectionManager = new SelectionManager();
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

  onSVGContextMenu(selectedShapes: ContextMenuSVGSelectionEvent) {
    this.onNavigatorContextMenu.emit(selectedShapes);
  }
}
