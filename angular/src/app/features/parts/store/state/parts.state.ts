import {Part} from '../../../../core/model/entities/part';

export interface PartsState {
  projectParts: Part[],
  imagePart: Part,
  pagePart: Part,
  regionPart: Part,
  symbolPart: Part;
}

export const initialSemanticRepresentationState: PartsState = {
  projectParts: null,
  imagePart: null,
  pagePart: null,
  regionPart: null,
  symbolPart: null
};

export function getInitialState(): PartsState {
  return initialSemanticRepresentationState;
}
