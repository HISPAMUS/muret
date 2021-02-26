import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {ImageOverviewService} from "../../services/image-overview.service";
import {
  ImageOverviewActionTypes,
  ImageRecognitionGetImageOverview,
  ImageRecognitionGetImageOverviewSuccess,
  ImageRecognitionGetPagesRegionsSymbols,
  ImageRecognitionGetPagesRegionsSymbolsSuccess, ImageRecognitionLinkNewPart, ImageRecognitionLinkNewPartSuccess,
  ImageRecognitionLinkPart, ImageRecognitionLinkPartSuccess,
  ImageRecognitionPutComments,
  ImageRecognitionPutCommentsSuccess,
  ImageRecognitionServerError, ImageRecognitionUnlinkPart, ImageRecognitionUnlinkPartSuccess
} from "../actions/image-overview.actions";
import {
  DocumentAnalysisServerError
} from "../actions/document-analysis.actions";
import {Page} from "../../../../core/model/entities/page";
import {ImagePartsService} from "../../services/image-parts.service";


/**
 * We use the same effects for overview and parts because they share the state
 */
@Injectable()
export class ImageOverviewEffects {
  constructor(
    private imageOverviewService: ImageOverviewService,
    private imagePartsService: ImagePartsService,
    private actions$: Actions,
  ) {}


  @Effect()
  getImageOverview$ = this.actions$.pipe(
    ofType<ImageRecognitionGetImageOverview>(ImageOverviewActionTypes.ImageRecognitionGetImageOverview),
    switchMap((action: ImageRecognitionGetImageOverview) => this.imageOverviewService.getImageOverview$(action.imageID).pipe(
      switchMap((overview) => of(new ImageRecognitionGetImageOverviewSuccess(overview))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  getPagesRegionsSymbols$ = this.actions$.pipe(
    ofType<ImageRecognitionGetPagesRegionsSymbols>(ImageOverviewActionTypes.ImageRecognitionGetPagesRegionsSymbols),
    switchMap((action: ImageRecognitionGetPagesRegionsSymbols) => this.imageOverviewService.getPagesRegionsSymbols$(action.imageID).pipe(
      switchMap((pageRegionsSymbols: Page[]) => of(new ImageRecognitionGetPagesRegionsSymbolsSuccess(pageRegionsSymbols))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


  @Effect()
  putComments$ = this.actions$.pipe(
    ofType<ImageRecognitionPutComments>(ImageOverviewActionTypes.ImageRecognitionPutComments),
    switchMap((action: ImageRecognitionPutComments) => this.imageOverviewService.putComments$(action.imageID, action.comments).pipe(
      switchMap((comments: string) => of(new ImageRecognitionPutCommentsSuccess(comments))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));

  // --------- Parts -------

  @Effect()
  linkPart$ = this.actions$.pipe(
    ofType<ImageRecognitionLinkPart>(ImageOverviewActionTypes.ImageRecognitionLinkPart),
    switchMap((action: ImageRecognitionLinkPart) => this.imagePartsService.linkToPart$(action.payload).pipe(
      switchMap((pagesRegionsSymbols) => of(new ImageRecognitionLinkPartSuccess(pagesRegionsSymbols))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  linkNewPart$ = this.actions$.pipe(
    ofType<ImageRecognitionLinkNewPart>(ImageOverviewActionTypes.ImageRecognitionLinkNewPart),
    switchMap((action: ImageRecognitionLinkNewPart) => this.imagePartsService.linkToNewPart$(action.payload).pipe(
      switchMap((payload) => of(new ImageRecognitionLinkNewPartSuccess(payload))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  unlinkPart$ = this.actions$.pipe(
    ofType<ImageRecognitionUnlinkPart>(ImageOverviewActionTypes.ImageRecognitionUnlinkPart),
    switchMap((action: ImageRecognitionUnlinkPart) => this.imagePartsService.unlinkToPart$(action.payload).pipe(
      switchMap((payload) => of(new ImageRecognitionUnlinkPartSuccess(payload))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));
}