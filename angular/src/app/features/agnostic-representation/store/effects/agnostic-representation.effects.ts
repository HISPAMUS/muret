import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {
  AgnosticRepresentationActionTypes, ChangeSymbolBoundingBox,
  ChangeSymbol, ChangeSymbolSuccess,
  CreateSymbolFromBoundingBox, CreateSymbolFromStrokes, CreateSymbolSuccess, DeleteSymbol, DeleteSymbolSuccess,
  GetRegion,
  GetRegionSuccess,
  GetSVGSet,
  GetSVGSetSucccess
} from '../actions/agnostic-representation.actions';
import {AgnosticRepresentationService} from '../../services/agnostic-representation.service';
import {Region} from '../../../../core/model/entities/region';
import {SVGSet} from '../../model/svgset';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {SymbolCreationResult} from '../../model/symbol-creation-result';

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
  changeSymbol$ = this.actions$.pipe(
    ofType<ChangeSymbol>(AgnosticRepresentationActionTypes.ChangeSymbol),
    switchMap((action: ChangeSymbol) =>
      this.agnosticRepresentationService.changeSymbol$(action.agnosticSymbol, action.agnosticSymbolType, action.positionInStaff)),
    switchMap((agnosticSymbol: AgnosticSymbol) => {
      return of(new ChangeSymbolSuccess(agnosticSymbol));
    })
  );
  @Effect()
  changeSymbolBoundingBox$ = this.actions$.pipe(
    ofType<ChangeSymbolBoundingBox>(AgnosticRepresentationActionTypes.ChangeSymbolBoundingBox),
    switchMap((action: ChangeSymbolBoundingBox) =>
      this.agnosticRepresentationService.changeSymbolBoundingBox$(action.agnosticSymbol,
        action.boundingBox.fromX, action.boundingBox.fromY,
        action.boundingBox.toX, action.boundingBox.toY)),
    switchMap((agnosticSymbol: AgnosticSymbol) => {
      return of(new ChangeSymbolSuccess(agnosticSymbol));
    })
  );
  @Effect()
  createSymbolFromBoundingBox$ = this.actions$.pipe(
    ofType<CreateSymbolFromBoundingBox>(AgnosticRepresentationActionTypes.CreateSymbolFromBoundingBox),
    switchMap((action: CreateSymbolFromBoundingBox) =>
      this.agnosticRepresentationService.createSymbolFromBoundingBox$(action.regionID, action.boundingBox,
        action.agnosticSymbolType, action.positionInStaff)),
    switchMap((symbolCreationResult: SymbolCreationResult) => {
      return of(new CreateSymbolSuccess(symbolCreationResult));
    })
  );
  @Effect()
  createSymbolFromStrokes$ = this.actions$.pipe(
    ofType<CreateSymbolFromStrokes>(AgnosticRepresentationActionTypes.CreateSymbolFromStrokes),
    switchMap((action: CreateSymbolFromStrokes) =>
      this.agnosticRepresentationService.createSymbolFromStrokes$(action.regionID, action.points,
        action.agnosticSymbolType, action.positionInStaff)),
    switchMap((symbolCreationResult: SymbolCreationResult) => {
      return of(new CreateSymbolSuccess(symbolCreationResult));
    })
  );
  /*@Effect()
  classifySymbolFromBoundingBox$ = this.actions$.pipe(
    ofType<CreateSymbolFromBoundingBox>(AgnosticRepresentationActionTypes.ClassifySymbolFromBoundingBox),
    switchMap((action: CreateSymbolFromBoundingBox) =>
      this.agnosticRepresentationService.classifySymbolFromBoundingBox$(action.regionID, action.boundingBox, action.agnosticSymbolType)),
    switchMap((classifiedSymbols: AgnosticSymbolAndPosition[]) => {
      return of(new ClassifySymbolSuccess(classifiedSymbols));
    })
  );
  @Effect()
  classifySymbolFromStrokes$ = this.actions$.pipe(
    ofType<CreateSymbolFromStrokes>(AgnosticRepresentationActionTypes.ClassifySymbolFromStrokes),
    switchMap((action: CreateSymbolFromStrokes) =>
      this.agnosticRepresentationService.classifySymbolFromStrokes$(action.regionID, action.points, action.agnosticSymbolType)),
    switchMap((classifiedSymbols: AgnosticSymbolAndPosition[]) => {
      return of(new ClassifySymbolSuccess(classifiedSymbols));
    })
  );*/
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
