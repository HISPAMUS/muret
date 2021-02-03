import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';
import {HomeService} from "../../services/home.service";
import {
  GetLastDocuments,
  GetLastDocumentsSuccess,
  HomeActionTypes,
  HomeServerError,
  UpdateLastDocuments, UpdateLastDocumentsSuccess
} from "../actions/home.actions";
import {LastDocumentExtract} from "../../model/last-document-extract";

@Injectable()
export class HomeEffects {
  constructor(
    private homeService: HomeService,
    private actions$: Actions,
  ) {}


  @Effect()
  getUserLastDocuments$ = this.actions$.pipe(
    ofType<GetLastDocuments>(HomeActionTypes.GetLastDocuments),
    switchMap((action: GetLastDocuments) => this.homeService.getUserLastDocuments$(action.userID, action.count).pipe(
      switchMap((lastDocuments: LastDocumentExtract[]) => of(new GetLastDocumentsSuccess(lastDocuments))),
      catchError(err => of(new HomeServerError(err)))
    )));

  @Effect()
  updateUserLastDocument$ = this.actions$.pipe(
    ofType<UpdateLastDocuments>(HomeActionTypes.UpdateLastDocuments),
    switchMap((action: UpdateLastDocuments) => this.homeService.updateUserLastDocument$(action.userID, action.documentID).pipe(
      switchMap((lastDocument: LastDocumentExtract) => of(new UpdateLastDocumentsSuccess(lastDocument))),
      catchError(err => of(new HomeServerError(err)))
    )));
}
