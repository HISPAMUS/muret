import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {Part} from "../../../../core/model/entities/part";
import {Image} from "../../../../core/model/entities/image";
import {Section} from "../../../../core/model/entities/section";
import {DialogsService} from "../../../../shared/services/dialogs.service";
import {Store} from "@ngrx/store";

import {
  DocumentCreateSection,
  DocumentDeleteSection, DocumentMoveImagesToDefaultSection,
  DocumentRenameSection
} from "../../store/actions/document.actions";
import {ContextMenuComponent, ContextMenuService} from "ngx-contextmenu";
import {compareOrdering} from "../../../../core/model/entities/iordered";
import {Router} from "@angular/router";
import {PartsInImage} from "../../../../core/model/restapi/parts-in-image";
import {SelectionManager} from "../../../../shared/directives/selection-manager";

@Component({
  selector: 'app-section',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.css']
})
export class SectionComponent implements OnChanges {
  @Input() documentID: number;
  @Input() section: Section;
  @Input() sections: Section[];
  @Input() includeNewSection: boolean;
  @Input() documentParts: Part[];
  @Input() documentPath: string;
  @Input() images: Image[];
  @Input() selectionManager: SelectionManager;
  @Input() partsInImages: PartsInImage[];

  // , { static: true } for avoiding ExpressionChangedAfterItHasCheckedError
  @ViewChild(ContextMenuComponent, {static: true}) public contextualMenu: ContextMenuComponent;
  compressed: boolean = false;

  sortedImages: Image[];
  imagePartsMap: Map<number, number[]>; // key = imageID, value = part IDS

  constructor(private dialogsService: DialogsService, private store: Store<Document>,
              private contextMenuService: ContextMenuService, private router: Router) {
    this.compressed = false;
  }

  ngOnChanges(changes: SimpleChanges): void {
      if (changes.images) {
        this.sortedImages = this.images.slice().sort(compareOrdering);
      } else if (changes.partsInImages) {
        this.buildMaps();
      } else if (changes.parts) {
        this.buildMaps();
      }
  }
  // built when partsInImages and parts are received
  private buildMaps() {
    if (this.partsInImages && this.documentParts) {
      this.imagePartsMap = new Map<number, number[]>();
      this.partsInImages.forEach(partsInImage => {
        this.imagePartsMap.set(partsInImage.imageID, partsInImage.idsOfParts);
      });
    }
  }


  compress() {
    this.compressed = true;
  }

  expand() {
    this.compressed = false;
  }

  imageTracking(index, item: Image): number {
    return item.id;
  }

  createSection() {
    this.dialogsService.showInput('Section', 'Input the section name', null, true)
      .subscribe((text) => {
        if (text) {
          this.store.dispatch(new DocumentCreateSection(this.documentID, text));
        }
      });
  }

  renameSection() {
    this.dialogsService.showInput('Section', 'Input the section name', this.section.name, true)
      .subscribe((text) => {
        if (text) {
          const sectionChanged: Section = {
            id: this.section.id,
            images: null,
            name: text,
            ordering: this.section.ordering
          };
          this.store.dispatch(new DocumentRenameSection(sectionChanged));
        }
      });
  }

  deleteSection() {
    if (this.section.images.length === 0) {
      // don't ask anything
      this.store.dispatch(new DocumentDeleteSection(this.section.id));
    } else {
      // input section name to assess
      this.dialogsService.showInput('The section has ' + this.section.images.length
        + ' images, they will be moved to the "unassigned" section',
        'Input the name of the section to delete ', null, true)
        .subscribe((text) => {
          if (text) {
            if (text === this.section.name) {
              this.store.dispatch(new DocumentDeleteSection(this.section.id));
            } else {
              this.dialogsService.showMessage('Delete section',
                'The input name is not the actual section name', 'Section name is "'
                + this.section.name + '" and you have used "' + text + '"');
            }
          }
        });
    }
  }


  // use left click instead of right click
  public onContextMenu($event: MouseEvent): void {
    this.contextMenuService.show.next({
      // Optional - if unspecified, all context menu components will open
      contextMenu: this.contextualMenu,
      event: $event,
      item: null,
    });
    $event.preventDefault();
    $event.stopPropagation();
  }

  reorderImages() {
    this.router.navigate(['/document/reorderImages', this.section.id]);
  }

  reorderSections() {
    this.router.navigate(['/document/reorderSections', this.documentID]);
  }

  getImagePartIds(id: number): number[] {
    if (this.imagePartsMap) {
      return this.imagePartsMap.get(id);
    }
  }

  moveAllToDefaultSection() {
    this.store.dispatch(new DocumentMoveImagesToDefaultSection(this.documentID));
  }
}
