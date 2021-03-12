import {Component, EventEmitter, Input, OnChanges, Output, SimpleChanges} from '@angular/core';
import {SafeResourceUrl} from "@angular/platform-browser";
import {Observable} from "rxjs";
import {RegionType} from "../../../../../core/model/entities/region-type";
import {Shape} from "../../../../../svg/model/shape";
import {ContextMenuSVGSelectionEvent} from "../../../../../svg/model/context-menu-s-v-g-selection-event";
import {ZoomManager} from "../../../../../shared/model/zoom-manager";

@Component({
  selector: 'app-image-document-analysis-navigator',
  templateUrl: './image-document-analysis-navigator.component.html',
  styleUrls: ['./image-document-analysis-navigator.component.css']
})
export class ImageDocumentAnalysisNavigatorComponent implements OnChanges {
  @Input() loadedImage: SafeResourceUrl;
  @Input() regionTypes: RegionType[];
  @Input() shapes: Shape[];
  @Input() nextShapeToAdd: 'Rectangle' | 'Line' | 'Text' | 'Polylines';
  @Input() zoomManager: ZoomManager;
  @Input() addRegionTypeToFilter: RegionType;
  @Input() singleSelectionMode: boolean; // if this value is set just one symbol can be selected

  @Output() onNavigatorContextMenu = new EventEmitter<ContextMenuSVGSelectionEvent>();
  @Output() onShapesSelected = new EventEmitter<Shape[]>();
  @Output() modeChange = new EventEmitter(); // must have this name in order to be input / output

  @Output() onSvgShapeCreated = new EventEmitter<Shape>();
  @Output() onSvgShapeChanged = new EventEmitter<Shape>();


  modeValue: 'eSelecting' | 'eEditing' | 'eAdding';

  filteredOutRegionNames: Set<string> = new Set<string>();




  constructor() {
  }

  @Input()
  get mode() {
    return this.modeValue;
  }

  set mode(val) {
    if (this.modeValue !== val) {
      this.modeValue = val;
      this.modeChange.emit(this.modeValue);
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
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

  onSVGShapesSelected(shapes: Shape[]) {
    this.onShapesSelected.emit(shapes);
  }

  svgShapeChanged(shape: Shape) {
    this.onSvgShapeChanged.emit(shape);
  }

  svgShapeCreated(shape: Shape) {
    this.onSvgShapeCreated.emit(shape);
  }
}
