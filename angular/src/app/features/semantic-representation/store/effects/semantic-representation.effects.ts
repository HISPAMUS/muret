import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {DocumentAnalysisActionTypes} from '../../../document-analysis/store/actions/document-analysis.actions';
import {Accion, AccionSuccess, SemanticRepresentationActionTypes} from '../actions/semantic-representation.actions';
import {SemanticRepresentationService} from '../../services/semantic-representation.service';

@Injectable()
export class SemanticRepresentationEffects {
  constructor(
    private semanticRepresentationService: SemanticRepresentationService,
    private actions$: Actions,
  ) {}

  @Effect()
  accion$ = this.actions$.pipe(
    ofType<Accion>(SemanticRepresentationActionTypes.Accion),
    map((action: Accion) => action.payload),
    switchMap((parametro) => this.semanticRepresentationService.hazAccion$(parametro)),
    switchMap((resultado: any) => {
      return of(new AccionSuccess(resultado));
    })
  );
}
