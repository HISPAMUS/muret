import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {Accion, AccionSuccess, SampleActionTypes} from '../actions/sample.actions';
import {SampleService} from '../../services/sample.service';

@Injectable()
export class SampleEffects {
  constructor(
    private sampleService: SampleService,
    private actions$: Actions,
  ) {}

  @Effect()
  accion$ = this.actions$.pipe(
    ofType<Accion>(SampleActionTypes.Accion),
    map((action: Accion) => action.payload),
    switchMap((parametro) => this.sampleService.hazAccion$(parametro)),
    switchMap((resultado: any) => {
      return of(new AccionSuccess(resultado));
    })
  );

/*  @Effect()
  deletePage$ = this.actions$.pipe(
      ofType<DeletePage>(DocumentAnalysisActionTypes.DeletePage),
      switchMap((action: DeletePage) => this.documentAnalysisService.deletePage(action.pageID)),
      switchMap((deletedPageID: number) => {
        return of(new DeletePageSuccess(deletedPageID));
      })
  );*/

}
