import {ProjectActions, ProjectActionTypes} from '../actions/project.actions';
import {initialProjectState, ProjectState} from '../state/project.state';

export function projectReducers(state = initialProjectState, action: ProjectActions): ProjectState {
  switch (action.type) {
    case ProjectActionTypes.GetProjectSuccess: {
      return {
        ...state,
        project: action.project
      };
    }
    case ProjectActionTypes.GetImagesSuccess: {
      return {
        ...state,
        images: action.images
      };
    }
    default: {
      return state;
    }
  }
}