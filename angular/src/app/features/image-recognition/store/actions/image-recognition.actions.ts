import { Action } from '@ngrx/store';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {ImageOverview} from "../../model/image-overview";

export enum ImageRecognitionActionTypes {
  ImageRecognitionGetImageOverview = '[ImageRecognition] Get image overview',
  ImageRecognitionGetImageOverviewSuccess = '[ImageRecognition] Get image overview success',
  ImageRecognitionServerError = '[ImageRecognition] Server error',
}

export class ImageRecognitionGetImageOverview implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetImageOverview;
  constructor(public documentID: number) {}
}

export class ImageRecognitionGetImageOverviewSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetImageOverviewSuccess;
  constructor(public imageOverview: ImageOverview) {}
}

export class ImageRecognitionServerError implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionServerError;
  constructor(public serverError: APIRestServerError) {}
}

export type ImageRecognitionActions =
  ImageRecognitionServerError |
  ImageRecognitionGetImageOverview | ImageRecognitionGetImageOverviewSuccess ;
