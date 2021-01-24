import {UserActionTypes} from './../actions/user.actions';
import { UserActions } from '../actions/user.actions';
import {initialUserState, UserState} from '../state/user.state';

export function userReducers(state = initialUserState, action: UserActions): UserState {
  switch (action.type) {
    case UserActionTypes.GetUserSuccess: {
      return {
        ...state,
        loggedInUser: action.user
      };
    }

    case UserActionTypes.GetUserPermissionsSuccess: {
      return{
        ...state,
        permissionsData: action.payload
      }
    }

    case UserActionTypes.GetUsersSuccess : {
      return {
        ...state,
        userList: action.payload
      }
    }

    default:
      return state;
  }
};
