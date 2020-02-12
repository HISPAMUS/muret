import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {NGXLogger} from 'ngx-logger';
import {DialogsService} from '../../shared/services/dialogs.service';
import {HttpErrorResponse} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
/**
 * @deprecated Errors are handled using the ErrorInterceptor class
 */
export class ErrorHandlingService {

  constructor(private dialogsService: DialogsService, private logger: NGXLogger) { }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param errorDialogTitle - the title of the error dialog
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  public handleHttpError<T>(errorDialogTitle: string, error: HttpErrorResponse, operation = 'operation', result?: T) {
    return (): Observable<T> => {
      this.logger.warn(`${operation} failed: ${error.message}`);
      this.dialogsService.showError(errorDialogTitle, error.message, operation + ' generates the error ' + JSON.stringify(error));

      /*this.logger.warn(`${operation} failed: ${error.message}`);
      this.dialogsService.showError(error.error.error, error.error.message);*/
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  public showError(title: string, message: string) {
    this.logger.warn('Error message: ' + message);
    this.dialogsService.showError(title, message);
  }
}
