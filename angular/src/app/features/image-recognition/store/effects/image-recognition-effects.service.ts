import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {ImageOverviewService} from "../../services/image-overview.service";
import {
  ImageRecognitionActionTypes,
  ImageRecognitionGetImageOverview,
  ImageRecognitionGetImageOverviewSuccess,
  ImageRecognitionGetPagesRegionsSymbols,
  ImageRecognitionGetPagesRegionsSymbolsSuccess,
  ImageRecognitionServerError
} from "../actions/image-recognition.actions";
import {
  DocumentAnalysisServerError
} from "../actions/document-analysis.actions";
import {Page} from "../../../../core/model/entities/page";

@Injectable()
export class ImageOverviewEffects {
  constructor(
    private imageRecognitionService: ImageOverviewService,
    private actions$: Actions,
  ) {}


  @Effect()
  getImageOverview$ = this.actions$.pipe(
    ofType<ImageRecognitionGetImageOverview>(ImageRecognitionActionTypes.ImageRecognitionGetImageOverview),
    switchMap((action: ImageRecognitionGetImageOverview) => this.imageRecognitionService.getImageOverview$(action.imageID).pipe(
      switchMap((overview) => of(new ImageRecognitionGetImageOverviewSuccess(overview))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  getPagesRegionsSymbols$ = this.actions$.pipe(
    ofType<ImageRecognitionGetPagesRegionsSymbols>(ImageRecognitionActionTypes.ImageRecognitionGetPagesRegionsSymbols),
    switchMap((action: ImageRecognitionGetPagesRegionsSymbols) => this.imageRecognitionService.getPagesRegionsSymbols$(action.imageID).pipe(
      switchMap((pageRegionsSymbols: Page[]) => of(new ImageRecognitionGetPagesRegionsSymbolsSuccess(pageRegionsSymbols))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));



}
