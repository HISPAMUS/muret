import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {
  AgnosticRepresentationActionTypes,
  GetRegion,
  GetRegionSuccess, GetSVGSet, GetSVGSetSucccess
} from '../actions/agnostic-representation.actions';
import {AgnosticRepresentationService} from '../../services/agnostic-representation.service';
import {Region} from '../../../../core/model/entities/region';
import {SVGSet} from '../../model/svgset';

@Injectable()
export class AgnosticRepresentationEffects {
  constructor(
    private agnosticRepresentationService: AgnosticRepresentationService,
    private actions$: Actions,
  ) {}

  @Effect()
  getRegion$ = this.actions$.pipe(
    ofType<GetRegion>(AgnosticRepresentationActionTypes.GetRegion),
    map((action: GetRegion) => action.id),
    switchMap((id) => this.agnosticRepresentationService.getRegion$(id)),
    switchMap((region: Region) => {
      return of(new GetRegionSuccess(region));
    })
  );
  @Effect()
  getSVGSet$ = this.actions$.pipe(
    ofType<GetSVGSet>(AgnosticRepresentationActionTypes.GetSVGSet),
    switchMap((action: GetSVGSet) => this.agnosticRepresentationService.getSVGSet$(action.notationType, action.manuscriptType)),
    switchMap((svgSet: SVGSet) => {
      return of(new GetSVGSetSucccess(svgSet));
    })
  );
}
