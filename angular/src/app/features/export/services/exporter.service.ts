import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {UserService} from '../../../core/services/user.service';
import {TrainingSetExporterService} from './training-set-exporter.service';
import {TrainingSetExporter} from '../../../core/model/restapi/training-set-exporter';

@Injectable() // non-singleton
export class ExporterService {
  constructor(private userService: UserService, private trainingSetExporterService: TrainingSetExporterService) { }

  /*private getAllProjectsOfUser(user: User): Project[] {
    const result = [...user.projectsCreated , ...user.permissions.map((permission) => permission.project)];
    return result;
  }*/

  downloadTrainingSet$(exporterIndex: number, projectIDS: number[]): Observable<Blob> {
    return this.trainingSetExporterService.download(exporterIndex, projectIDS);
  }

  getTrainingSetExporters$(): Observable<TrainingSetExporter[]> {
    return this.trainingSetExporterService.getTrainingSetExporters();
  }
}
