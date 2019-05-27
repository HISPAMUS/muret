import {Collection} from '../../../../core/model/entities/collection';

export interface ProjectsState {
  collection: Collection;
}

export const initialProjectsState: ProjectsState = {
  collection: null,
};

export function getInitialState(): ProjectsState {
  return initialProjectsState;
}
