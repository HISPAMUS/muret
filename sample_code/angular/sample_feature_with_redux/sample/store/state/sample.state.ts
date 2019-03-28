export interface SampleState {
  nada: string;
}

export const initialSampleState: SampleState = {
  nada: null,
};

export function getInitialState(): SampleState {
  return initialSampleState;
}
