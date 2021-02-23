import {Action} from '@ngrx/store';
import {DocumentAnalysisImageProjection} from '../../../../core/model/restapi/document-analysis-image-projection';
import {RegionType} from '../../../../core/model/entities/region-type';
import {Region} from '../../../../core/model/entities/region';
import {Page} from '../../../../core/model/entities/page';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {Part} from '../../../../core/model/entities/part';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';
// import { DocumentAnalysisForm } from '../../model/document-analysis-form'
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export enum DocumentAnalysisActionTypes {
  DocumentAnalysisServerError = '[Image recognition. Document Analysis] Server error',
  DocumentAnalysisGetRegionTypes = '[Image recognition. Document Analysis] Get region types',
  DocumentAnalysisGetRegionTypesSuccess = '[Image recognition. Document Analysis] Get region types success',

  // revisado hasta aquí
  ResetDocumentAnalysisServerError = '[Image Recognition. Document Analysis] Reset Server error',
  GetImageURL = '[Image Recognition. Document Analysis] Get image URL',
  GetImageURLSuccess = '[Image Recognition. Document Analysis] Get image URL success',

  GetImagePart = '[Image Recognition. Document Analysis] Get image part',
  GetImagePartSuccess = '[Image Recognition. Document Analysis] Get image part success',

  // SelectPage = '[Image Recognition. Document Analysis] Select page',

  // SelectRegion = '[Image Recognition. Document Analysis] Select region',

  ChangeRegionType = '[Image Recognition. Document Analysis] Change region type',
  ChangeRegionTypeSuccess = '[Image Recognition. Document Analysis] Change region type success',

  ChangePageBoundingBox = '[Image Recognition. Document Analysis] Change page bounding box',
  ChangePageBoundingBoxSuccess = '[Image Recognition. Document Analysis] Change page bounding box success',

  ChangeRegionBoundingBox = '[Image Recognition. Document Analysis] Change region bounding box',
  ChangeRegionBoundingBoxSuccess = '[Image Recognition. Document Analysis] Change region bounding box success',

  CreatePage = '[Image Recognition. Document Analysis] Create page',
  CreatePageSuccess = '[Image Recognition. Document Analysis] Create page success',

  CreatePages = '[Image Recognition. Document Analysis] Create pages',
  CreatePagesSuccess = '[Image Recognition. Document Analysis] Create pages success',

  CreateRegion = '[Image Recognition. Document Analysis] Create region',
  CreateRegionSuccess = '[Image Recognition. Document Analysis] Create region success',

  Clear = '[Image Recognition. Document Analysis] Clear',
  ClearSuccess = '[Image Recognition. Document Analysis] Clear success',

  DeletePage = '[Image Recognition. Document Analysis] Delete page',
  DeletePageSuccess = '[Image Recognition. Document Analysis] Delete page success',

  DeleteRegion = '[Image Recognition. Document Analysis] Delete region',
  DeleteRegionSuccess = '[Image Recognition. Document Analysis] Delete region success',

  GetDocumentAnModels = '[Image Recognition. Document Analysis] Get Models',
  GetDocumentAnModelsSuccess = '[Image Recognition. Document Analysis] Get Models Success',

  AutomaticDocumentAnalysis = '[Image Recognition. Document Analysis] Start automatic analysis',
  AutomaticDocumentAnalysisSuccess = '[Image Recognition. Document Analysis] Automatic analysis success',

  DocumentClearAll = '[Image Recognition. Document Analysis] Clear all the document',
  DocumentClearAllSucess = '[Image Recognition. Document Analysis] Clear all the document successful',
  ResetWipeOut = '[Image Recognition. Document Analysis] Reset wipeout flag'
}


export class DocumentAnalysisServerError implements Action {
  public readonly type = DocumentAnalysisActionTypes.DocumentAnalysisServerError;
  constructor(public serverError: APIRestServerError) {}
}


export class DocumentAnalysisGetRegionTypes implements Action {
  public readonly type = DocumentAnalysisActionTypes.DocumentAnalysisGetRegionTypes;
  constructor() {
  }
}

export class DocumentAnalysisGetRegionTypesSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.DocumentAnalysisGetRegionTypesSuccess;
  constructor(public regionTypes: RegionType[]) {}
}



// revisado hasta aquí
export class ResetDocumentAnalysisServerError implements Action {
  public readonly type = DocumentAnalysisActionTypes.ResetDocumentAnalysisServerError;
  constructor() {}
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
  constructor() {}
}

export class CreatePage implements Action {
  public readonly type = DocumentAnalysisActionTypes.CreatePage;
  constructor(public imageID: number, public boundingBox: BoundingBox) {}
}

export class CreatePageSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.CreatePageSuccess;
  constructor(public pages: Page[]) {} // it returns several pagesWithRegions because some regions may have changed its page
}

export class CreatePages implements Action {
  public readonly type = DocumentAnalysisActionTypes.CreatePages;
  constructor(public imageID: number, public numPages: number) {}
}

export class CreatePagesSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.CreatePagesSuccess;
  constructor(public pages: Page[]) {} // new pagesWithRegions
}

export class CreateRegion implements Action {
  public readonly type = DocumentAnalysisActionTypes.CreateRegion;
  constructor(public imageID: number, public regionType: RegionType, public boundingBox: BoundingBox) {}
}

export class CreateRegionSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.CreateRegionSuccess;
  constructor(public pages: Page[]) {} // it returns several pagesWithRegions because we don't a priori in which page the region has been created
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

export class GetDocumentAnModels implements Action {
  public readonly type = DocumentAnalysisActionTypes.GetDocumentAnModels;
  constructor(public imageID: number) {}
}

export class GetDocumentAnModelsSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.GetDocumentAnModelsSuccess;
  constructor(public response: ClassifierModel[]) {}
}

/*export class AutomaticDocumentAnalysis implements Action {
  public readonly type = DocumentAnalysisActionTypes.AutomaticDocumentAnalysis;
  constructor(public form: DocumentAnalysisForm) {}
}*/

export class AutomaticDocumentAnalysisSuccess implements Action {
  public readonly type = DocumentAnalysisActionTypes.AutomaticDocumentAnalysisSuccess;
  constructor(public pages: Page[]) {}
}

export class ClearAllDoc implements Action
{
  public readonly type = DocumentAnalysisActionTypes.DocumentClearAll;
  constructor(public imageID: number){}
}

export class ClearAllDocSuccess implements Action
{
  public readonly type = DocumentAnalysisActionTypes.DocumentClearAllSucess;
  constructor(){}
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
  DocumentAnalysisServerError |
  DocumentAnalysisGetRegionTypes | DocumentAnalysisGetRegionTypesSuccess |

  // revisado hasta aquí
  ResetDocumentAnalysisServerError |
  GetImagePart | GetImagePartSuccess |
  GetImageURL | GetImageURLSuccess |
 // SelectPage | SelectRegion |
  ChangeRegionType | ChangeRegionTypeSuccess |
  ChangePageBoundingBox | ChangePageBoundingBoxSuccess |
  ChangeRegionBoundingBox | ChangeRegionBoundingBoxSuccess |
  CreatePage | CreatePageSuccess |
  CreatePages | CreatePagesSuccess |
  CreateRegion | CreateRegionSuccess |
  Clear | ClearSuccess |
  DeletePage | DeletePageSuccess |
  DeleteRegion | DeleteRegionSuccess |
  GetDocumentAnModels | GetDocumentAnModelsSuccess |
  //AutomaticDocumentAnalysis | AutomaticDocumentAnalysisSuccess|
  ClearAllDoc | ClearAllDocSuccess;
