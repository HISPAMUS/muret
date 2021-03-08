import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
import {ImageOverviewService} from "../../services/image-overview.service";
import {
  ImageRecognitionActionTypes,
  ImageRecognitionChangePageBoundingBox,
  ImageRecognitionChangePageBoundingBoxSuccess,
  ImageRecognitionChangeRegionBoundingBox,
  ImageRecognitionChangeRegionBoundingBoxSuccess,
  ImageRecognitionChangeStatus,
  ImageRecognitionChangeStatusSuccess,
  ImageRecognitionClear,
  ImageRecognitionClearSuccess,
  ImageRecognitionCreatePage,
  ImageRecognitionCreatePages,
  ImageRecognitionCreatePagesSuccess,
  ImageRecognitionCreatePageSuccess,
  ImageRecognitionCreateRegion,
  ImageRecognitionCreateRegionSuccess,
  ImageRecognitionDeletePages,
  ImageRecognitionDeletePagesSuccess,
  ImageRecognitionDeleteRegions,
  ImageRecognitionDeleteRegionsSuccess,
  ImageRecognitionGetImageOverview,
  ImageRecognitionGetImageOverviewSuccess,
  ImageRecognitionGetPagesRegionsSymbols,
  ImageRecognitionGetPagesRegionsSymbolsSuccess,
  ImageRecognitionLinkImageToNewPart,
  ImageRecognitionLinkImageToNewPartSuccess,
  ImageRecognitionLinkImageToPart,
  ImageRecognitionLinkImageToPartSuccess,
  ImageRecognitionLinkNewPart,
  ImageRecognitionLinkNewPartSuccess,
  ImageRecognitionLinkPart,
  ImageRecognitionLinkPartSuccess,
  ImageRecognitionPutComments,
  ImageRecognitionPutCommentsSuccess,
  ImageRecognitionServerError,
  ImageRecognitionUnlinkImageFromPart,
  ImageRecognitionUnlinkImageFromPartSuccess,
  ImageRecognitionUnlinkPart,
  ImageRecognitionUnlinkPartSuccess
} from "../actions/image-recognition.actions";
import {Page} from "../../../../core/model/entities/page";
import {ImagePartsService} from "../../services/image-parts.service";
import {RegionType} from "../../../../core/model/entities/region-type";
import {ChangedRegionTypes} from "../../../../core/model/restapi/changed-region-types";
import {
  ImageRecognitionChangeRegionsType,
  ImageRecognitionChangeRegionsTypeSuccess,
  ImageRecognitionGetRegionTypes, ImageRecognitionGetRegionTypesSuccess
} from "../actions/image-recognition.actions";
import {DocumentAnalysisService} from "../../services/document-analysis.service";
import {Region} from "../../../../core/model/entities/region";
import {NumberArray} from "../../../../core/model/restapi/number-array";


/**
 * We use the same effects for overview and parts because they share the state
 */
@Injectable()
export class ImageOverviewEffects {
  constructor(
    private imageOverviewService: ImageOverviewService,
    private imagePartsService: ImagePartsService,
    private documentAnalysisService: DocumentAnalysisService,
    private actions$: Actions,
  ) {}


