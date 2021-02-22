import {ImageOverviewState, initialImageOverviewState} from "./image-overview.state";
import {DocumentAnalysisState, initialDocumentAnalysisState} from "./document-analysis.state";


export interface ImageRecognitionState {
  imageOverview: ImageOverviewState;
  documentAnalysis: DocumentAnalysisState
}

export const initialImageRecognitionState: ImageRecognitionState = {
  imageOverview: initialImageOverviewState,
  documentAnalysis: initialDocumentAnalysisState
};

export function getInitialState(): ImageRecognitionState {
  return initialImageRecognitionState;
}
