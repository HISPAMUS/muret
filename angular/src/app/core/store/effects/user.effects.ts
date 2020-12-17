import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import {of} from 'rxjs';
import {switchMap, map, withLatestFrom, catchError, tap} from 'rxjs/operators';

import {
  GetUserSuccess,
  GetUser, UserActionTypes, GetUserPermissions, GetUserPermissionsSuccess, GetUsers, GetUsersSuccess,
} from '../actions/user.actions';
import {UserService} from '../../services/user.service';
import {User} from '../../model/entities/user';

@Injectable()
export class UserEffects {
  constructor(
    private userService: UserService,
    private actions$: Actions,
  ) {}


  @Effect()
  getUser$ = this.actions$.pipe(
    ofType<GetUser>(UserActionTypes.GetUser),
    map((action: GetUser) => action.payload),
    switchMap((userID) => this.userService.getUserProjection$(userID)),
    switchMap((user: User) => {
      return of(new GetUserSuccess(user));
    })
  );

  @Effect()
  getUserPermission$ = this.actions$.pipe(
    ofType<GetUserPermissions>(UserActionTypes.GetUserPermissions),
    switchMap(()=> this.userService.getUsersPermissions$()),
    switchMap((response:any) => {
      return of(new GetUserPermissionsSuccess(response))
    })
  )

  @Effect()
  getAllUsers$ = this.actions$.pipe(
    ofType<GetUsers>(UserActionTypes.GetUsers),
    switchMap(()=> this.userService.getAllUsers()),
    switchMap((response:string[]) => {
      return of(new GetUsersSuccess(response))
    })
  )
}
