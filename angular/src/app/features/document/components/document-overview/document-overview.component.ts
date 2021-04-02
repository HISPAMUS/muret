import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Store} from "@ngrx/store";
import {DocumentState} from "../../store/state/document.state";
import {
  DocumentDownloadActionLogs,
  DocumentGetDocumentStatistics,
  DocumentGetOverview,
  DocumentLogOpen
} from "../../store/actions/document.actions";
import {BreadcrumbsUpdateDocument} from "../../../../layout/store/actions/breadcrumbs.actions";
import {selectAuthUserID} from "../../../../auth/store/selectors/auth.selector";
import {HomeUpdateLastDocuments} from "../../../home/store/actions/home.actions";
import {Observable, Subscription} from "rxjs";
import {DialogsService} from "../../../../shared/services/dialogs.service";
import {
  selectDocumentActionLogsFile,
  selectDocumentOverview,
  selectDocumentStatistics
} from "../../store/selectors/document.selector";
import {Document} from "../../../../core/model/entities/document";
import {DocumentStatistics} from "../../../../core/model/restapi/document-statistics";
import saveAs from 'file-saver';

interface ImageTableRow { // view of the image in the table
  id: number;
  filename: string;
  documentAnalysisProgress: string;
  partsProgress: string;
  transcriptionProgress: string;
}

@Component({
  selector: 'app-document-overview',
  templateUrl: './document-overview.component.html',
  styleUrls: ['./document-overview.component.css']
})
export class DocumentOverviewComponent implements OnInit, OnDestroy {
  private userIDSubscription: Subscription;
  private documentOverviewSubscription: Subscription;
  private documentActionLogsFileSubscription: Subscription;

  protected documentID: number;
  documentOverview: Document;
  // private statistics$: Observable<DocumentStatistics>;
  private downloadingActionLogs: boolean = false;

  constructor(protected router: Router, protected route: ActivatedRoute, protected store: Store<DocumentState>,
              protected dialogsService: DialogsService) {
    this.documentOverviewSubscription = this.store.select(selectDocumentOverview).subscribe(next => {
      if (next) {
        this.documentOverview = next;
        this.onDocumentOverviewChanged(this.documentOverview);
      }
    });

    this.documentActionLogsFileSubscription = this.store.select(selectDocumentActionLogsFile).subscribe(next => {
      if (next) {
        if (this.downloadingActionLogs) {
          this.downloadingActionLogs = false;
          const blob1 = new Blob([next], {type: 'application/x-gzip'});
          saveAs.saveAs(blob1, 'document_' + this.documentID + '_actionlogs.csv'); // TODO file name
        }
      }
    });
    // this.statistics$ = this.store.select(selectDocumentStatistics);
  }

  ngOnInit(): void {
      this.route.paramMap.subscribe((params: ParamMap) => {
        this.documentID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
        this.store.dispatch(new DocumentLogOpen(this.documentID));
        this.store.dispatch(new DocumentGetOverview(this.documentID));
        this.store.dispatch(new BreadcrumbsUpdateDocument(this.documentID));
        //TODO Muy lento para grandes colecciones - mejorarlo this.store.dispatch(new DocumentGetDocumentStatistics(this.documentID));
        this.onDocumentIDChanged(this.documentID);

        this.userIDSubscription = this.store.select(selectAuthUserID).subscribe(next => {
          if (next) {
            this.store.dispatch(new HomeUpdateLastDocuments(next, this.documentID));
          }
        });
      });


  }

  ngOnDestroy(): void {
    if (this.userIDSubscription) {
      this.userIDSubscription.unsubscribe();
    }
    this.documentOverviewSubscription.unsubscribe();
  }

  protected onDocumentIDChanged(documentID: number) {
  }

  protected onDocumentOverviewChanged(documentOverview: Document) {
  }

  openDocument() {
    let url = '/document/' + this.documentOverview.documentType; // incipits, compilation, piece
    this.router.navigate([url, this.documentID]);
  }

  hasOtherView(documentOverview: Document) {
    return documentOverview.documentType == 'piece';
  }

  uploadImages() {
    this.router.navigate(['/document/uploadImages', this.documentID]);
  }

  downloadActionLogs() {
    this.downloadingActionLogs = true;
    this.store.dispatch(new DocumentDownloadActionLogs(this.documentID));
  }
}
