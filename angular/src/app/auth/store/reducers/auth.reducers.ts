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
        username: action.payload.username,
        roles: action.payload.authorities,
        errorMessage: null
      };
    }
    case AuthActionTypes.REFRESH_LOGGED: {
      if (action.sessionData) {
        return {
          ...state,
          isAuthenticated: true,
          accessToken: action.sessionData.accessToken,
          userID: +action.sessionData.userID,
          username: action.sessionData.username,
          roles: action.sessionData.roles,
          errorMessage: null
        };
      } else {
        return {
          ...state,
          isAuthenticated: false,
          accessToken: null,
          userID: null,
          username: null,
          roles: null,
          errorMessage: null
        };
      }
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
    case AuthActionTypes.RESET_PASSWORD_SUCCESS : {
      return {
        ...state,
        passwordresetmess : 200
      }
    }
    default: {
      return state;
    }
  }
}
