import { Injectable } from "@angular/core";
import { Effect, Actions, ofType } from '@ngrx/effects';
import { Observable, of } from 'rxjs';
import { AdminDBActionTypes, RegisterStart, RegisterSuccess, RegisterFail, RevokePermissions, RevokePermissionsSuccess } from '../actions/admindb.actions';
import { map, switchMap, catchError } from 'rxjs/operators';
import { NewUser } from '../../models/newusermodel';
import { AdminDBService } from '../../services/admindb.service';
import { UserRegisteredResponse } from '../../models/registeredusermodel';

@Injectable()
export class AdminDBEffets{

    constructor(
        private admindbActions : Actions,
        private admindbService : AdminDBService
    ){}

    @Effect()
    RegisterUser : Observable<any> = this.admindbActions.pipe(
        ofType(AdminDBActionTypes.REGISTER_START),
        map((action: RegisterStart) => action.payload),
        switchMap(payload => {
            return this.admindbService.attemptRegister$(payload).pipe(
                map((payload: UserRegisteredResponse) => {
                    return new RegisterSuccess();
                }),
                catchError((error: any) => {
                    return of(new RegisterFail(error));
                }
                )
            )
        })
    )

    @Effect()
    revokePermissions : Observable<any> = this.admindbActions.pipe(
        ofType(AdminDBActionTypes.REVOKE_PERMISSIONS),
        map((action: RevokePermissions) => action.payload),
        switchMap(payload => {
            return this.admindbService.revokePermissions$(payload).pipe(
                map((payload: string) => {
                    return new RevokePermissionsSuccess();
                })
            )
        })
    )
}

export const admindbeffects : any[] = [AdminDBEffets]