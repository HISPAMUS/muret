import {Component, isDevMode, OnInit, OnChanges, OnDestroy, Input} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {CoreState} from '../../../core/store/state/core.state';
import {Store} from '@ngrx/store';
import {selectAuthIsAuthenticated, selectAuthUsername, selectAuthRoles} from '../../../auth/store/selectors/auth.selector';
import {selectCoreServerStatus } from 'src/app/core/store/selectors/core.selector';
import { CoreGetServerStatus } from 'src/app/core/store/actions/server-status.actions';
import { DialogsService} from 'src/app/shared/services/dialogs.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {
  isDev = isDevMode();
  isAuthenticated$: Observable<boolean>;
  showMenu = false; //TODO
  showBreadcrumbs = false; //TODO - see https://getbootstrap.com/docs/4.2/components/breadcrumb/

  constructor(private store: Store<CoreState>) {
    this.isAuthenticated$ = this.store.select(selectAuthIsAuthenticated);
  }

  ngOnInit() {
  }

}
