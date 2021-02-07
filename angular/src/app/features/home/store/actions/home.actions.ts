import { Action } from '@ngrx/store';
import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {LastDocumentExtract} from "../../model/last-document-extract";

export enum HomeActionTypes {
  HomeGetLastDocuments = '[Home] Get last documents',
  HomeGetLastDocumentsSuccess = '[Home] Get last documents success',
  HomeUpdateLastDocuments = '[Home] Update last documents',
  HomeUpdateLastDocumentsSuccess = '[Home] Update last documents succcess',
  HomeServerError = '[Home] Server error',
}

export class HomeGetLastDocuments implements Action {
  public readonly type = HomeActionTypes.HomeGetLastDocuments;
  constructor(public userID: number, public count: number) {}
}

export class HomeGetLastDocumentsSuccess implements Action {
  public readonly type = HomeActionTypes.HomeGetLastDocumentsSuccess;
  constructor(public lastDocuments: LastDocumentExtract[]) {}
}


export class HomeUpdateLastDocuments implements Action {
  public readonly type = HomeActionTypes.HomeUpdateLastDocuments;
  constructor(public userID: number, public documentID: number) {}
}

export class HomeUpdateLastDocumentsSuccess implements Action {
  public readonly type = HomeActionTypes.HomeUpdateLastDocumentsSuccess;
  constructor(public lastDocument: LastDocumentExtract) {}
}

export class HomeServerError implements Action {
  public readonly type = HomeActionTypes.HomeServerError;
  constructor(public serverError: APIRestServerError) {}
}

export type HomeActions =
  HomeServerError |
  HomeGetLastDocuments | HomeGetLastDocumentsSuccess |
  HomeUpdateLastDocuments | HomeUpdateLastDocumentsSuccess;
