import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Observable} from 'rxjs';

@Injectable()
export class SemanticRepresentationService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  hazAccion$(parametro: any): Observable<any> {
    return null;
  }
}
