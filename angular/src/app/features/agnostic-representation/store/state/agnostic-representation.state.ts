import {Region} from '../../../../core/model/entities/region';
import {SVGSet} from '../../model/svgset';

export interface AgnosticRepresentationState {
  selectedRegion: Region;
  svgAgnosticSymbolsSet: SVGSet;
}

export const initialAgnosticRepresentationState: AgnosticRepresentationState = {
  selectedRegion: null,
  svgAgnosticSymbolsSet: null
};

export function getInitialState(): AgnosticRepresentationState {
  return initialAgnosticRepresentationState;
}
