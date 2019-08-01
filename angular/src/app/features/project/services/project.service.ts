import { Injectable } from '@angular/core';
import {Project} from '../../../core/model/entities/project';
import {Observable} from 'rxjs';
import {Image} from '../../../core/model/entities/image';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {StringResponse} from '../../../core/model/restapi/string-response';

@Injectable() // non-singleton
export class ProjectService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public getProject$(id: number): Observable<Project> {
    return this.apiRestClientService.getOf$<Project>('projects', id);
  }

  public getProjectImages$(id: number): Observable<Image[]> {
    return this.apiRestClientService.getDetailsExcerptProjection$<Image>('projects', 'images', id);
  }


  public getProjectUploadURL(): string {
    return this.apiRestClientService.url + '/project/uploadProjectImage';
  }

  exportMEIPartsFacsimile$(projectID: number) {
    const url = `project/exportMEIPartsFacsimile/${projectID}`;
    return this.apiRestClientService.get$<StringResponse>(url);
  }

  exportMEI$(projectID: number, partID: number): Observable<StringResponse> {
    let url: string;
    if (partID) {
      url = `project/exportPartMEI/${projectID}/${partID}`;
    } else {
      url = `project/exportFullScoreMEI/${projectID}`;
    }
    return this.apiRestClientService.get$<StringResponse>(url);
  }

}
