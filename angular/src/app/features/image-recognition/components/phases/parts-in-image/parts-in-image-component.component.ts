import {Component, ViewChild} from '@angular/core';
import {ImageRecognitionBaseAbstractComponent} from "../image-recognition-base-abstract/image-recognition-base-abstract.component";
import {Part} from "../../../../../core/model/entities/part";
import {Page} from "../../../../../core/model/entities/page";
import {Region} from "../../../../../core/model/entities/region";
import {ContextMenuComponent, ContextMenuService} from "ngx-contextmenu";
import {ActivatedRoute} from "@angular/router";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../store/state/image-recognition.state";
import {DialogsService} from "../../../../../shared/services/dialogs.service";
import {ContextMenuSVGSelectionEvent} from "../../../../../svg/model/context-menu-s-v-g-selection-event";
import {PartLinking} from "../../../../../core/model/restapi/part-linking";
import {PartLinkedTo} from "../../../../../core/model/restapi/part-assigned-to.enum";
import {
  ImageRecognitionLinkImageToNewPart,
  ImageRecognitionLinkImageToPart,
  ImageRecognitionLinkNewPart,
  ImageRecognitionLinkPart,
  ImageRecognitionUnlinkImageFromPart,
  ImageRecognitionUnlinkPart
} from "../../../store/actions/image-recognition.actions";
import {ModalOptions} from "../../../../../dialogs/options-dialog/options-dialog.component";
import {ImageFilesService} from "../../../../../core/services/image-files.service";
import {DomSanitizer} from "@angular/platform-browser";
import {ShowErrorService} from "../../../../../core/services/show-error.service";

@Component({
  selector: 'app-parts-in-image-component',
  templateUrl: './parts-in-image-component.component.html',
  styleUrls: ['./parts-in-image-component.component.css']
})
export class PartsInImageComponentComponent extends ImageRecognitionBaseAbstractComponent {
  @ViewChild(ContextMenuComponent) public contextMenu: ContextMenuComponent;
  private selectedIDs: Set<number>;
  private selectedType: PartLinkedTo;

  constructor(route: ActivatedRoute, store: Store<ImageRecognitionState>, dialogsService: DialogsService, private contextMenuService: ContextMenuService,
              protected imageFilesService: ImageFilesService, protected sanitizer: DomSanitizer, protected manageErrorsService: ShowErrorService) {
    super(route, store, dialogsService, imageFilesService, sanitizer, manageErrorsService);
    this.phase = 'parts';
  }

  ngOnInit() {
    super.ngOnInit();
  }

  protected drawPage(page: Page) {
    super.drawPage(page);

    if (page.part) {
      this.addLabelBox('page', page.id, page.boundingBox, 'FF0000', page, page.part.name);
    }

  }

  protected drawRegion(region: Region) {
    super.drawRegion(region);

    if (region.part) {
      this.addLabelBox(region.regionType.name, region.id, region.boundingBox, region.regionType.hexargb, region, region.part.name);
    }
  }


  partTracking(index, item): number {
    return index;
  }


  //TODO Now we are receiving 'staff2503' where 2503 is the ID
  onContextMenu(event: ContextMenuSVGSelectionEvent) {
    this.selectedIDs = new Set<number>();
    this.selectedType = null;
    event.selectedShapes.forEach(shape => {
      if (shape.id) {
        if (shape.id.startsWith('staff')) {
          const id = shape.id.substring(5);
          this.selectedIDs.add(+id);
          if (this.selectedType != null && this.selectedType != PartLinkedTo.region) {
            throw new Error('Cannot link two different region types');
          }
          this.selectedType = PartLinkedTo.region;
        } else if (shape.id.startsWith('page')) {
          const id = shape.id.substring(4);
          this.selectedIDs.add(+id);
          if (this.selectedType != null && this.selectedType != PartLinkedTo.page) {
            throw new Error('Cannot link two different region types');
          }
          this.selectedType = PartLinkedTo.page;
        }
      }
    });

    this.contextMenuService.show.next({
      anchorElement: event.contextMenuTarget,
      // Optional - if unspecified, all context menu components will open
      contextMenu: this.contextMenu,
      //event: <any>$event,
      item: null,
    });
  }


  private createPartLinking(): PartLinking {
    const partLinking: PartLinking = {
      documentID: this.imageOverview.documentID,
      imageID: this.imageID,
      partAssignedTo: this.selectedType,
      toIDs: {
        values: Array.from(this.selectedIDs)
      }
    };

    return partLinking;
  }


  linkToPart(part: Part) {
    const partLinking: PartLinking = this.createPartLinking();
    partLinking.partID = part.id;
    this.store.dispatch(new ImageRecognitionLinkPart(partLinking));
  }

  linkToNewPart() {
    this.dialogsService.showInput('Link selected to new part', 'Input the name of the new part', null, true)
      .subscribe((text) => {
        if (text) {
          const partLinking: PartLinking = this.createPartLinking();
          partLinking.partName = text;
          this.store.dispatch(new ImageRecognitionLinkNewPart(partLinking));
        }
      });
  }

  unlinkPart() {
    const partLinking: PartLinking = this.createPartLinking();
    this.store.dispatch(new ImageRecognitionUnlinkPart(partLinking));
  }

  unlinkImageFromPart() {
    this.store.dispatch(new ImageRecognitionUnlinkImageFromPart(this.imageID));
  }

  linkImageToPart() {
    const options: ModalOptions[] = [];
    this.imageOverview.documentParts.forEach(part => {
      const item: ModalOptions = {
        id: ''+part.id,
        name: part.name
      };
      options.push(item);
    });

    this.dialogsService.showOptions('Link image to part', options, 'New part').subscribe(result => {
      if (result) {
        if (!result.id) {
          this.store.dispatch(new ImageRecognitionLinkImageToNewPart(this.imageID, result.name));
        } else {
          this.store.dispatch(new ImageRecognitionLinkImageToPart(this.imageID, +result.id));
        }
      }
    });
  }

  protected isPageSelectable(): boolean {
    return true;
  }

}