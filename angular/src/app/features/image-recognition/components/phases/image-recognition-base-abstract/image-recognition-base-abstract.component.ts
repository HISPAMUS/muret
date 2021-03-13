import {AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {ImageOverview} from "../../../../../core/model/restapi/image-overview";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Store} from "@ngrx/store";
import {
  ImageRecognitionChangeStatus, ImageRecognitionGetClassifierModels,
  ImageRecognitionGetImageOverview,
  ImageRecognitionGetPagesRegionsSymbols, ImageRecognitionGetRegionTypes
} from "../../../store/actions/image-recognition.actions";
import {
  selectImageRecognitionImageOverview,
  selectImageRecognitionPagesRegionsSymbols, selectImageRecognitionRegionTypes
} from "../../../store/selectors/image-recognition.selector";
import {BreadcrumbsUpdateImage} from "../../../../../layout/store/actions/breadcrumbs.actions";
import {RegionType} from "../../../../../core/model/entities/region-type";
import {ImageRecognitionState} from "../../../store/state/image-recognition.state";
import {Page} from "../../../../../core/model/entities/page";
import {BoundingBox} from "../../../../../core/model/entities/bounding-box";
import {Region} from "../../../../../core/model/entities/region";
import {Rectangle} from "../../../../../svg/model/rectangle";
import {Shape} from "../../../../../svg/model/shape";
import {DialogsService} from "../../../../../shared/services/dialogs.service";
import {ZoomManager} from "../../../../../shared/model/zoom-manager";
import {ImageRecognitionProgressStatusChange} from "../../../../../core/model/restapi/image-recognition-progress-status-change";
import {Text} from "../../../../../svg/model/text";
import {map} from "rxjs/operators";
import {ImageFilesService} from "../../../../../core/services/image-files.service";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";
import {SVGSet} from "../../../../agnostic-representation/model/svgset";
import {selectCoreSVGAgnosticOrSemanticSymbolSet} from "../../../../../core/store/selectors/core.selector";
import {CoreGetSVGSet} from "../../../../../core/store/actions/fonts.actions";

@Component({
  selector: 'app-image-recognition-base-abstract-component',
  templateUrl: './image-recognition-base-abstract-component.component.html',
  styleUrls: ['./image-recognition-base-abstract-component.component.css']
})
export abstract class ImageRecognitionBaseAbstractComponent implements OnInit, OnDestroy, AfterViewInit {
  private _imageID: number;
  private _imageOverview: ImageOverview;
  private imageOverviewSubscription: Subscription;
  private pagesSubscription: Subscription;
  private regionTypesSubscription: Subscription;
  regionTypes$: Observable<RegionType[]>;
  private _documentAnalysisShapes: Shape[];
  zoomManager: ZoomManager = new ZoomManager();
  protected phase: string;
  private _status: string;
  protected undefinedRegionType: RegionType;
  private loadedImage$: Observable<SafeResourceUrl>;
  svgSet$: Observable<SVGSet>;


