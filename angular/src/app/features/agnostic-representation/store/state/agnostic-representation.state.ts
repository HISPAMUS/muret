import {Region} from '../../../../core/model/entities/region';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {SVGSet} from '../../model/svgset';

export interface AgnosticRepresentationState {
  selectedRegion: Region;
  agnosticSymbols: AgnosticSymbol[];
  selectedSymbolID: number;
  svgAgnosticSymbolsSet: SVGSet;
}

export const initialAgnosticRepresentationState: AgnosticRepresentationState = {
  selectedRegion: null,
  agnosticSymbols: null,
  selectedSymbolID: null,
  svgAgnosticSymbolsSet: null
};

export function getInitialState(): AgnosticRepresentationState {
  return initialAgnosticRepresentationState;
}
