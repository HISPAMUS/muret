import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {AlertComponent} from '../../shared/components/error-modal-message/alert.component';
import {ServerError} from '../model/restapi/server-error';
import {SimpleModalService} from 'ngx-simple-modal';
import {NGXLogger} from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlingService {

  constructor(private simpleModalService: SimpleModalService, private logger: NGXLogger) { }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  public handleError<T>(operation = 'operation', result?: T) {
    return (error: ServerError): Observable<T> => {

      this.logger.warn(`${operation} failed: ${error.message}`);
      this.simpleModalService.addModal(AlertComponent, {
        title: error.error,
        message: error.message
      });
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
