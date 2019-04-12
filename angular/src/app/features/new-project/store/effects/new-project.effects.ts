import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import { switchMap} from 'rxjs/operators';
import {NewProjectService} from '../../new-project.service';
import {CreateProject, CreateProjectSuccess, NewProjectActionTypes} from '../actions/new-project.actions';
import {Project} from '../../../../core/model/entities/project';

@Injectable()
export class NewProjectEffects {
  constructor(
    private newProjectService: NewProjectService,
    private actions$: Actions,
  ) {}

  @Effect()
  createProject$ = this.actions$.pipe(
    ofType<CreateProject>(NewProjectActionTypes.CreateProject),
    switchMap((action: CreateProject) =>
      this.newProjectService.newProject$(action.user, action.name, action.composer, action.notationType,
      action.manuscriptType, action.comments, action.imgSrc)),
    switchMap((project: Project) => {
      return of(new CreateProjectSuccess(project));
    })
  );

}
