import {Part} from '../../../../core/model/entities/part';
import {UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';

export interface PartsState {
  usesOfParts: UsesOfParts;
  partNamesUsedInImage: string[];
}

export const initialSemanticRepresentationState: PartsState = {
  usesOfParts: null,
  partNamesUsedInImage: null
};

export function getInitialState(): PartsState {
  return initialSemanticRepresentationState;
}
