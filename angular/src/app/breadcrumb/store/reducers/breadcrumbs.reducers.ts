import {BreadcrumbsActions, BreadcrumbsActionTypes} from '../actions/breadcrumbs.actions';
import {BreadcrumbsState, initialBreadcrumbsState} from '../state/breadcrumbs.state';

export function breadcrumbsReducers(state = initialBreadcrumbsState, action: BreadcrumbsActions):
BreadcrumbsState {
  switch (action.type) {
    case BreadcrumbsActionTypes.ActivateLink: {
      const newState: BreadcrumbsState = {
        links: [],
        init: state.init
      };
      
      //Link is not in the path
      const oldLinks = state.links;
      sessionStorage.setItem("URL", oldLinks.toString());

      let i = 0;
      let inserted = false;
      while(i < oldLinks.length)
      {
        //If we are not in the position we desire
        if(i != action.linkType)
          newState.links.push(oldLinks[i]); //Push the referred link
        else
        {
          newState.links[i] = action.link;
          inserted = true;
          break;
        }
        i++; //Increase i in any case
      }
      if(!inserted) //If it has not been inserted, we push it to the end
        newState.links.push(action.link);

      return newState;
    }
    case BreadcrumbsActionTypes.ClearLinks: {
      const newState: BreadcrumbsState = {
        links: [],
        init: false
      };
      return newState;
    }
    default: {
      return state;
    }
  }
}
