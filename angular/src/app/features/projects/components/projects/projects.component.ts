import {Component, OnDestroy, OnInit, Self} from '@angular/core';
import {Project} from '../../../../core/model/entities/project';
import {Permissions} from '../../../../core/model/entities/permissions';
import {Observable, Subscription} from 'rxjs';
import {User} from '../../../../core/model/entities/user';
import {CoreState} from '../../../../core/store/state/core.state';
import {select, Store} from '@ngrx/store';
import {selectLoggedInUser} from '../../../../core/store/selectors/user.selector';
import {AuthState} from '../../../../auth/store/state/auth.state';
import {GetUser} from '../../../../core/store/actions/user.actions';
import {selectAuthState} from '../../../../auth/store/selectors/auth.selector';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css'],
})

export class ProjectsComponent implements OnInit, OnDestroy {
  private authSubscription: Subscription;

  user$: Observable<User>;

  constructor(private store: Store<any>) {
    this.user$ = this.store.select(selectLoggedInUser);
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
