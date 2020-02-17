import {Region} from '../../../../core/model/entities/region';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {SVGSet} from '../../model/svgset';
import {AgnosticSymbolAndPosition} from '../../model/agnostic-symbol-and-position';
import {ClassifierModel} from '../../../../core/model/entities/classifier-model';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface AgnosticRepresentationState {
  selectedRegion: Region;
  agnosticSymbols: AgnosticSymbol[];
  selectedSymbolID: number;
  svgAgnosticSymbolsSet: SVGSet;
  classifiedSymbols: AgnosticSymbolAndPosition[];
  end2endClassifierModels: ClassifierModel[];
  symbolClassifierModels: ClassifierModel[];
  apiRestServerError: APIRestServerError;
}

export const initialAgnosticRepresentationState: AgnosticRepresentationState = {
  selectedRegion: null,
  agnosticSymbols: null,
  selectedSymbolID: null,
  svgAgnosticSymbolsSet: null,
  classifiedSymbols: null,
  end2endClassifierModels: null,
  symbolClassifierModels: null,
  apiRestServerError: null
};

export function getInitialState(): AgnosticRepresentationState {
  return initialAgnosticRepresentationState;
}
