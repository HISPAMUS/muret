import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Observable} from 'rxjs';
import {DocumentAnalysisImageProjection} from '../../../core/model/restapi/document-analysis-image-projection';
import {RegionType} from '../../../core/model/entities/region-type';
import {Page} from '../../../core/model/entities/page';
import {Region} from '../../../core/model/entities/region';
import {BoundingBox} from '../../../core/model/entities/bounding-box';

@Injectable() // non-singleton
export class DocumentAnalysisService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public getDocumentAnalysisImageProjection$(id: number): Observable<DocumentAnalysisImageProjection> {
    return this.apiRestClientService.getProjectionOf$<DocumentAnalysisImageProjection>(id, 'images', 'documentAnalysisImage');
  }

  public getRegionTypes$(): Observable<RegionType[]> {
    return this.apiRestClientService.getListExcerptProjection$<RegionType>('regionTypes');
  }

  public updatePageBoundingBox(page: Page, fromX: number, fromY: number, toX: number, toY: number): Observable<Page> {
    const boundingBox: BoundingBox = {
        id: page.id,
        fromX,
        fromY,
        toX,
        toY
    };
    return this.apiRestClientService.put$<Page>('documentanalysis/pageBoundingBoxUpdate', boundingBox);
  }

  public updateRegionBoundingBox(region: Region, fromX: number, fromY: number, toX: number, toY: number): Observable<Region> {
    const boundingBox: BoundingBox = {
      id: region.id,
      fromX,
      fromY,
      toX,
      toY
    };

    const newRegion: Region = {
      id: region.id,
      boundingBox,
      regionType: region.regionType
    };

    return this.apiRestClientService.put$<Region>('documentanalysis/regionUpdate', newRegion);
  }

  updateRegionType(region: Region, regionType: RegionType) {
    const newRegion: Region = {
      id: region.id,
      regionType
    };

    return this.apiRestClientService.put$<Region>('documentanalysis/regionUpdate', newRegion);
  }

  createPage(imageID: number, fromX: number, fromY: number, toX: number, toY: number): Observable<Page[]> {
    const boundingBox: BoundingBox = {
      fromX,
      fromY,
      toX,
      toY
    };

    const page = {
      imageID,
      boundingBox
    };

    return this.apiRestClientService.put$<Page[]>('documentanalysis/createPage', page);
  }

  createRegion(imageID: number, regionType: RegionType, fromX: number, fromY: number, toX: number, toY: number): Observable<Page[]> {
    const boundingBox: BoundingBox = {
      fromX,
      fromY,
      toX,
      toY
    };

    const region = {
      imageID,
      regionTypeID: regionType.id,
      boundingBox
    };

    return this.apiRestClientService.put$<Page[]>('documentanalysis/createRegion', region);
  }

  clear(imageID: number) {
    return this.apiRestClientService.delete$<Page[]>('documentanalysis/clear', imageID);
  }

  deletePage(pageID: number) {
    return this.apiRestClientService.delete$<number>('documentanalysis/deletePage', pageID);
  }

  deleteRegion(regionID: number) {
    return this.apiRestClientService.delete$<number>('documentanalysis/deleteRegion', regionID);
  }

}
