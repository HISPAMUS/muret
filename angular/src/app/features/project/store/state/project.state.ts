import {Project} from '../../../../core/model/entities/project';
import {Image} from '../../../../core/model/entities/image';
import {ProjectStatistics} from '../../../../core/model/entities/project-statistics';

export interface ProjectState {
  project: Project;
  images: Image[];
  mei: string;
  statistics: ProjectStatistics;
}

export const initialProjectState: ProjectState = {
  project: null,
  images: null,
  mei: null,
  statistics: null
};

export function getInitialState(): ProjectState {
  return initialProjectState;
}
