import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {Observable, of, Subscription} from "rxjs";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Store} from "@ngrx/store";
import {DocumentState} from "../../../store/state/document.state";
import {DialogsService} from "../../../../../shared/services/dialogs.service";
import {ShowErrorService} from "../../../../../core/services/show-error.service";
import {BreadcrumbsUpdateDocument} from "../../../../../layout/store/actions/breadcrumbs.actions";
import {Document} from "../../../../../core/model/entities/document";
import {DocumentGetOverview, DocumentGetPartsInImages} from "../../../store/actions/document.actions";
import {selectDocumentOverview, selectDocumentPartsInImages} from "../../../store/selectors/document.selector";
import {SelectionManager} from "../../../../../shared/directives/selection-manager";
import {Section} from "../../../../../core/model/entities/section";
import {compareOrdering} from "../../../../../core/model/entities/iordered";
import {PartsInImage} from "../../../../../core/model/restapi/parts-in-image";
import {Part} from "../../../../../core/model/entities/part";
import {DocumentOverviewComponent} from "../../document-overview/document-overview.component";

@Component({
  selector: 'app-document-piece',
  templateUrl: './document-piece.component.html',
  styleUrls: ['./document-piece.component.css']
})
export class DocumentPieceComponent extends DocumentOverviewComponent {
  orderedSections: Section[];
  orderedParts: Part[];
  selectedImages: SelectionManager;
  partsInImages$: Observable<PartsInImage[]>;

  constructor(protected router: Router, protected route: ActivatedRoute, protected store: Store<DocumentState>,
              protected dialogsService: DialogsService) {
    super(router, route, store, dialogsService);
    this.selectedImages = new SelectionManager();
    this.partsInImages$ = this.store.select(selectDocumentPartsInImages);
  }

  ngOnInit(): void {
    super.ngOnInit();
  }

  ngOnDestroy(): void {
    super.ngOnDestroy();

  }

  sectionTracking(index, item): number {
    return index;
  }

  /*drop(event: CdkDragDrop<Section[]>) {
    // reordering
    console.log('Previous=' + event.previousIndex + ', new=' + event.currentIndex);
  }*/

  sortSections(sections: Section[]) {
    return sections.slice().sort(compareOrdering);
  }

  viewAndExport() {
    this.router.navigate(['/document/documentScoreViewAndExport', this.documentID]);
  }

  editInstruments() {
    this.router.navigate(['/document/instruments', this.documentID]);
  }

  viewAlignmentPreview() {
    this.router.navigate(['/document/alignmentPreview', this.documentID]);
  }

  protected onDocumentIDChanged(documentID: number) {
    super.onDocumentIDChanged(documentID);
    this.store.dispatch(new DocumentGetPartsInImages(this.documentID));
  }

  protected onDocumentOverviewChanged(documentOverview: Document) {
    super.onDocumentOverviewChanged(documentOverview);
    this.orderedSections = documentOverview.sections.slice().sort(compareOrdering); // must use slide to use a copy
    this.orderedParts = documentOverview.parts.slice().sort(compareOrdering); // must use slide to use a copy
  }

}

