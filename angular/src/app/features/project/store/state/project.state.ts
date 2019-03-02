import {Project} from '../../../../core/model/entities/project';
import {Image} from '../../../../core/model/entities/image';

export interface ProjectState {
  project: Project;
  images: Image[];
}

export const initialProjectState: ProjectState = {
  project: null,
  images: null
};

export function getInitialState(): ProjectState {
  return initialProjectState;
}
