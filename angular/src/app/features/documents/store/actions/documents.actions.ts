import { Action } from '@ngrx/store';
import {Collection} from '../../../../core/model/entities/collection';

export enum DocumentsActionTypes {
  GetCollection = '[Documents] Get collection',
  GetCollectionSuccess = '[Documents] Get collection success',
  CreateSubcollection = '[Documents] Create subcollection',
  CreateSubcollectionSuccess = '[Documents] Create subcollection success',
  DeleteSubcollection = '[Documents] Delete subcollection',
  DeleteSubcollectionSuccess = '[Documents] Delete subcollection success',
}

export class GetCollection implements Action {
  public readonly type = DocumentsActionTypes.GetCollection;
  constructor(public collectionID: number) {}
}

export class GetCollectionSuccess implements Action {
  public readonly type = DocumentsActionTypes.GetCollectionSuccess;
  constructor(public collection: Collection) {}
}

export class CreateSubcollection implements Action {
  public readonly type = DocumentsActionTypes.CreateSubcollection;
  constructor(public parentID: number, public name: string) {}
}

export class CreateSubcollectionSuccess implements Action {
  public readonly type = DocumentsActionTypes.CreateSubcollectionSuccess;
  constructor(public collection: Collection) {}
}

export class DeleteSubcollection implements Action {
  public readonly type = DocumentsActionTypes.DeleteSubcollection;
  constructor(public id: number) {}
}

export class DeleteSubcollectionSuccess implements Action {
  public readonly type = DocumentsActionTypes.DeleteSubcollectionSuccess;
  constructor(public deletedSubcollectionID: number) {}
}

export type DocumentsActions =
  GetCollection | GetCollectionSuccess |
  CreateSubcollection | CreateSubcollectionSuccess |
  DeleteSubcollection | DeleteSubcollectionSuccess;
