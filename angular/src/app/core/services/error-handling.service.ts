import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {NGXLogger} from 'ngx-logger';
import {DialogsService} from '../../shared/services/dialogs.service';

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlingService {

  constructor(private dialogsService: DialogsService, private logger: NGXLogger) { }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  public handleError<T>(operation = 'operation', result?: T) {
    return (error): Observable<T> => {
      this.logger.warn(`${operation} failed: ${error.message}`);
      this.dialogsService.showError(error.error.error, error.error.message);
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  public showError(title: string, message: string) {
    this.logger.warn('Error message: ' + message);
    this.dialogsService.showError(title, message);
  }
}
