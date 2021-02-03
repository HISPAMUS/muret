import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {User} from '../../../../core/model/entities/user';
import {Store} from '@ngrx/store';
import {selectCoreLoggedInUser} from '../../../../core/store/selectors/core.selector';
import {ActivateLink} from '../../../../layout/store/actions/breadcrumbs.actions';
import {selectAuthState, selectAuthUserID} from '../../../../auth/store/selectors/auth.selector';
import {CoreGetUser} from '../../../../core/store/actions/user.actions';
import {Document} from '../../../../core/model/entities/document';
import {Permissions} from '../../../../core/model/entities/permissions';
import {ShowErrorService} from '../../../../core/services/show-error.service';
import {selectDocumentsServerError} from '../../store/selectors/documents.selector';
import {ResetDocumentsServerError} from '../../store/actions/documents.actions';
import { LinkType } from 'src/app/layout/components/breadcrumb/breadcrumbType';

@Component({
  selector: 'app-collections',
  templateUrl: './collections.component.html',
  styleUrls: ['./collections.component.css']
})
export class CollectionsComponent implements OnInit, OnDestroy {
  private authSubscription: Subscription;

  user$: Observable<User>;
  private serverErrorSubscription: Subscription;

  constructor(private store: Store<any>, private showErrorService: ShowErrorService) {
    this.user$ = this.store.select(selectCoreLoggedInUser);

    this.store.dispatch(new ActivateLink(LinkType.Collection, {title: 'Collections', routerLink: 'collections'}));
  }

  ngOnInit(): void {
    /*this.authSubscription = this.store.select(selectAuthState).subscribe(next => {
      this.store.dispatch(new CoreGetUser(next.userID));
    });*/
    this.authSubscription = this.store.select(selectAuthUserID).subscribe(next => {
      this.store.dispatch(new CoreGetUser(next));
    });

    this.serverErrorSubscription = this.store.select(selectDocumentsServerError).subscribe(next => {
      if (next) {
        this.showErrorService.warning(next);
        this.store.dispatch(new ResetDocumentsServerError());
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
