import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {GetCollection, GetCollectionSuccess, ProjectsActionTypes} from '../actions/projects.actions';
import {Collection} from '../../../../core/model/entities/collection';
import {ProjectsService} from '../../services/projects.service';

@Injectable()
export class ProjectsEffects {
  constructor(
    private projectsService: ProjectsService,
    private actions$: Actions,
  ) {}

  @Effect()
  getCollection$ = this.actions$.pipe(
    ofType<GetCollection>(ProjectsActionTypes.GetCollection),
    map((action: GetCollection) => action.collectionID),
    switchMap((collectionID) => this.projectsService.getCollection$(collectionID)),
    switchMap((collection: Collection) => {
      return of(new GetCollectionSuccess(collection));
    })
  );
}
