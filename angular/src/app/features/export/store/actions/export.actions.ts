import { Action } from '@ngrx/store';
import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export enum ExportActionTypes {
  ExportServerError = '[Export] Export server error',
  GetTrainingSetExporters = '[Export] Get training set exporters',
  GetTrainingSetExportersSuccess = '[Export] Get training set exporters success',
  DownloadTrainingSet = '[Export] Download training set',
  DownloadTrainingSetSuccess = '[Export] Download training set success',
}

export class ExportServerError implements Action {
  public readonly type = ExportActionTypes.ExportServerError;
  constructor(public serverError: APIRestServerError) {}
}

export class GetTrainingSetExporters implements Action {
  public readonly type = ExportActionTypes.GetTrainingSetExporters;
}

export class GetTrainingSetExportersSuccess implements Action {
  public readonly type = ExportActionTypes.GetTrainingSetExportersSuccess;
  constructor(public payload: TrainingSetExporter[]) {}
}


export class DownloadTrainingSet implements Action {
  public readonly type = ExportActionTypes.DownloadTrainingSet;
  constructor(public exporterIndex: number, public documentIDS: number[]) {}
}

export class DownloadTrainingSetSuccess implements Action {
  public readonly type = ExportActionTypes.DownloadTrainingSetSuccess;
  constructor(public payload: Blob) {}
}

export type ExportActions =
  ExportServerError |
  GetTrainingSetExporters | GetTrainingSetExportersSuccess | DownloadTrainingSet | DownloadTrainingSetSuccess;
