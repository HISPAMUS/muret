import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, map, switchMap} from 'rxjs/operators';
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
  GetRegionTypesSuccess
} from '../actions/document-analysis.actions';
import {DocumentAnalysisImageProjection} from '../../../../core/model/restapi/document-analysis-image-projection';
import {RegionType} from '../../../../core/model/entities/region-type';
import {ImageFilesService} from '../../../../core/services/image-files.service';
import {Region} from '../../../../core/model/entities/region';
import {Page} from '../../../../core/model/entities/page';

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
    map((action: GetImageProjection) => action.imageID),
    switchMap((imageID) => this.documentAnalysisService.getDocumentAnalysisImageProjection$(imageID)),
    switchMap((imageProjection: DocumentAnalysisImageProjection) => {
      return of(new GetImageProjectionSuccess(imageProjection));
    })
  );

  @Effect()
  getImageURL$ = this.actions$.pipe(
    ofType<GetImageURL>(DocumentAnalysisActionTypes.GetImageURL),
    map((action: GetImageURL) => action),
    switchMap((action) => this.imageFilesService.getMasterImageBlob$(null, action.imageID)),
    switchMap((imageBlob: Blob) => {
      return of(new GetImageURLSuccess(window.URL.createObjectURL(imageBlob)));
    })
  );

  @Effect()
  getRegionTypes$ = this.actions$.pipe(
    ofType<GetRegionTypes>(DocumentAnalysisActionTypes.GetImageProjection),
    switchMap(() => this.documentAnalysisService.getRegionTypes$()),
    switchMap((regionTypes: RegionType[]) => {
      return of(new GetRegionTypesSuccess(regionTypes));
    })
  );

  @Effect()
  changeRegionType$ = this.actions$.pipe(
    ofType<ChangeRegionType>(DocumentAnalysisActionTypes.ChangeRegionType),
    switchMap((action: ChangeRegionType) => this.documentAnalysisService.updateRegionType(action.region, action.regionType)),
    switchMap((region: Region) => {
      return of(new ChangeRegionTypeSuccess(region));
    })
  );

  @Effect()
  changeRegionBoundingBox$ = this.actions$.pipe(
    ofType<ChangeRegionBoundingBox>(DocumentAnalysisActionTypes.ChangeRegionBoundingBox),
    switchMap((action: ChangeRegionBoundingBox) => this.documentAnalysisService.updateRegionBoundingBox(
      action.region, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY)),
    switchMap((region: Region) => {
      return of(new ChangeRegionBoundingBoxSuccess(region));
    })
  );

  @Effect()
  changePageBoundingBox$ = this.actions$.pipe(
    ofType<ChangePageBoundingBox>(DocumentAnalysisActionTypes.ChangePageBoundingBox),
    switchMap((action: ChangePageBoundingBox) => this.documentAnalysisService.updatePageBoundingBox(
      action.page, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY)),
    switchMap((page: Page) => {
      return of(new ChangePageBoundingBoxSuccess(page));
    })
  );

  @Effect()
  clear$ = this.actions$.pipe(
    ofType<Clear>(DocumentAnalysisActionTypes.Clear),
    switchMap((action: Clear) => this.documentAnalysisService.clear(action.imageID)),
    switchMap((pages: Page[]) => {
      return of(new ClearSuccess(pages));
    })
  );

  @Effect()
  createPage$ = this.actions$.pipe(
    ofType<CreatePage>(DocumentAnalysisActionTypes.CreatePage),
    switchMap((action: CreatePage) => this.documentAnalysisService.createPage(
      action.imageID, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY)),
    switchMap((pages: Page[]) => {
      return of(new CreatePageSuccess(pages));
    })
  );

  @Effect()
  createRegion$ = this.actions$.pipe(
    ofType<CreateRegion>(DocumentAnalysisActionTypes.CreateRegion),
    switchMap((action: CreateRegion) => this.documentAnalysisService.createRegion(
      action.imageID, action.regionType,
      action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY)),
    switchMap((pages: Page[]) => {
      return of(new CreateRegionSuccess(pages));
    })
  );

  @Effect()
  deletePage$ = this.actions$.pipe(
    ofType<DeletePage>(DocumentAnalysisActionTypes.DeletePage),
    switchMap((action: DeletePage) => this.documentAnalysisService.deletePage(action.pageID)),
    switchMap((deletedPageID: number) => {
      return of(new DeletePageSuccess(deletedPageID));
    })
  );

  @Effect()
  deleteRegion$ = this.actions$.pipe(
    ofType<DeleteRegion>(DocumentAnalysisActionTypes.DeleteRegion),
    switchMap((action: DeleteRegion) => this.documentAnalysisService.deleteRegion(action.regionID)),
    switchMap((deletedRegionID) => {
      return of(new DeleteRegionSuccess(deletedRegionID));
    })
  );

}
