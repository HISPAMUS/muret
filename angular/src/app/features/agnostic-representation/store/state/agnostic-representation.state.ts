import {Region} from '../../../../core/model/entities/region';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {SVGSet} from '../../model/svgset';
import {AgnosticSymbolAndPosition} from '../../model/agnostic-symbol-and-position';
import {ClassifierModel} from '../../../../core/model/entities/classifier-model';

export interface AgnosticRepresentationState {
  selectedRegion: Region;
  agnosticSymbols: AgnosticSymbol[];
  selectedSymbolID: number;
  svgAgnosticSymbolsSet: SVGSet;
  classifiedSymbols: AgnosticSymbolAndPosition[];
  end2endClassifierModels: ClassifierModel[];
  symbolClassifierModels: ClassifierModel[];
}

export const initialAgnosticRepresentationState: AgnosticRepresentationState = {
  selectedRegion: null,
  agnosticSymbols: null,
  selectedSymbolID: null,
  svgAgnosticSymbolsSet: null,
  classifiedSymbols: null,
  end2endClassifierModels: null,
  symbolClassifierModels: null,
};

export function getInitialState(): AgnosticRepresentationState {
  return initialAgnosticRepresentationState;
}
