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
import {Page} from '../../../shared/entities/page';
import {BoundingBox} from '../../../shared/entities/bounding-box';
import {Region} from '../../../shared/entities/region';

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
  regionTypes: RegionType[]; // non observable

  private shapes = new Array<Shape>();
  private imageHeight: number;
  private imageWidth: number;


  @ViewChild('svgCanvasComponent') svgCanvasComponent: SvgCanvasComponent;
  canvasHeightPercentage: number;  // e.g. 100 for 100%
  canvasWidthPercentage: number;
  zoomFactor = 1;

  layersCheckboxes: FormGroup;

  // tools
  public radioGroupForm: FormGroup;
  public regionTypesRadioGroupForm: FormGroup;
  private selectedShape: Shape;
  // end tools

  constructor(@Self() private documentAnalysisService: DocumentAnalysisService,
              private imageFilesService: ImageFilesService,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder
              ) {
  }

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    // tools
    this.radioGroupForm = this.formBuilder.group({
      model: 'idle'
    });

    this.regionTypesRadioGroupForm = this.formBuilder.group({
      regionTypeRB: 'none'
    });

    this.layersCheckboxes = this.formBuilder.group({
      page: true
    });

    // get different region types
    this.regionTypes$ = this.documentAnalysisService.getRegionTypes$().pipe(
      tap(regionTypes => regionTypes.forEach(regionType => {
        this.layersCheckboxes.addControl(regionType.name, new FormControl(true));
        this.regionTypesRadioGroupForm.addControl('regionTypeRB', new FormControl(false));
        this.regionTypes = regionTypes;
        }
      ))
    );
    this.layersCheckboxes.valueChanges.subscribe(val => {
      this.onLayerChanged(val);
    });

    // download image
    this.documentAnalysisImageProjection$ = this.documentAnalysisService.getDocumentAnalysisImageProjection$(id);
    this.loadedImage$ = this.documentAnalysisImageProjection$.pipe(
      switchMap(next => {
        return this.readImageContents(next);
      })
    );


    this.computeZoom();
  }

  private readImageContents(documentAnalysisImageProjection: DocumentAnalysisImageProjection) {
    this.imageWidth = documentAnalysisImageProjection.width;
    this.imageHeight = documentAnalysisImageProjection.height;
    this.drawPagesAndRegions(documentAnalysisImageProjection);

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

  public idle(): SVGCanvasState {
    return this.svgCanvasComponent.requestStateChange(SVGCanvasState.eIdle);
  }

  onShapeCreated(shape: Shape) {
    // TODO crear páginas
    // TODO
    // shape.id = '10202';
    console.log('Adding shape');
    // the array address must be changed in order to propagate changes to the @Input onChange
    const error = false;
    const regionTypeName = this.regionTypesRadioGroupForm.get('regionTypeRB').value;

    // TODO algo más elegante....
    const regionType = this.regionTypes.find(rt => rt.name === regionTypeName);
    shape.layer = regionTypeName;
    // TODO (shape.data as Region).regionType = regionType;
    shape.strokeColor = '#' + regionType.hexargb; // TODO TODO TODO

    if (!error) {
      this.shapes = [...this.shapes, shape];
    } else {
      this.shapes = [...this.shapes]; // error - propagate error by not adding the shape
    }
  }

  onShapeChanged(shape: Shape) {
    const error = false;
    if (error) {
      shape.fromY = 15;
    }
  }

  changeRegionType(regionType: RegionType) {
    if (this.selectedShape) {
      const error = false;
      if (!error) {
        this.selectedShape.layer = regionType.name;
        this.selectedShape.strokeColor = '#' + regionType.hexargb; // TODO enviar a BBDD y cambiar esto en la respuesta∫
      }
    }
  }

  onShapeSelected(shape: Shape) {
    this.selectedShape = shape;
    this.regionTypesRadioGroupForm.get('regionTypeRB').setValue(shape.layer);
  }

  onShapeDeselected(shape: Shape) {
    this.selectedShape = null;
  }

  trackByRegionTypeFn(index, item: RegionType) {
    return item.id; // unique id corresponding to the item
  }

  private drawPagesAndRegions(documentAnalysisImageProjection: DocumentAnalysisImageProjection) {
    documentAnalysisImageProjection.pages.forEach(page => {
      this.drawPage(page);
      page.regions.forEach(region => {
        this.drawRegion(region);
      });
    });
  }

  example() {
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
  }

  private createBox(layer: string, id: number, boundingBox: BoundingBox, color: string): Rectangle {
    const rect = new Rectangle();
    rect.id = layer + id;
    rect.fromX = boundingBox.fromX;
    rect.fromY = boundingBox.fromY;
    rect.width = boundingBox.toX - boundingBox.fromX;
    rect.height  = boundingBox.toY - boundingBox.fromY;
    rect.fillColor = 'transparent';
    rect.strokeColor = color;
    rect.strokeWidth = 3;
    rect.layer = layer;
    this.shapes.push(rect);
    return rect;
  }
  private drawPage(page: Page) {
    this.createBox('page', page.id, page.boundingBox, 'red' ).data = page; // TODO color
  }

  private drawRegion(region: Region) {
    this.createBox(region.regionType.name, region.id, region.boundingBox, '#' + region.regionType.hexargb ).data = region;
  }

  private onLayerChanged(val: any) {
    this.shapes.forEach(shape => {
      const checkBox = this.layersCheckboxes.get(shape.layer);
      shape.hidden = !this.layersCheckboxes.get(shape.layer).value;
    });
  }


}
