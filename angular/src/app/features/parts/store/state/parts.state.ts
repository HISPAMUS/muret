import {UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface PartsState {
  usesOfParts: UsesOfParts;
  apiRestServerError: APIRestServerError;
  // partNamesUsedInImage: Set<string>;
}

export const initialSemanticRepresentationState: PartsState = {
  usesOfParts: null,
  apiRestServerError: null
  // partNamesUsedInImage: null
};

export function getInitialState(): PartsState {
  return initialSemanticRepresentationState;
}
