import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, mergeMap, switchMap} from 'rxjs/operators';
import {ImageOverviewService} from "../../services/image-overview.service";
import {
  ImageRecognitionActionTypes,
  ImageRecognitionApplyRotation,
  ImageRecognitionApplyRotationSuccess,
  ImageRecognitionAutomaticDocumentAnalysis,
  ImageRecognitionAutomaticDocumentAnalysisSuccess,
  ImageRecognitionChangeNotationType,
  ImageRecognitionChangeNotationTypeSuccess,
  ImageRecognitionChangePageBoundingBox,
  ImageRecognitionChangePageBoundingBoxSuccess,
  ImageRecognitionChangeRegionBoundingBox,
  ImageRecognitionChangeRegionBoundingBoxSuccess,
  ImageRecognitionChangeRegionExternalReference,
  ImageRecognitionChangeRegionExternalReferenceSuccess,
  ImageRecognitionChangeStatus,
  ImageRecognitionChangeStatusSuccess,
  ImageRecognitionChangeSymbol,
  ImageRecognitionChangeSymbolBoundingBox,
  ImageRecognitionChangeSymbolComments,
  ImageRecognitionChangeSymbolSuccess,
  ImageRecognitionClassifyRegionEndToEnd,
  ImageRecognitionClassifyRegionEndToEndSuccess,
  ImageRecognitionClear,
  ImageRecognitionClearRegionSymbols,
  ImageRecognitionClearRegionSymbolsSuccess,
  ImageRecognitionClearSuccess,
  ImageRecognitionConvertAgnostic2Semantic,
  ImageRecognitionConvertAgnostic2SemanticSuccess,
  ImageRecognitionCreatePage,
  ImageRecognitionCreatePages,
  ImageRecognitionCreatePagesSuccess,
  ImageRecognitionCreatePageSuccess,
  ImageRecognitionCreateRegion,
  ImageRecognitionCreateRegionSuccess,
  ImageRecognitionCreateSymbolFromBoundingBox,
  ImageRecognitionCreateSymbolFromStrokes,
  ImageRecognitionCreateSymbolSuccess,
  ImageRecognitionDeletePages,
  ImageRecognitionDeletePagesSuccess,
  ImageRecognitionDeleteRegions,
  ImageRecognitionDeleteRegionsSuccess,
  ImageRecognitionDeleteSymbols,
  ImageRecognitionDeleteSymbolsSuccess,
  ImageRecognitionGetClassifierModels,
  ImageRecognitionGetClassifierModelsSuccess,
  ImageRecognitionGetImageOverview,
  ImageRecognitionGetImageOverviewSuccess,
  ImageRecognitionGetNotation,
  ImageRecognitionGetNotationSuccess,
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
  ImageRecognitionRevertRotation,
  ImageRecognitionRevertRotationSuccess,
  ImageRecognitionSendSemanticEncoding,
  ImageRecognitionSendSemanticEncodingSuccess,
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
import {ClassifierModel} from "../../../../core/model/entities/classifier-model";
import {SymbolCreationResult} from "../../../agnostic-representation-old/model/symbol-creation-result";
import {AgnosticRepresentationService} from "../../services/agnostic-representation.service";
import {AgnosticSymbol} from "../../../../core/model/entities/agnostic-symbol";
import {Notation} from "../../../../shared/services/notation";
import {SemanticRepresentationService} from "../../services/semantic-representation.service";
import {ChangeNotationTypeSuccess} from "../../../semantic-representation-old/store/actions/semantic-representation.actions";
import {StringResponse} from "../../../../core/model/restapi/string-response";


/**
 * We use the same effects for overview and parts because they share the state
 */
@Injectable()
export class ImageOverviewEffects {
  constructor(
    private imageOverviewService: ImageOverviewService,
    private imagePartsService: ImagePartsService,
    private documentAnalysisService: DocumentAnalysisService,
    private agnosticRepresentationService: AgnosticRepresentationService,
    private semanticRepresentationService: SemanticRepresentationService,
    private actions$: Actions,
  ) {}


  @Effect()
  getImageOverview$ = this.actions$.pipe(
    ofType<ImageRecognitionGetImageOverview>(ImageRecognitionActionTypes.ImageRecognitionGetImageOverview),
    switchMap((action: ImageRecognitionGetImageOverview) => this.imageOverviewService.getImageOverview$(action.imageID).pipe(
      switchMap((overview) => of(new ImageRecognitionGetImageOverviewSuccess(overview))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  getPagesRegionsSymbols$ = this.actions$.pipe(
    ofType<ImageRecognitionGetPagesRegionsSymbols>(ImageRecognitionActionTypes.ImageRecognitionGetPagesRegionsSymbols),
    switchMap((action: ImageRecognitionGetPagesRegionsSymbols) => this.imageOverviewService.getPagesRegionsSymbols$(action.imageID).pipe(
      switchMap((pageRegionsSymbols: Page[]) => of(new ImageRecognitionGetPagesRegionsSymbolsSuccess(pageRegionsSymbols))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  putComments$ = this.actions$.pipe(
    ofType<ImageRecognitionPutComments>(ImageRecognitionActionTypes.ImageRecognitionPutComments),
    switchMap((action: ImageRecognitionPutComments) => this.imageOverviewService.putComments$(action.imageID, action.comments).pipe(
      switchMap((comments: StringResponse) => of(new ImageRecognitionPutCommentsSuccess(comments))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  changeStatus$ = this.actions$.pipe(
    ofType<ImageRecognitionChangeStatus>(ImageRecognitionActionTypes.ImageRecognitionChangeStatus),
    switchMap((action: ImageRecognitionChangeStatus) => this.imageOverviewService.changeProgressStatus$(action.imageRecognitionProgressStatusChange).pipe(
      switchMap((statuses) => of(new ImageRecognitionChangeStatusSuccess(statuses))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));
  // --------- Parts -------

  @Effect()
  linkPart$ = this.actions$.pipe(
    ofType<ImageRecognitionLinkPart>(ImageRecognitionActionTypes.ImageRecognitionLinkPart),
    switchMap((action: ImageRecognitionLinkPart) => this.imagePartsService.linkToPart$(action.payload).pipe(
      switchMap((pagesRegionsSymbols) => of(new ImageRecognitionLinkPartSuccess(pagesRegionsSymbols))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  linkNewPart$ = this.actions$.pipe(
    ofType<ImageRecognitionLinkNewPart>(ImageRecognitionActionTypes.ImageRecognitionLinkNewPart),
    switchMap((action: ImageRecognitionLinkNewPart) => this.imagePartsService.linkToNewPart$(action.payload).pipe(
      switchMap((payload) => of(new ImageRecognitionLinkNewPartSuccess(payload))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  unlinkPart$ = this.actions$.pipe(
    ofType<ImageRecognitionUnlinkPart>(ImageRecognitionActionTypes.ImageRecognitionUnlinkPart),
    switchMap((action: ImageRecognitionUnlinkPart) => this.imagePartsService.unlinkFromPart$(action.payload).pipe(
      switchMap((payload) => of(new ImageRecognitionUnlinkPartSuccess(payload))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  linkPartToPart$ = this.actions$.pipe(
    ofType<ImageRecognitionLinkImageToPart>(ImageRecognitionActionTypes.ImageRecognitionLinkImageToPart),
    switchMap((action: ImageRecognitionLinkImageToPart) => this.imagePartsService.linkImageToPart$(action.imageID, action.partID).pipe(
      switchMap((part) => of(new ImageRecognitionLinkImageToPartSuccess(part))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  linkImageToNewPart$ = this.actions$.pipe(
    ofType<ImageRecognitionLinkImageToNewPart>(ImageRecognitionActionTypes.ImageRecognitionLinkImageToNewPart),
    switchMap((action: ImageRecognitionLinkImageToNewPart) => this.imagePartsService.linkImageToNewPart$(action.imageID, action.partName).pipe(
      switchMap((payload) => of(new ImageRecognitionLinkImageToNewPartSuccess(payload))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  unlinkImageFromPart$ = this.actions$.pipe(
    ofType<ImageRecognitionUnlinkImageFromPart>(ImageRecognitionActionTypes.ImageRecognitionUnlinkImageFromPart),
    switchMap((action: ImageRecognitionUnlinkImageFromPart) => this.imagePartsService.unlinkImageFromPart$(action.imageID).pipe(
      switchMap(() => of(new ImageRecognitionUnlinkImageFromPartSuccess())),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  // ----- Document analysis
  @Effect()
  getDocumentAnalsysisRegionTypes$ = this.actions$.pipe(
    ofType<ImageRecognitionGetRegionTypes>(ImageRecognitionActionTypes.ImageRecognitionGetRegionTypes),
    switchMap(() => this.documentAnalysisService.getRegionTypes$().pipe(
      switchMap((regionTypes: RegionType[]) => of(new ImageRecognitionGetRegionTypesSuccess(regionTypes))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  changeRegionsType$ = this.actions$.pipe(
    ofType<ImageRecognitionChangeRegionsType>(ImageRecognitionActionTypes.ImageRecognitionChangeRegionsType),
    switchMap((action: ImageRecognitionChangeRegionsType) => this.documentAnalysisService.changeRegionsType$(action.regions, action.regionType).pipe(
      switchMap((changedRegionTypes: ChangedRegionTypes) => of(new ImageRecognitionChangeRegionsTypeSuccess(changedRegionTypes))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  changeRegionBoundingBox$ = this.actions$.pipe(
    ofType<ImageRecognitionChangeRegionBoundingBox>(ImageRecognitionActionTypes.ImageRecognitionChangeRegionBoundingBox),
    switchMap((action: ImageRecognitionChangeRegionBoundingBox) => this.documentAnalysisService.updateRegionBoundingBox$(
      action.region, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
      switchMap((region: Region) => of(new ImageRecognitionChangeRegionBoundingBoxSuccess(region))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  changePageBoundingBox$ = this.actions$.pipe(
    ofType<ImageRecognitionChangePageBoundingBox>(ImageRecognitionActionTypes.ImageRecognitionChangePageBoundingBox),
    switchMap((action: ImageRecognitionChangePageBoundingBox) => this.documentAnalysisService.updatePageBoundingBox$(
      action.page, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
      switchMap((page: Page) => of(new ImageRecognitionChangePageBoundingBoxSuccess(page))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  clear$ = this.actions$.pipe(
    ofType<ImageRecognitionClear>(ImageRecognitionActionTypes.ImageRecognitionClear),
    switchMap((action: ImageRecognitionClear) => this.documentAnalysisService.clear(action.imageID).pipe(
      switchMap(() => of(new ImageRecognitionClearSuccess())),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  createPage$ = this.actions$.pipe(
    ofType<ImageRecognitionCreatePage>(ImageRecognitionActionTypes.ImageRecognitionCreatePage),
    switchMap((action: ImageRecognitionCreatePage) => this.documentAnalysisService.createPage$(
      action.imageID, action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
      switchMap((pages: Page[]) => of(new ImageRecognitionCreatePageSuccess(pages))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  createPages$ = this.actions$.pipe(
    ofType<ImageRecognitionCreatePages>(ImageRecognitionActionTypes.ImageRecognitionCreatePages),
    switchMap((action: ImageRecognitionCreatePages) => this.documentAnalysisService.createPages$(
      action.imageID, action.numPages).pipe(
      switchMap((pages: Page[]) => of(new ImageRecognitionCreatePagesSuccess(pages))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  createRegion$ = this.actions$.pipe(
    ofType<ImageRecognitionCreateRegion>(ImageRecognitionActionTypes.ImageRecognitionCreateRegion),
    switchMap((action: ImageRecognitionCreateRegion) => this.documentAnalysisService.createRegion$(
      action.imageID, action.regionType,
      action.boundingBox.fromX, action.boundingBox.fromY, action.boundingBox.toX, action.boundingBox.toY).pipe(
      switchMap((pages: Page[]) => of(new ImageRecognitionCreateRegionSuccess(pages))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  deletePages$ = this.actions$.pipe(
    ofType<ImageRecognitionDeletePages>(ImageRecognitionActionTypes.ImageRecognitionDeletePages),
    switchMap((action: ImageRecognitionDeletePages) => this.documentAnalysisService.deletePages$(action.pages).pipe(
      switchMap((deletedPagesID: NumberArray) => of(new ImageRecognitionDeletePagesSuccess(deletedPagesID))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  deleteRegions$ = this.actions$.pipe(
    ofType<ImageRecognitionDeleteRegions>(ImageRecognitionActionTypes.ImageRecognitionDeleteRegions),
    switchMap((action: ImageRecognitionDeleteRegions) => this.documentAnalysisService.deleteRegions$(action.regions).pipe(
      switchMap((deletedRegionID) => of(new ImageRecognitionDeleteRegionsSuccess(deletedRegionID))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  getModel$ = this.actions$.pipe(
    ofType<ImageRecognitionGetClassifierModels>(ImageRecognitionActionTypes.ImageRecognitionGetClassifierModels),
    switchMap((action: ImageRecognitionGetClassifierModels) => this.documentAnalysisService.getModels$(action.imageID).pipe(
      switchMap((classifierModels: ClassifierModel[]) => of(new ImageRecognitionGetClassifierModelsSuccess(classifierModels))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));


  @Effect()
  attemptAutomaticAnalysis$ = this.actions$.pipe(
    ofType<ImageRecognitionAutomaticDocumentAnalysis>(ImageRecognitionActionTypes.ImageRecognitionAutomaticDocumentAnalysis),
    switchMap((action: ImageRecognitionAutomaticDocumentAnalysis) => this.documentAnalysisService.attemptAutomaticAnalysis$(action.form).pipe(
      switchMap((page: Page[]) => of(new ImageRecognitionAutomaticDocumentAnalysisSuccess(page))),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  @Effect()
  rotateImage$ = this.actions$.pipe(
    ofType<ImageRecognitionApplyRotation>(ImageRecognitionActionTypes.ImageRecognitionApplyRotation),
    switchMap((action: ImageRecognitionApplyRotation) => this.documentAnalysisService.rotateImage$(action.imageID, action.rotationDegrees).pipe(
      switchMap(() => of(new ImageRecognitionApplyRotationSuccess())),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));
  @Effect()
  revertRotation$ = this.actions$.pipe(
    ofType<ImageRecognitionRevertRotation>(ImageRecognitionActionTypes.ImageRecognitionRevertRotation),
    switchMap((action: ImageRecognitionRevertRotation) => this.documentAnalysisService.revertRotation$(action.imageID).pipe(
      switchMap(() => of(new ImageRecognitionRevertRotationSuccess())),
      //catchError(err => of(new ImageRecognitionServerError(err)))
    )));

  // ------------- Agnostic representation
  @Effect()
  createSymbolFromBoundingBox$ = this.actions$.pipe(
    ofType<ImageRecognitionCreateSymbolFromBoundingBox>(ImageRecognitionActionTypes.ImageRecognitionCreateSymbolFromBoundingBox),
    switchMap((action: ImageRecognitionCreateSymbolFromBoundingBox) =>
      this.agnosticRepresentationService.createSymbolFromBoundingBox$(action.modelID, action.regionID, action.boundingBox,
        action.agnosticSymbolType, action.positionInStaff).pipe(
        switchMap((symbolCreationResult: SymbolCreationResult) => of(new ImageRecognitionCreateSymbolSuccess(symbolCreationResult))),
        //catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  createSymbolFromStrokes$ = this.actions$.pipe(
    ofType<ImageRecognitionCreateSymbolFromStrokes>(ImageRecognitionActionTypes.ImageRecognitionCreateSymbolFromStrokes),
    switchMap((action: ImageRecognitionCreateSymbolFromStrokes) =>
      this.agnosticRepresentationService.createSymbolFromStrokes$(action.modelID, action.regionID, action.points,
        action.agnosticSymbolType, action.positionInStaff).pipe(
        switchMap((symbolCreationResult: SymbolCreationResult) => of(new ImageRecognitionCreateSymbolSuccess(symbolCreationResult))),
        //catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));
  /**
   * Replaced switchMap for mergeMag to avoid sending the event twice
   */
  @Effect()
  deleteSymbol$ = this.actions$.pipe(
    ofType<ImageRecognitionDeleteSymbols>(ImageRecognitionActionTypes.ImageRecognitionDeleteSymbols),
    mergeMap((action: ImageRecognitionDeleteSymbols) =>
      this.agnosticRepresentationService.deleteSymbols$(action.agnosticSymbols).pipe(
        switchMap((deletedSymbolIDs: NumberArray) => of(new ImageRecognitionDeleteSymbolsSuccess(deletedSymbolIDs))),
        //catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  classifyRegionEndToEnd$ = this.actions$.pipe(
    ofType<ImageRecognitionClassifyRegionEndToEnd>(ImageRecognitionActionTypes.ImageRecognitionClassifyRegionEndToEnd),
    switchMap((action: ImageRecognitionClassifyRegionEndToEnd) =>
      this.agnosticRepresentationService.classifyRegionEndToEnd$(action.modelID, action.regionID).pipe(
        switchMap((classifiedSymbols: AgnosticSymbol[]) => of(new ImageRecognitionClassifyRegionEndToEndSuccess(classifiedSymbols))),
        //catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  clearRegionSymbols$ = this.actions$.pipe(
    ofType<ImageRecognitionClearRegionSymbols>(ImageRecognitionActionTypes.ImageRecognitionClearRegionSymbols),
    switchMap((action: ImageRecognitionClearRegionSymbols) =>
      this.agnosticRepresentationService.clearRegionSymbols$(action.regionID).pipe(
        switchMap((deleted: boolean) => of(new ImageRecognitionClearRegionSymbolsSuccess(deleted))), // it should always return true
        //catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  changeSymbol$ = this.actions$.pipe(
    ofType<ImageRecognitionChangeSymbol>(ImageRecognitionActionTypes.ImageRecognitionChangeSymbol),
    switchMap((action: ImageRecognitionChangeSymbol) =>
      this.agnosticRepresentationService.changeSymbol$(action.agnosticSymbol, action.agnosticSymbolType, action.positionInStaff).pipe(
        switchMap((agnosticSymbol: AgnosticSymbol) => of(new ImageRecognitionChangeSymbolSuccess(agnosticSymbol))),
        //catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  changeSymbolBoundingBox$ = this.actions$.pipe(
    ofType<ImageRecognitionChangeSymbolBoundingBox>(ImageRecognitionActionTypes.ImageRecognitionChangeSymbolBoundingBox),
    switchMap((action: ImageRecognitionChangeSymbolBoundingBox) =>
      this.agnosticRepresentationService.changeSymbolBoundingBox$(action.agnosticSymbol,
        action.boundingBox.fromX, action.boundingBox.fromY,
        action.boundingBox.toX, action.boundingBox.toY).pipe(
        switchMap((agnosticSymbol: AgnosticSymbol) => of(new ImageRecognitionChangeSymbolSuccess(agnosticSymbol))),
        //catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));

  @Effect()
  changeSymbolComments$ = this.actions$.pipe(
    ofType<ImageRecognitionChangeSymbolComments>(ImageRecognitionActionTypes.ImageRecognitionChangeSymbolComments),
    switchMap((action: ImageRecognitionChangeSymbolComments) =>
      this.agnosticRepresentationService.changeSymbolComments$(action.agnosticSymbol,
        action.comments).pipe(
        switchMap((agnosticSymbol: AgnosticSymbol) => of(new ImageRecognitionChangeSymbolSuccess(agnosticSymbol))),
        //catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));
  @Effect()
  changeRegionExternalReference$ = this.actions$.pipe(
    ofType<ImageRecognitionChangeRegionExternalReference>(ImageRecognitionActionTypes.ImageRecognitionChangeRegionExternalReference),
    switchMap((action: ImageRecognitionChangeRegionExternalReference) =>
      this.agnosticRepresentationService.changeRegionExternalReference$(action.region,
        action.externalReference).pipe(
        switchMap((region: Region) => of(new ImageRecognitionChangeRegionExternalReferenceSuccess(region))),
        //catchError((error: any) => of(new AgnosticRepresentationServerError(error)))
      )));
  // ------ semantic representation
  @Effect()
  convertAgnostic2Semantic$ = this.actions$.pipe(
    ofType<ImageRecognitionConvertAgnostic2Semantic>(ImageRecognitionActionTypes.ImageRecognitionConvertAgnostic2Semantic),
    switchMap((action: ImageRecognitionConvertAgnostic2Semantic) =>
      this.semanticRepresentationService.agnostic2Semantic$(action.classifierModelID, action.region, action.mensustriche, action.renderer).pipe(
        switchMap((notation: Notation) => of(new ImageRecognitionConvertAgnostic2SemanticSuccess(notation))),
        //catchError(err => of(new SemanticRepresentationServerError(err)))
      )));

  @Effect()
  getNotation$ = this.actions$.pipe(
    ofType<ImageRecognitionGetNotation>(ImageRecognitionActionTypes.ImageRecognitionGetNotation),
    switchMap((action: ImageRecognitionGetNotation) =>
      this.semanticRepresentationService.getNotation$(action.region, action.mensustriche, action.renderer).pipe(
        switchMap((notation: Notation) => of(new ImageRecognitionGetNotationSuccess(notation))),
        //catchError(err => of(new SemanticRepresentationServerError(err)))
      )));

  @Effect()
  sendSemanticEncoding$ = this.actions$.pipe(
    ofType<ImageRecognitionSendSemanticEncoding>(ImageRecognitionActionTypes.ImageRecognitionSendSemanticEncoding),
    switchMap((action: ImageRecognitionSendSemanticEncoding) =>
      this.semanticRepresentationService.sendSemanticEncoding$(action.region, action.semanticEncoding,
        action.mensustriche, action.renderer).pipe(
        switchMap((notation: Notation) => of(new ImageRecognitionSendSemanticEncodingSuccess(notation))),
        //catchError(err => of(new SemanticRepresentationServerError(err)))
      )));

  @Effect()
  changeNotationType$ = this.actions$.pipe(
    ofType<ImageRecognitionChangeNotationType>(ImageRecognitionActionTypes.ImageRecognitionChangeNotationType),
    switchMap((action: ImageRecognitionChangeNotationType) =>
      this.semanticRepresentationService.changeNotationType$(action.region.id, action.notationType).pipe(
        switchMap((region: Region) => of(new ImageRecognitionChangeNotationTypeSuccess(region))),
        //catchError(err => of(new SemanticRepresentationServerError(err)))
      )));

}
