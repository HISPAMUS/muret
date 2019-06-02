import {initialNewProjectState, NewProjectState} from '../state/new-project.state';
import {NewProjectActions, NewProjectActionTypes} from '../actions/new-project.actions';

export function newProjectReducers(state = initialNewProjectState, action: NewProjectActions):
  NewProjectState {
  switch (action.type) {
    case NewProjectActionTypes.CreateProjectSuccess: {
      const result: NewProjectState =  {
        project: action.project,
        collections: state.collections
      };
      return result;
    }
    case NewProjectActionTypes.CreateProjectReset: {
      return {...initialNewProjectState};
    }
    case NewProjectActionTypes.GetCollectionsSuccess: {
      const result: NewProjectState =  {
        project: state.project,
        collections: action.collections
      };
      return result;
    }
    default: {
      return state;
    }
  }
}
