import {Part} from '../../../../core/model/entities/part';

export interface PartsState {
  imagePart: Part,
  pagePart: Part,
  regionPart: Part,
  symbolPart: Part;
}

export const initialSemanticRepresentationState: PartsState = {
  imagePart: null,
  pagePart: null,
  regionPart: null,
  symbolPart: null
};

export function getInitialState(): PartsState {
  return initialSemanticRepresentationState;
}
