import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { Store, select } from '@ngrx/store';
import {Observable, of} from 'rxjs';
import {switchMap, map, withLatestFrom, catchError, tap} from 'rxjs/operators';

import {
  GetUserSuccess,
  GetUser, UserActionTypes,
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
}
