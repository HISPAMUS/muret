import { Injectable } from '@angular/core';
import {ToastrService} from 'ngx-toastr';
import {APIRestServerError} from '../model/restapi/apirest-server-error';

//@deprecated - Use ErrorHandler
@Injectable({
  providedIn: 'root'
})
export class ShowErrorService {

  constructor(private toastr: ToastrService) {
  }

  public showServerError(apiRestServerError: APIRestServerError) {
    this.toastr.warning(apiRestServerError.detailedMessage, apiRestServerError.message);
  }

  public showWarning(message: string, detailedMessage: string) {
    this.toastr.warning(detailedMessage, message);
  }

}
