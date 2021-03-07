import {ImageOverview} from "../../../../core/model/restapi/image-overview";
import {APIRestServerError} from "../../../../core/model/restapi/apirest-server-error";
import {Page} from "../../../../core/model/entities/page";
import {RegionType} from "../../../../core/model/entities/region-type";

export interface ImageRecognitionState {
  imageOverview: ImageOverview;
  apiRestServerError: APIRestServerError;
  pagesRegionsSymbols: Page[];
  regionTypes: RegionType[];
}

export const initialImageRecognitionState: ImageRecognitionState = {
  imageOverview: null,
  pagesRegionsSymbols: null,
  apiRestServerError: null,
  regionTypes: null
};

export function getInitialState(): ImageRecognitionState {
  return initialImageRecognitionState;
}
