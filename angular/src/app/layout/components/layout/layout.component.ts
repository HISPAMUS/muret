import {Component, isDevMode, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {CoreState} from '../../../core/store/state/core.state';
import {Store} from '@ngrx/store';
import {selectIsAuthenticated, selectUsername} from '../../../auth/store/selectors/auth.selector';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {
  isDev = isDevMode();

  menuVisible = true;
  isAuthenticated$: Observable<boolean>;
  username$: Observable<string>;

  constructor(private store: Store<CoreState>) {
    this.isAuthenticated$ = this.store.select(selectIsAuthenticated);
    this.username$ = this.store.select(selectUsername);
  }

  ngOnInit() {
  }
}
