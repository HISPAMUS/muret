import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {
  GetTrainingSetExporters,
  GetTrainingSetExportersSuccess,
  ExportActionTypes, ExportServerError, DownloadTrainingSet, DownloadTrainingSetSuccess
} from '../actions/export.actions';
import {ExporterService} from '../../services/exporter.service';
import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';

@Injectable()
export class ExportEffects {
  constructor(
    private exporterService: ExporterService,
    private actions$: Actions,
  ) {}


  @Effect()
  getTrainingSetExporters$ = this.actions$.pipe(
    ofType<GetTrainingSetExporters>(ExportActionTypes.GetTrainingSetExporters),
    switchMap(() => this.exporterService.getTrainingSetExporters$().pipe(
      switchMap((trainingSetExporters: TrainingSetExporter[]) => of(new GetTrainingSetExportersSuccess(trainingSetExporters))),
      catchError(err => of(new ExportServerError(err)))
    )));

  @Effect()
  downloadTrainingSet$ = this.actions$.pipe(
    ofType<DownloadTrainingSet>(ExportActionTypes.DownloadTrainingSet),
    switchMap((action: DownloadTrainingSet) =>
      this.exporterService.downloadTrainingSet$(action.exporterIndex, action.documentIDS).pipe(
      switchMap((exportedBlob) => of(new DownloadTrainingSetSuccess(exportedBlob))),
      catchError(err => of(new ExportServerError(err)))
    )));

}
