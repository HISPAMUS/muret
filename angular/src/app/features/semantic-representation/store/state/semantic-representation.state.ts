import {Notation} from '../../services/notation';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface SemanticRepresentationState {
  notation: Notation;
  models: ClassifierModel[];
  apiRestServerError: APIRestServerError;
}

export const initialSemanticRepresentationState: SemanticRepresentationState = {
  notation: null,
  models: null,
  apiRestServerError: null
};

export function getInitialState(): SemanticRepresentationState {
  return initialSemanticRepresentationState;
}
