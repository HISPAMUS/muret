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

  public createSubcollection$(parentId: number, subcollectionName: string): Observable<Collection> {
    return this.apiRestClientService.put$<Collection>('collections/create/' + parentId + '/' + subcollectionName, null);
  }

  public deleteSubcollection$(id: number): Observable<number> {
    return this.apiRestClientService.delete$<number>('collections/delete', id);
  }

  moveDocumentsToSubcollection$(currentCollectionID: number, documentIDs: number[], subcollectionID: number): Observable<number> {
    const params = {
      currentCollectionID,
      documentIDs,
      subcollectionID
    };

    return this.apiRestClientService.put$<number>('collections/moveDocumentToSubcollection', params);
  }

  moveDocumentsToNewSubcollection$(currentCollectionID: number, documentIDs: number[], newCollectionName: string): Observable<number> {
    const params = {
      currentCollectionID,
      documentIDs,
      newCollectionName
    };

    return this.apiRestClientService.put$<number>('collections/moveDocumentToNewSubcollection', params);
  }
}
