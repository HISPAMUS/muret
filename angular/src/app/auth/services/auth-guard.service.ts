import {Injectable, OnDestroy} from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {AuthState} from '../store/state/auth.state';
import {selectIsAuthenticated} from '../store/selectors/auth.selector';
import {Subscription} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate, OnDestroy {
  isAuthenticatedSubscription: Subscription;
  private isAuthenticated: boolean;

  constructor(
    private store: Store<AuthState>,
    public router: Router
  ) {
    this.isAuthenticatedSubscription = this.store.select(selectIsAuthenticated).subscribe(next => {
      this.isAuthenticated = next;
    });
  }
  canActivate(): boolean {
    return this.isAuthenticated;
  }

  ngOnDestroy(): void {
    this.isAuthenticatedSubscription.unsubscribe();
  }
}
