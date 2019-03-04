import {AuthState, initialAuthState} from '../state/auth.state';
import {AuthActions, AuthActionTypes} from '../actions/auth.actions';

export function authReducers(state = initialAuthState, action: AuthActions): AuthState {
  switch (action.type) {
    case AuthActionTypes.LOGIN_SUCCESS: { // action.payload: JwtResponse
      return {
        ...state,
        isAuthenticated: true,
        accessToken: action.payload.accessToken,
        userID: action.payload.userID,
        roles: action.payload.authorities,
        errorMessage: null
      };
    }
    case AuthActionTypes.LOGIN_FAILURE: {
      return {
        ...state,
        errorMessage: action.payload // message
      };
    }
    case AuthActionTypes.LOGOUT: {
      return initialAuthState;
    }
    default: {
      return state;
    }
  }
}