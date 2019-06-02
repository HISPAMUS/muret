import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {ApiRestClientService} from '../../core/services/api-rest-client.service';
import {Project} from '../../core/model/entities/project';
import {User} from '../../core/model/entities/user';
import {Collection} from '../../core/model/entities/collection';

@Injectable()
export class NewProjectService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public newProject$(createdBy: User, name: string, composer: string, notationType: string, manuscriptType: string, comments: string,
                     base64Thumbnail: string, collectionID: number): Observable<Project> {
    const collection: Collection = {
      id: collectionID
    };

    return this.apiRestClientService.post$<Project>('project/new', {
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
