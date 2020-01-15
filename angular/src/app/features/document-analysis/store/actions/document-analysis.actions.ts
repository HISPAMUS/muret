import {Action} from '@ngrx/store';
import {DocumentAnalysisImageProjection} from '../../../../core/model/restapi/document-analysis-image-projection';
import {RegionType} from '../../../../core/model/entities/region-type';
import {Region} from '../../../../core/model/entities/region';
import {Page} from '../../../../core/model/entities/page';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {Part} from '../../../../core/model/entities/part';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';

export enum DocumentAnalysisActionTypes {
  GetImageProjection = '[DocumentAnalysis] Get image projection',
  GetImageProjectionSuccess = '[DocumentAnalysis] Get image projection success',
  GetImageURL = '[DocumentAnalysis] Get image URL',
  GetImageURLSuccess = '[DocumentAnalysis] Get image URL success',
  GetRegionTypes = '[DocumentAnalysis] Get region types',
  GetRegionTypesSuccess = '[DocumentAnalysis] Get region types success',

  GetImagePart = '[DocumentAnalysis] Get image part',
  GetImagePartSuccess = '[DocumentAnalysis] Get image part success',

  // SelectPage = '[DocumentAnalysis] Select page',

  // SelectRegion = '[DocumentAnalysis] Select region',

  ChangeRegionType = '[DocumentAnalysis] Change region type',
  ChangeRegionTypeSuccess = '[DocumentAnalysis] Change region type success',

  ChangePageBoundingBox = '[DocumentAnalysis] Change page bounding box',
  ChangePageBoundingBoxSuccess = '[DocumentAnalysis] Change page bounding box success',

  ChangeRegionBoundingBox = '[DocumentAnalysis] Change region bounding box',
  ChangeRegionBoundingBoxSuccess = '[DocumentAnalysis] Change region bounding box success',

  CreatePage = '[DocumentAnalysis] Create page',
  CreatePageSuccess = '[DocumentAnalysis] Create page success',

  CreateRegion = '[DocumentAnalysis] Create region',
  CreateRegionSuccess = '[DocumentAnalysis] Create region success',

  Clear = '[DocumentAnalysis] Clear',
  ClearSuccess = '[DocumentAnalysis] Clear success',

  DeletePage = '[DocumentAnalysis] Delete page',
  DeletePageSuccess = '[DocumentAnalysis] Delete page success',

  DeleteRegion = '[DocumentAnalysis] Delete region',
  DeleteRegionSuccess = '[DocumentAnalysis] Delete region success',

  GetDocumentAnModels = '[DocumentAnalysis] Get Models',
  GetDocumentAnModelsSuccess = '[DocumentAnalysis] Get Models Success'
}

export class GetImageProjection implements Action {
  public readonly type = DocumentAnalysisActionTypes.GetImageProjection;
  constructor(public imageID: number) {}
}

export class GetImageProjectionSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.GetImageProjectionSuccess;
  constructor(public documentAnalysisImageProjection: DocumentAnalysisImageProjection) {}
}

export class GetImagePart implements Action {
  public readonly type = DocumentAnalysisActionTypes.GetImagePart;
  constructor(public imageID: number) {}
}

export class GetImagePartSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.GetImagePartSuccess;
  constructor(public part: Part) {}
}

export class GetImageURL implements Action {
  public readonly type = DocumentAnalysisActionTypes.GetImageURL;
  constructor(public imageID: number) {}
}

export class GetImageURLSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.GetImageURLSuccess;
  constructor(public url: string) {}
}

export class GetRegionTypes implements Action {
  public readonly type = DocumentAnalysisActionTypes.GetRegionTypes;
}

export class GetRegionTypesSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.GetRegionTypesSuccess;
  constructor(public regionTypes: RegionType[]) {}
}


export class ChangeRegionType implements Action {
  public readonly type = DocumentAnalysisActionTypes.ChangeRegionType;
  constructor(public region: Region, public regionType: RegionType) {}
}

