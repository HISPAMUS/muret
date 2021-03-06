import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, mergeMap, switchMap} from 'rxjs/operators';
import {
  AgnosticRepresentationActionTypes,
  ChangeSymbolBoundingBox,
  ChangeSymbol,
  ChangeSymbolSuccess,
  CreateSymbolFromBoundingBox,
  CreateSymbolFromStrokes,
  CreateSymbolSuccess,
  DeleteSymbol,
  DeleteSymbolSuccess,
  GetRegion,
  GetRegionSuccess,
  GetSVGSet,
  GetSVGSetSucccess,
  ClassifyRegionEndToEnd,
  ClassifyRegionEndToEndSuccess,
  ClearRegionSymbols,
  ClearRegionSymbolsSuccess,
  ChangeSymbolComments,
  GetSymbolClassifierModelsSuccess,
  GetSymbolClassifierModels,
  GetAgnosticEnd2EndClassifierModels,
  GetAgnosticEnd2EndClassifierModelsSuccess, AgnosticRepresentationServerError
} from '../actions/agnostic-representation.actions';
import {AgnosticRepresentationService} from '../../services/agnostic-representation.service';
import {Region} from '../../../../core/model/entities/region';
import {SVGSet} from '../../model/svgset';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {SymbolCreationResult} from '../../model/symbol-creation-result';
import {ClassifierModel} from '../../../../core/model/entities/classifier-model';

@Injectable()
export class AgnosticRepresentationEffects {
  constructor(
    private agnosticRepresentationService: AgnosticRepresentationService,
    private actions$: Actions,
  ) {}

  @Effect()
  getRegion$ = this.actions$.pipe(
    ofType<GetRegion>(AgnosticRepresentationActionTypes.GetRegion),
    switchMap((action: GetRegion) => this.agnosticRepresentationService.getRegion$(action.id).pipe(
      switchMap((region: Region) => of (new GetRegionSuccess(region))),
      catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
    )));

  @Effect()
  getSVGSet$ = this.actions$.pipe(
    ofType<GetSVGSet>(AgnosticRepresentationActionTypes.GetSVGSet),
    switchMap((action: GetSVGSet) => this.agnosticRepresentationService.getSVGSet$(action.notationType, action.manuscriptType).pipe(
      switchMap((svgSet: SVGSet) => of(new GetSVGSetSucccess(svgSet))),
      catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
    )));

