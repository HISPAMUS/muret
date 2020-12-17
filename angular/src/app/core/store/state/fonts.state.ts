import {SVGSet} from "../../../features/agnostic-representation/model/svgset";
import {APIRestServerError} from "../../model/restapi/apirest-server-error";

export interface FontsState {
  svgAgnosticOrSemanticSymbolsSet: SVGSet;
  apiRestServerError: APIRestServerError;
}

export const initialFontsState: FontsState = {
  svgAgnosticOrSemanticSymbolsSet: null,
  apiRestServerError: null
};
