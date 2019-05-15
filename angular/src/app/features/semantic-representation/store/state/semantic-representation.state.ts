import {Region} from '../../../../core/model/entities/region';
import {Notation} from '../../services/notation';

export interface SemanticRepresentationState {
  notation: Notation;
}

export const initialSemanticRepresentationState: SemanticRepresentationState = {
  notation: null
};

export function getInitialState(): SemanticRepresentationState {
  return initialSemanticRepresentationState;
}
