import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {ApiRestClientService} from '../../core/services/api-rest-client.service';
import {Document} from '../../core/model/entities/document';
import {User} from '../../core/model/entities/user';
import {Collection} from '../../core/model/entities/collection';

@Injectable()
export class NewDocumentService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public newDocument$(createdBy: User, name: string, composer: string, notationType: string, manuscriptType: string, comments: string,
                     base64Thumbnail: string, collectionID: number): Observable<Document> {
    const collection: Collection = {
      id: collectionID
    };

    return this.apiRestClientService.post$<Document>('document/new', {
      createdBy,
      name,
      composer,
      notationType,
      manuscriptType,
      comments,
      thumbnailBase64Encoding: base64Thumbnail,
      collection
    });
  }

  public getCollections$(): Observable<Collection[]> {
    return this.apiRestClientService.getListExcerptProjection$<Collection>('collections');
  }
}
