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

  exportMEIPartsFacsimile$(projectID: number, selectedImages: Array<number>) {
    const selectedImagesString = selectedImages.join(',');
    const url = `project/exportMEIPartsFacsimile/${projectID}/${selectedImagesString}`;
    return this.apiRestClientService.get$<StringResponse>(url);
  }

  exportMEI$(projectID: number, partID: number, selectedImages: Array<number>): Observable<StringResponse> {
    const selectedImagesString = selectedImages.join(',');
    let url: string;
    if (partID) {
      url = `project/exportPartMEI/${projectID}/${partID}/${selectedImagesString}`;
    } else {
      url = `project/exportFullScoreMEI/${projectID}/${selectedImagesString}`;
    }
    return this.apiRestClientService.get$<StringResponse>(url);
  }

  exportMensurstrich$(projectID: number, selectedImages: Array<number>): Observable<Blob> {
    const selectedImagesString = selectedImages.join(',');
    const url = `project/exportMensurstrich/${projectID}/${selectedImagesString}`;
    return this.apiRestClientService.getBlob$(url);
  }

  exportMusicXML$(projectID: number, selectedImages: Array<number>): Observable<Blob> {
    const selectedImagesString = selectedImages.join(',');
    const url = `project/exportMusicXML/${projectID}/${selectedImagesString}`;
    return this.apiRestClientService.getBlob$(url);
  }
}
