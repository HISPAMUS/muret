import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {ProjectService} from '../../services/project.service';
import {GetImages, GetImagesSuccess, GetProject, GetProjectSuccess, ProjectActionTypes} from '../actions/project.actions';
import {Project} from '../../../../core/model/entities/project';
import {Image} from '../../../../core/model/entities/image';

@Injectable()
export class ProjectEffects {
  constructor(
    private projectService: ProjectService,
    private actions$: Actions,
  ) {}

  @Effect()
  getProject$ = this.actions$.pipe(
    ofType<GetProject>(ProjectActionTypes.GetProject),
    map((action: GetProject) => action.projectID),
    switchMap((projectID) => this.projectService.getProject$(projectID)),
    switchMap((project: Project) => {
      return of(new GetProjectSuccess(project));
    })
  );

  @Effect()
  getImages$ = this.actions$.pipe(
    ofType<GetImages>(ProjectActionTypes.GetImages),
    map((action: GetImages) => action.projectID),
    switchMap((projectID) => this.projectService.getProjectImages$(projectID)),
    switchMap((images: Image[]) => {
      return of(new GetImagesSuccess(images));
    })
  );

}
