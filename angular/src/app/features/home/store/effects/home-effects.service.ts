import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';
import {HomeService} from "../../services/home.service";
import {
  HomeGetLastDocuments,
  HomeGetLastDocumentsSuccess,
  HomeActionTypes,
  HomeServerError,
  HomeUpdateLastDocuments, HomeUpdateLastDocumentsSuccess
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
    ofType<HomeGetLastDocuments>(HomeActionTypes.HomeGetLastDocuments),
    switchMap((action: HomeGetLastDocuments) => this.homeService.getUserLastDocuments$(action.userID, action.count).pipe(
      switchMap((lastDocuments: LastDocumentExtract[]) => of(new HomeGetLastDocumentsSuccess(lastDocuments))),
      catchError(err => of(new HomeServerError(err)))
    )));

  @Effect()
  updateUserLastDocument$ = this.actions$.pipe(
    ofType<HomeUpdateLastDocuments>(HomeActionTypes.HomeUpdateLastDocuments),
    switchMap((action: HomeUpdateLastDocuments) => this.homeService.updateUserLastDocument$(action.userID, action.documentID).pipe(
      switchMap((lastDocument: LastDocumentExtract) => of(new HomeUpdateLastDocumentsSuccess(lastDocument))),
      catchError(err => of(new HomeServerError(err)))
    )));
}
