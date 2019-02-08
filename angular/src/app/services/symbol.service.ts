import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {NGXLogger} from 'ngx-logger';
import {environment} from '../../environments/environment';
import {AuthService} from './auth.service';
import {DialogsService} from './dialogs.service';
import {Observable} from 'rxjs';
import {Symbol} from '../model/symbol';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SymbolService {
  private urlSymbol: string;

  constructor(private http: HttpClient,
              private logger: NGXLogger,
              private authService: AuthService,
              private dialogService: DialogsService) {
    this.urlSymbol = environment.apiEndpoint + '/symbol';
  }

  // TODO ¿Se está usando? - Si no, quitarlo
  public getSymbolsOfRegion$(regionID: number): Observable<Symbol> {
    this.logger.debug('IM3WSService: fetching symbols with region_id ' + regionID);
    return this.http.get<Symbol>(this.urlSymbol + '/region/' + regionID, this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('getSymbols$ with region_id=' + regionID, null))
      );
  }

  changeAgnosticSymbolType(symbolID: number, agnosticSymbolTypeString: string): Observable<Symbol> {
    this.logger.debug('IM3WSService: changeAgnosticSymbolType with symbol id: ' + symbolID + ' to ' + agnosticSymbolTypeString);

    return this.http.get<Symbol>(this.urlSymbol + '/changeAgnosticSymbolType/' + symbolID + '/' + agnosticSymbolTypeString
      , this.authService.getHttpAuthOptions());
  }

  changeAgnosticPositionInStaff(symbolID: number, agnosticSymbolPositionInStaff: string): Observable<Symbol> {
    this.logger.debug('IM3WSService: changeAgnosticSymbolType with symbol id: ' + symbolID + ' to ' + agnosticSymbolPositionInStaff);

    return this.http.get<Symbol>(this.urlSymbol + '/changeAgnosticPositionInStaff/' + symbolID + '/' + agnosticSymbolPositionInStaff
      , this.authService.getHttpAuthOptions());
  }

  /**
   * @param upOrDown up | down
   */
  changeAgnosticPositionInStaffUpOrDown(symbolID: number, upOrDown: string): Observable<Symbol> {
    this.logger.debug('IM3WSService: changeAgnosticSymbolType with symbol id: ' + symbolID + ' ' + upOrDown);

    return this.http.get<Symbol>(this.urlSymbol + '/changeAgnosticPositionInStaffUpOrDown/' + symbolID + '/' + upOrDown
      , this.authService.getHttpAuthOptions());
  }


}
