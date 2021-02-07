import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {User} from '../../../../core/model/entities/user';
import {Store} from '@ngrx/store';
import {selectCoreLoggedInUser} from '../../../../core/store/selectors/core.selector';
import {selectAuthUserID} from '../../../../auth/store/selectors/auth.selector';
import {CoreGetUser} from '../../../../core/store/actions/user.actions';
import {Document} from '../../../../core/model/entities/document';
import {Permissions} from '../../../../core/model/entities/permissions';
import {ShowErrorService} from '../../../../core/services/show-error.service';
import {selectDocumentsServerError} from '../../store/selectors/documents.selector';
import {DocumentsResetDocumentsServerError} from '../../store/actions/documents.actions';
import { LinkType } from 'src/app/layout/components/breadcrumbs/breadcrumbType';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {
  BreadcrumbsUpdateCollection,
  BreadcrumbsUpdateDocument
} from "../../../../layout/store/actions/breadcrumbs.actions";

@Component({
  selector: 'app-collections',
  templateUrl: './collections.component.html',
  styleUrls: ['./collections.component.css']
})
export class CollectionsComponent implements OnInit, OnDestroy {
  private authSubscription: Subscription;

  user$: Observable<User>;
  private serverErrorSubscription: Subscription;

  constructor(private route: ActivatedRoute, private store: Store<any>, private showErrorService: ShowErrorService) {
    this.user$ = this.store.select(selectCoreLoggedInUser);
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      if (this.route.snapshot.paramMap.get('id')) {
        const collectionID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
        this.store.dispatch(new BreadcrumbsUpdateCollection(collectionID));
      }
    });

    /*this.authSubscription = this.store.select(selectAuthState).subscribe(next => {
      this.store.dispatch(new CoreGetUser(next.userID));
    });*/
    this.authSubscription = this.store.select(selectAuthUserID).subscribe(next => {
      this.store.dispatch(new CoreGetUser(next));
    });

    this.serverErrorSubscription = this.store.select(selectDocumentsServerError).subscribe(next => {
      if (next) {
        this.showErrorService.warning(next);
        this.store.dispatch(new DocumentsResetDocumentsServerError());
      }
    });

  }

  trackByDocumentFn(index, item: Document) {
    return item.id; // unique id corresponding to the item
  }

  trackByPermissionFn(index, item: Permissions) {
    return item.id; // unique id corresponding to the item
  }


  ngOnDestroy(): void {
    this.authSubscription.unsubscribe();
    this.serverErrorSubscription.unsubscribe();
  }
}
