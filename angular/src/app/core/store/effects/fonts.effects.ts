import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {FontsService} from "../../services/fonts.service";
import {FontsActionTypes, CoreGetSVGSet, GetSVGSetSucccess} from "../actions/fonts.actions";
import {SVGSet} from "../../model/restapi/svgset";

@Injectable()
export class FontsEffects {
  constructor(
    private fontsService: FontsService,
    private actions$: Actions,
  ) {}

  @Effect()
  getSVGSet$ = this.actions$.pipe(
    ofType<CoreGetSVGSet>(FontsActionTypes.GetSVGSet),
    switchMap((action: CoreGetSVGSet) => this.fontsService.getSVGSet$(action.notationType, action.manuscriptType).pipe(
      switchMap((svgSet: SVGSet) => of(new GetSVGSetSucccess(svgSet))),
      //catchError((error: any) => of(new FontsServerError(error)))
    )));


}
