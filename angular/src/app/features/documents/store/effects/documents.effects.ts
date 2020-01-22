import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {
  GetCollection,
  GetCollectionSuccess,
  DocumentsActionTypes,
  CreateSubcollection,
  CreateSubcollectionSuccess,
  DeleteSubcollection,
  DeleteSubcollectionSuccess,
  MoveDocumentsToSubcollection,
  MoveDocumentsToSubcollectionSuccess, MoveDocumentsToNewSubcollection, MoveDocumentsToNewSubcollectionSuccess
} from '../actions/documents.actions';
import {Collection} from '../../../../core/model/entities/collection';
import {DocumentsService} from '../../services/documents.service';

@Injectable()
export class DocumentsEffects {
  constructor(
    private documentsService: DocumentsService,
    private actions$: Actions,
  ) {}

  @Effect()
  getCollection$ = this.actions$.pipe(
    ofType<GetCollection>(DocumentsActionTypes.GetCollection),
    map((action: GetCollection) => action.collectionID),
    switchMap((collectionID) => this.documentsService.getCollection$(collectionID)),
    switchMap((collection: Collection) => {
      return of(new GetCollectionSuccess(collection));
    })
  );

  @Effect()
  createSubcollection$ = this.actions$.pipe(
    ofType<CreateSubcollection>(DocumentsActionTypes.CreateSubcollection),
    switchMap((action: CreateSubcollection) =>
      this.documentsService.createSubcollection$(action.parentID, action.name)),
    switchMap((collection: Collection) => {
      return of(new CreateSubcollectionSuccess(collection));
    })
  );

  @Effect()
  deleteSubcollection$ = this.actions$.pipe(
    ofType<DeleteSubcollection>(DocumentsActionTypes.DeleteSubcollection),
    switchMap((action: DeleteSubcollection) =>
      this.documentsService.deleteSubcollection$(action.id)),
    switchMap((deletedCollectionID: number) => {
      return of(new DeleteSubcollectionSuccess(deletedCollectionID));
    })
  );
  @Effect()
  moveDocumentsToSubcollection$ = this.actions$.pipe(
    ofType<MoveDocumentsToSubcollection>(DocumentsActionTypes.MoveDocumentsToSubcollection),
    switchMap((action: MoveDocumentsToSubcollection) =>
      this.documentsService.moveDocumentsToSubcollection$(action.currentCollectionID, action.documentIDs, action.subcollectionID)),
    switchMap((changedCollectionID: number) => {
      return of(new MoveDocumentsToSubcollectionSuccess(changedCollectionID));
    })
  );
  @Effect()
  moveDocumentsToNewSubcollection$ = this.actions$.pipe(
    ofType<MoveDocumentsToNewSubcollection>(DocumentsActionTypes.MoveDocumentsToNewSubcollection),
    switchMap((action: MoveDocumentsToNewSubcollection) =>
      this.documentsService.moveDocumentsToNewSubcollection$(action.currentCollectionID, action.documentIDs, action.subCollectionName)),
    switchMap((changedCollectionID: number) => {
      return of(new MoveDocumentsToNewSubcollectionSuccess(changedCollectionID));
    })
  );
}
