import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {UserService} from '../../../core/services/user.service';
import {TrainingSetExporterService} from './training-set-exporter.service';
import {TrainingSetExporter} from '../../../core/model/restapi/training-set-exporter';

@Injectable() // non-singleton
export class ExporterService {
  constructor(private userService: UserService, private trainingSetExporterService: TrainingSetExporterService) { }

  /*private getAllDocumentsOfUser(user: User): Document[] {
    const result = [...user.documentsCreated , ...user.permissions.map((permission) => permission.document)];
    return result;
  }*/

  downloadTrainingSet$(exporterIndex: number, documentIDS: number[]): Observable<Blob> {
    return this.trainingSetExporterService.download(exporterIndex, documentIDS);
  }

  getTrainingSetExporters$(): Observable<TrainingSetExporter[]> {
    return this.trainingSetExporterService.getTrainingSetExporters();
  }
}
