import {ImageOverview} from "../../../../core/model/restapi/image-overview";
import {Page} from "../../../../core/model/entities/page";
import {RegionType} from "../../../../core/model/entities/region-type";
import {ClassifierModel} from "../../../../core/model/entities/classifier-model";
import {Region} from "../../../../core/model/entities/region";
import {AgnosticSymbol} from "../../../../core/model/entities/agnostic-symbol";

export interface ImageRecognitionState {
  imageOverview: ImageOverview;
  //apiRestServerError: APIRestServerError;
  pagesRegionsSymbols: Page[];
  regionTypes: RegionType[];
  classifierModels: ClassifierModel[];
  analyzing: boolean;
  selectedRegion?: Region; // used to select agnostic symbols
  selectedAgnosticSymbols?: AgnosticSymbol[];
}

export const initialImageRecognitionState: ImageRecognitionState = {
  imageOverview: null,
  pagesRegionsSymbols: null,
  //apiRestServerError: null,
  regionTypes: null,
  classifierModels: null,
  analyzing: false,
  selectedRegion: null,
  selectedAgnosticSymbols: null,
};

export function getInitialState(): ImageRecognitionState {
  return initialImageRecognitionState;
}
