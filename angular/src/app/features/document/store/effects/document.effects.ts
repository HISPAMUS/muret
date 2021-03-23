import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import {Observable, of} from 'rxjs';
import {switchMap} from 'rxjs/operators';
import {DocumentService} from '../../services/document.service';
import {
  DocumentExportMEI,
  DocumentExportMEIPartsFacsimile,
  DocumentExportMEIPartsFacsimileSuccess,
  DocumentExportMEISuccess,
  DocumentExportMensurstrich,
  DocumentExportMensurstrichSuccess,
  DocumentExportMusicXML,
  DocumentExportMusicXMLSuccess,
  DocumentGetImages,
  DocumentGetImagesSuccess,
  DocumentGetDocument,
  DocumentGetDocumentStatistics,
  DocumentGetDocumentStatisticsSuccess,
  DocumentGetDocumentSuccess,
  DocumentActionTypes,
  DocumentGetAlignmentPreview,
  DocumentGetAlignmentPreviewSuccess,
  DocumentServerError,
  DocumentGetOverview,
  DocumentGetOverviewSuccess,
  DocumentMoveImagesToSection,
  DocumentMoveImagesToSectionSuccess,
  DocumentCreateSection,
  DocumentCreateSectionSuccess,
  DocumentRenameSection,
  DocumentRenameSectionSuccess,
  DocumentDeleteSection,
  DocumentDeleteSectionSuccess,
  DocumentReorderSections,
  DocumentReorderSectionsSuccess,
  DocumentGetSection,
  DocumentGetSectionSuccess,
  DocumentReorderImages,
  DocumentReorderImagesSuccess,
  DocumentGetPartsInImages,
  DocumentGetPartsInImagesSuccess,
  DocumentMoveImagesToDefaultSection,
  DocumentMoveImagesToDefaultSectionSuccess,
  DocumentLinkImagesToPart,
  DocumentLinkImagesToPartSuccess,
  DocumentLinkImagesToNewPart,
  DocumentLinkImagesToNewPartSuccess,
  DocumentUnlinkImagesFromPart,
  DocumentUnlinkImagesFromPartSuccess,
  DocumentChangeImagesVisibility,
  DocumentChangeImagesVisibilitySuccess,
} from '../actions/document.actions';
import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {StringResponse} from '../../../../core/model/restapi/string-response';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {AlignmentPreview} from '../../../../core/model/restapi/alignment-preview';
import {ImageFilesService} from '../../../../core/services/image-files.service';
import {Action} from '@ngrx/store';
import {Section} from "../../../../core/model/entities/section";

@Injectable()
export class DocumentEffects {
  constructor(
    private documentService: DocumentService,
    private imageFilesService: ImageFilesService,
    private actions$: Actions,
  ) {}

