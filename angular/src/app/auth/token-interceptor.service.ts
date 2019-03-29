import {HttpErrorResponse, HttpEvent} from '@angular/common/http';
import {Injectable, OnDestroy} from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';

import {AuthService} from './services/auth.service';
import {Router} from '@angular/router';
import {Observable, Subscription, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Store} from '@ngrx/store';
import {AuthState} from './store/state/auth.state';
import {selectAccessToken} from './store/selectors/auth.selector';
import {SessionData} from './models/session-data';
import {ErrorHandlingService} from '../core/services/error-handling.service';

const TOKEN_HEADER_KEY = 'Authorization';

// singleton shared across all the application
@Injectable({
  providedIn: 'root'
})
// Interceptor used to include the auth bearer information
export class TokenInterceptor implements HttpInterceptor, OnDestroy {
    accessTokenSubscription: Subscription;
    accessToken: string;

    constructor(private store: Store<AuthState>) {
      this.accessTokenSubscription = store.select(selectAccessToken).subscribe(next => {
        this.accessToken = next;
      });

    }

    intercept(req: HttpRequest<any>, next: HttpHandler) {
        let authReq = req;
        if (this.accessToken != null) {
            authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + this.accessToken) });
        }

        return next.handle(authReq);
    }

  ngOnDestroy(): void {
      this.accessTokenSubscription.unsubscribe();
  }
}

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
  constructor(private router: Router, private errorHandlingService: ErrorHandlingService) {}
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(request).pipe(
      catchError((response: any) => {
        if (response instanceof HttpErrorResponse && response.status === 401) {
          SessionData.clearSessionData();
          this.router.navigateByUrl('/login');
          return throwError(response);
        } else {
          this.errorHandlingService.showError('Server error', response.message);
          return null;
        }
      }));
  }
}
