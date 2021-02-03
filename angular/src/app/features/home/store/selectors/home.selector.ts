import {createFeatureSelector, createSelector} from '@ngrx/store';
import {HomeState} from "../state/home.state";

export const homeState = createFeatureSelector<HomeState>('home');

export const selectHomeLastDocuments = createSelector(
  homeState,
  (state: HomeState) => state.lastDocuments
);
