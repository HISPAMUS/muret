import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {TrainingSetExporter} from '../../shared/entities/training-set-exporter';
import {ApiRestClientService} from '../../shared/services/api-rest-client.service';

@Injectable()
export class TrainingSetExporterService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public getTrainingSetExporters(): Observable<TrainingSetExporter[]> {
    return this.apiRestClientService.getList$<TrainingSetExporter>('trainingsets/exporters');
  }

  public download(exporterIndex: number, projectIds: number[]): Observable<Blob> {
    const projectIdsString = projectIds.join(',');
    return this.apiRestClientService.getBlob$('trainingsets/download/' + exporterIndex + '/' + projectIdsString);
  }
}
