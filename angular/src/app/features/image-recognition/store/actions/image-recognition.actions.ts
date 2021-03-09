import { Action } from '@ngrx/store';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {ImageOverview} from "../../../../core/model/restapi/image-overview";
import {Page} from "../../../../core/model/entities/page";
import {PartLinking} from "../../../../core/model/restapi/part-linking";
import {PagesRegionsSymbolsAndNewPart} from "../../../../core/model/restapi/pages-regions-symbols-and-new-part";
import {Part} from "../../../../core/model/entities/part";
import {ImageRecognitionProgressStatusChange} from "../../../../core/model/restapi/image-recognition-progress-status-change";
import {ImageRecognitionProgressStatus} from "../../../../core/model/entities/image-recognition-progress-status";
import {Region} from "../../../../core/model/entities/region";
import {RegionType} from "../../../../core/model/entities/region-type";
import {ChangedRegionTypes} from "../../../../core/model/restapi/changed-region-types";
import {BoundingBox} from "../../../../core/model/entities/bounding-box";
import {NumberArray} from "../../../../core/model/restapi/number-array";

/**
 * We use the same actions for overview, parts, document analysis ... because they share the state
 */
export enum ImageRecognitionActionTypes {
  ImageRecognitionServerError = '[ImageRecognition] Server error',

  ImageRecognitionGetImageOverview = '[ImageRecognition] Get image overview',
  ImageRecognitionGetImageOverviewSuccess = '[ImageRecognition] Get image overview success',
  ImageRecognitionGetPagesRegionsSymbols = '[ImageRecognition] Get pages, regions, symbols',
  ImageRecognitionGetPagesRegionsSymbolsSuccess = '[ImageRecognition] Get pages, regions, symbols success',
  ImageRecognitionPutComments = '[ImageRecognition] Put comments',
  ImageRecognitionPutCommentsSuccess = '[ImageRecognition] Put comments success',
  ImageRecognitionChangeStatus = '[ImageRecognition] Change status',
  ImageRecognitionChangeStatusSuccess = '[ImageRecognition] Change status success',

  ImageRecognitionLinkPart = '[ImageRecognition - Parts] Link part',
  ImageRecognitionLinkPartSuccess = '[ImageRecognition - Parts] Link part success',
  ImageRecognitionLinkNewPart = '[ImageRecognition - Parts] Link new part',
  ImageRecognitionLinkNewPartSuccess = '[ImageRecognition - Parts] Link new part success',
  ImageRecognitionUnlinkPart = '[ImageRecognition - Parts] Unlink part',
  ImageRecognitionUnlinkPartSuccess = '[ImageRecognition - Parts] Unlink part success',

  ImageRecognitionLinkImageToPart = '[ImageRecognition - Parts] Link part to image',
  ImageRecognitionLinkImageToPartSuccess = '[ImageRecognition - Parts] Link part to image success',
  ImageRecognitionLinkImageToNewPart = '[ImageRecognition - Parts] Link new part to image',
  ImageRecognitionLinkImageToNewPartSuccess = '[ImageRecognition - Parts] Link new part to image success',
  ImageRecognitionUnlinkImageFromPart = '[ImageRecognition - Parts] Unlink part from image',
  ImageRecognitionUnlinkImageFromPartSuccess = '[ImageRecognition - Parts] Unlink part from image success',

  ImageRecognitionGetRegionTypes = '[Image recognition. Document Analysis] Get region types',
  ImageRecognitionGetRegionTypesSuccess = '[Image recognition. Document Analysis] Get region types success',
  ImageRecognitionChangeRegionsType = '[Image Recognition. Document Analysis] Change regions type',
  ImageRecognitionChangeRegionsTypeSuccess = '[Image Recognition. Document Analysis] Change regions type success',
  ImageRecognitionChangeRegionBoundingBox = '[Image Recognition. Document Analysis] Change region bounding box',
  ImageRecognitionChangeRegionBoundingBoxSuccess = '[Image Recognition. Document Analysis] Change region bounding box success',
  ImageRecognitionChangePageBoundingBox = '[Image Recognition. Document Analysis] Change page bounding box',
  ImageRecognitionChangePageBoundingBoxSuccess = '[Image Recognition. Document Analysis] Change page bounding box success',
  ImageRecognitionCreatePage = '[Image Recognition. Document Analysis] Create page',
  ImageRecognitionCreatePageSuccess = '[Image Recognition. Document Analysis] Create page success',
  ImageRecognitionCreatePages = '[Image Recognition. Document Analysis] Create pages',
  ImageRecognitionCreatePagesSuccess = '[Image Recognition. Document Analysis] Create pages success',
  ImageRecognitionCreateRegion = '[Image Recognition. Document Analysis] Create region',
  ImageRecognitionCreateRegionSuccess = '[Image Recognition. Document Analysis] Create region success',
  ImageRecognitionClear = '[Image Recognition. Document Analysis] Clear',
  ImageRecognitionClearSuccess = '[Image Recognition. Document Analysis] Clear success',
  ImageRecognitionDeletePages = '[Image Recognition. Document Analysis] Delete page',
  ImageRecognitionDeletePagesSuccess = '[Image Recognition. Document Analysis] Delete page success',
  ImageRecognitionDeleteRegions = '[Image Recognition. Document Analysis] Delete region',
  ImageRecognitionDeleteRegionsSuccess = '[Image Recognition. Document Analysis] Delete region success',



}

