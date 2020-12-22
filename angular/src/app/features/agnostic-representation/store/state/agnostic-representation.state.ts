import {Region} from '../../../../core/model/entities/region';
import {AgnosticSymbol} from '../../../../core/model/entities/agnostic-symbol';
import {AgnosticOrSemanticSymbolAndPosition} from '../../model/agnostic-or-semantic-symbol-and-position';
import {ClassifierModel} from '../../../../core/model/entities/classifier-model';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface AgnosticRepresentationState {
  selectedRegion: Region;
  agnosticSymbols: AgnosticSymbol[];
  selectedSymbolID: number;
  classifiedSymbols: AgnosticOrSemanticSymbolAndPosition[];
  end2endClassifierModels: ClassifierModel[];
  symbolClassifierModels: ClassifierModel[];
  apiRestServerError: APIRestServerError;
}

export const initialAgnosticRepresentationState: AgnosticRepresentationState = {
  selectedRegion: null,
  agnosticSymbols: null,
  selectedSymbolID: null,
  classifiedSymbols: null,
  end2endClassifierModels: null,
  symbolClassifierModels: null,
  apiRestServerError: null
};

export function getInitialState(): AgnosticRepresentationState {
  return initialAgnosticRepresentationState;
}
