import {Project} from '../../../../core/model/entities/project';
import {Collection} from '../../../../core/model/entities/collection';

export interface NewProjectState {
  project: Project;
  collections: Collection[];
}

export const initialNewProjectState: NewProjectState = {
  project: null,
  collections: null
};

export function getInitialState(): NewProjectState {
  return initialNewProjectState;
}
