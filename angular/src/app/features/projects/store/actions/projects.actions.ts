import { Action } from '@ngrx/store';
import {Collection} from '../../../../core/model/entities/collection';

export enum ProjectsActionTypes {
  GetCollection = '[Projects] Get collection',
  GetCollectionSuccess = '[Projects] Get collection success',
}

export class GetCollection implements Action {
  public readonly type = ProjectsActionTypes.GetCollection;
  constructor(public collectionID: number) {}
}

export class GetCollectionSuccess implements Action {
  public readonly type = ProjectsActionTypes.GetCollectionSuccess;
  constructor(public collection: Collection) {}
}


export type ProjectsActions =
  GetCollection | GetCollectionSuccess;
