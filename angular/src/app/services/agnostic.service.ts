import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {NGXLogger} from 'ngx-logger';
import {AuthService} from './auth.service';
import {DialogsService} from './dialogs.service';
import {Observable} from 'rxjs';
import {StringReponse} from '../string-reponse';
import {catchError} from 'rxjs/operators';
import {SVGSet} from '../model/SVGSet';

@Injectable({
  providedIn: 'root'
})
export class AgnosticService {
  private urlAgnostic: string;

  constructor(private http: HttpClient,
              private logger: NGXLogger,
              private authService: AuthService,
              private dialogService: DialogsService) {
    this.urlAgnostic = environment.apiEndpoint + '/agnostic';
  }

  public getSVGFromAgnosticSymbolType$(notationType: string, manuscriptType: string, agnosticSymbolType: string)
    : Observable<StringReponse> {
    this.logger.debug('IM3WSService: fetching svg path for notationType=' + notationType
      + 'manuscriptType=' + manuscriptType
      + ' and agnosticSymbolType=' + agnosticSymbolType);
    return this.http.get<StringReponse>(this.urlAgnostic + '/svg'
      + '?notationType=' + notationType
      + '&manuscriptType=' + manuscriptType
      + '&symbolType=' + agnosticSymbolType
      ,
      this.authService.getHttpAuthOptions(),
    )
      .pipe(
        catchError(this.dialogService.handleError('getSVGFromAgnosticSymbolType ' + agnosticSymbolType, null))
      );
  }

  public setSVGSet$(notationType: string, manuscriptType: string): Observable<SVGSet> {
    this.logger.debug('IM3WSService: fetching svgset for notationType=' + notationType
      + 'manuscriptType=' + manuscriptType);
    return this.http.get<SVGSet>(this.urlAgnostic + '/svgset'
      + '?notationType=' + notationType
      + '&manuscriptType=' + manuscriptType
      ,
      this.authService.getHttpAuthOptions(),
    )
      .pipe(
        catchError(this.dialogService.handleError('getSVGScale', null))
      );
  }

}
