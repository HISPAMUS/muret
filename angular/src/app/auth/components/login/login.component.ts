import {Component, isDevMode, OnInit} from '@angular/core';
import {Credentials} from '../../models/credentials';
import {CoreState} from '../../../core/store/state/core.state';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {AuthState} from '../../store/state/auth.state';
import {selectAuthState} from '../../store/selectors/auth.selector';
import {LogIn, LogOut} from '../../store/actions/auth.actions';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credentials: Credentials = {};

  private authState$: Observable<AuthState>;
  errorMessage: string = null;
  isAuthenticated = false;
  isDev = isDevMode();

  constructor(private store: Store<AuthState>) {
    this.authState$ = this.store.select<AuthState>(selectAuthState);
  }

  ngOnInit() {
    this.authState$.subscribe((state: AuthState) => {
      this.errorMessage = state.errorMessage;
      this.isAuthenticated = state.isAuthenticated;
    });
  }

  login() {
    this.store.dispatch(new LogIn(this.credentials));
  }

  logout() {
    this.store.dispatch(new LogOut());
  }

  dev() {
    this.credentials.username = 'davidrizo';
    this.credentials.password = 'nose';
    this.login();
  }
    /*login() {
      this.loginTo('/home');
    }

    loginTo(url: string) {
      this.store.dispatch(new LogIn(this.credentials));
    }

    dev() {
      this.credentials.username = 'davidrizo';
      this.credentials.password = 'nose';
      // this.loginTo('/project/148');
      // this.loginTo('/documentanalysis/2104');
      this.loginTo('/documentanalysis/1849');
    }

    authenticated() {
      return this.authService.isLoggedIn;
    }*/

}
