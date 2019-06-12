import {createFeatureSelector, createSelector} from '@ngrx/store';
import {ProjectsState} from '../state/projects.state';

export const projectsState = createFeatureSelector<ProjectsState>('projects');

export const selectCollection = createSelector(
  projectsState,
  (state: ProjectsState) => state.collection
);

