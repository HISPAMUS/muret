import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {ApiRestClientService} from "../../core/services/api-rest-client.service";
import {Breadcrumb} from "../../core/model/restapi/breadcrumb";

@Injectable() // non-singleton
export class BreadcrumbsService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public getCollectionBreadcrumbs(collectionID: number): Observable<Breadcrumb[]> {
    const url = `breadcrumbs/collection/${collectionID}`;
    return this.apiRestClientService.get$<Breadcrumb[]>(url);
  }

  public getDocumentBreadcrumbs(document: number): Observable<Breadcrumb[]> {
    const url = `breadcrumbs/document/${document}`;
    return this.apiRestClientService.get$<Breadcrumb[]>(url);
  }

}
