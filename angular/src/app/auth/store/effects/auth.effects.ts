import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import {catchError, map, switchMap, tap} from 'rxjs/operators';

import {
  AuthActionTypes,
  LogIn, LogInSuccess, LogInFailure,
  RefreshLogged,
} from '../actions/auth.actions';
import {AuthService} from '../../../auth/services/auth.service';
import {Actions, Effect, ofType} from '@ngrx/effects';
import {Observable, of} from 'rxjs';
import {JwtResponse} from '../../../auth/models/jwt-response';
import {SessionData} from '../../models/session-data';


@Injectable()
export class AuthEffects {

  constructor(
    private actions: Actions,
    private authService: AuthService,
    private router: Router,
  ) {}

  @Effect()
  LogIn: Observable<any> = this.actions.pipe(
    ofType(AuthActionTypes.LOGIN),
    map((action: LogIn) => action.payload),
    switchMap(payload => {
      return this.authService.attemptAuth$(payload).pipe(
        map((jwtResponse: JwtResponse) => {
          return new LogInSuccess(jwtResponse);
        }),
        catchError((error) => {
          return of(new LogInFailure(error.error.message));
        }));
    })
  );

  @Effect({ dispatch: false })
  LogInSuccess: Observable<any> = this.actions.pipe(
    ofType(AuthActionTypes.LOGIN_SUCCESS),
    tap((user) => {
      SessionData.saveSessionData(
        new SessionData(user.payload.userID, user.payload.username, user.payload.accessToken, user.payload.authorities)
      ),
      this.router.navigateByUrl('/home');
    })
  );

  @Effect()
  Refresh: Observable<any> = this.actions.pipe(
    ofType(AuthActionTypes.REFRESH),
    switchMap(() => {
      return of(new RefreshLogged(SessionData.loadSessionData()));
    })
  );

  @Effect({ dispatch: false })
  LogInFailure: Observable<any> = this.actions.pipe(
    ofType(AuthActionTypes.LOGIN_FAILURE)
  );

  @Effect({ dispatch: false })
  public LogOut: Observable<any> = this.actions.pipe(
    ofType(AuthActionTypes.LOGOUT),
    tap((user) => {
      SessionData.clearSessionData();
    })
  );

  // @Effect({ dispatch: false })
  /*@Effect()
  GetStatus: Observable<any> = this.actions.pipe(
    ofType(AuthActionTypes.GET_STATUS),
    switchMap(payload => {
      return this.authService.getStatus();
    })
  );*/
}

export const authEffects: any[] = [AuthEffects];
