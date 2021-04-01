import {Component} from '@angular/core';
import {DocumentOverviewComponent} from "../../document-overview/document-overview.component";
import {Document} from "../../../../../core/model/entities/document";
import {ActivatedRoute, Router} from "@angular/router";
import {Store} from "@ngrx/store";
import {DocumentState} from "../../../store/state/document.state";
import {DialogsService} from "../../../../../shared/services/dialogs.service";


@Component({
  selector: 'app-document-incipits',
  templateUrl: './document-incipits.component.html',
  styleUrls: ['./document-incipits.component.css']
})
export class DocumentIncipitsComponent  extends DocumentOverviewComponent {

  constructor(protected router: Router, protected route: ActivatedRoute, protected store: Store<DocumentState>,
              protected dialogsService: DialogsService) {
    super(router, route, store, dialogsService);
  }

    ngOnInit(): void {
    super.ngOnInit();
  }

  ngOnDestroy(): void {
    super.ngOnDestroy();

  }
  protected onDocumentOverviewChanged(documentOverview: Document) {
    super.onDocumentOverviewChanged(documentOverview);
  }
}
