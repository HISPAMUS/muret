import {Project} from '../../../../core/model/entities/project';
import {Image} from '../../../../core/model/entities/image';
import {ProjectStatistics} from '../../../../core/model/restapi/project-statistics';
import {UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';

export interface ProjectState {
  project: Project;
  images: Image[];
  mei: string;
  statistics: ProjectStatistics;
  usesOfParts: UsesOfParts;
}

export const initialProjectState: ProjectState = {
  project: null,
  images: null,
  mei: null,
  statistics: null,
  usesOfParts: null
};

export function getInitialState(): ProjectState {
  return initialProjectState;
}