  @Effect()
  getImageOverview$ = this.actions$.pipe(
    ofType<ImageRecognitionGetImageOverview>(ImageRecognitionActionTypes.ImageRecognitionGetImageOverview),
    switchMap((action: ImageRecognitionGetImageOverview) => this.imageOverviewService.getImageOverview$(action.imageID).pipe(
      switchMap((overview) => of(new ImageRecognitionGetImageOverviewSuccess(overview))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  getPagesRegionsSymbols$ = this.actions$.pipe(
    ofType<ImageRecognitionGetPagesRegionsSymbols>(ImageRecognitionActionTypes.ImageRecognitionGetPagesRegionsSymbols),
    switchMap((action: ImageRecognitionGetPagesRegionsSymbols) => this.imageOverviewService.getPagesRegionsSymbols$(action.imageID).pipe(
      switchMap((pageRegionsSymbols: Page[]) => of(new ImageRecognitionGetPagesRegionsSymbolsSuccess(pageRegionsSymbols))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  putComments$ = this.actions$.pipe(
    ofType<ImageRecognitionPutComments>(ImageRecognitionActionTypes.ImageRecognitionPutComments),
    switchMap((action: ImageRecognitionPutComments) => this.imageOverviewService.putComments$(action.imageID, action.comments).pipe(
      switchMap((comments: string) => of(new ImageRecognitionPutCommentsSuccess(comments))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  changeStatus$ = this.actions$.pipe(
    ofType<ImageRecognitionChangeStatus>(ImageRecognitionActionTypes.ImageRecognitionChangeStatus),
    switchMap((action: ImageRecognitionChangeStatus) => this.imageOverviewService.changeProgressStatus$(action.imageRecognitionProgressStatusChange).pipe(
      switchMap((statuses) => of(new ImageRecognitionChangeStatusSuccess(statuses))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));
  // --------- Parts -------

  @Effect()
  linkPart$ = this.actions$.pipe(
    ofType<ImageRecognitionLinkPart>(ImageRecognitionActionTypes.ImageRecognitionLinkPart),
    switchMap((action: ImageRecognitionLinkPart) => this.imagePartsService.linkToPart$(action.payload).pipe(
      switchMap((pagesRegionsSymbols) => of(new ImageRecognitionLinkPartSuccess(pagesRegionsSymbols))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  linkNewPart$ = this.actions$.pipe(
    ofType<ImageRecognitionLinkNewPart>(ImageRecognitionActionTypes.ImageRecognitionLinkNewPart),
    switchMap((action: ImageRecognitionLinkNewPart) => this.imagePartsService.linkToNewPart$(action.payload).pipe(
      switchMap((payload) => of(new ImageRecognitionLinkNewPartSuccess(payload))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  unlinkPart$ = this.actions$.pipe(
    ofType<ImageRecognitionUnlinkPart>(ImageRecognitionActionTypes.ImageRecognitionUnlinkPart),
    switchMap((action: ImageRecognitionUnlinkPart) => this.imagePartsService.unlinkFromPart$(action.payload).pipe(
      switchMap((payload) => of(new ImageRecognitionUnlinkPartSuccess(payload))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  linkPartToPart$ = this.actions$.pipe(
    ofType<ImageRecognitionLinkImageToPart>(ImageRecognitionActionTypes.ImageRecognitionLinkImageToPart),
    switchMap((action: ImageRecognitionLinkImageToPart) => this.imagePartsService.linkImageToPart$(action.imageID, action.partID).pipe(
      switchMap((part) => of(new ImageRecognitionLinkImageToPartSuccess(part))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  linkImageToNewPart$ = this.actions$.pipe(
    ofType<ImageRecognitionLinkImageToNewPart>(ImageRecognitionActionTypes.ImageRecognitionLinkImageToNewPart),
    switchMap((action: ImageRecognitionLinkImageToNewPart) => this.imagePartsService.linkImageToNewPart$(action.imageID, action.partName).pipe(
      switchMap((payload) => of(new ImageRecognitionLinkImageToNewPartSuccess(payload))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  unlinkImageFromPart$ = this.actions$.pipe(
    ofType<ImageRecognitionUnlinkImageFromPart>(ImageRecognitionActionTypes.ImageRecognitionUnlinkImageFromPart),
    switchMap((action: ImageRecognitionUnlinkImageFromPart) => this.imagePartsService.unlinkImageFromPart$(action.imageID).pipe(
      switchMap(() => of(new ImageRecognitionUnlinkImageFromPartSuccess())),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  // ----- Document analysis
  @Effect()
  getDocumentAnalsysisRegionTypes$ = this.actions$.pipe(
    ofType<ImageRecognitionGetRegionTypes>(ImageRecognitionActionTypes.ImageRecognitionGetRegionTypes),
    switchMap(() => this.documentAnalysisService.getRegionTypes$().pipe(
      switchMap((regionTypes: RegionType[]) => of(new ImageRecognitionGetRegionTypesSuccess(regionTypes))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  changeRegionsType$ = this.actions$.pipe(
    ofType<ImageRecognitionChangeRegionsType>(ImageRecognitionActionTypes.ImageRecognitionChangeRegionsType),
    switchMap((action: ImageRecognitionChangeRegionsType) => this.documentAnalysisService.changeRegionsType$(action.regions, action.regionType).pipe(
      switchMap((changedRegionTypes: ChangedRegionTypes) => of(new ImageRecognitionChangeRegionsTypeSuccess(changedRegionTypes))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  changeRegionBoundingBox$ = this.actions$.pipe(
    ofType<ImageRecognitionChangeRegionBoundingBox>(ImageRecognitionActionTypes.ImageRecognitionChangeRegionBoundingBox),
    switchMap((action: ImageRecognitionChangeRegionBoundingBox) => this.documentAnalysisService.updateRegionBoundingBox$(
      action.region, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
      switchMap((region: Region) => of(new ImageRecognitionChangeRegionBoundingBoxSuccess(region))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  changePageBoundingBox$ = this.actions$.pipe(
    ofType<ImageRecognitionChangePageBoundingBox>(ImageRecognitionActionTypes.ImageRecognitionChangePageBoundingBox),
    switchMap((action: ImageRecognitionChangePageBoundingBox) => this.documentAnalysisService.updatePageBoundingBox$(
      action.page, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
      switchMap((page: Page) => of(new ImageRecognitionChangePageBoundingBoxSuccess(page))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  clear$ = this.actions$.pipe(
    ofType<ImageRecognitionClear>(ImageRecognitionActionTypes.ImageRecognitionClear),
    switchMap((action: ImageRecognitionClear) => this.documentAnalysisService.clear(action.imageID).pipe(
      switchMap(() => of(new ImageRecognitionClearSuccess())),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  createPage$ = this.actions$.pipe(
    ofType<ImageRecognitionCreatePage>(ImageRecognitionActionTypes.ImageRecognitionCreatePage),
    switchMap((action: ImageRecognitionCreatePage) => this.documentAnalysisService.createPage$(
      action.imageID, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
      switchMap((pages: Page[]) => of(new ImageRecognitionCreatePageSuccess(pages))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  createPages$ = this.actions$.pipe(
    ofType<ImageRecognitionCreatePages>(ImageRecognitionActionTypes.ImageRecognitionCreatePages),
    switchMap((action: ImageRecognitionCreatePages) => this.documentAnalysisService.createPages$(
      action.imageID, action.numPages).pipe(
      switchMap((pages: Page[]) => of(new ImageRecognitionCreatePagesSuccess(pages))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  createRegion$ = this.actions$.pipe(
    ofType<ImageRecognitionCreateRegion>(ImageRecognitionActionTypes.ImageRecognitionCreateRegion),
    switchMap((action: ImageRecognitionCreateRegion) => this.documentAnalysisService.createRegion$(
      action.imageID, action.regionType,
      action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
      switchMap((pages: Page[]) => of(new ImageRecognitionCreateRegionSuccess(pages))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  deletePages$ = this.actions$.pipe(
    ofType<ImageRecognitionDeletePages>(ImageRecognitionActionTypes.ImageRecognitionDeletePages),
    switchMap((action: ImageRecognitionDeletePages) => this.documentAnalysisService.deletePages$(action.pages).pipe(
      switchMap((deletedPagesID: NumberArray) => of(new ImageRecognitionDeletePagesSuccess(deletedPagesID))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  deleteRegions$ = this.actions$.pipe(
    ofType<ImageRecognitionDeleteRegions>(ImageRecognitionActionTypes.ImageRecognitionDeleteRegions),
    switchMap((action: ImageRecognitionDeleteRegions) => this.documentAnalysisService.deleteRegions$(action.regions).pipe(
      switchMap((deletedRegionID) => of(new ImageRecognitionDeleteRegionsSuccess(deletedRegionID))),
      catchError(err => of(new ImageRecognitionServerError(err)))
    )));

}
