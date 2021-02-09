import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import {Observable, of} from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
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
  DocumentServerError, DocumentGetOverview, DocumentGetOverviewSuccess,
} from '../actions/document.actions';
import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {StringResponse} from '../../../../core/model/restapi/string-response';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {AlignmentPreview} from '../../../../core/model/restapi/alignment-preview';
import {ImageFilesService} from '../../../../core/services/image-files.service';
import {Action} from '@ngrx/store';

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
      catchError(err => of(new DocumentServerError(err)))
    )));


  // revisado hasta aquí
  @Effect()
  getDocument$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentGetDocument>(DocumentActionTypes.DocumentGetDocument),
    switchMap((action: DocumentGetDocument) => this.documentService.getDocument$(action.documentID).pipe(
      switchMap((document: Document) => of(new DocumentGetDocumentSuccess(document))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  getImages$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentGetImages>(DocumentActionTypes.DocumentGetImages),
    switchMap((action: DocumentGetImages) => this.documentService.getDocumentImages$(action.documentID).pipe(
      switchMap((images: Image[]) => of(new DocumentGetImagesSuccess(images))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  exportMEIPartsFacsimile$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentExportMEIPartsFacsimile>(DocumentActionTypes.DocumentExportMEIPartsFacsimile),
    switchMap((action: DocumentExportMEIPartsFacsimile) =>
      this.documentService.exportMEIPartsFacsimile$(action.documentID, action.selectedImages, action.forMeasuringPolyphony).pipe(
        switchMap((mei: StringResponse) => of(new DocumentExportMEIPartsFacsimileSuccess(mei.response))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  exportMEI$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentExportMEI>(DocumentActionTypes.DocumentExportMEI),
    switchMap((action: DocumentExportMEI) => this.documentService.exportMEI$(action.documentID, action.partID, action.selectedImages).pipe(
      switchMap((mei: StringResponse) => of(new DocumentExportMEISuccess(mei.response))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  exportMensurstrich$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentExportMensurstrich>(DocumentActionTypes.DocumentExportMensurstrich),
    switchMap((action: DocumentExportMensurstrich) => this.documentService.exportMensurstrich$(action.documentID, action.selectedImages).pipe(
      switchMap((payload: Blob) => of(new DocumentExportMensurstrichSuccess(payload))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  exportMusicXML$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentExportMusicXML>(DocumentActionTypes.DocumentExportMusicXML),
    switchMap((action: DocumentExportMusicXML) => this.documentService.exportMusicXML$(action.documentID, action.selectedImages).pipe(
      switchMap((payload: Blob) => of(new DocumentExportMusicXMLSuccess(payload))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  getDocumentStatistics$: Observable<Action> = this.actions$.pipe(
    ofType<DocumentGetDocumentStatistics>(DocumentActionTypes.DocumentGetDocumentStatistics),
    switchMap((action: DocumentGetDocumentStatistics) => this.documentService.getDocumentStatistics$(action.documentID).pipe(
      switchMap((documentStatistics: DocumentStatistics) => of(new DocumentGetDocumentStatisticsSuccess(documentStatistics))),
      catchError(err => of(new DocumentServerError(err)))
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
      catchError(err => of(new DocumentServerError(err)))
    )));
}
