import {BreadcrumbsActions, BreadcrumbsActionTypes} from '../actions/breadcrumbs.actions';
import {BreadcrumbsState, initialBreadcrumbsState} from '../state/breadcrumbs.state';

export function breadcrumbsReducers(state = initialBreadcrumbsState, action: BreadcrumbsActions):
BreadcrumbsState {
  switch (action.type) {
    case BreadcrumbsActionTypes.BreadcrumbsUpdateCollectionSuccess:
    case BreadcrumbsActionTypes.BreadcrumbsUpdateDocumentSuccess: {
      return {
        ...state,
        breadcrumbs: action.breadcrumbs,
        serverError: null
      };
    }
    case BreadcrumbsActionTypes.BreadcrumbsServerError:
      return {
        ...state,
        serverError: action.serverError
      };
    default: {
      return state;
    }
  }
}
