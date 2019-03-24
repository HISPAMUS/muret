import {BreadcrumbsActions, BreadcrumbsActionTypes} from '../actions/breadcrumbs.actions';
import {BreadcrumbsState, initialBreadcrumbsState} from '../state/breadcrumbs.state';

export function breadcrumbsReducers(state = initialBreadcrumbsState, action: BreadcrumbsActions):
BreadcrumbsState {
  switch (action.type) {
    case BreadcrumbsActionTypes.ActivateLink: {
      const newState: BreadcrumbsState = {
        links: []
      };

      let alreadyInPath = false;
      let i = 0;
      while (!alreadyInPath && i < state.links.length) {
        alreadyInPath = state.links[i].title === action.link.title;
        if (!alreadyInPath) {
          newState.links.push(state.links[i]);
          i++;
        } else {
          newState.links.push(action.link);
        }
      }
      if (!alreadyInPath) {
        newState.links.push(action.link);
      }
      return newState;
    }
    default: {
      return state;
    }
  }
}
