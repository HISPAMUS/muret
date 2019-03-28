import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {ApiRestClientService} from '../../core/services/api-rest-client.service';
import {Project} from '../../core/model/entities/project';
import {User} from '../../core/model/entities/user';

@Injectable()
export class NewProjectService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public newProject$(createdBy: User, name: string, composer: string, notationType: string, manuscriptType: string, comments: string,
                     base64Thumbnail: string): Observable<Project> {
    return this.apiRestClientService.post$<Project>('project/new', {
      createdBy,
      name,
      composer,
      notationType,
      manuscriptType,
      comments,
      thumbnailBase64Encoding: base64Thumbnail
    });
  }
}
