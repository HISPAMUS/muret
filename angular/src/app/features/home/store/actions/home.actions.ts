import { Action } from '@ngrx/store';
import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {LastDocumentExtract} from "../../model/last-document-extract";

export enum HomeActionTypes {
  GetLastDocuments = '[Home] Get last documents',
  GetLastDocumentsSuccess = '[Home] Get last documents success',
  UpdateLastDocuments = '[Home] Update last documents',
  UpdateLastDocumentsSuccess = '[Home] Update last documents succcess',
  HomeServerError = '[Home] Server error',
}

export class GetLastDocuments implements Action {
  public readonly type = HomeActionTypes.GetLastDocuments;
  constructor(public userID: number, public count: number) {}
}

export class GetLastDocumentsSuccess implements Action {
  public readonly type = HomeActionTypes.GetLastDocumentsSuccess;
  constructor(public lastDocuments: LastDocumentExtract[]) {}
}


export class UpdateLastDocuments implements Action {
  public readonly type = HomeActionTypes.UpdateLastDocuments;
  constructor(public userID: number, public documentID: number) {}
}

export class UpdateLastDocumentsSuccess implements Action {
  public readonly type = HomeActionTypes.UpdateLastDocumentsSuccess;
  constructor(public lastDocument: LastDocumentExtract) {}
}

export class HomeServerError implements Action {
  public readonly type = HomeActionTypes.HomeServerError;
  constructor(public serverError: APIRestServerError) {}
}

export type HomeActions =
  HomeServerError |
  GetLastDocuments | GetLastDocumentsSuccess |
  UpdateLastDocuments | UpdateLastDocumentsSuccess;
