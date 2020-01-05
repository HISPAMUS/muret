import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import { switchMap} from 'rxjs/operators';
import {SemanticRepresentationService} from '../../services/semantic-representation.service';
import {
  ConvertAgnostic2Semantic,
  ConvertAgnostic2SemanticSuccess, GetNotation, GetNotationSuccess,
  SemanticRepresentationActionTypes, SendSemanticEncoding, SendSemanticEncodingSuccess
} from '../actions/semantic-representation.actions';
import {Notation} from '../../services/notation';

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
      this.semanticRepresentationService.agnostic2Semantic$(action.region, action.mensustriche, action.renderer)),
    switchMap((notation: Notation) => {
      return of(new ConvertAgnostic2SemanticSuccess(notation));
    })
  );

  @Effect()
  getNotation$ = this.actions$.pipe(
    ofType<GetNotation>(SemanticRepresentationActionTypes.GetNotation),
    switchMap((action: GetNotation) =>
      this.semanticRepresentationService.getNotation$(action.region, action.mensustriche, action.renderer)),
    switchMap((notation: Notation) => {
      return of(new GetNotationSuccess(notation));
    })
  );

  @Effect()
  sendSemanticEncoding$ = this.actions$.pipe(
    ofType<SendSemanticEncoding>(SemanticRepresentationActionTypes.SendSemanticEncoding),
    switchMap((action: SendSemanticEncoding) =>
      this.semanticRepresentationService.sendSemanticEncoding$(action.region, action.semanticEncoding,
        action.mensustriche, action.renderer)),
    switchMap((notation: Notation) => {
      return of(new SendSemanticEncodingSuccess(notation));
    })
  );

}
