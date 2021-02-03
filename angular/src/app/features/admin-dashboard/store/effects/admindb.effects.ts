import { Injectable } from '@angular/core';
import { Effect, Actions, ofType } from '@ngrx/effects';
import { Observable, of } from 'rxjs';
import {
  AdminDBActionTypes, RegisterStart, RegisterSuccess, RegisterFail, RevokePermissions, RevokePermissionsSuccess, GrantPermissions,
  GrantPermissionsSuccess, AdminDBServerError
} from '../actions/admindb.actions';
import { switchMap, catchError } from 'rxjs/operators';
import { AdminDBService } from '../../services/admindb.service';
import { UserRegisteredResponse } from '../../model/user-registered-response';
import {Action} from '@ngrx/store';

@Injectable()
export class AdminDBEffects {

    constructor(
        private admindbActions: Actions,
        private admindbService: AdminDBService
    ) {}

    @Effect()
    registerUser$: Observable<Action> = this.admindbActions.pipe(
        ofType(AdminDBActionTypes.REGISTER_START),
        switchMap((action: RegisterStart) => this.admindbService.attemptRegister$(action.payload).pipe(
          switchMap((payload: UserRegisteredResponse) => of(new RegisterSuccess())),
          catchError((error: any) => of(new RegisterFail(error)))
        )));

    @Effect()
    revokePermissions$: Observable<Action> = this.admindbActions.pipe(
        ofType(AdminDBActionTypes.REVOKE_PERMISSIONS),
        switchMap((action: RevokePermissions) => this.admindbService.revokePermissions$(action.payload).pipe(
          switchMap((payload: RevokePermissions) => of(new RevokePermissionsSuccess())),
          catchError((error: any) => of(new AdminDBServerError(error)))
        )));

    @Effect()
    grantPermissions$: Observable<Action> = this.admindbActions.pipe(
        ofType(AdminDBActionTypes.GRANT_PERMISSIONS),
        switchMap((action: GrantPermissions) => this.admindbService.grantPermissions$(action.payload).pipe(
          switchMap((payload: GrantPermissions) => of(new GrantPermissionsSuccess())),
          catchError((error: any) => of(new AdminDBServerError(error)))
        )));
}

export const admindbeffects: any[] = [AdminDBEffects]
