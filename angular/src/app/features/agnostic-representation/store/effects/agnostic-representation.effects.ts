import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {
  AgnosticRepresentationActionTypes,
  ChangeSymbolPositionInStaff,
  ChangeSymbolPositionInStaffSuccess,
  ChangeSymbolType,
  ChangeSymbolTypeSuccess, CreateSymbolFromBoundingBox, CreateSymbolFromStrokes, CreateSymbolSuccess, DeleteSymbol, DeleteSymbolSuccess,
  GetRegion,
  GetRegionSuccess,
  GetSVGSet,
  GetSVGSetSucccess
} from '../actions/agnostic-representation.actions';
import {AgnosticRepresentationService} from '../../services/agnostic-representation.service';
import {Region} from '../../../../core/model/entities/region';
import {SVGSet} from '../../model/svgset';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';

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
  @Effect()
  changeSymbolType$ = this.actions$.pipe(
    ofType<ChangeSymbolType>(AgnosticRepresentationActionTypes.ChangeSymbolType),
    switchMap((action: ChangeSymbolType) =>
      this.agnosticRepresentationService.changeSymbolType$(action.agnosticSymbol, action.agnosticSymbolType)),
    switchMap((agnosticSymbol: AgnosticSymbol) => {
      return of(new ChangeSymbolTypeSuccess(agnosticSymbol));
    })
  );
  @Effect()
  changeSymbolPositionInStaff$ = this.actions$.pipe(
    ofType<ChangeSymbolPositionInStaff>(AgnosticRepresentationActionTypes.ChangeSymbolPositionInStaff),
    switchMap((action: ChangeSymbolPositionInStaff) =>
      this.agnosticRepresentationService.changeSymbolPositionInStaff$(action.agnosticSymbol, action.difference)),
    switchMap((agnosticSymbol: AgnosticSymbol) => {
      return of(new ChangeSymbolPositionInStaffSuccess(agnosticSymbol));
    })
  );
  @Effect()
  createSymbolFromBoundingBox$ = this.actions$.pipe(
    ofType<CreateSymbolFromBoundingBox>(AgnosticRepresentationActionTypes.CreateSymbolFromBoundingBox),
    switchMap((action: CreateSymbolFromBoundingBox) =>
      this.agnosticRepresentationService.createSymbolFromBoundingBox$(action.regionID, action.boundingBox, action.agnosticSymbolType)),
    switchMap((createdSymbol: AgnosticSymbol) => {
      return of(new CreateSymbolSuccess(createdSymbol));
    })
  );
  @Effect()
  createSymbolFromStrokes$ = this.actions$.pipe(
    ofType<CreateSymbolFromStrokes>(AgnosticRepresentationActionTypes.CreateSymbolFromStrokes),
    switchMap((action: CreateSymbolFromStrokes) =>
      this.agnosticRepresentationService.createSymbolFromStrokes$(action.regionID, action.points, action.agnosticSymbolType)),
    switchMap((createdSymbol: AgnosticSymbol) => {
      return of(new CreateSymbolSuccess(createdSymbol));
    })
  );
  @Effect()
  deleteSymbol$ = this.actions$.pipe(
    ofType<DeleteSymbol>(AgnosticRepresentationActionTypes.DeleteSymbol),
    switchMap((action: DeleteSymbol) =>
      this.agnosticRepresentationService.deleteSymbol$(action.agnosticSymbolID)),
    switchMap((deletedSymbolID: number) => {
      return of(new DeleteSymbolSuccess(deletedSymbolID));
    })
  );
}
