import {BreadcrumbLink} from '../../model/breadcrumb-link';

export interface BreadcrumbsState {
  links: BreadcrumbLink[];
}

export const initialBreadcrumbsState: BreadcrumbsState = {
  links: [],
};

export function getInitialState(): BreadcrumbsState {
  return initialBreadcrumbsState;
}
