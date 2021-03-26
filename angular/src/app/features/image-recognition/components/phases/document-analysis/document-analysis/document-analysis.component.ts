import { Component, OnInit } from '@angular/core';
import {ImageRecognitionBaseAbstractComponent} from "../../image-recognition-base-abstract/image-recognition-base-abstract.component";
import {ActivatedRoute} from "@angular/router";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";
import {DialogsService} from "../../../../../../shared/services/dialogs.service";
import {ContextMenuService} from "ngx-contextmenu";
import {ContextMenuSVGSelectionEvent} from "../../../../../../svg/model/context-menu-s-v-g-selection-event";
import {Page} from "../../../../../../core/model/entities/page";
import {Region} from "../../../../../../core/model/entities/region";
import {Shape} from "../../../../../../svg/model/shape";
import {RegionType} from "../../../../../../core/model/entities/region-type";
import {
  ImageRecognitionAutomaticDocumentAnalysis,
  ImageRecognitionChangePageBoundingBox,
  ImageRecognitionChangeRegionBoundingBox,
  ImageRecognitionChangeRegionsType,
  ImageRecognitionClear,
  ImageRecognitionCreatePage,
  ImageRecognitionCreateRegion, ImageRecognitionDeletePages,
  ImageRecognitionDeleteRegions
} from "../../../../store/actions/image-recognition.actions";
import {Rectangle} from "../../../../../../svg/model/rectangle";
import {SelectedRegionOrPage} from "./selected-region-or-page";
import {ClassifierModel} from "../../../../../../core/model/entities/classifier-model";
import {Observable} from "rxjs";
import {selectImageRecognitionDocumentAnalysisClassifierModels} from "../../../../store/selectors/image-recognition.selector";
import {ImageFilesService} from "../../../../../../core/services/image-files.service";
import {DomSanitizer} from "@angular/platform-browser";
import {ShowErrorService} from "../../../../../../core/services/show-error.service";


@Component({
  selector: 'app-document-analysis-component',
  templateUrl: './document-analysis.component.html',
  styleUrls: ['./document-analysis.component.css']
})
export class DocumentAnalysisComponent extends ImageRecognitionBaseAbstractComponent {
  contextMenu: any;
  selectedRegionType: 'several' | 'page' | RegionType;
  private selectedShapes: Shape[];
  mode: 'eAdding' | 'eEditing' | 'eSelecting';
  documentAnalysisModels$: Observable<ClassifierModel[]>;

  constructor(route: ActivatedRoute, store: Store<ImageRecognitionState>, dialogsService: DialogsService, private contextMenuService: ContextMenuService,
              protected imageFilesService: ImageFilesService, protected sanitizer: DomSanitizer, protected manageErrorsService: ShowErrorService) {
    super(route, store, dialogsService, imageFilesService, sanitizer, manageErrorsService);
    this.phase = 'documentAnalysis';
    this.mode = 'eSelecting';
  }

  ngOnInit() {
    super.ngOnInit();
    // the dispatch to get all the classifiers is found in the base class
    this.documentAnalysisModels$ = this.store.select(selectImageRecognitionDocumentAnalysisClassifierModels);
  }

  protected isPageSelectable(): boolean {
    return true;
  }

  onContextMenu(event: ContextMenuSVGSelectionEvent) {

  }

  protected drawPage(page: Page) {
    super.drawPage(page);

    this.addLabelBox('page', page.id, page.boundingBox, 'FF0000', page, 'page');
  }

  protected drawRegion(region: Region) {
    super.drawRegion(region);

    if (region.regionType) {
      this.addLabelBox(region.regionType.name, region.id, region.boundingBox, region.regionType.hexargb, region, region.regionType.name);
    }
  }

  /**
   * When shapes are selected, the region type in the toolbar is highlighted
   * @param shapes
   */
  onDocumentAnalysisShapesSelected(shapes: Shape[]) {
    this.selectedShapes = shapes;
    if (shapes && shapes.length > 0) {
      this.selectedRegionType = null;
      let selectedRegionTypeString = null;
      shapes.forEach(shape => {
        let type = null;
        let typeString = null;
        if (shape.data) {
          if (shape.data.regions) {
            type = 'page';
            typeString = 'page';
          } else if (shape.data.regionType) {
            type = shape.data.regionType;
            typeString = shape.data.regionType.name;
          }

          if (this.selectedRegionType == null) {
            this.selectedRegionType = type;
            selectedRegionTypeString = typeString;
          } else if (selectedRegionTypeString !== typeString) {
            this.selectedRegionType = 'several';
            return; // we don't need to continue
          }
        }
      });
    }
  }

