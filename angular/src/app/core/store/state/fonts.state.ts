import {SVGSet} from "../../model/restapi/svgset";

export interface FontsState {
  svgAgnosticOrSemanticSymbolsSet: SVGSet;
  //apiRestServerError: APIRestServerError;
}

export const initialFontsState: FontsState = {
  svgAgnosticOrSemanticSymbolsSet: null,
  //apiRestServerError: null
};
