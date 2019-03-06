export interface SemanticRepresentationState {
  nada: string;
}

export const initialSemanticRepresentationState: SemanticRepresentationState = {
  nada: null,
};

export function getInitialState(): SemanticRepresentationState {
  return initialSemanticRepresentationState;
}
