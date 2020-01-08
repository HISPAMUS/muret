import { createFeatureSelector, createSelector } from '@ngrx/store';
import { AdminDashboardState } from '../state/admindb.state';

export const selectAdminDBState = createFeatureSelector<AdminDashboardState>('adminDB');

export const selectRegisterStatus = createSelector(
    selectAdminDBState,
    (state: AdminDashboardState) => state.userRegisterStatus
)

export const selectErrorRegisterMessage = createSelector(
    selectAdminDBState,
    (state: AdminDashboardState) => state.errorMessage
)

export const selectRevokedFlag = createSelector(
    selectAdminDBState,
    (state: AdminDashboardState) => state.revokedPermissions
)

export const selectGrantedFlag = createSelector(
    selectAdminDBState,
    (state: AdminDashboardState) => state.grantedPermissions
)