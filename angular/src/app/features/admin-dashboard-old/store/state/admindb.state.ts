import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface AdminDashboardState {
    userRegisterStatus: number; // 0 - wainting ; 1 - success ; -1 - fail
    errorMessage: string | null;
    revokedPermissions: number;
    grantedPermissions: number;
    apiRestServerError: APIRestServerError;
}

export const initialAdimnDashboardState: AdminDashboardState = {
    userRegisterStatus : 0,
    errorMessage : null,
    revokedPermissions: 0,
    grantedPermissions: 0,
    apiRestServerError: null
}
