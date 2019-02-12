import { Injectable } from '@angular/core';
import {NGXLogger} from 'ngx-logger';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Symbol} from '../model/symbol';
import {catchError} from 'rxjs/operators';
import {RestClientService} from "./rest-client.service";

@Injectable({
  providedIn: 'root'
})
export class SymbolService {
  private urlSymbol: string;

  constructor(private restClientService: RestClientService,
              private logger: NGXLogger) {
    this.urlSymbol = environment.apiEndpoint + '/symbol';
  }

  changeAgnosticSymbolType$(symbolID: number, agnosticSymbolTypeString: string): Observable<Symbol> {
    return this.restClientService.httpGet$<Symbol>(this.urlSymbol + '/changeAgnosticSymbolType/' + symbolID + '/' + agnosticSymbolTypeString
      , 'ChangeAgnosticSymbolType with symbol id: ' + symbolID + ' to ' + agnosticSymbolTypeString);
  }

  changeAgnosticPositionInStaff(symbolID: number, agnosticSymbolPositionInStaff: string): Observable<Symbol> {
    this.logger.debug('IM3WSService: changeAgnosticSymbolType with symbol id: ' + symbolID + ' to ' + agnosticSymbolPositionInStaff);

    return this.restClientService.httpGet$<Symbol>(this.urlSymbol + '/changeAgnosticPositionInStaff/' + symbolID + '/' + agnosticSymbolPositionInStaff
      , 'ChangeAgnosticSymbolType with symbol id: ' + symbolID + ' to ' + agnosticSymbolPositionInStaff);
  }

  /**
   * @param upOrDown up | down
   */
  changeAgnosticPositionInStaffUpOrDown$(symbolID: number, upOrDown: string): Observable<Symbol> {
    return this.restClientService.httpGet$<Symbol>(this.urlSymbol + '/changeAgnosticPositionInStaffUpOrDown/' + symbolID + '/' + upOrDown
      , 'ChangeAgnosticSymbolType with symbol id: ' + symbolID + ' ' + upOrDown);
  }


}
