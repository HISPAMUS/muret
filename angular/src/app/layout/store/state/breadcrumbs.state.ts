import {BreadcrumbLink} from '../../model/breadcrumb-link';

export interface BreadcrumbsState {
  links: BreadcrumbLink[];
  init: boolean;
}

export const initialBreadcrumbsState: BreadcrumbsState = {
  links: [],
  init: false
};

export function getInitialState(): BreadcrumbsState {
  return initialBreadcrumbsState;
}
