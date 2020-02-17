import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {DocumentAnalysisService} from '../../services/document-analysis.service';
import {
  ChangePageBoundingBox,
  ChangePageBoundingBoxSuccess,
  ChangeRegionBoundingBox,
  ChangeRegionBoundingBoxSuccess,
  ChangeRegionType,
  ChangeRegionTypeSuccess,
  Clear,
  ClearSuccess,
  CreatePage,
  CreatePageSuccess,
  CreateRegion,
  CreateRegionSuccess,
  DeletePage, DeletePageSuccess, DeleteRegion, DeleteRegionSuccess,
  DocumentAnalysisActionTypes,
  GetImageProjection,
  GetImageProjectionSuccess,
  GetImageURL,
  GetImageURLSuccess,
  GetRegionTypes,
  GetRegionTypesSuccess,
  GetDocumentAnModels,
  GetDocumentAnModelsSuccess,
  AutomaticDocumentAnalysis,
  AutomaticDocumentAnalysisSuccess, CreatePages, CreatePagesSuccess, DocumentAnalysisServerError
} from '../actions/document-analysis.actions';
import {DocumentAnalysisImageProjection} from '../../../../core/model/restapi/document-analysis-image-projection';
import {RegionType} from '../../../../core/model/entities/region-type';
import {ImageFilesService} from '../../../../core/services/image-files.service';
import {Region} from '../../../../core/model/entities/region';
import {Page} from '../../../../core/model/entities/page';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';

@Injectable()
export class DocumentAnalysisEffects {
  constructor(
    private documentAnalysisService: DocumentAnalysisService,
    private imageFilesService: ImageFilesService,
    private actions$: Actions,
  ) {}

  @Effect()
  getImageProjection$ = this.actions$.pipe(
    ofType<GetImageProjection>(DocumentAnalysisActionTypes.GetImageProjection),
    switchMap((action: GetImageProjection) => this.documentAnalysisService.getDocumentAnalysisImageProjection$(action.imageID).pipe(
    switchMap((imageProjection: DocumentAnalysisImageProjection) => of(new GetImageProjectionSuccess(imageProjection))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));

  @Effect()
  getImageURL$ = this.actions$.pipe(
    ofType<GetImageURL>(DocumentAnalysisActionTypes.GetImageURL),
    switchMap((action: GetImageURL) => this.imageFilesService.getMasterImageBlob$(null, action.imageID).pipe(
    switchMap((imageBlob: Blob) => of(new GetImageURLSuccess(window.URL.createObjectURL(imageBlob)))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));

  @Effect()
  getRegionTypes$ = this.actions$.pipe(
    ofType<GetRegionTypes>(DocumentAnalysisActionTypes.GetImageProjection),
    switchMap(() => this.documentAnalysisService.getRegionTypes$().pipe(
    switchMap((regionTypes: RegionType[]) => of(new GetRegionTypesSuccess(regionTypes))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


  @Effect()
  changeRegionType$ = this.actions$.pipe(
    ofType<ChangeRegionType>(DocumentAnalysisActionTypes.ChangeRegionType),
    switchMap((action: ChangeRegionType) => this.documentAnalysisService.updateRegionType$(action.region, action.regionType).pipe(
    switchMap((region: Region) => of(new ChangeRegionTypeSuccess(region))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


  @Effect()
  changeRegionBoundingBox$ = this.actions$.pipe(
    ofType<ChangeRegionBoundingBox>(DocumentAnalysisActionTypes.ChangeRegionBoundingBox),
    switchMap((action: ChangeRegionBoundingBox) => this.documentAnalysisService.updateRegionBoundingBox$(
      action.region, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
    switchMap((region: Region) => of(new ChangeRegionBoundingBoxSuccess(region))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


  @Effect()
  changePageBoundingBox$ = this.actions$.pipe(
    ofType<ChangePageBoundingBox>(DocumentAnalysisActionTypes.ChangePageBoundingBox),
    switchMap((action: ChangePageBoundingBox) => this.documentAnalysisService.updatePageBoundingBox$(
      action.page, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
    switchMap((page: Page) => of(new ChangePageBoundingBoxSuccess(page))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


  @Effect()
  clear$ = this.actions$.pipe(
    ofType<Clear>(DocumentAnalysisActionTypes.Clear),
    switchMap((action: Clear) => this.documentAnalysisService.clear(action.imageID).pipe(
    switchMap(() => of(new ClearSuccess())),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


  @Effect()
  createPage$ = this.actions$.pipe(
    ofType<CreatePage>(DocumentAnalysisActionTypes.CreatePage),
    switchMap((action: CreatePage) => this.documentAnalysisService.createPage$(
      action.imageID, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
    switchMap((pages: Page[]) => of(new CreatePageSuccess(pages))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


  @Effect()
  createPages$ = this.actions$.pipe(
    ofType<CreatePages>(DocumentAnalysisActionTypes.CreatePages),
    switchMap((action: CreatePages) => this.documentAnalysisService.createPages$(
      action.imageID, action.numPages).pipe(
    switchMap((pages: Page[]) => of(new CreatePagesSuccess(pages))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));

  @Effect()
  createRegion$ = this.actions$.pipe(
    ofType<CreateRegion>(DocumentAnalysisActionTypes.CreateRegion),
    switchMap((action: CreateRegion) => this.documentAnalysisService.createRegion$(
      action.imageID, action.regionType,
      action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
    switchMap((pages: Page[]) => of(new CreateRegionSuccess(pages))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


  @Effect()
  deletePage$ = this.actions$.pipe(
    ofType<DeletePage>(DocumentAnalysisActionTypes.DeletePage),
    switchMap((action: DeletePage) => this.documentAnalysisService.deletePage$(action.pageID).pipe(
    switchMap((deletedPageID: number) => of(new DeletePageSuccess(deletedPageID))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


  @Effect()
  deleteRegion$ = this.actions$.pipe(
    ofType<DeleteRegion>(DocumentAnalysisActionTypes.DeleteRegion),
    switchMap((action: DeleteRegion) => this.documentAnalysisService.deleteRegion$(action.regionID).pipe(
    switchMap((deletedRegionID) => of(new DeleteRegionSuccess(deletedRegionID))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


  @Effect()
  getModel$ = this.actions$.pipe(
    ofType<GetDocumentAnModels>(DocumentAnalysisActionTypes.GetDocumentAnModels),
    switchMap((action: GetDocumentAnModels) => this.documentAnalysisService.getModels$(action.imageID).pipe(
    switchMap((classifierModels: ClassifierModel[]) => of(new GetDocumentAnModelsSuccess(classifierModels))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


  @Effect()
  attemptAutomaticAnalysis$ = this.actions$.pipe(
    ofType<AutomaticDocumentAnalysis>(DocumentAnalysisActionTypes.AutomaticDocumentAnalysis),
    switchMap((action: AutomaticDocumentAnalysis) => this.documentAnalysisService.attemptAutomaticAnalysis$(action.form).pipe(
    switchMap((page: Page[]) => of(new AutomaticDocumentAnalysisSuccess(page))),
      catchError(err => of(new DocumentAnalysisServerError(err)))
    )));


}
