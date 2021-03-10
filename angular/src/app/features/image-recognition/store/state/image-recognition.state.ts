import {ImageOverview} from "../../../../core/model/restapi/image-overview";
import {APIRestServerError} from "../../../../core/model/restapi/apirest-server-error";
import {Page} from "../../../../core/model/entities/page";
import {RegionType} from "../../../../core/model/entities/region-type";
import {ClassifierModel} from "../../../../core/model/entities/classifier-model";

export interface ImageRecognitionState {
  imageOverview: ImageOverview;
  apiRestServerError: APIRestServerError;
  pagesRegionsSymbols: Page[];
  regionTypes: RegionType[];
  documentAnalysisClassifierModels: ClassifierModel[];
  analyzing: boolean;
}

export const initialImageRecognitionState: ImageRecognitionState = {
  imageOverview: null,
  pagesRegionsSymbols: null,
  apiRestServerError: null,
  regionTypes: null,
  documentAnalysisClassifierModels: null,
  analyzing: false
};

export function getInitialState(): ImageRecognitionState {
  return initialImageRecognitionState;
}
