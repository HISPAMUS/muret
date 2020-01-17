import { Action } from '@ngrx/store';
import {Collection} from '../../../../core/model/entities/collection';

export enum DocumentsActionTypes {
  GetCollection = '[Documents] Get collection',
  GetCollectionSuccess = '[Documents] Get collection success',
}

export class GetCollection implements Action {
  public readonly type = DocumentsActionTypes.GetCollection;
  constructor(public collectionID: number) {}
}

export class GetCollectionSuccess implements Action {
  public readonly type = DocumentsActionTypes.GetCollectionSuccess;
  constructor(public collection: Collection) {}
}


export type DocumentsActions =
  GetCollection | GetCollectionSuccess;
