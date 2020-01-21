import { AdminDashboardState, initialAdimnDashboardState } from '../state/admindb.state';
import { AdminDBActions, AdminDBActionTypes } from '../actions/admindb.actions';

export function adminDBReducers( state = initialAdimnDashboardState, action: AdminDBActions ) : AdminDashboardState
{
    switch(action.type)
    {
        case AdminDBActionTypes.REGISTER_START:
            return{
                ...state,
                userRegisterStatus: 0
            }
        case AdminDBActionTypes.REGISTER_SUCCESS:
            return{
                ...state,
                userRegisterStatus: 1
            }
        case AdminDBActionTypes.REGISTER_FAIL:
            return{
                ...state,
                userRegisterStatus: -1,
                errorMessage: action.payload
            }
        case AdminDBActionTypes.REVOKE_PERMISSIONS:
            return{
                ...state,
                revokedPermissions: 0
            }
        case AdminDBActionTypes.REVOKE_PERMISSIONS_SUCCESS:
            return{
                ...state,
                revokedPermissions: 1
            }
        case AdminDBActionTypes.GRANT_PERMISSIONS:
            return{
                ...state,
                grantedPermissions: 0
            }
        case AdminDBActionTypes.GRANT_PERMISSIONS_SUCCESS:
            return{
                ...state,
                grantedPermissions: 1
            }
        default:
            return {
                ...state
            }   
    }
}