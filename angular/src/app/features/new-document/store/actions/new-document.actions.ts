import {Action} from '@ngrx/store';
import {Document} from '../../../../core/model/entities/document';
import {User} from '../../../../core/model/entities/user';
import {Collection} from '../../../../core/model/entities/collection';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export enum NewDocumentActionTypes {
  NewDocumentServerError = '[NewDocument] New document server error',
  CreateDocumentReset = '[NewDocument] Create document reset',
  CreateDocument = '[NewDocument] Create document',
  CreateDocumentSuccess = '[NewDocument] Create document success',
  GetCollections = '[NewDocument] Get collections',
  GetCollectionsSuccess = '[NewDocument] Get collections success'

}

export class CreateDocument implements Action {
  public readonly type = NewDocumentActionTypes.CreateDocument;
  constructor(public user: User,
              public name: string, public composer: string,
              public notationType: string, public manuscriptType: string,
              public comments: any, public imgSrc: string, public collectionID: number) {}
}

export class NewDocumentServerError implements Action {
  public readonly type = NewDocumentActionTypes.NewDocumentServerError;
  constructor(public serverError: APIRestServerError) {}
}

export class CreateDocumentSuccess implements Action {
  public readonly type = NewDocumentActionTypes.CreateDocumentSuccess;
  constructor(public document: Document) {}
}

export class CreateDocumentReset implements Action {
  public readonly type = NewDocumentActionTypes.CreateDocumentReset;
  constructor() {}
}

export class GetCollections implements Action {
  public readonly type = NewDocumentActionTypes.GetCollections;
  constructor() {}
}

export class GetCollectionsSuccess implements Action {
  public readonly type = NewDocumentActionTypes.GetCollectionsSuccess;
  constructor(public collections: Collection[]) {}
}

export type NewDocumentActions =
  NewDocumentServerError |
  CreateDocumentReset | CreateDocument | CreateDocumentSuccess | GetCollections | GetCollectionsSuccess;
