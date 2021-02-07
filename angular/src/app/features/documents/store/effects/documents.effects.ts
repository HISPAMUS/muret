import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import {Observable, of} from 'rxjs';
import {catchError, map, switchMap} from 'rxjs/operators';
import {
  DocumentsGetCollection,
  DocumentsGetCollectionSuccess,
  DocumentsActionTypes,
  DocumentsCreateSubcollection,
  DocumentsCreateSubcollectionSuccess,
  DocumentsDeleteSubcollection,
  DocumentsDeleteSubcollectionSuccess,
  DocumentsMoveDocumentsToSubcollection,
  DocumentsMoveDocumentsToSubcollectionSuccess, DocumentsMoveDocumentsToNewSubcollection, DocumentsMoveDocumentsToNewSubcollectionSuccess, DocumentsServerError
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
    ofType<DocumentsGetCollection>(DocumentsActionTypes.DocumentsGetCollection),
    switchMap((action: DocumentsGetCollection) => this.documentsService.getCollection$(action.collectionID).pipe(
      switchMap((collection: Collection) => of(new DocumentsGetCollectionSuccess(collection))),
      catchError(err => of(new DocumentsServerError(err)))
    )));

  @Effect()
  createSubcollection$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentsCreateSubcollection>(DocumentsActionTypes.DocumentsCreateSubcollection),
    switchMap((action: DocumentsCreateSubcollection) =>
      this.documentsService.createSubcollection$(action.parentID, action.name).pipe(
      switchMap((collection: Collection) => of(new DocumentsCreateSubcollectionSuccess(collection))),
      catchError(err => of(new DocumentsServerError(err)))
    )));

  @Effect()
  deleteSubcollection$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentsDeleteSubcollection>(DocumentsActionTypes.DocumentsDeleteSubcollection),
    switchMap((action: DocumentsDeleteSubcollection) =>
      this.documentsService.deleteSubcollection$(action.id).pipe(
      switchMap((deletedCollectionID: number) => of(new DocumentsDeleteSubcollectionSuccess(deletedCollectionID))),
        catchError(err => of(new DocumentsServerError(err)))
      )));

  @Effect()
  moveDocumentsToSubcollection$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentsMoveDocumentsToSubcollection>(DocumentsActionTypes.DocumentsMoveDocumentsToSubcollection),
    switchMap((action: DocumentsMoveDocumentsToSubcollection) =>
      this.documentsService.moveDocumentsToSubcollection$(action.currentCollectionID, action.documentIDs, action.subcollectionID).pipe(
      switchMap((changedCollectionID: number) => of(new DocumentsMoveDocumentsToSubcollectionSuccess(changedCollectionID))),
        catchError(err => of(new DocumentsServerError(err)))
      )));

  @Effect()
  moveDocumentsToNewSubcollection$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentsMoveDocumentsToNewSubcollection>(DocumentsActionTypes.DocumentsMoveDocumentsToNewSubcollection),
    switchMap((action: DocumentsMoveDocumentsToNewSubcollection) =>
      this.documentsService.moveDocumentsToNewSubcollection$(action.currentCollectionID, action.documentIDs, action.subCollectionName).pipe(
      switchMap((changedCollectionID: number) => of(new DocumentsMoveDocumentsToNewSubcollectionSuccess(changedCollectionID))),
        catchError(err => of(new DocumentsServerError(err)))
      )));
}
