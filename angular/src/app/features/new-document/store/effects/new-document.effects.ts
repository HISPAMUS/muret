import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import { switchMap} from 'rxjs/operators';
import {NewDocumentService} from '../../new-document.service';
import {
  CreateDocument,
  CreateDocumentSuccess,
  GetCollections,
  GetCollectionsSuccess,
  NewDocumentActionTypes
} from '../actions/new-document.actions';
import {Document} from '../../../../core/model/entities/document';
import {Collection} from '../../../../core/model/entities/collection';

@Injectable()
export class NewDocumentEffects {
  constructor(
    private newDocumentService: NewDocumentService,
    private actions$: Actions,
  ) {}

  @Effect()
  createDocument$ = this.actions$.pipe(
    ofType<CreateDocument>(NewDocumentActionTypes.CreateDocument),
    switchMap((action: CreateDocument) =>
      this.newDocumentService.newDocument$(action.user, action.name, action.composer, action.notationType,
      action.manuscriptType, action.comments, action.imgSrc, action.collectionID)),
    switchMap((document: Document) => {
      return of(new CreateDocumentSuccess(document));
    })
  );
  @Effect()
  getCollections$ = this.actions$.pipe(
    ofType<GetCollections>(NewDocumentActionTypes.GetCollections),
    switchMap((action: GetCollections) =>
      this.newDocumentService.getCollections$()),
    switchMap((collections: Collection[]) => {
      return of(new GetCollectionsSuccess(collections));
    })
  );
}
