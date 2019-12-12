import {Part} from '../../../../core/model/entities/part';
import {UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';

export interface PartsState {
  projectParts: Part[],
  imagePart: Part,
  pagePart: Part,
  regionPart: Part,
  symbolPart: Part,
  usesOfParts: UsesOfParts;
}

export const initialSemanticRepresentationState: PartsState = {
  projectParts: null,
  imagePart: null,
  pagePart: null,
  regionPart: null,
  symbolPart: null,
  usesOfParts: null
};

export function getInitialState(): PartsState {
  return initialSemanticRepresentationState;
}
