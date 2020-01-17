import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Collection} from '../../../core/model/entities/collection';

@Injectable() // non-singleton
export class DocumentsService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public getCollection$(id: number): Observable<Collection> {
    return this.apiRestClientService.getExcerptProjectionOf$<Collection>(id, 'collections');
  }
}
