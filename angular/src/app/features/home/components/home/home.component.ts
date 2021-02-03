import {Component, OnDestroy, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import {ClearLinks} from "../../../../layout/store/actions/breadcrumbs.actions";
import {Observable, Subscription} from "rxjs";
import {
  selectAuthIsAdmin,
  selectAuthUserID
} from "../../../../auth/store/selectors/auth.selector";
import {LastDocumentExtract} from "../../model/last-document-extract";
import {selectHomeLastDocuments} from "../../store/selectors/home.selector";
import {GetLastDocuments} from "../../store/actions/home.actions";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {
  isAdmin$: Observable<boolean>;
  lastDocuments$: Observable<LastDocumentExtract[]>;
  userIDSubscription: Subscription;

  constructor(private store: Store<any>) {
    store.dispatch(new ClearLinks());
  }
  ngOnInit(): void {
    this.isAdmin$ = this.store.select(selectAuthIsAdmin);
    this.lastDocuments$ = this.store.select(selectHomeLastDocuments);
    this.userIDSubscription = this.store.select(selectAuthUserID).subscribe(next => {
      if (next) {
        this.store.dispatch(new GetLastDocuments(next, 7));
      }
    });
  }

  lastDocumentFn(index, item: LastDocumentExtract) {
    return item.documentID; // unique id corresponding to the item
  }

  ngOnDestroy(): void {
    this.userIDSubscription.unsubscribe();
  }

}
