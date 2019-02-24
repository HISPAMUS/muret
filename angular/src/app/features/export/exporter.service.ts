import { Injectable } from '@angular/core';
import {Project} from '../../shared/entities/project';
import {Observable} from 'rxjs';
import {User} from '../../shared/entities/user';
import {map} from 'rxjs/operators';
import {UserService} from '../../shared/services/user.service';
import {TrainingSetExporterService} from './training-set-exporter.service';
import {TrainingSetExporter} from '../../shared/entities/training-set-exporter';

@Injectable() // non-singleton
export class ExporterService {
  constructor(private userService: UserService, private trainingSetExporterService: TrainingSetExporterService) { }

  public getUserAuthorizedProjects(): Observable<Project[]> {
    return this.userService.getCurrentUserProjection().pipe(
      map((data: User) => this.getAllProjectsOfUser(data))
    );
  }

  private getAllProjectsOfUser(user: User): Project[] {
    const result = [...user.projectsCreated , ...user.permissions.map((permission) => permission.project)];
    return result;
  }

  downloadTrainingSet$(exporterIndex: number, projectIDS: number[]): Observable<Blob> {
    return this.trainingSetExporterService.download(exporterIndex, projectIDS);
  }

  getTrainingSetExporters(): Observable<TrainingSetExporter[]> {
    return this.trainingSetExporterService.getTrainingSetExporters();
  }
}
