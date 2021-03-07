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
  ImageRecognitionChangeRegionsType | ImageRecognitionChangeRegionsTypeSuccess
  ;

