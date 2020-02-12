import {Component, OnInit, OnDestroy} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Image} from '../../../../core/model/entities/image';
import {Observable} from 'rxjs';
import {Document} from '../../../../core/model/entities/document';
import {Store} from '@ngrx/store';
import {DocumentState} from '../../store/state/document.state';
import {selectImages, selectDocument, selectDocumentStatistics} from '../../store/selectors/document.selector';
import {
  GetImages,
  GetDocument,
  GetDocumentStatistics
} from '../../store/actions/document.actions';
import {ActivateLink} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {GetUsesOfParts} from '../../../parts/store/actions/parts.actions';
import {selectUsesOfParts} from '../../../parts/store/selectors/parts.selector';
import {UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';
import { AgnosticRepresentationState } from 'src/app/features/agnostic-representation/store/state/agnostic-representation.state';
import { ResetSelectedRegion } from 'src/app/features/agnostic-representation/store/actions/agnostic-representation.actions';

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrls: ['./document.component.css'],
})
export class DocumentComponent implements OnInit {
  document$: Observable<Document>;
  images$: Observable<Image[]>;
  statistics$: Observable<DocumentStatistics>;
  usesOfParts$: Observable<UsesOfParts>;
  private documentID: number;

  constructor(private route: ActivatedRoute, private store: Store<DocumentState>, private agnosticStore: Store<AgnosticRepresentationState>, private router: Router,
              private dialogsService: DialogsService) {
    this.document$ = this.store.select(selectDocument);
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
      setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
        this.store.dispatch(new ActivateLink({title: 'Document ', routerLink: 'document/' + this.documentID}));
      });
    });
  }

  ngOnDestroy(): void {
   this.agnosticStore.dispatch(new ResetSelectedRegion());
  }

  trackByImageFn(index, item: Image) {
    return item.id; // unique id corresponding to the item
  }

  uploadImages() {
    this.router.navigate(['/document/uploadImages', this.documentID]);
  }

  viewFullScore() {
    this.router.navigate(['/document/scoreView', this.documentID]);
  }

  editInstruments() {
    this.router.navigate(['/document/instruments', this.documentID]);
  }

  viewAlignmentPreview() {
    this.router.navigate(['/document/alignmentPreview', this.documentID]);
  }
}
