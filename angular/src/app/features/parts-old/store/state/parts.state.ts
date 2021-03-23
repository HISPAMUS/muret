import {UsesOfAllParts} from '../../../../core/model/restapi/uses-of-all-parts';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface PartsState {
  usesOfParts: UsesOfAllParts;
  apiRestServerError: APIRestServerError;
  // partNamesUsedInImage: Set<string>;
}

export const initialPartsState: PartsState = {
  usesOfParts: null,
  apiRestServerError: null
  // partNamesUsedInImage: null
};

export function getInitialState(): PartsState {
  return initialPartsState;
}
