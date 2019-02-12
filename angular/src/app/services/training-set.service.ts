import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {NGXLogger} from 'ngx-logger';
import {AuthService} from './auth.service';
import {DialogsService} from './dialogs.service';
import {Observable} from 'rxjs';
import {ITrainingSetExporter} from '../model/itraining-set-exporter';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TrainingSetService {
  private urlTrainingSets: string;

  constructor(private http: HttpClient,
              private logger: NGXLogger,
              private authService: AuthService,
              private dialogService: DialogsService) {
    this.urlTrainingSets = environment.apiEndpoint + '/trainingsets';
  }

  getTrainingSetExporters$(): Observable<Array<ITrainingSetExporter>> {
    this.logger.debug('IM3WSService: fetching training set exporters');
    return this.http.get<Array<ITrainingSetExporter>>(this.urlTrainingSets + '/exporters', this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('Fetch training set exporters', null))
      );
  }

  downloadTrainingSet$(exporterIndex: number, projectIDS: Array<number>): Observable<any> {
    this.logger.debug('IM3WSService: fetching training set file for exporter ' + exporterIndex + ' and project ids: ' + projectIDS);
    let projectIdsString: string = null;
    projectIDS.forEach(id => {
      if (projectIdsString != null) {
        projectIdsString = projectIdsString + ',' + id;
      } else {
        projectIdsString = '' + id;
      }
    });
    const headers = new HttpHeaders();
    Object.assign(headers, this.authService.getHttpAuthOptions());
    headers.append('Content-Type', 'application/x-gzip');

    /*return this.http.post<any>(this.urlTrainingSets + '/download/' + exporterIndex + '/' + projectIdsString,
      {headers, responseType: 'blob'})
      .pipe(
        catchError(this.dialogService.handleError('Download training set', null))
      );*/

    return this.http.get(this.urlTrainingSets + '/download/' + exporterIndex + '/' + projectIdsString,
      { responseType: 'blob' }).pipe(
      catchError(this.dialogService.handleError('Download training set', null))
    );
  }
}
