import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {FontsService} from "../../services/fonts.service";
import {FontsActionTypes, FontsServerError, GetSVGSet, GetSVGSetSucccess} from "../actions/fonts.actions";
import {SVGSet} from "../../../features/agnostic-representation/model/svgset";

@Injectable()
export class FontsEffects {
  constructor(
    private fontsService: FontsService,
    private actions$: Actions,
  ) {}

  @Effect()
  getSVGSet$ = this.actions$.pipe(
    ofType<GetSVGSet>(FontsActionTypes.GetSVGSet),
    switchMap((action: GetSVGSet) => this.fontsService.getSVGSet$(action.notationType, action.manuscriptType).pipe(
      switchMap((svgSet: SVGSet) => of(new GetSVGSetSucccess(svgSet))),
      catchError((error: any) => of(new FontsServerError(error)))
    )));


}
