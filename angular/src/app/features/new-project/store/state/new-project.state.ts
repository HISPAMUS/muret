import {Project} from '../../../../core/model/entities/project';

export interface NewProjectState {
  project: Project;
}

export const initialNewProjectState: NewProjectState = {
  project: null,
};

export function getInitialState(): NewProjectState {
  return initialNewProjectState;
}
