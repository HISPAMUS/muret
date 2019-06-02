import {createFeatureSelector, createSelector} from '@ngrx/store';
import {NewProjectState} from '../state/new-project.state';

export const newProjectState = createFeatureSelector<NewProjectState>('new-project');

export const selectNewProject = createSelector(
  newProjectState,
  (state: NewProjectState) => state.project
);

export const selectCollections = createSelector(
  newProjectState,
  (state: NewProjectState) => state.collections
);
