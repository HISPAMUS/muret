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
import {DialogsService} from '../shared/services/dialogs.service';
import {NGXLogger} from 'ngx-logger';

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
  // constructor(private router: Router, private errorHandlingService: ErrorHandlingService) {}
  constructor(private router: Router, private dialogsService: DialogsService, private logger: NGXLogger) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(request).pipe(
      catchError((response: any) => {
        if (response instanceof HttpErrorResponse && response.status === 401) {
          SessionData.clearSessionData();
          this.router.navigateByUrl('/login');
          return throwError(response);
        } else {
          // see Angular issue: https://github.com/angular/angular/issues/19888
          if (response instanceof HttpErrorResponse && response.error instanceof Blob && response.error.type === 'application/json') {
            this.handleBlobError(response);
            return throwError(response);
          } else {
            this.serveError(response);
            return throwError(response);
          }
        }
      }));
  }

  serveError(error: HttpErrorResponse) {
    switch (error.error.path)  {
      case '/muretapi/auth/login':
        this.logger.info('Error login');
        this.dialogsService.showError('Authentication error', 'The username or password are incorrect');
        break;
      default: {
        this.logger.warn(JSON.stringify(error));
        let title: string;
        if (error.error instanceof ErrorEvent) {
          title = 'Client communication error';
        } else {
          title = 'Server error #' + error.status;
        }

        this.dialogsService.showError(title, error.url, error.message);
      }
    }
  }

  private handleBlobError(err: HttpErrorResponse) {
// https://github.com/angular/angular/issues/19888
    // When request of type Blob, the error is also in Blob instead of object of the json data
    return new Promise<any>((resolve, reject) => {
      const reader = new FileReader();
      reader.onload = (e: Event) => {
        try {
          const error = JSON.parse((<any>e.target).result); // errmsg.message
          this.dialogsService.showError('Server error', err.url, error.message);
          /*
          reject(new HttpErrorResponse({
            error: errmsg,
            headers: err.headers,
            status: err.status,
            statusText: err.statusText,
            url: err.url
          }));*/
        } catch (e) {
          reject(err);
        }
      };
      reader.onerror = (e) => {
        reject(err);
      };
      reader.readAsText(err.error);
    });
  }
}