  @Effect()
  getDocumentOverview$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentGetOverview>(DocumentActionTypes.DocumentGetOverview),
    switchMap((action: DocumentGetOverview) => this.documentService.getOverview$(action.documentID).pipe(
      switchMap((documentSummary: Document) => of(new DocumentGetOverviewSuccess(documentSummary))),
      //catchError(err => of(new DocumentServerError(err)))
    )));


  @Effect()
  moveImageToSection$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentMoveImagesToSection>(DocumentActionTypes.DocumentMoveImagesToSection),
    switchMap((action: DocumentMoveImagesToSection) => this.documentService.moveImagesToSection$(action.sectionImages).pipe(
      switchMap((sectionImages) => of(new DocumentMoveImagesToSectionSuccess(sectionImages))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  moveImageToDefaultSection$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentMoveImagesToDefaultSection>(DocumentActionTypes.DocumentMoveImagesToDefaultSection),
    switchMap((action: DocumentMoveImagesToDefaultSection) => this.documentService.moveImagesToDefaultSection$(action.documentID).pipe(
      switchMap((section) => of(new DocumentMoveImagesToDefaultSectionSuccess(section))),
      //catchError(err => of(new DocumentServerError(err)))
    )));


  @Effect()
  createSection$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentCreateSection>(DocumentActionTypes.DocumentCreateSection),
    switchMap((action: DocumentCreateSection) => this.documentService.createSection$(action.documentID, action.name).pipe(
      switchMap((section) => of(new DocumentCreateSectionSuccess(section))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  renameSection$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentRenameSection>(DocumentActionTypes.DocumentRenameSection),
    switchMap((action: DocumentRenameSection) => this.documentService.renameSection$(action.section).pipe(
      switchMap((section) => of(new DocumentRenameSectionSuccess(section))),
      //catchError(err => of(new DocumentServerError(err)))
    )));


  @Effect()
  deleteSection$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentDeleteSection>(DocumentActionTypes.DocumentDeleteSection),
    switchMap((action: DocumentDeleteSection) => this.documentService.deleteSection$(action.sectionID).pipe(
      switchMap((sectionID) => of(new DocumentDeleteSectionSuccess(sectionID))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  reorderSections$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentReorderSections>(DocumentActionTypes.DocumentReorderSections),
    switchMap((action: DocumentReorderSections) => this.documentService.reorderSections$(action.ordering).pipe(
      switchMap((ordering) => of(new DocumentReorderSectionsSuccess(ordering))),
      //catchError(err => of(new DocumentServerError(err)))
    )));


  @Effect()
  getSection$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentGetSection>(DocumentActionTypes.DocumentGetSection),
    switchMap((action: DocumentGetSection) => this.documentService.getSection$(action.id).pipe(
      switchMap((section: Section) => of(new DocumentGetSectionSuccess(section))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  reorderImages$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentReorderImages>(DocumentActionTypes.DocumentReorderImages),
    switchMap((action: DocumentReorderImages) => this.documentService.reorderImages$(action.ordering).pipe(
      switchMap((ordering) => of(new DocumentReorderImagesSuccess(ordering))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  getPartsInImages$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentGetPartsInImages>(DocumentActionTypes.DocumentGetPartsInImages),
    switchMap((action: DocumentGetPartsInImages) => this.documentService.getPartsInImages$(action.documentID).pipe(
      switchMap((partsInImages) => of(new DocumentGetPartsInImagesSuccess(partsInImages))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  linkImagesToPart$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentLinkImagesToPart>(DocumentActionTypes.DocumentLinkImagesToPart),
    switchMap((action: DocumentLinkImagesToPart) => this.documentService.linkImagesToPart$(action.imageIDs, action.partID).pipe(
      switchMap((partsInImages) => of(new DocumentLinkImagesToPartSuccess(partsInImages))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  linkImagesToNewPart$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentLinkImagesToNewPart>(DocumentActionTypes.DocumentLinkImagesToNewPart),
    switchMap((action: DocumentLinkImagesToNewPart) => this.documentService.linkImagesToNewPart$(action.imageIDs, action.partName).pipe(
      switchMap((imagesInNewPart) => of(new DocumentLinkImagesToNewPartSuccess(imagesInNewPart))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  unlinkImagesFromPart$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentUnlinkImagesFromPart>(DocumentActionTypes.DocumentUnlinkImagesFromPart),
    switchMap((action: DocumentUnlinkImagesFromPart) => this.documentService.unlinkImagesFromPart$(action.imageIDs).pipe(
      switchMap((partsInImages) => of(new DocumentUnlinkImagesFromPartSuccess(partsInImages))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  changeImageVisibility$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentChangeImagesVisibility>(DocumentActionTypes.DocumentChangeImagesVisibility),
    switchMap((action: DocumentChangeImagesVisibility) => this.documentService.changeImagesVisibility$(action.imageIDs, action.hidden).pipe(
      switchMap((imageVisibility) => of(new DocumentChangeImagesVisibilitySuccess(imageVisibility))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  exportMEIPartsFacsimile$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentExportMEIPartsFacsimile>(DocumentActionTypes.DocumentExportMEIPartsFacsimile),
    switchMap((action: DocumentExportMEIPartsFacsimile) =>
      this.documentService.exportMEIPartsFacsimile$(action.selectedImages, action.forMeasuringPolyphony).pipe(
        switchMap((mei: StringResponse) => of(new DocumentExportMEIPartsFacsimileSuccess(mei.response))),
        //catchError(err => of(new DocumentServerError(err)))
      )));

  @Effect()
  exportMEI$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentExportMEI>(DocumentActionTypes.DocumentExportMEI),
    switchMap((action: DocumentExportMEI) => this.documentService.exportMEI$(action.optionalPartID, action.selectedImages).pipe(
      switchMap((mei: StringResponse) => of(new DocumentExportMEISuccess(mei.response))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  // revisado hasta aquí
  @Effect()
  getDocument$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentGetDocument>(DocumentActionTypes.DocumentGetDocument),
    switchMap((action: DocumentGetDocument) => this.documentService.getDocument$(action.documentID).pipe(
      switchMap((document: Document) => of(new DocumentGetDocumentSuccess(document))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  getImages$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentGetImages>(DocumentActionTypes.DocumentGetImages),
    switchMap((action: DocumentGetImages) => this.documentService.getDocumentImages$(action.documentID).pipe(
      switchMap((images: Image[]) => of(new DocumentGetImagesSuccess(images))),
      //catchError(err => of(new DocumentServerError(err)))
    )));



  @Effect()
  exportMensurstrich$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentExportMensurstrich>(DocumentActionTypes.DocumentExportMensurstrich),
    switchMap((action: DocumentExportMensurstrich) => this.documentService.exportMensurstrich$(action.documentID, action.selectedImages).pipe(
      switchMap((payload: Blob) => of(new DocumentExportMensurstrichSuccess(payload))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  exportMusicXML$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentExportMusicXML>(DocumentActionTypes.DocumentExportMusicXML),
    switchMap((action: DocumentExportMusicXML) => this.documentService.exportMusicXML$(action.documentID, action.selectedImages).pipe(
      switchMap((payload: Blob) => of(new DocumentExportMusicXMLSuccess(payload))),
      //catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  getDocumentStatistics$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentGetDocumentStatistics>(DocumentActionTypes.DocumentGetDocumentStatistics),
    switchMap((action: DocumentGetDocumentStatistics) => this.documentService.getDocumentStatistics$(action.documentID).pipe(
      switchMap((documentStatistics: DocumentStatistics) => of(new DocumentGetDocumentStatisticsSuccess(documentStatistics))),
      //catchError(err => of(new DocumentServerError(err)))
    )));
  /**
   * @deprecated Use getAlignmentPreview$
   */
 /* @Effect()
  preflightCheck$ = this.actions$.pipe(
    ofType<PreflightCheck>(DocumentActionTypes.PreflightCheck),
    switchMap((action: PreflightCheck) => this.documentService.preflightCheck$(action.documentID, action.selectedImages)),
    switchMap((preflightCheckResult: PreflightCheckResult) => {
      return of(new PreflightCheckSuccess(preflightCheckResult));
    })
  );*/

  @Effect()
  getAlignmentPreview$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentGetAlignmentPreview>(DocumentActionTypes.DocumentGetAlignmentPreview),
    switchMap((action: DocumentGetAlignmentPreview) => this.documentService.getAlignmentPreview$(action.documentID).pipe(
      switchMap((alignmentPreview: AlignmentPreview) => of(new DocumentGetAlignmentPreviewSuccess(alignmentPreview))),
      //catchError(err => of(new DocumentServerError(err)))
    )));
}