export class ImageRecognitionGetImageOverview implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetImageOverview;
  constructor(public imageID: number) {}
}

export class ImageRecognitionGetImageOverviewSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetImageOverviewSuccess;
  constructor(public imageOverview: ImageOverview) {}
}


export class ImageRecognitionServerError implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionServerError;
  constructor(public serverError: APIRestServerError) {}
}

export class ImageRecognitionGetPagesRegionsSymbolsSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetPagesRegionsSymbolsSuccess;
  constructor(public pagesRegionsSymbols: Page[]) {}
}

export class ImageRecognitionGetPagesRegionsSymbols implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetPagesRegionsSymbols;
  constructor(public imageID: number) {}
}

export class ImageRecognitionPutComments implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionPutComments;
  constructor(public imageID: number, public comments: string) {}
}

export class ImageRecognitionPutCommentsSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionPutCommentsSuccess;
  constructor(public comments: string) {}
}


export class ImageRecognitionChangeStatus implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeStatus;
  constructor(public imageRecognitionProgressStatusChange: ImageRecognitionProgressStatusChange) {}
}

export class ImageRecognitionChangeStatusSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeStatusSuccess;
  constructor(public statuses: ImageRecognitionProgressStatus[]) {}
}


// ------ Parts ----


export class ImageRecognitionLinkPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkPart;
  constructor(public payload: PartLinking) {}
}

export class ImageRecognitionLinkPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkPartSuccess;
  constructor(public pagesRegionsSymbols: Page[]) {}
}

export class ImageRecognitionLinkNewPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkNewPart;
  constructor(public payload: PartLinking) {}
}

export class ImageRecognitionLinkNewPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkNewPartSuccess;
  constructor(public pagesRegionsSymbolsAndNewPart: PagesRegionsSymbolsAndNewPart) {}
}


export class ImageRecognitionUnlinkPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionUnlinkPart;
  constructor(public payload: PartLinking) {}
}

export class ImageRecognitionUnlinkPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionUnlinkPartSuccess;
  constructor(public pagesRegionsSymbols: Page[]) {}
}


export class ImageRecognitionLinkImageToPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkImageToPart;
  constructor(public imageID: number, public partID: number) {}
}

export class ImageRecognitionLinkImageToPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkImageToPartSuccess;
  constructor(public part: Part) {}
}

export class ImageRecognitionLinkImageToNewPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkImageToNewPart;
  constructor(public imageID: number, public partName: string) {}
}

export class ImageRecognitionLinkImageToNewPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkImageToNewPartSuccess;
  constructor(public part: Part) {}
}

export class ImageRecognitionUnlinkImageFromPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionUnlinkImageFromPart;
  constructor(public imageID: number) {}
}

export class ImageRecognitionUnlinkImageFromPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionUnlinkImageFromPartSuccess;
  constructor() {}
}

// ----- Document analysis

export class ImageRecognitionGetRegionTypes implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetRegionTypes;
  constructor() {
  }
}

export class ImageRecognitionGetRegionTypesSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetRegionTypesSuccess;
  constructor(public regionTypes: RegionType[]) {}
}

export class ImageRecognitionChangeRegionsType implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeRegionsType;
  constructor(public regions: Region[], public regionType: RegionType) {}
}

export class ImageRecognitionChangeRegionsTypeSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeRegionsTypeSuccess;
  constructor(public changeRegionTypes: ChangedRegionTypes) {}
}

