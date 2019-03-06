import {Region} from '../../../../core/model/entities/region';

export interface AgnosticRepresentationState {
  selectedRegion: Region;
}

export const initialAgnosticRepresentationState: AgnosticRepresentationState = {
  selectedRegion: null,
};

export function getInitialState(): AgnosticRepresentationState {
  return initialAgnosticRepresentationState;
}
