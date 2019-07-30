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
    case ProjectActionTypes.ExportMEI: {
      return {
        ...state,
        mei: null
      };
    }
    case ProjectActionTypes.ExportMEISuccess: {
      return {
        ...state,
        mei: action.mei
      };
    }
    default: {
      return state;
    }
  }
}