  constructor(protected route: ActivatedRoute, protected store: Store<ImageRecognitionState>, protected dialogsService: DialogsService,
              protected imageFilesService: ImageFilesService, protected sanitizer: DomSanitizer
  ) {
    this.store.dispatch(new ImageRecognitionGetRegionTypes());
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this._imageID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new ImageRecognitionGetImageOverview(this.imageID))
      this.store.dispatch(new BreadcrumbsUpdateImage(this.imageID));
      this.store.dispatch(new ImageRecognitionGetPagesRegionsSymbols(+this.imageID));
      this.store.dispatch(new ImageRecognitionGetClassifierModels(+this.imageID)); // then, in each phase (document analysis ...) we'll get the required classifiers
    });

    this.regionTypes$ = this.store.select(selectImageRecognitionRegionTypes);
    this.regionTypesSubscription = this.regionTypes$.subscribe(next => {
      if (next) {
        this.undefinedRegionType = next.find(regionType => regionType.name === 'undefined');
        if (!this.undefinedRegionType) {
          throw new Error('Cannot find a region type with name "Undefined"');
        }
      }
    });

    this.imageOverviewSubscription = this.store.select(selectImageRecognitionImageOverview).subscribe(next => {
      if (next) {
        this._imageOverview = next;

        this.store.dispatch(new CoreGetSVGSet(next.notationType, next.manuscriptType));

        this.loadedImage$ = this.imageFilesService.getMasterImageBlob$(next.documentPath, next.imageID).pipe(
            //map(imageBlob => this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)))
            map(imageBlob => window.URL.createObjectURL(imageBlob)));

        this._status = this.getProgressStatus();
        this.onImageOverviewChanged();
      }
    });

    this.svgSet$ = this.store.select(selectCoreSVGAgnosticOrSemanticSymbolSet);
  }
  ngAfterViewInit(): void {
    this.pagesSubscription = this.store.select(selectImageRecognitionPagesRegionsSymbols).subscribe(next => {
      if (next) {
        this.drawPagesAndRegions(next);
      }
      //this.pagesWithRegions = next;
    });
  }

  ngOnDestroy() {
    this.imageOverviewSubscription.unsubscribe();
    this.pagesSubscription.unsubscribe();
    this.regionTypesSubscription.unsubscribe();
  }

  get imageOverview() {
    return this._imageOverview;
  }

  get imageID() {
    return this._imageID;
  }

  get documentAnalysisShapes() {
    return this._documentAnalysisShapes;
  }

  protected drawPagesAndRegions(pagesRegionsSymbols: Page[]) {
    this._documentAnalysisShapes = new Array();
    if (pagesRegionsSymbols) {
      pagesRegionsSymbols.forEach(page => {
        this.drawPage(page);
        if (page.regions) {
          page.regions.forEach(region => {
            this.drawRegion(region);
          });
        }
      });
    }
  }

  private drawBox(layer: string, id: number, boundingBox: BoundingBox, color: string, data: Region | Page): Rectangle {
    const rect = new Rectangle();
    rect.id = layer + id;
    rect.fromX = boundingBox.fromX;
    rect.fromY = boundingBox.fromY;
    rect.width = boundingBox.toX - boundingBox.fromX;
    rect.height  = boundingBox.toY - boundingBox.fromY;
    rect.fillColor = 'transparent';
    rect.strokeColor = color;
    rect.strokeWidth = 9;
    rect.layer = layer;
    rect.data = data;
    this._documentAnalysisShapes.push(rect);
    return rect;
  }
  protected drawPage(page: Page) {
    this.drawBox('page', page.id, page.boundingBox, 'red', page).selectable = this.isPageSelectable();
  }

  protected abstract isPageSelectable(): boolean;

  protected drawRegion(region: Region) {
    this.drawBox(region.regionType.name, region.id, region.boundingBox, '#' + region.regionType.hexargb, region);
  }

  protected addLabelBox(layer: string, id: number, boundingBox: BoundingBox, color: string, data: Region | Page, label: string) {
    const rect = new Rectangle(); // background
    //rect.id = layer + id;
    rect.fromX = boundingBox.fromX;
    rect.fromY = boundingBox.fromY;
    rect.width = label.length * 20;
    rect.height  = 50;
    rect.fillColor = '#' + color;
    rect.layer = layer;
    rect.data = data;
    rect.selectable = false;
    // this.documentAnalysisShapes.push(rect); //TODO si lo pongo no va bien la selección

    const t: Text = new Text();
    t.layer = layer;
    t.text = label;
    t.fromX = boundingBox.fromX + 10;
    t.fromY = boundingBox.fromY + 40;
    t.strokeColor = '#' + color;
    t.strokeWidth = 1;
    t.fillColor = 'black';
    t.fontSize = 30;
    t.selectable = false;

    this.documentAnalysisShapes.push(t);
  }

  protected onImageOverviewChanged() {
    // just to notify children about the change
  }


  get status(): string {
    return this._status;
  }

  set status(value: string) {
    this._status = value;
  }

  onStatusChange(status: string) {
    const imageRecognitionProgressStatusChange: ImageRecognitionProgressStatusChange = {
      imageID: this.imageID,
      phase: this.phase,
      status: status
    };
    this.store.dispatch(new ImageRecognitionChangeStatus(imageRecognitionProgressStatusChange));
  }

  private getProgressStatusOfPhase(phase: string): string {
    if (phase && this._imageOverview && this._imageOverview.imageRecognitionProgressStatuses) {
      const result = this._imageOverview.imageRecognitionProgressStatuses.find(s => s.phase === phase);
      if (result) {
        return result.status;
      }
    }
  }
  private getProgressStatus(): string {
    return this.getProgressStatusOfPhase(this.phase);
  }

}
