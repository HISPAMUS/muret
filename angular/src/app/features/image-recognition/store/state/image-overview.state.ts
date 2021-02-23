import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {ImageOverview} from "../../model/image-overview";
import {Page} from "../../../../core/model/entities/page";

export interface ImageOverviewState {
  imageOverview: ImageOverview;
  apiRestServerError: APIRestServerError;
  pagesRegionsSymbols: Page[];
}

export const initialImageOverviewState: ImageOverviewState = {
  imageOverview: null,
  pagesRegionsSymbols: null,
  apiRestServerError: null
};
