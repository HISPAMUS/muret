import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../shared/services/api-rest-client.service';
import {Project} from '../../shared/entities/project';
import {Observable} from 'rxjs';
import {Image} from '../../shared/entities/image';

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
