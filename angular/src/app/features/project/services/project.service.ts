import { Injectable } from '@angular/core';
import {Project} from '../../../core/model/entities/project';
import {Observable} from 'rxjs';
import {Image} from '../../../core/model/entities/image';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';

@Injectable() // non-singleton
export class ProjectService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public getProject$(id: number): Observable<Project> {
    return this.apiRestClientService.get$<Project>('projects', id);
  }

  public getProjectImages$(id: number): Observable<Image[]> {
    console.log('id=' + id);
    return this.apiRestClientService.getDetailsExcerptProjection$<Image>('projects', 'images', id);
  }
}
