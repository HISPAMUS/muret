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
        default:
            return {
                ...state
            }   
    }
}