import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {DocumentAnalysisActionTypes} from '../../../document-analysis/store/actions/document-analysis.actions';
import {Accion, AccionSuccess, AgnosticRepresentationActionTypes} from '../actions/agnostic-representation.actions';
import {AgnosticRepresentationService} from '../../services/agnostic-representation.service';

@Injectable()
export class AgnosticRepresentationEffects {
  constructor(
    private agnosticRepresentationService: AgnosticRepresentationService,
    private actions$: Actions,
  ) {}

  @Effect()
  accion$ = this.actions$.pipe(
    ofType<Accion>(AgnosticRepresentationActionTypes.Accion),
    map((action: Accion) => action.payload),
    switchMap((parametro) => this.agnosticRepresentationService.hazAccion$(parametro)),
    switchMap((resultado: any) => {
      return of(new AccionSuccess(resultado));
    })
  );
}
