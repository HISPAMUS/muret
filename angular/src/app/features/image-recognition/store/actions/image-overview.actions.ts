import { Action } from '@ngrx/store';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {ImageOverview} from "../../../../core/model/restapi/image-overview";
import {Page} from "../../../../core/model/entities/page";
import {PartLinking} from "../../../../core/model/restapi/part-linking";
import {PagesRegionsSymbolsAndNewPart} from "../../../../core/model/restapi/pages-regions-symbols-and-new-part";

/**
 * We use the same actions for overview and parts because they share the state
 */
export enum ImageOverviewActionTypes {
  ImageRecognitionServerError = '[ImageRecognition] Server error',

  ImageRecognitionGetImageOverview = '[ImageRecognition] Get image overview',
  ImageRecognitionGetImageOverviewSuccess = '[ImageRecognition] Get image overview success',
  ImageRecognitionGetPagesRegionsSymbols = '[ImageRecognition] Get pages, regions, symbols',
  ImageRecognitionGetPagesRegionsSymbolsSuccess = '[ImageRecognition] Get pages, regions, symbols success',
  ImageRecognitionPutComments = '[ImageRecognition] Put comments',
  ImageRecognitionPutCommentsSuccess = '[ImageRecognition] Put comments success',

  ImageRecognitionLinkPart = '[ImageRecognition - Parts] Link part',
  ImageRecognitionLinkPartSuccess = '[ImageRecognition - Parts] Link part success',
  ImageRecognitionLinkNewPart = '[ImageRecognition - Parts] Link new part',
  ImageRecognitionLinkNewPartSuccess = '[ImageRecognition - Parts] Link new part success',
  ImageRecognitionUnlinkPart = '[ImageRecognition - Parts] Unlink part',
  ImageRecognitionUnlinkPartSuccess = '[ImageRecognition - Parts] Unlink part success',

}

export class ImageRecognitionGetImageOverview implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionGetImageOverview;
  constructor(public imageID: number) {}
}

export class ImageRecognitionGetImageOverviewSuccess implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionGetImageOverviewSuccess;
  constructor(public imageOverview: ImageOverview) {}
}


export class ImageRecognitionServerError implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionServerError;
  constructor(public serverError: APIRestServerError) {}
}

export class ImageRecognitionGetPagesRegionsSymbolsSuccess implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionGetPagesRegionsSymbolsSuccess;
  constructor(public pagesRegionsSymbols: Page[]) {}
}

export class ImageRecognitionGetPagesRegionsSymbols implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionGetPagesRegionsSymbols;
  constructor(public imageID: number) {}
}

export class ImageRecognitionPutComments implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionPutComments;
  constructor(public imageID: number, public comments: string) {}
}

export class ImageRecognitionPutCommentsSuccess implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionPutCommentsSuccess;
  constructor(public comments: string) {}
}

// ------ Parts ----


export class ImageRecognitionLinkPart implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionLinkPart;
  constructor(public payload: PartLinking) {}
}

export class ImageRecognitionLinkPartSuccess implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionLinkPartSuccess;
  constructor(public pagesRegionsSymbols: Page[]) {}
}

export class ImageRecognitionLinkNewPart implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionLinkNewPart;
  constructor(public payload: PartLinking) {}
}

export class ImageRecognitionLinkNewPartSuccess implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionLinkNewPartSuccess;
  constructor(public pagesRegionsSymbolsAndNewPart: PagesRegionsSymbolsAndNewPart) {}
}


export class ImageRecognitionUnlinkPart implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionUnlinkPart;
  constructor(public payload: PartLinking) {}
}

export class ImageRecognitionUnlinkPartSuccess implements Action {
  public readonly type = ImageOverviewActionTypes.ImageRecognitionUnlinkPartSuccess;
  constructor(public pagesRegionsSymbols: Page[]) {}
}

export type ImageOverviewActions =
  ImageRecognitionServerError |
  ImageRecognitionGetImageOverview | ImageRecognitionGetImageOverviewSuccess |
  ImageRecognitionGetPagesRegionsSymbols | ImageRecognitionGetPagesRegionsSymbolsSuccess |
  ImageRecognitionPutComments | ImageRecognitionPutCommentsSuccess |

  // parts
  ImageRecognitionLinkPart | ImageRecognitionLinkPartSuccess |
  ImageRecognitionLinkNewPart | ImageRecognitionLinkNewPartSuccess |
  ImageRecognitionUnlinkPart | ImageRecognitionUnlinkPartSuccess
  ;

