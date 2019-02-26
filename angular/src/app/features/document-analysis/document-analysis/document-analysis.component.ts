import {Component, OnInit, Self, ViewChild} from '@angular/core';
import {DocumentAnalysisService} from '../document-analysis.service';
import {Observable, of} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {map, switchMap, tap} from 'rxjs/operators';
import {ImageFilesService} from '../../../shared/services/image-files.service';
import {DocumentAnalysisImageProjection} from '../../../shared/projections/document-analysis-image-projection';
import {Rectangle} from '../../../svg/model/rectangle';
import {Line} from '../../../svg/model/line';
import {Text} from '../../../svg/model/text';
import {Path} from '../../../svg/model/path';
import {Shape} from '../../../svg/model/shape';
import {SvgCanvasComponent} from '../../../svg/components/svg-canvas/svg-canvas.component';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {SVGCanvasState} from '../../../svg/services/svg-canvas-state.service';
import {RegionType} from '../../../shared/entities/region-type';

@Component({
  selector: 'app-document-analysis',
  templateUrl: './document-analysis.component.html',
  styleUrls: ['./document-analysis.component.css'],
  providers: [DocumentAnalysisService]
})
export class DocumentAnalysisComponent implements OnInit {
  documentAnalysisImageProjection$: Observable<DocumentAnalysisImageProjection>;
  loadingImage = 'assets/loading.svg';
  loadedImage$: Observable<string>;

  regionTypes$: Observable<RegionType[]>;

  private shapes: Shape[];
  private imageHeight: number;
  private imageWidth: number;


  @ViewChild('svgCanvasComponent') svgCanvasComponent: SvgCanvasComponent;
  canvasHeightPercentage: number;  // e.g. 100 for 100%
  canvasWidthPercentage: number;
  zoomFactor = 1;

  checkboxGroupForm: FormGroup;

  constructor(@Self() private documentAnalysisService: DocumentAnalysisService,
              private imageFilesService: ImageFilesService,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder
              ) {
      this.checkboxGroupForm = this.formBuilder.group({
        pages: true
      });
  }

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    // get different region types
    this.regionTypes$ = this.documentAnalysisService.getRegionTypes$().pipe(
      tap(regions => regions.forEach(region => {
        this.checkboxGroupForm.addControl(region.name, new FormControl());
        }
      ))
    );

    // download image
    this.documentAnalysisImageProjection$ = this.documentAnalysisService.getDocumentAnalysisImageProjection$(id);
    this.loadedImage$ = this.documentAnalysisImageProjection$.pipe(
      switchMap(next => {
        return this.readImageContents(next);
      })
    );



    this.shapes = new Array();
    const rect = new Rectangle();
    rect.id = '1';
    rect.fromX = 0;
    rect.fromY = 0;
    rect.width = 1000;
    rect.height  = 500;
    rect.strokeDashArray = '20';
    rect.fillColor = 'blue';
    rect.strokeColor = 'green';
    rect.strokeWidth = 20;

    this.shapes.push(rect);


    const line = new Line();
    line.id = '2';
    line.fromX = 0;
    line.fromY = 0;
    line.toX = 2965;
    line.toY = 2126;
    line.strokeColor = 'yellow';
    line.strokeWidth = 10;
    this.shapes.push(line);

    const text = new Text();
    text.id = '3';
    text.fromX = 125;
    text.fromY = 123;
    text.text = 'David';
    this.shapes.push(text);

    const path = new Path();
    path.id = '4';
    path.d = 'M150 0 L75 200 L225 200 Z';
    this.shapes.push(path);


    text.fromX = 0;
    text.fromY = 200;


    this.computeZoom();
  }

  private readImageContents(documentAnalysisImageProjection: DocumentAnalysisImageProjection) {
    this.imageWidth = documentAnalysisImageProjection.width;
    this.imageHeight = documentAnalysisImageProjection.height;

    return this.imageFilesService.getMasterImageBlob$(documentAnalysisImageProjection.projectPath, documentAnalysisImageProjection.id).
      pipe(map(imageBlob => window.URL.createObjectURL(imageBlob)));
  }

  zoomIn() {
    this.zoomFactor += 0.5;
    this.computeZoom();
  }

  zoomOut() {
    this.zoomFactor = Math.max(1, this.zoomFactor - 0.5);
    this.computeZoom();
  }

  zoomFit() {
    this.zoomFactor = 1;
    this.computeZoom();
  }

  private computeZoom() {
    this.canvasHeightPercentage = 100.0 * this.zoomFactor;
    this.canvasWidthPercentage = 100.0 * this.zoomFactor;
  }

  public select(): SVGCanvasState {
    return this.svgCanvasComponent.requestStateChange(SVGCanvasState.eSelecting);
  }

  public edit(): SVGCanvasState {
    return this.svgCanvasComponent.requestStateChange(SVGCanvasState.eEditing);
  }

  public draw(): SVGCanvasState {
    return this.svgCanvasComponent.requestStateChange(SVGCanvasState.eDrawing, Rectangle);
  }


  onShapeCreated(shape: Shape) {
    // TODO
    // shape.id = '10202';
    console.log('Adding shape');
    // the array address must be changed in order to propagate changes to the @Input onChange
    const error = false;
    if (error) {
      this.shapes = [...this.shapes, shape];
    } else {
      this.shapes = [...this.shapes]; // error - propagate error by not adding the shape
    }
  }

  onShapeChanged(shape: Shape) {
    console.log('New y' + shape.fromY);
    // TODO como redux, copiar estado anterior y este

    const error = true;
    if (error) {
      shape.fromY = 15;
    }


  }

  onShapeSelected($event: Shape) {
    // TODO
  }

  onShapeDeselected($event: Shape) {
    // TODO
  }

  trackByRegionTypeFn(index, item: RegionType) {
    return item.id; // unique id corresponding to the item
  }

}
