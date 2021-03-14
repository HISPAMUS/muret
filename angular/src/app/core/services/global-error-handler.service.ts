import {ErrorHandler, Injectable, Injector} from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import {ToastrService} from "ngx-toastr";

@Injectable()
export class GlobalErrorHandler implements ErrorHandler {
  private _toastService?: ToastrService; // cannot inject directly because it generates a cyclic dependency (see https://mdbootstrap.com/support/angular/6-1-2-toast-module-cannot-instantiate-cyclic-dependency/)

  constructor(private injector: Injector) {

  }

  handleError(error: any): void {
    if (!this._toastService) {
      this._toastService=this.injector.get(ToastrService);
    }
    if (error instanceof HttpErrorResponse) {
      this._toastService.warning(error.statusText, error.message);
    } else if (error.detailedMessage) { // instance of apiRestServerError
      this._toastService.warning(error.detailedMessage, error.message);
    } else {
      this._toastService.warning(null, error);
    }
    console.log(error);
  }
}
