import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {ImageOverview} from "../../model/image-overview";

export interface ImageRecognitionState {
  imageOverview: ImageOverview;
  apiRestServerError: APIRestServerError;
}

export const initialImageRecognitionState: ImageRecognitionState = {
  imageOverview: null,
  apiRestServerError: null
};
