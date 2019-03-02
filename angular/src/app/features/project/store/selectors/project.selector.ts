import {createFeatureSelector, createSelector} from '@ngrx/store';
import {ProjectState} from '../state/project.state';

export const projectState = createFeatureSelector<ProjectState>('project');

export const selectProject = createSelector(
  projectState,
  (state: ProjectState) => state.project
);

export const selectImages = createSelector(
  projectState,
  (state: ProjectState) => state.images
);

