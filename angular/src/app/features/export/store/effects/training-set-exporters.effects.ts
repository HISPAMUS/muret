import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import {
  GetTrainingSetExporters,
  GetTrainingSetExportersSuccess,
  ExportActionTypes
} from '../actions/export.actions';
import {ExporterService} from '../../services/exporter.service';
import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';

@Injectable()
export class TrainingSetExportersEffects {
  constructor(
    private exporterService: ExporterService,
    private actions$: Actions,
  ) {}


  @Effect()
  getUsers$ = this.actions$.pipe(
    ofType<GetTrainingSetExporters>(ExportActionTypes.GetTrainingSetExporters),
    switchMap(() => this.exporterService.getTrainingSetExporters$()),
    switchMap((trainingSetExporters: TrainingSetExporter[]) => {
      return of(new GetTrainingSetExportersSuccess(trainingSetExporters));
    })
  );
}
