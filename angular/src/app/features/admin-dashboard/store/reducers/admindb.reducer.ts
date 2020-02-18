import { AdminDashboardState, initialAdimnDashboardState } from '../state/admindb.state';
import { AdminDBActions, AdminDBActionTypes } from '../actions/admindb.actions';

export function adminDBReducers( state = initialAdimnDashboardState, action: AdminDBActions ): AdminDashboardState  {
    switch (action.type) {
      case AdminDBActionTypes.ADMIN_SERVER_ERROR:
        return {
          ...state,
          apiRestServerError: action.error
        };
      case AdminDBActionTypes.REGISTER_START:
            return{
                ...state,
                userRegisterStatus: 0,
              apiRestServerError: null
            };
        case AdminDBActionTypes.REGISTER_SUCCESS:
            return{
                ...state,
                userRegisterStatus: 1,
              apiRestServerError: null
            };
        case AdminDBActionTypes.REGISTER_FAIL:
            return{
                ...state,
                userRegisterStatus: -1,
                errorMessage: action.payload,
                apiRestServerError: null
            };
        case AdminDBActionTypes.REVOKE_PERMISSIONS:
            return{
                ...state,
                revokedPermissions: 0,
              apiRestServerError: null
            };
        case AdminDBActionTypes.REVOKE_PERMISSIONS_SUCCESS:
            return{
                ...state,
                revokedPermissions: 1,
              apiRestServerError: null
            };
        case AdminDBActionTypes.GRANT_PERMISSIONS:
            return{
                ...state,
                grantedPermissions: 0,
              apiRestServerError: null
            };
        case AdminDBActionTypes.GRANT_PERMISSIONS_SUCCESS:
            return{
                ...state,
                grantedPermissions: 1,
              apiRestServerError: null
            };
        default:
            return {
                ...state,
              apiRestServerError: null
            };
    }
}
