import { Injectable } from '@angular/core';
import {Project} from '../../../core/model/entities/project';
import {Observable} from 'rxjs';
import {Image} from '../../../core/model/entities/image';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {StringResponse} from '../../../core/model/restapi/string-response';
import {DocumentAnalysisImageProjection} from '../../../core/model/restapi/document-analysis-image-projection';
import {ProjectStatistics} from '../../../core/model/restapi/project-statistics';
import {UsesOfParts} from '../../../core/model/restapi/uses-of-parts';

@Injectable() // non-singleton
export class ProjectService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public getProject$(id: number): Observable<Project> {
    // return this.apiRestClientService.getOf$<Project>('projects', id);
    return this.apiRestClientService.getExcerptProjectionOf$<Project>(id, 'projects');
  }

  public getProjectImages$(id: number): Observable<Image[]> {
    return this.apiRestClientService.getDetailsExcerptProjection$<Image>('projects', 'images', id);
  }

  public getProjectStatistics$(id: number): Observable<ProjectStatistics> {
    const url = `project/statistics/${id}`;
    return this.apiRestClientService.get$<ProjectStatistics>(url);
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

  exportMensurstrich$(projectID: number): Observable<Blob> {
    const url = `project/exportMensurstrich/${projectID}`;
    return this.apiRestClientService.getBlob$(url);
  }

  exportMusicXML$(projectID: number): Observable<Blob> {
    const url = `project/exportMusicXML/${projectID}`;
    return this.apiRestClientService.getBlob$(url);
  }

  getUsesOfParts$(projectID: number): Observable<UsesOfParts> {
    const url = `parts/uses/${projectID}`;
    return this.apiRestClientService.get$<UsesOfParts>(url);
  }
}