  @Effect()
  changeSymbol$ = this.actions$.pipe(
    ofType<ChangeSymbol>(AgnosticRepresentationActionTypes.ChangeSymbol),
    switchMap((action: ChangeSymbol) =>
      this.agnosticRepresentationService.changeSymbol$(action.agnosticSymbol, action.agnosticSymbolType, action.positionInStaff).pipe(
        switchMap((agnosticSymbol: AgnosticSymbol) => of(new ChangeSymbolSuccess(agnosticSymbol))),
        catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  changeSymbolBoundingBox$ = this.actions$.pipe(
    ofType<ChangeSymbolBoundingBox>(AgnosticRepresentationActionTypes.ChangeSymbolBoundingBox),
    switchMap((action: ChangeSymbolBoundingBox) =>
      this.agnosticRepresentationService.changeSymbolBoundingBox$(action.agnosticSymbol,
        action.boundingBox.fromX, action.boundingBox.fromY,
        action.boundingBox.toX, action.boundingBox.toY).pipe(
    switchMap((agnosticSymbol: AgnosticSymbol) => of(new ChangeSymbolSuccess(agnosticSymbol))),
        catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  changeSymbolComments$ = this.actions$.pipe(
    ofType<ChangeSymbolComments>(AgnosticRepresentationActionTypes.ChangeSymbolComments),
    switchMap((action: ChangeSymbolComments) =>
      this.agnosticRepresentationService.changeSymbolComments$(action.agnosticSymbol,
        action.comments).pipe(
    switchMap((agnosticSymbol: AgnosticSymbol) => of(new ChangeSymbolSuccess(agnosticSymbol))),
        catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  createSymbolFromBoundingBox$ = this.actions$.pipe(
    ofType<CreateSymbolFromBoundingBox>(AgnosticRepresentationActionTypes.CreateSymbolFromBoundingBox),
    switchMap((action: CreateSymbolFromBoundingBox) =>
      this.agnosticRepresentationService.createSymbolFromBoundingBox$(action.modelID, action.regionID, action.boundingBox,
        action.agnosticSymbolType, action.positionInStaff).pipe(
    switchMap((symbolCreationResult: SymbolCreationResult) => of(new CreateSymbolSuccess(symbolCreationResult))),
        catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  createSymbolFromStrokes$ = this.actions$.pipe(
    ofType<CreateSymbolFromStrokes>(AgnosticRepresentationActionTypes.CreateSymbolFromStrokes),
    switchMap((action: CreateSymbolFromStrokes) =>
      this.agnosticRepresentationService.createSymbolFromStrokes$(action.modelID, action.regionID, action.points,
        action.agnosticSymbolType, action.positionInStaff).pipe(
    switchMap((symbolCreationResult: SymbolCreationResult) => of(new CreateSymbolSuccess(symbolCreationResult))),
        catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

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
  /**
   * Replaced switchMap for mergeMag to avoid sending the event twice
   */
  @Effect()
  deleteSymbol$ = this.actions$.pipe(
    ofType<DeleteSymbol>(AgnosticRepresentationActionTypes.DeleteSymbol),
    mergeMap((action: DeleteSymbol) =>
      this.agnosticRepresentationService.deleteSymbol$(action.agnosticSymbolID).pipe(
    switchMap((deletedSymbolID: number) => of(new DeleteSymbolSuccess(deletedSymbolID))),
      catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
    )));

  @Effect()
  classifyRegionEndToEnd$ = this.actions$.pipe(
    ofType<ClassifyRegionEndToEnd>(AgnosticRepresentationActionTypes.ClassifyRegionEndToEnd),
    switchMap((action: ClassifyRegionEndToEnd) =>
      this.agnosticRepresentationService.classifyRegionEndToEnd$(action.modelID, action.regionID).pipe(
    switchMap((classifiedSymbols: AgnosticSymbol[]) => of(new ClassifyRegionEndToEndSuccess(classifiedSymbols))),
        catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  clearRegionSymbols$ = this.actions$.pipe(
    ofType<ClearRegionSymbols>(AgnosticRepresentationActionTypes.ClearRegionSymbols),
    switchMap((action: ClearRegionSymbols) =>
      this.agnosticRepresentationService.clearRegionSymbols$(action.regionID).pipe(
        switchMap((deleted: boolean) => of(new ClearRegionSymbolsSuccess(deleted))), // it should always return true
        catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  getSymbolClassifierModels$ = this.actions$.pipe(
    ofType<GetSymbolClassifierModels>(AgnosticRepresentationActionTypes.GetSymbolClassifierModels),
    switchMap((action: GetSymbolClassifierModels) =>
      this.agnosticRepresentationService.getSymbolClassifierModel$(
        action.imageID).pipe(
        // action.collectionID, action.documentID, action.notationType, action.manuscriptType)),
    switchMap((models: ClassifierModel[]) => of(new GetSymbolClassifierModelsSuccess(models))),
        catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  GetAgnosticEnd2EndClassifierModels = this.actions$.pipe(
    ofType<GetAgnosticEnd2EndClassifierModels>(AgnosticRepresentationActionTypes.GetAgnosticEnd2EndClassifierModels),
    switchMap((action: GetAgnosticEnd2EndClassifierModels) =>
      this.agnosticRepresentationService.getAgnosticEnd2EndClassifierModel$(
        action.imageID).pipe(
        // action.collectionID, action.documentID, action.notationType, action.manuscriptType)),
    switchMap((models: ClassifierModel[]) => of(new GetAgnosticEnd2EndClassifierModelsSuccess(models))),
        catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));
}
