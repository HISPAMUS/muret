import {Component, isDevMode, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {CoreState} from '../../../core/store/state/core.state';
import {Store} from '@ngrx/store';
import {AuthState} from '../../../auth/store/state/auth.state';
import {selectAuthState} from '../../../auth/store/selectors/auth.selector';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {
  isDev = isDevMode();

  menuVisible = true;

  private authState$: Observable<AuthState>;
  private isAuthenticated = false;

  constructor(private store: Store<CoreState>) {
    this.authState$ = this.store.select<AuthState>(selectAuthState);
  }

  ngOnInit() {
    this.authState$.subscribe((state: AuthState) => {
      this.isAuthenticated = state.isAuthenticated;
    });
  }
}