export class ImageRecognitionChangeRegionBoundingBox implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeRegionBoundingBox;
  constructor(public region: Region, public boundingBox: BoundingBox) {}
}

export class ImageRecognitionChangeRegionBoundingBoxSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeRegionBoundingBoxSuccess;
  constructor(public region: Region) {}
}

export class ImageRecognitionChangePageBoundingBox implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangePageBoundingBox;
  constructor(public page: Page, public boundingBox: BoundingBox) {}
}

export class ImageRecognitionChangePageBoundingBoxSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangePageBoundingBoxSuccess;
  constructor(public page: Page) {}
}

export class ImageRecognitionCreatePage implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreatePage;
  constructor(public imageID: number, public boundingBox: BoundingBox) {}
}

export class ImageRecognitionCreatePageSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreatePageSuccess;
  constructor(public pages: Page[]) {} // it returns several pagesWithRegions because some regions may have changed its page
}

export class ImageRecognitionCreatePages implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreatePages;
  constructor(public imageID: number, public numPages: number) {}
}

export class ImageRecognitionCreatePagesSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreatePagesSuccess;
  constructor(public pages: Page[]) {} // new pagesWithRegions
}

export class ImageRecognitionCreateRegion implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreateRegion;
  constructor(public imageID: number, public regionType: RegionType, public boundingBox: BoundingBox) {}
}

export class ImageRecognitionCreateRegionSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreateRegionSuccess;
  constructor(public pages: Page[]) {} // it returns several pagesWithRegions because we don't a priori in which page the region has been created
}

export class ImageRecognitionDeletePages implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionDeletePages;
  constructor(public pages: Page[]) {}
}

export class ImageRecognitionDeletePagesSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionDeletePagesSuccess;
  constructor(public deletedPageIDs: NumberArray) {}
}

export class ImageRecognitionDeleteRegions implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionDeleteRegions;
  constructor(public regions: Region[]) {}
}

export class ImageRecognitionDeleteRegionsSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionDeleteRegionsSuccess;
  constructor(public deletedRegionIDs: NumberArray) {}
}

export class ImageRecognitionClear implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionClear;
  constructor(public imageID: number) {}
}

export class ImageRecognitionClearSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionClearSuccess;
  constructor() {}
}


export type ImageRecognitionActions =
  ImageRecognitionServerError |
  ImageRecognitionGetImageOverview | ImageRecognitionGetImageOverviewSuccess |
  ImageRecognitionGetPagesRegionsSymbols | ImageRecognitionGetPagesRegionsSymbolsSuccess |
  ImageRecognitionPutComments | ImageRecognitionPutCommentsSuccess |
  ImageRecognitionChangeStatus | ImageRecognitionChangeStatusSuccess |

  // parts
  ImageRecognitionLinkPart | ImageRecognitionLinkPartSuccess |
  ImageRecognitionLinkNewPart | ImageRecognitionLinkNewPartSuccess |
  ImageRecognitionUnlinkPart | ImageRecognitionUnlinkPartSuccess |
  ImageRecognitionLinkImageToPart | ImageRecognitionLinkImageToPartSuccess |
  ImageRecognitionLinkImageToNewPart | ImageRecognitionLinkImageToNewPartSuccess |
  ImageRecognitionUnlinkImageFromPart | ImageRecognitionUnlinkImageFromPartSuccess |

  // document analysis
  ImageRecognitionGetRegionTypes | ImageRecognitionGetRegionTypesSuccess |
  ImageRecognitionChangeRegionsType | ImageRecognitionChangeRegionsTypeSuccess |
  ImageRecognitionChangeRegionBoundingBox | ImageRecognitionChangeRegionBoundingBoxSuccess |
  ImageRecognitionChangePageBoundingBox | ImageRecognitionChangePageBoundingBoxSuccess |
  ImageRecognitionCreatePage | ImageRecognitionCreatePageSuccess |
  ImageRecognitionCreatePages | ImageRecognitionCreatePagesSuccess |
  ImageRecognitionCreateRegion | ImageRecognitionCreateRegionSuccess |
  ImageRecognitionClear | ImageRecognitionClearSuccess |
  ImageRecognitionDeletePages | ImageRecognitionDeletePagesSuccess |
  ImageRecognitionDeleteRegions | ImageRecognitionDeleteRegionsSuccess
  ;
