import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {Observable, of, Subscription} from "rxjs";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Store} from "@ngrx/store";
import {DocumentState} from "../../store/state/document.state";
import {DialogsService} from "../../../../shared/services/dialogs.service";
import {ShowErrorService} from "../../../../core/services/show-error.service";
import {BreadcrumbsUpdateDocument} from "../../../../layout/store/actions/breadcrumbs.actions";
import {Document} from "../../../../core/model/entities/document";
import {DocumentGetOverview, DocumentGetPartsInImages} from "../../store/actions/document.actions";
import {selectDocumentOverview, selectDocumentPartsInImages} from "../../store/selectors/document.selector";
import {SelectionManager} from "../../../../shared/directives/selection-manager";
import {CdkDragDrop} from "@angular/cdk/drag-drop";
import {Section} from "../../../../core/model/entities/section";
import {compareOrdering} from "../../../../core/model/entities/iordered";
import {PartsInImage} from "../../../../core/model/restapi/parts-in-image";
import {HomeGetLastDocuments, HomeUpdateLastDocuments} from "../../../home/store/actions/home.actions";
import {selectAuthUserID} from "../../../../auth/store/selectors/auth.selector";
import {Part} from "../../../../core/model/entities/part";

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrls: ['./document.component.css']
})
export class DocumentComponent implements OnInit, OnDestroy {
  private documentID: number;
  documentOverview: Document;
  documentOverviewSubscription: Subscription;
  orderedSections: Section[];
  orderedParts: Part[];
  selectedImages: SelectionManager;
  partsInImages$: Observable<PartsInImage[]>;
  private userIDSubscription: Subscription;

  constructor(private route: ActivatedRoute, private store: Store<DocumentState>,
              private router: Router,
              private dialogsService: DialogsService, private showErrorService: ShowErrorService) {
    this.selectedImages = new SelectionManager();
    this.partsInImages$ = this.store.select(selectDocumentPartsInImages);
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.documentID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new DocumentGetOverview(this.documentID));
      this.store.dispatch(new DocumentGetPartsInImages(this.documentID));
      this.store.dispatch(new BreadcrumbsUpdateDocument(this.documentID));
      this.userIDSubscription = this.store.select(selectAuthUserID).subscribe(next => {
        if (next) {
          this.store.dispatch(new HomeUpdateLastDocuments(next, this.documentID));
        }
      });
    });

    this.documentOverviewSubscription = this.store.select(selectDocumentOverview).subscribe(next => {
      if (next) {
        this.documentOverview = next;
        this.orderedSections = next.sections.slice().sort(compareOrdering); // must use slide to use a copy
        this.orderedParts = next.parts.slice().sort(compareOrdering); // must use slide to use a copy
      }
    });
  }

  ngOnDestroy(): void {
    this.documentOverviewSubscription.unsubscribe();
    this.userIDSubscription.unsubscribe();
  }

  sectionTracking(index, item): number {
    return index;
  }

  drop(event: CdkDragDrop<Section[]>) {
    // reordering
    console.log('Previous=' + event.previousIndex + ', new=' + event.currentIndex);
  }

  sortSections(sections: Section[]) {
    console.log('COmparing');
    return sections.slice().sort(compareOrdering);
  }
}