  getSelected(): SelectedRegionOrPage[] {
    const selectedRegions: SelectedRegionOrPage[] = [];
    if (this.selectedShapes) {
      this.selectedShapes.forEach(shape => {
        if (shape.data) {
          const s: SelectedRegionOrPage = {};
          if (shape.data.regionType) {
            s.region = shape.data;
          } else if (shape.data.regions) {
            s.page = shape.data;
          } else {
            throw new Error('Shape should be a region or a page');
          }
          selectedRegions.push(s);
        }
      });
    }
    return selectedRegions;
  }
  changeRegionType(regionType: RegionType) {
    this.selectedRegionType = regionType; // this value changes indirectly the region types filter
    const selected = this.getSelected();
    const regions: Region[] = [];
    selected.forEach(s => {
      if (s.region) {
        regions.push(s.region);
      }
    });
    if (regions.length > 0) {
      this.store.dispatch(new ImageRecognitionChangeRegionsType(regions, regionType));
    }
  }
  isSelectionDone() {
    return this.selectedShapes && this.selectedShapes.length;
  }

  onSVGShapeCreated(shape: Shape) {
    const rectangle = shape as Rectangle;

    let _selectedRegionType = null;
    if (this.selectedRegionType != 'several') {
      _selectedRegionType = this.selectedRegionType;
    }

    ///// TODO Page creation
    if (_selectedRegionType === 'page') {
      this.store.dispatch(new ImageRecognitionCreatePage(this.imageID, {fromX: rectangle.fromX,
        fromY: rectangle.fromY,
        toX: rectangle.fromX + rectangle.width,
        toY: rectangle.fromY + rectangle.height}));
    } else {
      this.store.dispatch(new ImageRecognitionCreateRegion(this.imageID, _selectedRegionType,
        {fromX: rectangle.fromX,
          fromY: rectangle.fromY,
          toX: rectangle.fromX + rectangle.width,
          toY: rectangle.fromY + rectangle.height}));

    }
  }

  onSVGShapeChanged(shape: Shape) {
    const rectangle = shape as Rectangle;

    if (shape.layer === 'page') {
      this.store.dispatch(new ImageRecognitionChangePageBoundingBox(shape.data, {
        fromX: rectangle.fromX,
        fromY: rectangle.fromY,
        id: rectangle.data.id,
        toX: rectangle.fromX + rectangle.width,
        toY: rectangle.fromY + rectangle.height
      }));
    } else {
      this.store.dispatch(new ImageRecognitionChangeRegionBoundingBox(shape.data, {
        fromX: rectangle.fromX,
        fromY: rectangle.fromY,
        id: rectangle.data.id,
        toX: rectangle.fromX + rectangle.width,
        toY: rectangle.fromY + rectangle.height
      }));
    }
  }

  private deleteRegionsOrPages(selected: SelectedRegionOrPage[]) {
    const regions: Region[] = [];
    const pages: Page[] = [];
    selected.forEach(s => {
      if (s.page) {
        pages.push(s.page);
      } else {
        regions.push(s.region);
      }
    });
    if (pages.length > 0) {
      this.store.dispatch(new ImageRecognitionDeletePages(pages));
    }
    if (regions.length > 0) {
      this.store.dispatch(new ImageRecognitionDeleteRegions(regions));
    }
  }

  onDelete() {
    const selected: SelectedRegionOrPage[] = this.getSelected();
    if (selected.length > 0) {
      if (selected.length > 1) {
        this.dialogsService.showConfirmation('There are ' + selected.length
          + ' selected regions', 'Do you want the delete them?')
          .subscribe((isConfirmed) => {
            this.deleteRegionsOrPages(selected);
            }
          );
      } else {
        this.deleteRegionsOrPages(selected);
      }
    }
  }

  onClear() {
    this.dialogsService.showConfirmation('Clear document analysis?', 'This action cannot be undone')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          this.dialogsService.showConfirmation('Are you sure to clear the document analysis?', 'This action cannot be undone')
            .subscribe((isConfirmed2) => {
              if (isConfirmed2) {
                this.store.dispatch(new ImageRecognitionClear(this.imageID));
              }
            });
        }
      });
  }

  onModeChange(mode: any) {
    if (this.mode === 'eAdding') {
      if (!this.selectedRegionType) {
        if (this.documentAnalysisShapes.length === 0) {
          this.selectedRegionType = 'page';
        } else {
          this.selectedRegionType = this.undefinedRegionType;
        }
      }
    }
  }

  attemptDocumentAnalysis(selectedModel: ClassifierModel) {
    this.dialogsService.showConfirmation('Automatic classification: it will erase previous analysis', 'This action cannot be undone')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          this.dialogsService.showInput('Automatic classification', 'How many vertical pagesWithRegions do you wish to create?',
            '1').subscribe(value => {
            if (value) {
              const pagesToCreate = Number(value);
              this.store.dispatch(new ImageRecognitionAutomaticDocumentAnalysis({
                imageID: this.imageID,
                modelToUse: selectedModel.id,
                numPages: pagesToCreate
              }));
              // this.mode = 'eEditing';
            }
          });
        }
      });
  }
}

