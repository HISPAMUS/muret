import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Observable, of, throwError} from 'rxjs';
import {catchError, map} from 'rxjs/operators';
import {environment} from '../../../environments/environment';
import {NGXLogger} from 'ngx-logger';
import {APIRestServerError} from '../model/restapi/apirest-server-error';

@Injectable({
  providedIn: 'root'
})
// Based on the code in https://medium.com/@krishna.acondy/a-generic-http-service-approach-for-angular-applications-a7bd8ff6a068
export class ApiRestClientService {
  url = environment.apiEndpoint;

  constructor(private httpClient: HttpClient,
              private logger: NGXLogger) { }

  private createAPIServerError(err: HttpErrorResponse): APIRestServerError {
    const serverError: APIRestServerError = {
      url: err.url,
      message: err.error.error,
      detailedMessage: err.error.message,
      status: err.error.status
    };
    return serverError;
  }

  // HATEOAS
  public getListExcerptProjection$<T>(endpoint: string): Observable<T[]> {
    return this.getListProjection$(endpoint, 'excerpt');
  }

  // HATEOAS
  public getListProjection$<T>(endpoint: string, projection: string): Observable<T[]> {
    let url: string;
    url = `${this.url}/${endpoint}/?projection=${projection}`;
    this.logger.debug('RestClientService#getListExcerptProjection$ ' + url);

    return this.httpClient.get(url).pipe(
      map((data: any) => data._embedded[endpoint] as T[]),
      catchError(err => throwError(this.createAPIServerError(err))) // required to return an observable
    );
  }
  // HATEOAS
  public getExcerptProjectionOf$<T>(id: number, endpoint: string): Observable<T> {
    return this.getProjectionOf$(id, endpoint, 'excerpt');
  }
  // HATEOAS
  public getProjectionOf$<T>(id: number, endpoint: string, projection: string): Observable<T> {
    let url: string;
    url = `${this.url}/${endpoint}/${id}?projection=${projection}`;
    this.logger.debug('RestClientService#getProjectionOf$ ' + url);

    return this.httpClient.get(url).pipe(
      map((data: any) => data as T),
      catchError(err => throwError(this.createAPIServerError(err))) // required to return an observable
    );
  }
  public getList$<T>(endpoint: string): Observable<T[]> {
    let url: string;
    url = `${this.url}/${endpoint}`;
    this.logger.debug('RestClientService#getList ' + url);

    return this.httpClient.get<T[]>(url).pipe(
      catchError(err => throwError(this.createAPIServerError(err))) // required to return an observable
    );
  }

  // HATEOAS
  public getOf$<T>(endpoint: string, id: number): Observable<T> {

    let url: string;
    url = `${this.url}/${endpoint}/${id}`;
    this.logger.debug('RestClientService#getOf ' + url);
    return this.httpClient.get<T>(url).pipe(
      catchError(err => throwError(this.createAPIServerError(err))) // required to return an observable
    );
  }

  // HATEOAS
  public getDetailsExcerptProjection$<T>(endpoint: string, detailsEndpoint: string, id: number): Observable<T[]> {

    let url: string;
    url = `${this.url}/${endpoint}/${id}/${detailsEndpoint}?projection=excerpt`;
    this.logger.debug('RestClientService#getDetailsExcerptProjection$ ' + url);
    return this.httpClient.get<T[]>(url).pipe(
      map((data: any) => data._embedded[detailsEndpoint] as T[]),
      catchError(err => of(null)) // required to return an observable
    );
  }


  public getBlob$(endpoint: string): Observable<Blob> {
    let url: string;
    url = `${this.url}/${endpoint}`;
    this.logger.debug('RestClientService#getBlob ' + url);
    return this.httpClient.get(url, {responseType: 'blob'}).pipe(
      catchError(err => throwError(this.createAPIServerError(err))) // required to return an observable
    );
    // Errors are handled in ErrorInterceptor
      // catchError(this.errorHandlingService.handleHttpError(endpoint, null))
      // catchError((err: HttpErrorResponse) => this.errorHandlingService.handleHttpError('TO-DO', err, endpoint, null))
  }

  public get$<T>(endpoint: string): Observable<T> {
    let url: string;
    url = `${this.url}/${endpoint}`;
    this.logger.debug('RestClientService#get ' + url);
    return this.httpClient.get<T>(url).pipe(
      catchError(err => throwError(this.createAPIServerError(err))) // required to return an observable
    );
  }


  public post$<T>(endpoint: string, body: any): Observable<T> {

    let url: string;
    url = `${this.url}/${endpoint}`;

    this.logger.debug('RestClientService#post ' + url);

    return this.httpClient.post<T>(url, body).pipe(
      catchError(err => throwError(this.createAPIServerError(err))) // required to return an observable
    );
    /*.Errors are handled in ErrorInterceptor pipe(
      // catchError(this.errorHandlingService.handleHttpError(endpoint, null))
      catchError(err => this.errorHandlingService.handleHttpError('TO-DO', endpoint, err, null))
    );*/
  }

  public put$<T>(endpoint: string, body: any): Observable<T> {

    let url: string;
    url = `${this.url}/${endpoint}`;

    this.logger.debug('RestClientService#put ' + url);

    return this.httpClient.put<T>(url, body).pipe(
      catchError(err => throwError(this.createAPIServerError(err))) // required to return an observable
    );
/*.Errors are handled in ErrorInterceptor   pipe(
   // catchError(this.errorHandlingService.handleHttpError(endpoint, null))
  .catchError(err => this.errorHandlingService.handleHttpError('TO-DO', endpoint, err, null))
  );*/
  }

  public delete$<T>(endpoint: string, id: any): Observable<T> {

    let url: string;
    url = `${this.url}/${endpoint}/${id}`;

    this.logger.debug('RestClientService#put ' + url);

    return this.httpClient.delete<T>(url).pipe(
      catchError(err => throwError(this.createAPIServerError(err))) // required to return an observable
    );
    /*.Errors are handled in ErrorInterceptor pipe(
      .catchError(err => this.errorHandlingService.handleHttpError('TO-DO', endpoint, err, null))
      // catchError(this.errorHandlingService.handleHttpError('TO-DO', endpoint, err, null))
    );*/
  }
}
