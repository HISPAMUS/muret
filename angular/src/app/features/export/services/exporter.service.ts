import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {UserService} from '../../../core/services/user.service';
import {TrainingSetExporter} from '../../../core/model/restapi/training-set-exporter';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';

@Injectable() // non-singleton
export class ExporterService {
  constructor(private userService: UserService, private apiRestClientService: ApiRestClientService) { }

  /*private getAllDocumentsOfUser(user: User): Document[] {
    const result = [...user.documentsCreated , ...user.permissions.map((permission) => permission.document)];
    return result;
  }*/

  downloadTrainingSet$(exporterIndex: number, documentIDS: number[]): Observable<Blob> {
    const documentIdsString = documentIDS.join(',');
    return this.apiRestClientService.getBlob$('trainingsets/download/' + exporterIndex + '/' + documentIdsString);
  }

  getTrainingSetExporters$(): Observable<TrainingSetExporter[]> {
    return this.apiRestClientService.getList$<TrainingSetExporter>('trainingsets/exporters');
  }
}
