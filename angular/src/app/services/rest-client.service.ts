import { Injectable } from '@angular/core';
import {NGXLogger} from 'ngx-logger';
import {AuthService} from './auth.service';
import {HttpClient} from "@angular/common/http";
import {DialogsService} from "./dialogs.service";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})

/**
 * This class encapsulates the HTTP REST API calls including CORS and authentication
 */
export class RestClientService {

  constructor(
    private http: HttpClient,
    private authService: AuthService,
    private dialogService: DialogsService,
    private logger: NGXLogger,
  ) {
    this.logger.info('Creating RestClientService');
  }

  public httpGetBlob<Blob>(url: string, debugMessage: string): Observable<Blob> {
    this.logger.debug('RestClientService: ' + debugMessage);

    return this.http.get(url, {headers: this.authService.getHeaders(), responseType: 'blob'}).pipe(
      catchError(this.dialogService.handleError(debugMessage, null))
    );
  }

  public httpGet$<T>(url: string, debugMessage: string): Observable<T> {
    this.logger.debug('RestClientService: ' + debugMessage);

    return this.http.get<T>(url, this.authService.getHttpAuthOptions()).pipe(
        catchError(this.dialogService.handleError(debugMessage, null))
    );
  }

  public httpPost<T>(url: string, body: any, debugMessage: string): Observable<T> {
    this.logger.debug('RestClientService: ' + debugMessage);

    return this.http.post<T>(url, body, this.authService.getHttpAuthOptions()).pipe(
      catchError(this.dialogService.handleError(debugMessage, null))
    );
  }

  public httpPut<T>(url: string, body: any, debugMessage: string): Observable<T> {
    this.logger.debug('RestClientService: ' + debugMessage);

    return this.http.put<T>(url, body, this.authService.getHttpAuthOptions()).
    pipe(
      catchError(this.dialogService.handleError(debugMessage, null))
    );
  }
}
