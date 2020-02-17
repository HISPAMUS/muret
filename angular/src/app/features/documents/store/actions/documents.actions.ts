import { Action } from '@ngrx/store';
import {Collection} from '../../../../core/model/entities/collection';
import {DocumentActionTypes, GetDocumentStatisticsSuccess} from '../../../document/store/actions/document.actions';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export enum DocumentsActionTypes {
  DocumentsServerError = '[Documents] Server error',
  GetCollection = '[Documents] Get collection',
  GetCollectionSuccess = '[Documents] Get collection success',
  CreateSubcollection = '[Documents] Create subcollection',
  CreateSubcollectionSuccess = '[Documents] Create subcollection success',
  DeleteSubcollection = '[Documents] Delete subcollection',
  DeleteSubcollectionSuccess = '[Documents] Delete subcollection success',
  MoveDocumentsToSubcollection = '[Document] Move documents to subcollection',
  MoveDocumentsToSubcollectionSuccess = '[Document] Move documents to subcollection success',
  MoveDocumentsToNewSubcollection = '[Document] Move documents to new subcollection',
  MoveDocumentsToNewSubcollectionSuccess = '[Document] Move documents to new subcollection success',
}

export class DocumentsServerError implements Action {
  public readonly type = DocumentsActionTypes.DocumentsServerError;
  constructor(public serverError: APIRestServerError) {}
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


export class MoveDocumentsToSubcollection implements Action {
  public readonly type = DocumentsActionTypes.MoveDocumentsToSubcollection;
  constructor(public currentCollectionID: number, public documentIDs: number[], public subcollectionID: number) {}
}

export class MoveDocumentsToSubcollectionSuccess implements Action {
  public readonly type = DocumentsActionTypes.MoveDocumentsToSubcollectionSuccess;
  constructor(public changedCollectionID: number) {}
}

export class MoveDocumentsToNewSubcollection implements Action {
  public readonly type = DocumentsActionTypes.MoveDocumentsToNewSubcollection;
  constructor(public currentCollectionID: number, public documentIDs: number[], public subCollectionName: string) {}
}

export class MoveDocumentsToNewSubcollectionSuccess implements Action {
  public readonly type = DocumentsActionTypes.MoveDocumentsToNewSubcollectionSuccess;
  constructor(public changedCollectionID: number) {}
}


export type DocumentsActions =
  DocumentsServerError |
  GetCollection | GetCollectionSuccess |
  CreateSubcollection | CreateSubcollectionSuccess |
  DeleteSubcollection | DeleteSubcollectionSuccess |
  MoveDocumentsToSubcollection | MoveDocumentsToSubcollectionSuccess |
  MoveDocumentsToNewSubcollection | MoveDocumentsToNewSubcollectionSuccess;
