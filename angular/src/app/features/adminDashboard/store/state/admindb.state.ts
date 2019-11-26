export interface AdminDashboardState
{
    userRegisterStatus: number //0 - wainting ; 1 - success ; -1 - fail
    errorMessage: string | null
}

export const initialAdimnDashboardState : AdminDashboardState = 
{
    userRegisterStatus : 0,
    errorMessage : null
}