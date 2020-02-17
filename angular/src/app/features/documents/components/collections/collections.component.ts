import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {User} from '../../../../core/model/entities/user';
import {Store} from '@ngrx/store';
import {selectLoggedInUser} from '../../../../core/store/selectors/core.selector';
import {ActivateLink} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';
import {selectAuthState} from '../../../../auth/store/selectors/auth.selector';
import {GetUser} from '../../../../core/store/actions/user.actions';
import {Document} from '../../../../core/model/entities/document';
import {Permissions} from '../../../../core/model/entities/permissions';
import {ShowErrorService} from '../../../../core/services/show-error.service';
import {selectDocumentsServerError} from '../../store/selectors/documents.selector';

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
    this.user$ = this.store.select(selectLoggedInUser);

    this.store.dispatch(new ActivateLink({title: 'Collections', routerLink: 'collections'}));
  }

  ngOnInit(): void {
    this.authSubscription = this.store.select(selectAuthState).subscribe(next => {
      this.store.dispatch(new GetUser(next.userID));
    });

    this.serverErrorSubscription = this.store.select(selectDocumentsServerError).subscribe(next => {
      if (next) {
        this.showErrorService.warning(next);
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
