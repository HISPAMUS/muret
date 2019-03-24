import {Action} from '@ngrx/store';
import {BreadcrumbLink} from '../../model/breadcrumb-link';

export enum BreadcrumbsActionTypes {
  ActivateLink = '[Breadcrumbs] Activate link',
}

export class ActivateLink implements Action {
  public readonly type = BreadcrumbsActionTypes.ActivateLink;
  constructor(public link: BreadcrumbLink) {}
}


export type BreadcrumbsActions =
  ActivateLink;
