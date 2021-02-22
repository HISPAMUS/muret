import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {ImageOverview} from "../../model/image-overview";

export interface ImageOverviewState {
  imageOverview: ImageOverview;
  apiRestServerError: APIRestServerError;
}

export const initialImageOverviewState: ImageOverviewState = {
  imageOverview: null,
  apiRestServerError: null
};
