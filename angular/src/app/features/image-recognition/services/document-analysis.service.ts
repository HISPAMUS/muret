import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Observable} from 'rxjs';
import {DocumentAnalysisImageProjection} from '../../../core/model/restapi/document-analysis-image-projection';
import {RegionType} from '../../../core/model/entities/region-type';
import {Page} from '../../../core/model/entities/page';
import {Region} from '../../../core/model/entities/region';
import {BoundingBox} from '../../../core/model/entities/bounding-box';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';
// import { DocumentAnalysisForm } from '../model/document-analysis-form';
import { StringResponse } from 'src/app/core/model/restapi/string-response';
import {ChangedRegionTypes} from "../../../core/model/restapi/changed-region-types";
import {NumberArray} from "../../../core/model/restapi/number-array";
import {DocumentAnalysisForm} from "../../../core/model/restapi/document-analysis-form";

@Injectable() // non-singleton
export class DocumentAnalysisService {

  constructor(private apiRestClientService: ApiRestClientService) { }
  public getRegionTypes$(): Observable<RegionType[]> {
    return this.apiRestClientService.getListExcerptProjection$<RegionType>('regionTypes');
  }

  private getRegionIds(regions: Region[]): NumberArray {
    const regionIDS: NumberArray = {
      values: regions.map(region => region.id)
    };
    return regionIDS;
  }

  private getPagesIds(pages: Page[]): NumberArray {
    const pagesIDS: NumberArray = {
      values: pages.map(page => page.id)
    };
    return pagesIDS;
  }

  changeRegionsType$(regions: Region[], regionType: RegionType): Observable<ChangedRegionTypes> {
    const url = `documentanalysis/changeRegionsType/${regionType.id}`

    return this.apiRestClientService.put$<ChangedRegionTypes>(url, this.getRegionIds(regions));
  }

  public updateRegionBoundingBox$(region: Region, fromX: number, fromY: number, toX: number, toY: number): Observable<Region> {
    const boundingBox: BoundingBox = {
      id: region.id,
      fromX,
      fromY,
      toX,
      toY
    };

    const newRegion: Region = {
      id: region.id,
      boundingBox
    };

    return this.apiRestClientService.put$<Region>('documentanalysis/regionBoundingBoxUpdate', newRegion);
  }

  public updatePageBoundingBox$(page: Page, fromX: number, fromY: number, toX: number, toY: number): Observable<Page> {
    const boundingBox: BoundingBox = {
      id: page.id,
      fromX,
      fromY,
      toX,
      toY
    };
    return this.apiRestClientService.put$<Page>('documentanalysis/pageBoundingBoxUpdate', boundingBox);
  }

  createRegion$(imageID: number, regionType: RegionType, fromX: number, fromY: number, toX: number, toY: number): Observable<Page[]> {
    const boundingBox: BoundingBox = {
      fromX,
      fromY,
      toX,
      toY
    };

    const region = {
      imageID,
      regionTypeID: regionType!=null?regionType.id:null,
      boundingBox
    };

    return this.apiRestClientService.post$<Page[]>('documentanalysis/createRegion', region);
  }

  clear(imageID: number): Observable<void> {
    return this.apiRestClientService.delete$('documentanalysis/clear', imageID);
  }

  deletePages$(pages: Page[]): Observable<NumberArray> {
    return this.apiRestClientService.post$<NumberArray>('documentanalysis/deletePages', this.getPagesIds(pages));
  }

  deleteRegions$(regions: Region[]): Observable<NumberArray> {
    return this.apiRestClientService.post$<NumberArray>('documentanalysis/deleteRegions', this.getRegionIds(regions));
  }

  createPage$(imageID: number, fromX: number, fromY: number, toX: number, toY: number): Observable<Page[]> {
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

    return this.apiRestClientService.post$<Page[]>('documentanalysis/createPage', page);
  }

  createPages$(imageID: number, numPages: number): Observable<Page[]> {
    const data = {
      imageID,
      numPages
    };

    return this.apiRestClientService.post$<Page[]>('documentanalysis/createPages', data);
  }



  getModels$(imageID: number): Observable<ClassifierModel[]> {
    const url = `classifierModels/models/${imageID}`
    return this.apiRestClientService.get$<ClassifierModel[]>(url);
  }

  attemptAutomaticAnalysis$(form: DocumentAnalysisForm): Observable<Page[]> {
     const url = 'documentanalysis/docAnalyze';
     return this.apiRestClientService.post$<Page[]>(url, form);
   }

  rotateImage$(imageID: number, degrees: number) {
    const url = `imagefiles/rotateImage/${imageID}/${degrees}`;
    return this.apiRestClientService.put$(url, null);
  }


  revertRotation$(imageID: number) {
    const url = `imagefiles/revertRotation/${imageID}`;
    return this.apiRestClientService.put$(url, null);
  }
  // revisado hasta aquí


  public getDocumentAnalysisImageProjection$(id: number): Observable<DocumentAnalysisImageProjection> {
    return this.apiRestClientService.getProjectionOf$<DocumentAnalysisImageProjection>(id, 'images', 'documentAnalysisImage');
  }





  updateRegionType$(region: Region, regionType: RegionType): Observable<Region> {
    const newRegion: Region = {
      id: region.id,
      part: region.part,
      regionType
    };

    return this.apiRestClientService.put$<Region>('documentanalysis/regionUpdate', newRegion);
  }



  attemptDocumentWipeOut$(id: number): Observable<StringResponse> {
    const url = 'documentanalysis/clearImage';
    return this.apiRestClientService.delete$<StringResponse>(url, id);
  }

}
