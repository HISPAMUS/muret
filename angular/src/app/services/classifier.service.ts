import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {NGXLogger} from 'ngx-logger';
import {Observable} from 'rxjs';
import {ClassifierType} from '../model/classifier-type';
import {catchError} from 'rxjs/operators';
import {AuthService} from './auth.service';
import {DialogsService} from './dialogs.service';

@Injectable({
  providedIn: 'root'
})
export class ClassifierService {
  private urlClassifierTypes: string;

  constructor(private http: HttpClient,
              private logger: NGXLogger,
              private authService: AuthService,
              private dialogService: DialogsService) {
    this.urlClassifierTypes = environment.apiEndpoint + '/classifiers';
  }

  getClassifierTypes$(): Observable<ClassifierType[]> {
    this.logger.debug('IM3WSService: fetching classifier types...');
    // TODO Pasarle usuario actual
    return this.http.get<ClassifierType[]>(this.urlClassifierTypes, this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('getClassifierTypes$', []))
      );

  }

}
