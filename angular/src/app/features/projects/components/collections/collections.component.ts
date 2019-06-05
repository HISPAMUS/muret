import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {User} from '../../../../core/model/entities/user';
import {Store} from '@ngrx/store';
import {selectLoggedInUser} from '../../../../core/store/selectors/user.selector';
import {ActivateLink} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';
import {selectAuthState} from '../../../../auth/store/selectors/auth.selector';
import {GetUser} from '../../../../core/store/actions/user.actions';
import {Project} from '../../../../core/model/entities/project';
import {Permissions} from '../../../../core/model/entities/permissions';

@Component({
  selector: 'app-collections',
  templateUrl: './collections.component.html',
  styleUrls: ['./collections.component.css']
})
export class CollectionsComponent implements OnInit, OnDestroy {
  private authSubscription: Subscription;

  user$: Observable<User>;

  constructor(private store: Store<any>) {
    this.user$ = this.store.select(selectLoggedInUser);

    this.store.dispatch(new ActivateLink({title: 'Collections', routerLink: 'collections'}));
  }

  ngOnInit(): void {
    this.authSubscription = this.store.select(selectAuthState).subscribe(next => {
      this.store.dispatch(new GetUser(next.userID));
    });
  }

  trackByProjectFn(index, item: Project) {
    return item.id; // unique id corresponding to the item
  }

  trackByPermissionFn(index, item: Permissions) {
    return item.id; // unique id corresponding to the item
  }


  ngOnDestroy(): void {
    this.authSubscription.unsubscribe();
  }
}
