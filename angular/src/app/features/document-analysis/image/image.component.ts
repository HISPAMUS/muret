import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnDestroy,
  OnInit,
  Output,
  SimpleChanges
} from '@angular/core';
import {Observable} from 'rxjs';
import {Shape} from '../../../svg/model/shape';
import {Store} from '@ngrx/store';
import {DocumentAnalysisState} from '../store/state/document-analysis.state';
import {selectImageHeight, selectImageURL, selectImageWidth} from '../store/selectors/document-analysis.selector';
import {GetImageURL} from '../store/actions/document-analysis.actions';
import {BoundingBox} from '../../../core/model/entities/bounding-box';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})
/**
 * Just in charge of showing an image with the option of zooming in and out
 */
export class ImageComponent implements OnInit, OnDestroy, OnChanges {
  @Input() imageID: number;
  @Input() shapes: Shape[];
  @Input() zoomFactor: number;
  @Input() crop: BoundingBox;
  @Input() nextShapeToDraw: 'Rectangle' | 'Line' | 'Text' | 'Path';
  selectedShapeValue: Shape;


  @Output() svgShapeCreated = new EventEmitter<Shape>();
  @Output() svgShapeChanged = new EventEmitter<Shape>();
  @Output() selectedShapeChange = new EventEmitter<Shape>();

  imageWidth$: Observable<number>;
  imageHeight$: Observable<number>;
  imageURL$: Observable<string>;

  canvasHeightPercentage: number;  // e.g. 100 for 100%
  canvasWidthPercentage: number;

  // @ViewChild('svgCanvasComponent') svgCanvasComponent: SvgCanvasComponent;

  private modeValue: 'eIdle' | 'eAdding' | 'eEditing' | 'eSelecting';
  @Output() modeChange = new EventEmitter();

  constructor(private docAnalysisStore: Store<DocumentAnalysisState>) {
    this.imageWidth$ = docAnalysisStore.select(selectImageWidth);
    this.imageHeight$ = docAnalysisStore.select(selectImageHeight);
    this.imageURL$ = docAnalysisStore.select(selectImageURL);
  }

  ngOnInit() {
    this.docAnalysisStore.dispatch(new GetImageURL(this.imageID)); // request image URL
    this.computeZoom();
  }

  ngOnDestroy() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.zoomFactor) {
      this.computeZoom();
    }
  }

  @Input()
  get mode() {
    return this.modeValue;
  }

  set mode(val) {
    this.modeValue = val;
    this.modeChange.emit(this.modeValue);
  }

  @Input()
  get selectedShape() {
    return this.selectedShapeValue;
  }

  set selectedShape(val) {
    if (this.selectedShapeValue !== val) {
      this.selectedShapeValue = val;
      this.selectedShapeChange.emit(val);
    }
  }

  private computeZoom() {
    this.canvasHeightPercentage = 100.0 * this.zoomFactor;
    this.canvasWidthPercentage = 100.0 * this.zoomFactor;
  }

  onShapeCreated($event: Shape) {
    this.svgShapeCreated.emit($event);
  }

  onShapeChanged($event: Shape) {
    this.svgShapeChanged.emit($event);
  }
}
