import {Action} from '@ngrx/store';
import {BreadcrumbLink} from '../../model/breadcrumb-link';

export enum BreadcrumbsActionTypes {
  ActivateLink = '[Breadcrumbs] Activate link',
  ClearLinks = '[Breadcrumbs] Clear links'
}

export class ActivateLink implements Action {
  public readonly type = BreadcrumbsActionTypes.ActivateLink;
  constructor(public link: BreadcrumbLink) {}
}

export class ClearLinks implements Action {
  public readonly type = BreadcrumbsActionTypes.ClearLinks;
  constructor() {}
}

export type BreadcrumbsActions =
  ActivateLink | ClearLinks;
