import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {selectPages} from '../../../features/document-analysis/store/selectors/document-analysis.selector';
import {Subscription} from 'rxjs';
import {Store} from '@ngrx/store';
import {Page} from '../../../core/model/entities/page';
import {Shape} from '../../../svg/model/shape';
import {GetRegion} from '../../../features/agnostic-representation/store/actions/agnostic-representation.actions';
import {Region} from '../../../core/model/entities/region';
import {BoundingBox} from '../../../core/model/entities/bounding-box';
import {Rectangle} from '../../../svg/model/rectangle';
import {selectSelectedRegion} from '../../../features/agnostic-representation/store/selectors/agnostic-representation.selector';

const regionRectangleStrokeWidth = 5;
const selectedRegionRectangleStrokeWidth = 25;

@Component({
  selector: 'app-image-preview',
  templateUrl: './image-preview.component.html',
  styleUrls: ['./image-preview.component.css']
})
export class ImagePreviewComponent implements OnInit, OnDestroy {
  @Input() imageID: number;
  @Output() selectedRegion = new EventEmitter<Region>();
  imagePreviewClass: string = null;
  isImagePreviewMinimized = false; // changed with toggle
  imagePreviewZoomFactor = 1;
  pagesSubscription: Subscription;
  imagePreviewShapes: Shape[];
  selectedRegionShapeIDValue: string;
  private selectedRegionSubscription: Subscription;

  constructor(private store: Store<any>) {
    this.selectedRegionShapeIDValue = null;
  }

  ngOnInit() {
    // the request of the imageProjection that generates the pages must be done by the host component
    // (agnostic-representation, semantic-representation)
    this.pagesSubscription = this.store.select(selectPages).subscribe(next => {
      if (next) {
        this.drawImagePreviewRegions(next);
      }
    });

    this.toggleImagePreview();

    this.selectedRegionSubscription = this.store.select(selectSelectedRegion).subscribe(next => {
      this.selectedRegion.emit(next);
      //see comment below this.highlightSelectedRegion(next);
    });
  }

  ngOnDestroy() {
    this.pagesSubscription.unsubscribe();
    this.selectedRegionSubscription.unsubscribe();
  }

  toggleImagePreview() {
    this.isImagePreviewMinimized = !this.isImagePreviewMinimized;
    if (this.isImagePreviewMinimized) {
      this.imagePreviewZoomFactor = 1.01; // force recompute sizes
      this.imagePreviewClass = 'imagePreviewMinimized';
    } else {
      this.imagePreviewZoomFactor = 0.99; // force recompute sizes
      this.imagePreviewClass = 'imagePreviewMaximized';
    }
  }

  private drawImagePreviewRegions(pages: Page[]) {
    this.imagePreviewShapes = new Array();
    if (pages) {
      pages.forEach(page => {
        if (page.regions) {
          page.regions.forEach(region => {
            this.drawImagePreviewRegion(region);
          });
        }
      });
    }
  }

  get selectedRegionShapeID() {
    return this.selectedRegionShapeIDValue;
  }

  set selectedRegionShapeID(id: string) {
    if (this.selectedRegionShapeIDValue !== id) {
      this.selectedRegionShapeIDValue = id;
      const shape = this.findSelectedRegionShape();
      if (shape) {
        this.store.dispatch(new GetRegion(shape.data.id));
      }
    }
  }

  private findSelectedRegionShape(): Shape {
    if (this.selectedRegionShapeID && this.imagePreviewShapes) {
      return this.imagePreviewShapes.find(s => s.id === this.selectedRegionShapeID);
    } else {
      return null;
    }
  }

  private drawImagePreviewRegion(region: Region) {
    this.drawBox(this.imagePreviewShapes, region,
      region.regionType.name, region.id, region.boundingBox, '#' + region.regionType.hexargb, regionRectangleStrokeWidth ).data = region;
  }

  private drawBox(shapes: Shape[], modelObject: Region,
                  layer: string, id: number, boundingBox: BoundingBox, color: string, strokeWidth: number): Rectangle {
    const rect = new Rectangle();
    rect.id = layer + id;
    rect.fromX = boundingBox.fromX;
    rect.fromY = boundingBox.fromY;
    rect.width = boundingBox.toX - boundingBox.fromX;
    rect.height  = boundingBox.toY - boundingBox.fromY;
    rect.fillColor = 'transparent';
    rect.strokeColor = color;
    rect.strokeWidth = strokeWidth;
    rect.layer = layer;
    rect.data = modelObject;
    shapes.push(rect);
    return rect;
  }

  /*Replaced by the property selectedShapeFillColor of ImageComponent
  private highlightSelectedRegion(next: Region) {
    if (this.imagePreviewShapes) {
      this.imagePreviewShapes.forEach(shape => {
        if (next && shape.data.id === next.id) {
          shape.strokeWidth = selectedRegionRectangleStrokeWidth;
        } else {
          shape.strokeWidth = regionRectangleStrokeWidth;
        }
      });
    }
  }*/
}
