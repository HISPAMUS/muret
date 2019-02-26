import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../shared/services/api-rest-client.service';
import {Observable} from 'rxjs';
import {DocumentAnalysisImageProjection} from '../../shared/projections/document-analysis-image-projection';
import {RegionType} from '../../shared/entities/region-type';

@Injectable() // non-singleton
export class DocumentAnalysisService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public getDocumentAnalysisImageProjection$(id: number): Observable<DocumentAnalysisImageProjection> {
    return this.apiRestClientService.getProjectionOf$<DocumentAnalysisImageProjection>(id, 'images', 'documentAnalysisImage');
  }

  public getRegionTypes$(): Observable<RegionType[]> {
    return this.apiRestClientService.getListExcerptProjection$<RegionType>('regionTypes');
  }

}
