import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {NGXLogger} from 'ngx-logger';
import {AuthService} from './auth.service';
import {DialogsService} from './dialogs.service';
import {Observable} from 'rxjs';
import {RegionType} from '../model/region-type';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RegionService {
  private urlRegionTypes: string;

  constructor(private http: HttpClient,
              private logger: NGXLogger,
              private authService: AuthService,
              private dialogService: DialogsService) {
    this.urlRegionTypes = environment.apiEndpoint + '/regiontypes';
  }

  getRegionTypes(): Observable<RegionType[]> {
    this.logger.debug('IM3WSService: fetching region types...');
    return this.http.get<RegionType[]>(this.urlRegionTypes, this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('getRegionTypes', []))
      );
  }

}
