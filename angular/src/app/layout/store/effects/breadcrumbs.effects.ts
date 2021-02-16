import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import {Observable, of} from 'rxjs';
import {catchError, map, switchMap} from 'rxjs/operators';
import {Action} from '@ngrx/store';
import {BreadcrumbsService} from "../../services/breadcrumbs.service";
import {Breadcrumb} from "../../../core/model/restapi/breadcrumb";
import {
  BreadcrumbsActionTypes, BreadcrumbsServerError,
  BreadcrumbsUpdateCollection, BreadcrumbsUpdateCollectionSuccess,
  BreadcrumbsUpdateDocument, BreadcrumbsUpdateDocumentSuccess, BreadcrumbsUpdateImage, BreadcrumbsUpdateImageSuccess
} from "../actions/breadcrumbs.actions";

@Injectable()
export class BreadcrumbsEffects {
  constructor(
    private documentsService: BreadcrumbsService,
    private actions$: Actions,
  ) {}

  @Effect()
  getCollectionBreadcrumbs$: Observable<Action> = this.actions$.pipe(
    ofType<BreadcrumbsUpdateCollection>(BreadcrumbsActionTypes.BreadcrumbsUpdateCollection),
    switchMap((action: BreadcrumbsUpdateCollection) => this.documentsService.getCollectionBreadcrumbs$(action.collectionID).pipe(
      switchMap((breadcrumbs: Breadcrumb[]) => of(new BreadcrumbsUpdateCollectionSuccess(breadcrumbs))),
      catchError(err => of(new BreadcrumbsServerError(err)))
    )));

  @Effect()
  getDocumentBreadcrumbs$: Observable<Action> = this.actions$.pipe(
    ofType<BreadcrumbsUpdateDocument>(BreadcrumbsActionTypes.BreadcrumbsUpdateDocument),
    switchMap((action: BreadcrumbsUpdateDocument) => this.documentsService.getDocumentBreadcrumbs$(action.documentID).pipe(
      switchMap((breadcrumbs: Breadcrumb[]) => of(new BreadcrumbsUpdateDocumentSuccess(breadcrumbs))),
      catchError(err => of(new BreadcrumbsServerError(err)))
    )));
  @Effect()
  getImageBreadcrumbs$: Observable<Action> = this.actions$.pipe(
    ofType<BreadcrumbsUpdateImage>(BreadcrumbsActionTypes.BreadcrumbsUpdateImage),
    switchMap((action: BreadcrumbsUpdateImage) => this.documentsService.getImageBreadcrumbs$(action.imageID).pipe(
      switchMap((breadcrumbs: Breadcrumb[]) => of(new BreadcrumbsUpdateImageSuccess(breadcrumbs))),
      catchError(err => of(new BreadcrumbsServerError(err)))
    )));
}
