import {initialNewProjectState, NewProjectState} from '../state/new-project.state';
import {NewProjectActions, NewProjectActionTypes} from '../actions/new-project.actions';

export function newProjectReducers(state = initialNewProjectState, action: NewProjectActions):
  NewProjectState {
  switch (action.type) {
    case NewProjectActionTypes.CreateProjectSuccess: {
      const result: NewProjectState =  {
        project: action.project
      };
      return result;
    }
    case NewProjectActionTypes.CreateProjectReset: {
      return {...initialNewProjectState};
    }
    default: {
      return state;
    }
  }
}
