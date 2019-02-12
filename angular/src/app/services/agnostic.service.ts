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
import {RestClientService} from "./rest-client.service";

@Injectable({
  providedIn: 'root'
})
export class AgnosticService {
  private urlAgnostic: string;

  constructor(private restClientService: RestClientService,
        private logger: NGXLogger,
        private dialogService: DialogsService) {
    this.urlAgnostic = environment.apiEndpoint + '/agnostic';
  }

  public getSVGFromAgnosticSymbolType$(notationType: string, manuscriptType: string, agnosticSymbolType: string)
    : Observable<StringReponse> {

    return this.restClientService.httpGet$<StringReponse>(this.urlAgnostic + '/svg'
      + '?notationType=' + notationType
      + '&manuscriptType=' + manuscriptType
      + '&symbolType=' + agnosticSymbolType,
      'Fetching svg path for notationType=' + notationType
      + 'manuscriptType=' + manuscriptType
      + ' and agnosticSymbolType=' + agnosticSymbolType);
  }

  public getSVGSet$(notationType: string, manuscriptType: string): Observable<SVGSet> {
    return this.restClientService.httpGet$<SVGSet>(this.urlAgnostic + '/svgset'
      + '?notationType=' + notationType
      + '&manuscriptType=' + manuscriptType
      ,
      'Fetching svgset for notationType=' + notationType
      + 'manuscriptType=' + manuscriptType);
  }

}
