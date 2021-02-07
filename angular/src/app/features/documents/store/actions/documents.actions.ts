import { Action } from '@ngrx/store';
import {Collection} from '../../../../core/model/entities/collection';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export enum DocumentsActionTypes {
  DocumentsResetDocumentsServerError = '[Documents] Reset Server error',
  DocumentsServerError = '[Documents] Server error',
  DocumentsGetCollection = '[Documents] Get collection',
  DocumentsGetCollectionSuccess = '[Documents] Get collection success',
  DocumentsCreateSubcollection = '[Documents] Create subcollection',
  DocumentsCreateSubcollectionSuccess = '[Documents] Create subcollection success',
  DocumentsDeleteSubcollection = '[Documents] Delete subcollection',
  DocumentsDeleteSubcollectionSuccess = '[Documents] Delete subcollection success',
  DocumentsMoveDocumentsToSubcollection = '[Document] Move documents to subcollection',
  DocumentsMoveDocumentsToSubcollectionSuccess = '[Document] Move documents to subcollection success',
  DocumentsMoveDocumentsToNewSubcollection = '[Document] Move documents to new subcollection',
  DocumentsMoveDocumentsToNewSubcollectionSuccess = '[Document] Move documents to new subcollection success',
}

export class DocumentsResetDocumentsServerError implements Action {
  public readonly type = DocumentsActionTypes.DocumentsResetDocumentsServerError;
  constructor() {}
}

export class DocumentsServerError implements Action {
  public readonly type = DocumentsActionTypes.DocumentsServerError;
  constructor(public serverError: APIRestServerError) {}
}

export class DocumentsGetCollection implements Action {
  public readonly type = DocumentsActionTypes.DocumentsGetCollection;
  constructor(public collectionID: number) {}
}

export class DocumentsGetCollectionSuccess implements Action {
  public readonly type = DocumentsActionTypes.DocumentsGetCollectionSuccess;
  constructor(public collection: Collection) {}
}

export class DocumentsCreateSubcollection implements Action {
  public readonly type = DocumentsActionTypes.DocumentsCreateSubcollection;
  constructor(public parentID: number, public name: string) {}
}

export class DocumentsCreateSubcollectionSuccess implements Action {
  public readonly type = DocumentsActionTypes.DocumentsCreateSubcollectionSuccess;
  constructor(public collection: Collection) {}
}

export class DocumentsDeleteSubcollection implements Action {
  public readonly type = DocumentsActionTypes.DocumentsDeleteSubcollection;
  constructor(public id: number) {}
}

export class DocumentsDeleteSubcollectionSuccess implements Action {
  public readonly type = DocumentsActionTypes.DocumentsDeleteSubcollectionSuccess;
  constructor(public deletedSubcollectionID: number) {}
}


export class DocumentsMoveDocumentsToSubcollection implements Action {
  public readonly type = DocumentsActionTypes.DocumentsMoveDocumentsToSubcollection;
  constructor(public currentCollectionID: number, public documentIDs: number[], public subcollectionID: number) {}
}

export class DocumentsMoveDocumentsToSubcollectionSuccess implements Action {
  public readonly type = DocumentsActionTypes.DocumentsMoveDocumentsToSubcollectionSuccess;
  constructor(public changedCollectionID: number) {}
}

export class DocumentsMoveDocumentsToNewSubcollection implements Action {
  public readonly type = DocumentsActionTypes.DocumentsMoveDocumentsToNewSubcollection;
  constructor(public currentCollectionID: number, public documentIDs: number[], public subCollectionName: string) {}
}

export class DocumentsMoveDocumentsToNewSubcollectionSuccess implements Action {
  public readonly type = DocumentsActionTypes.DocumentsMoveDocumentsToNewSubcollectionSuccess;
  constructor(public changedCollectionID: number) {}
}


export type DocumentsActions =
  DocumentsResetDocumentsServerError | DocumentsServerError |
  DocumentsGetCollection | DocumentsGetCollectionSuccess |
  DocumentsCreateSubcollection | DocumentsCreateSubcollectionSuccess |
  DocumentsDeleteSubcollection | DocumentsDeleteSubcollectionSuccess |
  DocumentsMoveDocumentsToSubcollection | DocumentsMoveDocumentsToSubcollectionSuccess |
  DocumentsMoveDocumentsToNewSubcollection | DocumentsMoveDocumentsToNewSubcollectionSuccess;
