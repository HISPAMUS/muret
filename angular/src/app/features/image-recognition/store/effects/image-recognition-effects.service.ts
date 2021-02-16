import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {ImageRecognitionService} from "../../services/image-recognition-service";
import {
  ImageRecognitionActionTypes,
  ImageRecognitionGetImageOverview, ImageRecognitionGetImageOverviewSuccess,
  ImageRecognitionServerError
} from "../actions/image-recognition.actions";

@Injectable()
export class ImageRecognitionEffects {
  constructor(
    private imageRecognitionService: ImageRecognitionService,
    private actions$: Actions,
  ) {}


  @Effect()
  getImageOverview$ = this.actions$.pipe(
    ofType<ImageRecognitionGetImageOverview>(ImageRecognitionActionTypes.ImageRecognitionGetImageOverview),
    switchMap((action: ImageRecognitionGetImageOverview) => this.imageRecognitionService.getImageOverview$(action.documentID).pipe(
      switchMap((overview) => of(new ImageRecognitionGetImageOverviewSuccess(overview))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));
}
