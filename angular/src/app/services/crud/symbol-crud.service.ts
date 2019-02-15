import { Injectable } from '@angular/core';
import {NGXLogger} from 'ngx-logger';
import {environment} from '../../../environments/environment';
import {RestClientService} from "../rest-client.service";

@Injectable({
  providedIn: 'root'
})
export class SymbolCrudService {
  private urlSymbol: string;

  constructor(private restClientService: RestClientService,
              private logger: NGXLogger) {
    this.urlSymbol = environment.apiEndpoint + '/symbolcrud';
  }
}
