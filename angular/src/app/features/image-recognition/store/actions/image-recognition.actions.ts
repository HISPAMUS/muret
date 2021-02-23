import { Action } from '@ngrx/store';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {ImageOverview} from "../../model/image-overview";
import {Page} from "../../../../core/model/entities/page";

export enum ImageRecognitionActionTypes {
  ImageRecognitionGetImageOverview = '[ImageRecognition] Get image overview',
  ImageRecognitionGetImageOverviewSuccess = '[ImageRecognition] Get image overview success',
  ImageRecognitionGetPagesRegionsSymbols = '[ImageRecognition] Get pages, regions, symbols',
  ImageRecognitionGetPagesRegionsSymbolsSuccess = '[ImageRecognition] Get pages, regions, symbols success',

  ImageRecognitionServerError = '[ImageRecognition] Server error',
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

export class ImageRecognitionGetPagesRegionsSymbols implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetPagesRegionsSymbols;
  constructor(public imageID: number) {}
}

export class ImageRecognitionGetPagesRegionsSymbolsSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetPagesRegionsSymbolsSuccess;
  constructor(public pagesRegionsSymbols: Page[]) {}
}

export type ImageRecognitionActions =
  ImageRecognitionServerError |
  ImageRecognitionGetImageOverview | ImageRecognitionGetImageOverviewSuccess |
  ImageRecognitionGetPagesRegionsSymbols | ImageRecognitionGetPagesRegionsSymbolsSuccess;
