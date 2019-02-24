import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlingService {

  constructor() { }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  public handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // this.logger.error(`${operation} failed: ${error.message}`);
      /// alert('Warning: ' + error.message); // TODO - algo mejor que un alert
      // Let the app keep running by returning an empty result.
      throw new Error(error.message);
    };
  }

}
