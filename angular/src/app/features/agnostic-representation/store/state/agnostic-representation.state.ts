import {Region} from '../../../../core/model/entities/region';
import {Region} from '../../../../core/model/entities/agnosticSymbol';
import {SVGSet} from '../../model/svgset';

export interface AgnosticRepresentationState {
  selectedRegion: Region;
  selectedSymbol: Symbol;
  svgAgnosticSymbolsSet: SVGSet;
}

export const initialAgnosticRepresentationState: AgnosticRepresentationState = {
  selectedRegion: null,
  selectedSymbol: null,
  svgAgnosticSymbolsSet: null
};

export function getInitialState(): AgnosticRepresentationState {
  return initialAgnosticRepresentationState;
}
