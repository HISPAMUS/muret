import {Action} from '@ngrx/store';
import {Breadcrumb} from "../../../core/model/restapi/breadcrumb";
import {APIRestServerError} from "../../../core/model/restapi/apirest-server-error";
import {DocumentsActionTypes} from "../../../features/documents/store/actions/documents.actions";

export enum BreadcrumbsActionTypes {
  BreadcrumbsUpdateCollection = '[Breadcrumbs] Update collection',
  BreadcrumbsUpdateCollectionSuccess = '[Breadcrumbs] Update collection success',
  BreadcrumbsUpdateDocument = '[Breadcrumbs] Update document',
  BreadcrumbsUpdateDocumentSuccess = '[Breadcrumbs] Update document success',
  BreadcrumbsUpdateImage = '[Breadcrumbs] Update image',
  BreadcrumbsUpdateImageSuccess = '[Breadcrumbs] Update image success',
  BreadcrumbsServerError = '[Breadcrumbs] Server error',
}

export class BreadcrumbsUpdateCollection implements Action {
  public readonly type = BreadcrumbsActionTypes.BreadcrumbsUpdateCollection;
  constructor(public collectionID: number) {}
}

export class BreadcrumbsUpdateCollectionSuccess implements Action {
  public readonly type = BreadcrumbsActionTypes.BreadcrumbsUpdateCollectionSuccess;
  constructor(public breadcrumbs: Breadcrumb[]) {}
}


export class BreadcrumbsUpdateDocument implements Action {
  public readonly type = BreadcrumbsActionTypes.BreadcrumbsUpdateDocument;
  constructor(public documentID: number) {}
}

export class BreadcrumbsUpdateDocumentSuccess implements Action {
  public readonly type = BreadcrumbsActionTypes.BreadcrumbsUpdateDocumentSuccess;
  constructor(public breadcrumbs: Breadcrumb[]) {}
}

export class BreadcrumbsUpdateImage implements Action {
  public readonly type = BreadcrumbsActionTypes.BreadcrumbsUpdateImage;
  constructor(public imageID: number) {}
}

export class BreadcrumbsUpdateImageSuccess implements Action {
  public readonly type = BreadcrumbsActionTypes.BreadcrumbsUpdateImageSuccess;
  constructor(public breadcrumbs: Breadcrumb[]) {}
}


export class BreadcrumbsServerError implements Action {
  public readonly type = BreadcrumbsActionTypes.BreadcrumbsServerError;
  constructor(public serverError: APIRestServerError) {}
}

export type BreadcrumbsActions =
  BreadcrumbsUpdateCollection | BreadcrumbsUpdateDocument | BreadcrumbsServerError |
  BreadcrumbsUpdateCollectionSuccess | BreadcrumbsUpdateDocumentSuccess |
  BreadcrumbsUpdateImage | BreadcrumbsUpdateImageSuccess;
