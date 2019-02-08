import {Injectable, ErrorHandler, Injector} from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import {NGXLogger} from 'ngx-logger';
import {Router} from '@angular/router';

@Injectable()
export class GlobalErrorHandlerService implements ErrorHandler {
  constructor (private logger: NGXLogger, private injector: Injector) {

  }

  handleError(error: any) {
    const router = this.injector.get(Router);

    if (error instanceof HttpErrorResponse) {
      // Backend returns unsuccessful response codes such as 404, 500 etc.
      this.logger.error(router.url + ', backend returned status code: ', error.status + ', and response body ' + error.message);
    } else {
      // A client-side or network error occurred.
      this.logger.error(router.url + ', a client or network error occurred:', error.message);
    }
  }
}
