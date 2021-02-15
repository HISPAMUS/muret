import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {LastDocumentExtract} from "../model/last-document-extract";

@Injectable() // non-singleton
export class HomeService {
  constructor(private apiRestClientService: ApiRestClientService) { }

  getUserLastDocuments$(userID: number, count: number): Observable<LastDocumentExtract[]> {
    const url = `lastdocument/user/${userID}/${count}`;
    return this.apiRestClientService.get$<LastDocumentExtract[]>(url);
  }

  updateUserLastDocument$(userID: number, documentID: number): Observable<LastDocumentExtract> {
    const url = `lastdocument/update/${userID}/${documentID}`;
    return this.apiRestClientService.get$<LastDocumentExtract>(url);
  }
}
