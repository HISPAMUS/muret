import {ActionReducerMap} from "@ngrx/store";
import {ImageRecognitionState} from "../state/image-recognition.state";
import {documentAnalysisReducers} from "./document-analysis.reducers";
import {imageOverviewReducers} from "./image-overview.reducers";

export const imageRecognitionReducers: ActionReducerMap<ImageRecognitionState, any> = {
  imageOverview: imageOverviewReducers,
  documentAnalysis: documentAnalysisReducers,
};
