import { Action } from '@ngrx/store';
import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';

export enum ExportActionTypes {
  GetTrainingSetExporters = '[Export] Get training set exporters',
  GetTrainingSetExportersSuccess = '[Export] Get training set exporters success',
  DownloadTrainingSet = '[Export] Download training set',
  DownloadTrainingSetSuccess = '[Export] Download training set success',
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
  constructor(public exporterIndex: number, public projectIDS: number[]) {}
}

export class DownloadTrainingSetSuccess implements Action {
  public readonly type = ExportActionTypes.DownloadTrainingSetSuccess;
  constructor(public payload: Blob) {}
}

export type ExportActions =
  GetTrainingSetExporters | GetTrainingSetExportersSuccess | DownloadTrainingSet | DownloadTrainingSetSuccess;
