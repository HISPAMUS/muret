import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Image} from '../../../../core/model/entities/image';
import {Observable, Subscription} from 'rxjs';
import {Document} from '../../../../core/model/entities/document';
import {Store} from '@ngrx/store';
import {DocumentState} from '../../store/state/document.state';
import {
  selectImages,
  selectDocument,
  selectDocumentStatistics,
  selectDocumentAPIRestErrorSelector
} from '../../store/selectors/document.selector';
import {
  GetImages,
  GetDocument,
  GetDocumentStatistics, ResetDocumentServerError
} from '../../store/actions/document.actions';
import {ActivateLink} from '../../../../layout/store/actions/breadcrumbs.actions';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {GetUsesOfParts} from '../../../parts/store/actions/parts.actions';
import {selectUsesOfParts} from '../../../parts/store/selectors/parts.selector';
import {UsesOfAllParts} from '../../../../core/model/restapi/uses-of-all-parts';
import { AgnosticRepresentationState } from 'src/app/features/agnostic-representation/store/state/agnostic-representation.state';
import { ResetSelectedRegion } from 'src/app/features/agnostic-representation/store/actions/agnostic-representation.actions';
import {ShowErrorService} from '../../../../core/services/show-error.service';
import { LinkType } from 'src/app/layout/components/breadcrumb/breadcrumbType';

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrls: ['./document.component.css'],
})
export class DocumentComponent implements OnInit, OnDestroy {
  documentSubscription : Subscription;
  document$: Observable<Document>;
  images$: Observable<Image[]>;
  statistics$: Observable<DocumentStatistics>;
  usesOfParts$: Observable<UsesOfAllParts>;
  private documentID: number;
  private serverErrorSubscription: Subscription;

  constructor(private route: ActivatedRoute, private store: Store<DocumentState>, private agnosticStore: Store<AgnosticRepresentationState>,
              private router: Router,
              private dialogsService: DialogsService, private showErrorService: ShowErrorService) {
    this.document$ = this.store.select(selectDocument)
    this.documentSubscription = this.document$.subscribe(doc => {
      setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
        if (doc) {
          this.store.dispatch(new ActivateLink(LinkType.Document, {
            title: doc.name,
            routerLink: 'document/' + this.documentID
          }));
        }
      });
    })
    this.images$ = this.store.select(selectImages);
    this.statistics$ = this.store.select(selectDocumentStatistics);
    this.usesOfParts$ = this.store.select(selectUsesOfParts);
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.documentID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new GetDocument(this.documentID));
      this.store.dispatch(new GetUsesOfParts(this.documentID));
      this.store.dispatch(new GetImages(this.documentID));
      this.store.dispatch(new GetDocumentStatistics(this.documentID));

    });

    this.serverErrorSubscription = this.store.select(selectDocumentAPIRestErrorSelector).subscribe(next => {
      if (next) {
        this.showErrorService.warning(next);
        this.store.dispatch(new ResetDocumentServerError());
      }
    });

  }

  ngOnDestroy(): void {
   this.agnosticStore.dispatch(new ResetSelectedRegion());
   this.serverErrorSubscription.unsubscribe();
   this.documentSubscription.unsubscribe();
  }

  trackByImageFn(index, item: Image) {
    return item.id; // unique id corresponding to the item
  }

  uploadImages() {
    this.router.navigate(['/document/uploadImages', this.documentID]);
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
}
