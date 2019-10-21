import { initialServerStatusState, ServerStatusState } from '../state/status.state';
import { ServerStatusActions, serverStatusActionTypes } from '../actions/serverStatus.actions';


export function serverStatusReducers(state = initialServerStatusState, action: ServerStatusActions): ServerStatusState
{
    switch(action.type)
    {
        case serverStatusActionTypes.GetStatus:
            return {
                
                ...state
            };
        case serverStatusActionTypes.StatusSuccess:
            return{
                ...state,
                status: ((action.payload == "true") ? "ON" : "OFF")
            }
        default:
            return{
                ...state
            }
    }
}