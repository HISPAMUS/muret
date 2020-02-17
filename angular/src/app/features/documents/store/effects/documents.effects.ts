import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import {Observable, of} from 'rxjs';
import {catchError, map, switchMap} from 'rxjs/operators';
import {
  GetCollection,
  GetCollectionSuccess,
  DocumentsActionTypes,
  CreateSubcollection,
  CreateSubcollectionSuccess,
  DeleteSubcollection,
  DeleteSubcollectionSuccess,
  MoveDocumentsToSubcollection,
  MoveDocumentsToSubcollectionSuccess, MoveDocumentsToNewSubcollection, MoveDocumentsToNewSubcollectionSuccess, DocumentsServerError
} from '../actions/documents.actions';
import {Collection} from '../../../../core/model/entities/collection';
import {DocumentsService} from '../../services/documents.service';
import {Action} from '@ngrx/store';

@Injectable()
export class DocumentsEffects {
  constructor(
    private documentsService: DocumentsService,
    private actions$: Actions,
  ) {}

  @Effect()
  getCollection$: Observable<Action> = this.actions$.pipe(
    ofType<GetCollection>(DocumentsActionTypes.GetCollection),
    switchMap((action: GetCollection) => this.documentsService.getCollection$(action.collectionID).pipe(
      switchMap((collection: Collection) => of(new GetCollectionSuccess(collection))),
      catchError(err => of(new DocumentsServerError(err)))
    )));

  @Effect()
  createSubcollection$: Observable<Action> = this.actions$.pipe(
    ofType<CreateSubcollection>(DocumentsActionTypes.CreateSubcollection),
    switchMap((action: CreateSubcollection) =>
      this.documentsService.createSubcollection$(action.parentID, action.name).pipe(
      switchMap((collection: Collection) => of(new CreateSubcollectionSuccess(collection))),
      catchError(err => of(new DocumentsServerError(err)))
    )));

  @Effect()
  deleteSubcollection$: Observable<Action> = this.actions$.pipe(
    ofType<DeleteSubcollection>(DocumentsActionTypes.DeleteSubcollection),
    switchMap((action: DeleteSubcollection) =>
      this.documentsService.deleteSubcollection$(action.id).pipe(
      switchMap((deletedCollectionID: number) => of(new DeleteSubcollectionSuccess(deletedCollectionID))),
        catchError(err => of(new DocumentsServerError(err)))
      )));

  @Effect()
  moveDocumentsToSubcollection$: Observable<Action> = this.actions$.pipe(
    ofType<MoveDocumentsToSubcollection>(DocumentsActionTypes.MoveDocumentsToSubcollection),
    switchMap((action: MoveDocumentsToSubcollection) =>
      this.documentsService.moveDocumentsToSubcollection$(action.currentCollectionID, action.documentIDs, action.subcollectionID).pipe(
      switchMap((changedCollectionID: number) => of(new MoveDocumentsToSubcollectionSuccess(changedCollectionID))),
        catchError(err => of(new DocumentsServerError(err)))
      )));

  @Effect()
  moveDocumentsToNewSubcollection$: Observable<Action> = this.actions$.pipe(
    ofType<MoveDocumentsToNewSubcollection>(DocumentsActionTypes.MoveDocumentsToNewSubcollection),
    switchMap((action: MoveDocumentsToNewSubcollection) =>
      this.documentsService.moveDocumentsToNewSubcollection$(action.currentCollectionID, action.documentIDs, action.subCollectionName).pipe(
      switchMap((changedCollectionID: number) => of(new MoveDocumentsToNewSubcollectionSuccess(changedCollectionID))),
        catchError(err => of(new DocumentsServerError(err)))
      )));
}