export class ChangeRegionTypeSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.ChangeRegionTypeSuccess;
  constructor(public region: Region) {}
}


export class ChangePageBoundingBox implements Action {
  public readonly type = DocumentAnalysisActionTypes.ChangePageBoundingBox;
  constructor(public page: Page, public boundingBox: BoundingBox) {}
}

export class ChangePageBoundingBoxSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.ChangePageBoundingBoxSuccess;
  constructor(public page: Page) {}
}

export class ChangeRegionBoundingBox implements Action {
  public readonly type = DocumentAnalysisActionTypes.ChangeRegionBoundingBox;
  constructor(public region: Region, public boundingBox: BoundingBox) {}
}

export class ChangeRegionBoundingBoxSuccess implements ChangeRegionBoundingBoxSuccess {
  public readonly type = DocumentAnalysisActionTypes.ChangeRegionBoundingBoxSuccess;
  constructor(public region: Region) {}
}


export class Clear implements Action {
  public readonly type = DocumentAnalysisActionTypes.Clear;
  constructor(public imageID: number) {}
}

export class ClearSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.ClearSuccess;
  constructor(public pages: Page[]) {}
}

export class CreatePage implements Action {
  public readonly type = DocumentAnalysisActionTypes.CreatePage;
  constructor(public imageID: number, public boundingBox: BoundingBox) {}
}

export class CreatePageSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.CreatePageSuccess;
  constructor(public pages: Page[]) {} // it returns several pages because some regions may have changed its page
}

export class CreateRegion implements Action {
  public readonly type = DocumentAnalysisActionTypes.CreateRegion;
  constructor(public imageID: number, public regionType: RegionType, public boundingBox: BoundingBox) {}
}

export class CreateRegionSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.CreateRegionSuccess;
  constructor(public pages: Page[]) {} // it returns several pages because we don't a priori in which page the region has been created
}



export class DeletePage implements Action {
  public readonly type = DocumentAnalysisActionTypes.DeletePage;
  constructor(public pageID: number) {}
}

export class DeletePageSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.DeletePageSuccess;
  constructor(public deletedPageID: number) {}
}

export class DeleteRegion implements Action {
  public readonly type = DocumentAnalysisActionTypes.DeleteRegion;
  constructor(public regionID: number) {}
}

export class DeleteRegionSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.DeleteRegionSuccess;
  constructor(public deletedRegionID: number) {}
}

export class GetDocumentAnModels implements Action{
  public readonly type = DocumentAnalysisActionTypes.GetDocumentAnModels;
  constructor(public imageID: number){}
}

export class GetDocumentAnModelsSuccess implements Action{
  public readonly type = DocumentAnalysisActionTypes.GetDocumentAnModelsSuccess;
  constructor(public response: ClassifierModel[]){}
}

/*export class SelectPage implements Action {
  public readonly type = DocumentAnalysisActionTypes.SelectPage;
  constructor(public page: Page) {}
}

export class SelectRegion implements Action {
  public readonly type = DocumentAnalysisActionTypes.SelectRegion;
  constructor(public region: Region) {}
}*/



export type DocumentAnalysisActions =
  GetImageProjection | GetImageProjectionSuccess |
  GetImagePart | GetImagePartSuccess |
  GetRegionTypes | GetRegionTypesSuccess |
  GetImageURL | GetImageURLSuccess |
 // SelectPage | SelectRegion |
  ChangeRegionType | ChangeRegionTypeSuccess |
  ChangePageBoundingBox | ChangePageBoundingBoxSuccess |
  ChangeRegionBoundingBox | ChangeRegionBoundingBoxSuccess |
  CreatePage | CreatePageSuccess |
  CreateRegion | CreateRegionSuccess |
  Clear | ClearSuccess |
  DeletePage | DeletePageSuccess |
  DeleteRegion | DeleteRegionSuccess |
  GetDocumentAnModels | GetDocumentAnModelsSuccess;
