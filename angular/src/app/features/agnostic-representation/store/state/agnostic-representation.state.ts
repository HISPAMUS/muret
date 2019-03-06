export interface AgnosticRepresentationState {
  nada: string;
}

export const initialAgnosticRepresentationState: AgnosticRepresentationState = {
  nada: null,
};

export function getInitialState(): AgnosticRepresentationState {
  return initialAgnosticRepresentationState;
}
