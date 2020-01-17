import {Notation} from '../../services/notation';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';

export interface SemanticRepresentationState {
  notation: Notation;
  models: ClassifierModel[];
}

export const initialSemanticRepresentationState: SemanticRepresentationState = {
  notation: null,
  models: null
};

export function getInitialState(): SemanticRepresentationState {
  return initialSemanticRepresentationState;
}
