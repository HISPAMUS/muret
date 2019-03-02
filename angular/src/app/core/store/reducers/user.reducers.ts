import {UserActionTypes} from './../actions/user.actions';
import { UserActions } from '../actions/user.actions';
import {initialUserState, UserState} from '../state/user.state';

export const userReducers = (
  state = initialUserState,
  action: UserActions
): UserState => {
  switch (action.type) {
    case UserActionTypes.GetUserSuccess: {
      return {
        ...state,
        loggedInUser: action.payload
      };
    }

    default:
      return state;
  }
};
