import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import { switchMap} from 'rxjs/operators';
import {NewProjectService} from '../../new-project.service';
import {
  CreateProject,
  CreateProjectSuccess,
  GetCollections,
  GetCollectionsSuccess,
  NewProjectActionTypes
} from '../actions/new-project.actions';
import {Project} from '../../../../core/model/entities/project';
import {Collection} from '../../../../core/model/entities/collection';

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
      action.manuscriptType, action.comments, action.imgSrc, action.collectionID)),
    switchMap((project: Project) => {
      return of(new CreateProjectSuccess(project));
    })
  );
  @Effect()
  getCollections$ = this.actions$.pipe(
    ofType<GetCollections>(NewProjectActionTypes.GetCollections),
    switchMap((action: GetCollections) =>
      this.newProjectService.getCollections$()),
    switchMap((collections: Collection[]) => {
      return of(new GetCollectionsSuccess(collections));
    })
  );
}
