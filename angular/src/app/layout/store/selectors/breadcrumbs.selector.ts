import {createFeatureSelector, createSelector} from '@ngrx/store';
import {BreadcrumbsState} from '../state/breadcrumbs.state';

export const breadcrumbsState = createFeatureSelector<BreadcrumbsState>('breadcrumbs');

export const selectBreadcrumbsLinks = createSelector(
  breadcrumbsState,
  (state: BreadcrumbsState) => state.links
);
