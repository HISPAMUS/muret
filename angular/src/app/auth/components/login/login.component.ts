import {Component, isDevMode, OnInit} from '@angular/core';
import {Credentials} from '../../models/credentials';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {AuthState} from '../../store/state/auth.state';
import {selectAuthErrorMessage, selectAuthIsAuthenticated, selectAuthUsername} from '../../store/selectors/auth.selector';
import {AuthLogIn, AuthLogOut} from '../../store/actions/auth.actions';
import {environment} from '../../../../environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credentials: Credentials = {};

  isAuthenticated$: Observable<boolean>;
  username$: Observable<string>;
  errorMessage$: Observable<string>;
  isDev = isDevMode();

  constructor(private store: Store<AuthState>) {
    this.isAuthenticated$ = this.store.select(selectAuthIsAuthenticated);
    this.errorMessage$ = this.store.select(selectAuthErrorMessage);
    this.username$ = this.store.select(selectAuthUsername);
  }

  ngOnInit() {
  }

  login() {
    this.store.dispatch(new AuthLogIn(this.credentials));
  }

  logout() {
    this.store.dispatch(new AuthLogOut());
  }
}
