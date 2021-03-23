import {Notation} from '../../../../shared/services/notation';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface SemanticRepresentationState {
  notation: Notation;
  models: ClassifierModel[];
  selectedSymbolID: number;
  apiRestServerError: APIRestServerError;
}

export const initialSemanticRepresentationState: SemanticRepresentationState = {
  notation: null,
  models: null,
  selectedSymbolID: null,
  apiRestServerError: null
};

export function getInitialState(): SemanticRepresentationState {
  return initialSemanticRepresentationState;
}
