import { Action } from '@ngrx/store';
import {APIRestServerError} from "../../model/restapi/apirest-server-error";
import {SVGSet} from "../../model/restapi/svgset";

export enum FontsActionTypes
{
  //FontsServerError = '[Fonts] Server error',
  GetSVGSet = '[Fonts] Get SVG set',
  GetSVGSetSucccess = '[Fonts] Get SVG set success',
}
export class CoreGetSVGSet implements Action {
  public readonly type = FontsActionTypes.GetSVGSet;
  constructor(public notationType: string, public manuscriptType: string) {
  }
}

export class GetSVGSetSucccess implements Action {
  public readonly type = FontsActionTypes.GetSVGSetSucccess;
  constructor(public svgSet: SVGSet) {}
}


/*export class FontsServerError implements Action {
  public readonly type = FontsActionTypes.FontsServerError;
  constructor(public serverError: APIRestServerError) {}
}*/

export type FontsActions = CoreGetSVGSet | GetSVGSetSucccess; // | FontsServerError;

