import { Injectable } from '@angular/core';
import {ToastrService} from 'ngx-toastr';
import {APIRestServerError} from '../model/restapi/apirest-server-error';

@Injectable({
  providedIn: 'root'
})
export class ShowErrorService {

  constructor(private toastr: ToastrService) { }

  public warning(apiRestServerError: APIRestServerError) {
    this.toastr.warning(apiRestServerError.detailedMessage, apiRestServerError.message);
  }
}
