import {Breadcrumb} from "../../../core/model/restapi/breadcrumb";
import {APIRestServerError} from "../../../core/model/restapi/apirest-server-error";

export interface BreadcrumbsState {
  breadcrumbs: Breadcrumb[];
  serverError: APIRestServerError;
}

export const initialBreadcrumbsState: BreadcrumbsState = {
  breadcrumbs: [],
  serverError: null
};

export function getInitialState(): BreadcrumbsState {
  return initialBreadcrumbsState;
}
