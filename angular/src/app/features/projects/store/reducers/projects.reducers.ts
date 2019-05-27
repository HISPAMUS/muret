import {initialProjectsState, ProjectsState} from '../state/projects.state';
import {ProjectsActions, ProjectsActionTypes} from '../actions/projects.actions';

export function projectsReducers(state = initialProjectsState, action: ProjectsActions): ProjectsState {
  switch (action.type) {
    case ProjectsActionTypes.GetCollectionSuccess: {
      return {
        ...state,
        collection: action.collection
      };
    }
    default: {
      return state;
    }
  }
}
