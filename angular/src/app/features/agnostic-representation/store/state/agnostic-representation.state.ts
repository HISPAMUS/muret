import {Region} from '../../../../core/model/entities/region';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {SVGSet} from '../../model/svgset';
import {AgnosticSymbolAndPosition} from '../../model/agnostic-symbol-and-position';

export interface AgnosticRepresentationState {
  selectedRegion: Region;
  agnosticSymbols: AgnosticSymbol[];
  selectedSymbolID: number;
  svgAgnosticSymbolsSet: SVGSet;
  classifiedSymbols: AgnosticSymbolAndPosition[];
}

export const initialAgnosticRepresentationState: AgnosticRepresentationState = {
  selectedRegion: null,
  agnosticSymbols: null,
  selectedSymbolID: null,
  svgAgnosticSymbolsSet: null,
  classifiedSymbols: null
};

export function getInitialState(): AgnosticRepresentationState {
  return initialAgnosticRepresentationState;
}
