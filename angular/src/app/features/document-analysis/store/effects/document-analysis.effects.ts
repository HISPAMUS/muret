import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, map, switchMap} from 'rxjs/operators';
import {DocumentAnalysisService} from '../../services/document-analysis.service';
import {
  ChangeRegionType, ChangeRegionTypeSuccess,
  DocumentAnalysisActionTypes, GetImageProjection, GetImageProjectionSuccess, GetImageURL, GetImageURLSuccess,
  GetRegionTypes,
  GetRegionTypesSuccess
} from '../actions/document-analysis.actions';
import {DocumentAnalysisImageProjection} from '../../../../core/model/restapi/document-analysis-image-projection';
import {RegionType} from '../../../../core/model/entities/region-type';
import {ImageFilesService} from '../../../../core/services/image-files.service';
import {ServerError} from '../../../../core/model/restapi/server-error';
import {Region} from '../../../../core/model/entities/region';

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
    switchMap((action) => this.imageFilesService.getMasterImageBlob$(action.projectPath, action.imageID)),
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
}
