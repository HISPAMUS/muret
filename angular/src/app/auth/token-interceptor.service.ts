import {HttpErrorResponse, HttpEvent} from '@angular/common/http';
import {Injectable, OnDestroy} from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';

import {Observable, Subscription, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Store} from '@ngrx/store';
import {AuthState} from './store/state/auth.state';
import {selectAuthAccessToken} from './store/selectors/auth.selector';

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
      this.accessTokenSubscription = store.select(selectAuthAccessToken).subscribe(next => {
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

/*@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
  // constructor(private router: Router, private errorHandlingService: ErrorHandlingService) {}
  constructor(private router: Router, private logger: NGXLogger) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(request).pipe(
      catchError((response: any) => {
        if (response instanceof HttpErrorResponse && response.status === 401) {
          SessionData.clearSessionData();
          this.router.navigateByUrl('/login');
          return throwError(response);
        }
      }));
  }

  /*serveError(error: HttpErrorResponse) {
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
  }*/
// }


// https://stackoverflow.com/questions/49479959/angular-5-manage-http-get-with-blob-response-and-json-errors/49481656#49481656
// Used to correct the problem described in https://github.com/angular/angular/issues/19888 where HttpClient -
// HttpErrorResponse not json but blob
// Declared in app/app-routing.module.ts
@Injectable()
export class BlobErrorHttpInterceptor implements HttpInterceptor {
  public intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      catchError(err => {
        if (err instanceof HttpErrorResponse && err.error instanceof Blob && err.error.type === 'application/json') {
          // https://github.com/angular/angular/issues/19888
          // When request of type Blob, the error is also in Blob instead of object of the json data
          return new Promise<any>((resolve, reject) => {
            const reader = new FileReader();
            reader.onload = (e: Event) => {
              try {
                const errmsg = JSON.parse((<any>e.target).result);
                reject(new HttpErrorResponse({
                  error: errmsg,
                  headers: err.headers,
                  status: err.status,
                  statusText: err.statusText,
                  url: err.url
                }));
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
        return throwError(err);
      })
    );
  }
}
