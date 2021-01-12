import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {SemanticRepresentationService} from '../../services/semantic-representation.service';
import {
  ConvertAgnostic2Semantic,
  ConvertAgnostic2SemanticSuccess,
  GetNotation,
  GetNotationSuccess,
  SemanticRepresentationActionTypes,
  SendSemanticEncoding,
  SendSemanticEncodingSuccess,
  GetTranslationModels,
  GetTranslationModelsSuccess,
  SemanticRepresentationServerError, ChangeNotationType, ChangeNotationTypeSuccess
} from '../actions/semantic-representation.actions';
import {Notation} from '../../services/notation';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';
import {Region} from "../../../../core/model/entities/region";

@Injectable()
export class SemanticRepresentationEffects {
  constructor(
    private semanticRepresentationService: SemanticRepresentationService,
    private actions$: Actions,
  ) {}


  @Effect()
  convertAgnostic2Semantic$ = this.actions$.pipe(
    ofType<ConvertAgnostic2Semantic>(SemanticRepresentationActionTypes.ConvertAgnostic2Semantic),
    switchMap((action: ConvertAgnostic2Semantic) =>
      this.semanticRepresentationService.agnostic2Semantic$(action.region, action.mensustriche, action.renderer).pipe(
    switchMap((notation: Notation) => of(new ConvertAgnostic2SemanticSuccess(notation))),
        catchError(err => of(new SemanticRepresentationServerError(err)))
      )));

  @Effect()
  getNotation$ = this.actions$.pipe(
    ofType<GetNotation>(SemanticRepresentationActionTypes.GetNotation),
    switchMap((action: GetNotation) =>
      this.semanticRepresentationService.getNotation$(action.region, action.mensustriche, action.renderer).pipe(
    switchMap((notation: Notation) => of(new GetNotationSuccess(notation))),
        catchError(err => of(new SemanticRepresentationServerError(err)))
      )));

  @Effect()
  sendSemanticEncoding$ = this.actions$.pipe(
    ofType<SendSemanticEncoding>(SemanticRepresentationActionTypes.SendSemanticEncoding),
    switchMap((action: SendSemanticEncoding) =>
      this.semanticRepresentationService.sendSemanticEncoding$(action.region, action.semanticEncoding,
        action.mensustriche, action.renderer).pipe(
    switchMap((notation: Notation) => of(new SendSemanticEncodingSuccess(notation))),
        catchError(err => of(new SemanticRepresentationServerError(err)))
      )));

  @Effect()
  getTranslationModels$ = this.actions$.pipe(
    ofType<GetTranslationModels>(SemanticRepresentationActionTypes.GetTranslationModels),
    switchMap((action: GetTranslationModels) =>
      this.semanticRepresentationService.getTranslationModels$(action.imageID).pipe(
      switchMap((translationModels: ClassifierModel[]) => of(new GetTranslationModelsSuccess(translationModels))),
        catchError(err => of(new SemanticRepresentationServerError(err)))
      )));

  @Effect()
  changeNotationType$ = this.actions$.pipe(
    ofType<ChangeNotationType>(SemanticRepresentationActionTypes.ChangeNotationType),
    switchMap((action: ChangeNotationType) =>
      this.semanticRepresentationService.changeNotationType$(action.region.id, action.notationType).pipe(
        switchMap((region: Region) => of(new ChangeNotationTypeSuccess(region))),
        catchError(err => of(new SemanticRepresentationServerError(err)))
      )));

}
